# app01的url配置文件
from django.urls import path, include
from rest_framework.routers import DefaultRouter

from app01 import views

# 创建一个路由实例
router = DefaultRouter()
# 指定viewset, 并且指定url前缀
router.register(prefix='student', viewset=views.StudentViewSet)

urlpatterns = [
    # 函数实现
    # path('student/', views.student_list, name='student_list'),
    # path('student/<int:pk>/', views.student_detail, name='student_detail'),

    # 类实现
    # path('student/', views.StudentList.as_view(), name='student_list'),
    # path('student/<int:pk>/', views.StudentDetail.as_view(), name='student_detail'),

    # 通用类实现
    # path('student/', views.GenericStudentList.as_view(), name='student_list'),
    # path('student/<int:pk>/', views.GenericStudentDetail.as_view(), name='student_detail'),

    # viewsets
    # path('student/', views.StudentViewSet.as_view({
    #     'get': 'list',   # key: Http请求方法  value: viewsets中对应的方法
    #     'post': 'create'
    # }), name='student_list'),
    # path('student/<int:pk>/', views.StudentViewSet.as_view({
    #     'get': 'retrieve',
    #     'put': 'update',
    #     'delete': 'destroy'
    # }), name='student_detail'),

    # viewsets router
    path('', include(router.urls))   # 导入router的路由
]