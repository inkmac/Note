from django import forms
from django.shortcuts import render, redirect
from app02 import models


def user_list(req):
    queryset = models.UserInfo.objects.all()
    content = {
        "queryset": queryset,
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


# 第二个参数nid 用于获取id的值  根据url的参数
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


class UserModelForm(forms.ModelForm):
    # 这里定义字段的限制
    pwd = forms.CharField(min_length=6, label="密码")

    def __init__(self, *args, **kwargs):
        super().__init__(*args, **kwargs)

        # 循环找到所有插件, 添加bootstrap样式
        for name, field in self.fields.items():
            if name == "pwd":
                field.widget.attrs = {"class": "form-control", "type": "password"}
                continue
            field.widget.attrs = {"class": "form-control"}

    class Meta:
        model = models.UserInfo
        fields = ["name", "pwd", "department"]
        widgets = {
            "name": forms.TextInput(attrs={
                "class": "form-control", "placeholder": "Enter your name",    # 添加bootstrap样式
            }),
            "pwd": forms.TextInput(attrs={
                "class": "form-control", "placeholder": "Enter your password", "type": "password",
            }),
        }


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
