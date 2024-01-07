from django import forms

class BootStrapModelForm(forms.ModelForm):
    """ 带有BootStrap样式的ModelForm, 直接继承使用 """
    def __init__(self, *args, **kwargs):
        super().__init__(*args, **kwargs)
        for name, field in self.fields.items():
            # 添加attrs属性
            if field.widget.attrs:
                field.widget.attrs["class"] = "form-control"
                field.widget.attrs["placeholder"] = field.label
            else:
                field.widget.attrs = {
                    "class": "form-control",
                    "placeholder": field.label,
                }

