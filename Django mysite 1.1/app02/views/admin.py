from django.shortcuts import render, redirect
from django import forms
from django.core.exceptions import ValidationError

from app02 import models
from ..utils.boostrap import BootStrapModelForm
from app02.utils.encrypt import md5


def admin_list(request):
    queryset = models.Admin.objects.all()
    content = {
        "queryset": queryset,
    }

    return render(request, "admin_list.html", content)


class AdminModelForm(BootStrapModelForm):
    confirm_password = forms.CharField(
        label="Confirm Password",
        widget= forms.PasswordInput,    # 输入的密码是隐藏的
        # widget= forms.PasswordInput(render_value=True),    # 保留原来的值
    )

    def clean_pwd(self):
        pwd = self.cleaned_data.get("pwd")
        return md5(pwd)

    def clean_confirm_password(self):
        print(self.cleaned_data)
        pwd = self.cleaned_data.get("pwd")
        confirm = md5(self.cleaned_data.get("confirm_password"))
        if confirm != pwd:
            raise ValidationError("密码不一致")
        return confirm      # 就是验证成功之后, 保存到form字典的值


    class Meta:
        model = models.Admin
        fields = ["username", "pwd"]
        widgets = {
            "pwd": forms.PasswordInput,
        }


def admin_add(request):
    if request.method == "GET":
        form = AdminModelForm()
        return render(request, "admin_change.html", {"form": form, "title": "Admin Registration Form"})

    form = AdminModelForm(data=request.POST)
    if form.is_valid():
        form.save()
        return redirect("/app02/admin/list/")

    return render(request, "admin_change.html", {"form": form, "title": "Admin Registration Form"})


def admin_edit(request, nid):
    obj = models.Admin.objects.filter(id=nid).first()
    if request.method == "GET":
        form = AdminModelForm(instance=obj)
        return render(request, "admin_change.html", {"form": form, "title": "Admin Edit Form"})

    form = AdminModelForm(data=request.POST, instance=obj)
    if form.is_valid():
        form.save()
        return redirect("/app02/admin/list/")

    return render(request, "admin_change.html", {"form": form, "title": "Admin Edit Form"})


def admin_delete(request, nid):
    models.Admin.objects.filter(id=nid).delete()
    return redirect("/app02/admin/list/")
