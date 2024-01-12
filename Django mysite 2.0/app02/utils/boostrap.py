from django import forms

class BootStrap:
    bootstrap_exclude_fields = []

    """ 带有BootStrap样式的类 """
    def __init__(self, *args, **kwargs):
        super().__init__(*args, **kwargs)
        for name, field in self.fields.items():
            # exclude的属性不添加样式
            if name in self.bootstrap_exclude_fields:
                continue

            # 添加attrs属性
            if field.widget.attrs:
                field.widget.attrs["class"] = "form-control"
                field.widget.attrs["placeholder"] = field.label
            else:
                field.widget.attrs = {
                    "class": "form-control",
                    "placeholder": field.label,
                }


class BootStrapModelForm(BootStrap, forms.ModelForm):
    pass


class BootStrapForm(BootStrap, forms.Form):
    pass