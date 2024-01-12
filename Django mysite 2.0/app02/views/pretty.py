from django.shortcuts import render, redirect
from django import forms
from django.core.validators import RegexValidator
from django.core.exceptions import ValidationError
from ..utils.pagination import Pagination
from app02 import models


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


class PrettyModelForm(forms.ModelForm):
    # 校验: 方式1
    mobile = forms.CharField(
        label="手机号",
        validators = [RegexValidator(r"^1[3-9]\d{9}$", "手机号格式错误")],   # 可以包含多个正则
    )

    def __init__(self, *args, **kwargs):
        super().__init__(*args, **kwargs)

        # 循环找到所有插件, 添加bootstrap样式
        for name, field in self.fields.items():
            field.widget.attrs = {"class": "form-control"}

    # 校验: 方式2
    def clean_mobile(self):
        txt = self.cleaned_data["mobile"]
        exist = models.PrettyNum.objects.exclude(id=self.instance.pk).filter(mobile=txt).exists()   # 检查是否存在
        if len(txt) != 11:
            raise ValidationError("格式错误")
        if exist:
            raise ValidationError("手机号已存在")
        return txt   # 验证通过, 返回用户输入的值


    class Meta:
        model = models.PrettyNum
        fields = ["mobile", "price", "level", "status"]
        # fields = "__all__"    # 全部字段
        # exclude = ["level"]   # 去除的字段


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
