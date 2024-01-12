from django.shortcuts import render, HttpResponse, redirect
from django import forms
from app02.utils.boostrap import BootStrapForm, BootStrapModelForm
from app02 import models
from pathlib import Path

def upload_list(request):
    if request.method == "GET":
        return render(request, "upload_list.html")

    print(request.FILES)   # request发过来的文件
    file_obj = request.FILES.get("avatar")
    file_name = file_obj.name   # 获取文件名

    with open("avatar.png", mode='wb') as f:
        for chunk in file_obj.chunks():
            f.write(chunk)

    return HttpResponse("...")


# class UpForm(BootStrapForm):
#     bootstrap_exclude_fields = ["avatar"]
#     name = forms.CharField()
#     age = forms.IntegerField()
#     avatar = forms.FileField()
#
# def upload_form(request):
#     title = "Form上传"
#     if request.method == "GET":
#         form = UpForm()
#         return render(request, "upload_form.html", {"title": title, "form": form})
#
#     form = UpForm(data=request.POST, files=request.FILES)
#     if form.is_valid():
#         img_obj = form.cleaned_data.get("img")
#         media_path = Path(f"/media/{img_obj.name}")
#         with media_path.open("wb") as f:
#             for chunk in img_obj.chunks():
#                 f.write(chunk)
#
#         # 差一步, 信息写入数据库
#
#         return HttpResponse("GGG")
#
#     return render(request, "upload_form.html", {"title": title, "form": form})


class UpModelForm(BootStrapModelForm):
    bootstrap_exclude_fields = ['avatar']
    class Meta:
        model = models.Boss
        fields = "__all__"

def upload_modelform(request):
    if request.method == "GET":
        form = UpModelForm()
        return render(request, "upload_form.html", {"title": "UploadModelForm", "form": form})

    form = UpModelForm(data=request.POST, files=request.FILES)
    if form.is_valid():
        # 文件: 自动保存到media, 路径保存到数据库
        # 其他: 保存到数据库
        form.save()
        return HttpResponse("SUCCESS")
    return render(request, "upload_form.html", {"title": "UploadModelForm", "form": form})
