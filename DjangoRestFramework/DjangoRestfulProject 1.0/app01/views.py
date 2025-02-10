from rest_framework import status, views, generics, viewsets
from rest_framework.authentication import BasicAuthentication, SessionAuthentication, TokenAuthentication
from rest_framework.decorators import api_view
from rest_framework.permissions import IsAuthenticated
from rest_framework.response import Response

from .models import Student
from .permissions import IsOwnerOrReadOnly
from .serializers import StudentSerializer


""" 函数视图 """
@api_view(['GET', 'POST'])
def student_list(request):
    """
    获取所有的学生信息或者新增一个学生
    """
    if request.method == 'GET':
        # instance为多个对象, many需要设置为True
        students_serializer = StudentSerializer(instance=Student.objects.all(), many=True)
        # 序列化数据保存在 students_serializer.data 中
        return Response(data=students_serializer.data, status=status.HTTP_200_OK)

    elif request.method == 'POST':
        s = StudentSerializer(data=request.data)
        if s.is_valid():
            s.save()
            return Response(data=s.data, status=status.HTTP_201_CREATED)

        # 序列化错误的的信息保存在 s.errors 中
        return Response(data=s.errors, status=status.HTTP_400_BAD_REQUEST)


@api_view(['GET', 'PUT', 'DELETE'])
def student_detail(request, pk):

    try:
        # Student.objects查询中, 只有get()可能会抛出异常: DoesNotExist MultipleObjectsReturned
        student = Student.objects.get(pk=pk)
    except Student.DoesNotExist:
        return Response(data={'error': 'Student do not exist'}, status=status.HTTP_404_NOT_FOUND)

    if request.method == 'GET':
        s = StudentSerializer(instance=student)  # student为单个对象, 不需要many=True
        return Response(data=s.data, status=status.HTTP_200_OK)

    elif request.method == 'PUT':
        # 将 request.data 序列化后保存到 student 实例中
        s = StudentSerializer(instance=student, data=request.data)
        if s.is_valid():
            s.save()
            return Response(data=s.data, status=status.HTTP_200_OK)

    elif request.method == 'DELETE':
        student.delete()
        return Response(status=status.HTTP_204_NO_CONTENT)


""" 类视图 """
class StudentList(views.APIView):
    def get(self, request):
        queryset = Student.objects.all()   # all() 得到的是QuerySet类型, get() 得到的是单个对象
        serializer = StudentSerializer(queryset, many=True)  # 如果是QuerySet类型, 就需要many=True
        return Response(data=serializer.data, status=status.HTTP_200_OK)

    def post(self, request):
        serializer = StudentSerializer(data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(data=serializer.data, status=status.HTTP_201_CREATED)
        return Response(data=serializer.errors, status=status.HTTP_400_BAD_REQUEST)


class StudentDetail(views.APIView):
    def get(self, request, pk):
        try:
            student = Student.objects.get(pk=pk)
            serializer = StudentSerializer(instance=student)
            return Response(data=serializer.data, status=status.HTTP_200_OK)
        except Student.DoesNotExist:
            return Response(data={'error': 'Student do not exist'}, status=status.HTTP_404_NOT_FOUND)

    def put(self, request, pk):
        try:
            student = Student.objects.get(pk=pk)
            serializer = StudentSerializer(instance=student, data=request.data)
            if serializer.is_valid():
                serializer.save()
                return Response(data=serializer.data, status=status.HTTP_200_OK)
            return Response(data=serializer.errors, status=status.HTTP_400_BAD_REQUEST)
        except Student.DoesNotExist:
            return Response(data={'error': 'Student do not exist'}, status=status.HTTP_404_NOT_FOUND)

    def delete(self, request, pk):
        try:
            student = Student.objects.get(pk=pk)
            student.delete()
            return Response(status=status.HTTP_204_NO_CONTENT)
        except Student.DoesNotExist:
            return Response(data={'error': 'Student do not exist'}, status=status.HTTP_404_NOT_FOUND)


""" 通用类视图 """
class GenericStudentList(generics.ListCreateAPIView):
    """ ListCreateAPIView 包含了 GET POST 方法 """
    # 重写父类的queryset和serializer_class
    queryset = Student.objects.all()     # Student.objects.all() 并不直接查询, 在使用到queryset的时候才会查询, 每次使用的时候都会重新查询一遍
    serializer_class = StudentSerializer

    # def perform_create(self, serializer):   # 重写perform_create方法来修改保存逻辑
    #     serializer.save()


class GenericStudentDetail(generics.RetrieveUpdateAPIView):
    """ GET PUT DELETE """
    queryset = Student.objects.all()
    serializer_class = StudentSerializer


""" DRF的视图集: viewsets """
class StudentViewSet(viewsets.ModelViewSet):
    """ 自动生成所有方法: GET POST PUT DELETE """
    queryset = Student.objects.all()
    serializer_class = StudentSerializer

    # 配置 permission 权限
    permission_classes = (IsAuthenticated, IsOwnerOrReadOnly)  # 优先级比全局配置高, 会覆盖全局配置

    # 配置 authenticated 验证
    authentication_classes = (BasicAuthentication, SessionAuthentication, TokenAuthentication)