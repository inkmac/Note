from io import BytesIO
from django.shortcuts import render, redirect, HttpResponse
from django import forms
from app02 import models
from app02.utils.boostrap import BootStrapForm
from app02.utils.encrypt import md5
from app02.utils.code import check_code


class LoginForm(BootStrapForm):
    username = forms.CharField(
        label="用户名",
        widget=forms.TextInput,
        required=True,
    )
    pwd = forms.CharField(
        label="密码",
        widget=forms.PasswordInput(render_value=True),
        required=True,
    )

    code = forms.CharField(
        label="请输入验证码",
        widget=forms.TextInput,
        required=True,
    )

    def clean_pwd(self):
        pwd = self.cleaned_data.get("pwd")
        return md5(pwd)


def login(request):
    if request.method == "GET":
        form = LoginForm()
        return render(request, "account_login.html", {"form": form})

    form = LoginForm(data=request.POST)
    if form.is_valid():
        user_input_code = form.cleaned_data.pop('code')  # 获取验证码, 同时从session中删除
        code = request.session.get("image_code", "")

        if code != user_input_code:
            form.add_error("code", "验证码错误")
            return render(request, "account_login.html", {"form": form})

        obj = models.Admin.objects.filter(**form.cleaned_data).first()   # 用解包 ** 更简单
        if obj:
            # 设置浏览器关于用户的session
            request.session["info"] = {"id": obj.id, "name": obj.username}
            request.session.set_expiry(60 * 60 * 24 * 30)    # 一个月内免登录
            return redirect("/app02/admin/list/")

        form.add_error("pwd", "用户名或密码错误")   # 主动显示错误信息
        return render(request, "account_login.html", {"form": form})

    return render(request, "account_login.html", {"form": form})


def logout(request):
    request.session.clear()   # 清除历史记录
    return redirect("/app02/login/")


def image_code(request):
    img, code_string = check_code()
    # 写到session中, 以便后续校验
    request.session['image_code'] = code_string
    # 设置验证码有效时间 60s超时
    request.session.set_expiry(60)

    stream = BytesIO()
    img.save(stream, 'png')
    return HttpResponse(stream.getvalue())