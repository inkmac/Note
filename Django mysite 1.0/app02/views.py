import math
from django.shortcuts import render, redirect
from app02 import models
from .utils.pagination import Pagination
from .utils.form import UserModelForm, PrettyModelForm


def user_list(req):
    queryset = models.UserInfo.objects.all()
    page_sys = Pagination(req, queryset)
    content = {
        "queryset": page_sys.page_queryset,
        "page_str": page_sys.generate_html(),
    }
    return render(req, "user_list.html", content)


def user_add(request):
    if request.method == "GET":
        content = {
            'department_choices': models.Department.objects.all()
        }
        return render(request, "user_add.html", content)

    name = request.POST.get("name")
    pwd = request.POST.get("pwd")
    department_id = request.POST.get("choice")
    models.UserInfo.objects.create(name=name, pwd=pwd, department_id=department_id)

    return redirect("/app02/user/list/")


def user_delete(request):
    # 获取id的值
    # http://127.0.0.1:8000/department/delete/?nid=1
    nid = request.GET.get('nid')
    models.UserInfo.objects.filter(id=nid).delete()

    return redirect("/app02/user/list/")


# 第二个参数nid 获取id的值  根据url的参数
def user_edit(request, nid):
    modify_obj = models.UserInfo.objects.filter(id=nid).first()  # 用first()直接获取对象, 而不是queryset

    if request.method == "GET":
        content = {
            'department_choices': models.Department.objects.all(),
            "modify_obj": modify_obj,
        }
        return render(request, 'user_edit.html', content)

    if request.method == "POST":
        name = request.POST.get("name")
        pwd = request.POST.get("pwd")
        department_id = request.POST.get("choice")
        models.UserInfo.objects.filter(id=nid).update(name=name, pwd=pwd, department_id=department_id)
        return redirect("/app02/user/list/")


def user_modelform_add(request):
    if request.method == "GET":
        # obj = models.UserInfo.objects.filter(id=7).first()
        # form = UserModelForm(instance=obj)    # 指定生成的对象 (只生成id=7的数据)

        form = UserModelForm()   # 生成一个空表
        return render(request, "user_modelform_add.html", {"form": form})

    # data = UserModelForm(data=request.POST, instance=obj)  意思就是更新数据到obj, 而不是新增数据
    data = UserModelForm(data=request.POST)
    if data.is_valid():     # 如果合法, 就保存到数据库
        data.save()
        return redirect("/app02/user/list/")
    else:
        return render(request, "user_modelform_add.html", {"form": data})



def pretty_list(request):
    date_dict = {}
    search_data = request.GET.get("q", "")
    if search_data:
        date_dict["mobile__contains"] = search_data

    """ 分页系统 """
    # 1.获取要展示的数据
    queryset = models.PrettyNum.objects.filter(**date_dict).order_by("-level")   # "-level" 就是倒序排列

    # 2.实例化对象
    page_sys = Pagination(request, queryset)

    content = {
        "search_data": search_data,
        "queryset": page_sys.page_queryset,
        "page_str": page_sys.generate_html(),
    }

    return render(request, 'pretty_list.html', content)


def pretty_add(request):
    if request.method == "GET":
        form = PrettyModelForm()
        return render(request, "pretty_add.html", {"form": form})

    form = PrettyModelForm(data=request.POST)
    if form.is_valid():
        form.save()
        return redirect("/app02/pretty/list")
    return render(request, "pretty_add.html", {"form": form})


def pretty_edit(request, nid):
    obj = models.PrettyNum.objects.filter(id=nid).first()

    if request.method == "GET":
        form = PrettyModelForm(instance=obj)
        return render(request, "pretty_edit.html", {"form": form})

    form = PrettyModelForm(data=request.POST, instance=obj)
    if form.is_valid():
        form.save()
        return redirect("/app02/pretty/list")
    return render(request, "pretty_edit.html", {"form": form})


def pretty_delete(request, nid):
    models.PrettyNum.objects.filter(id=nid).delete()
    return redirect("/app02/pretty/list")


