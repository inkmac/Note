from app02 import models
from django import forms
from django.core.validators import RegexValidator
from django.core.exceptions import ValidationError


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

