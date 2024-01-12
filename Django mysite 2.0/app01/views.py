from django.shortcuts import render, HttpResponse, redirect

# Create your views here.

def index(request):
    return HttpResponse('Welcome!')


def app01_user_list(request):
    # 如果setting的TEMPLATES的DIRS里面是 os.path.join(BASE_DIR, 'templates')  就先从根目录的templates找
    # 去app目录下的templates目录寻找该文件 (根据settings的install-app注册顺序, 逐一去每个app的templates寻找)
    return render(request, "user_list.html")


def tmpl(request):
    name = "BOB"
    roles = ['A', 'B', 'C']
    info = {"name": "BOB", "age": 10}
                                        # 用一个字典接收所有的变量
    return render(request, 'tmpl.html', {"n1": name, "n2": roles, "info": info})


def sth(request):
    # request 是一个对象, 封装了用户发过来的所有请求相关数据

    # 获取请求方式 GET/POST
    print(request.method)

    # 在URL上传递值  ?后面的值   字典形式
    print(request.GET)

    # 在请求体里面提交数据
    print(request.POST)

    # 将字符串内容返回给请求者
    # return HttpResponse("return content")

    # 读取HTML内容 + 渲染  ->  返回给用户浏览器
    # return render(request, 'app01_user_list.html')

    # 让浏览器重定向到其他页面
    return redirect("https://www.baidu.com")


def login(request):
    if request.method == "GET":
        return render(request, "login.html")

    print(request.method)
    print(request.POST)   # 获取用户提交的数据

    # get的是value的值
    user = request.POST.get("user")
    pwd = request.POST.get("pwd")

    if not (user == 'root' and pwd == 'root'):
        return render(request, "login.html", {"res": "登陆失败"})

    return HttpResponse("登陆成功")


from app01.models import UserInfo
def orm(request):
    # 测试orm操作表中数据

    # 新建数据
    UserInfo.objects.create(name="root", pwd="root")

    # 删除数据
    UserInfo.objects.filter(name="root", pwd="root").delete()   # 先筛选再删除
    UserInfo.objects.all().delete()   # 删除全部

    # 获取数据
    data_list = UserInfo.objects.all()    # 获取全部数据  QuerySet类型
    for obj in data_list:
        print(obj.id, obj.name, obj.pwd, obj.age)

    obj = UserInfo.objects.filter(id=1)
    first_obj = UserInfo.objects.filter(id=1).first()   # 获取符合条件的第一个对象

    # 更新数据
    UserInfo.objects.filter(name="root").update(pwd="123456")

    return HttpResponse("成功")


def app01_user_add(request):
    if request.method == "GET":
        return render(request, "user_add.html")

    user = request.POST.get("user")
    pwd = request.POST.get("pwd")

    # 添加用户到数据库
    UserInfo.objects.create(name=user, pwd=pwd)
    print(user, pwd)
    return redirect("/app01/user/list")


