from django.db import models

class Department(models.Model):
    # verbose_name 注解
    title = models.CharField(verbose_name="标题", max_length=32)

    def __str__(self):
        return self.title


class UserInfo(models.Model):
    name = models.CharField(max_length=16)
    pwd = models.CharField(max_length=16)

    # to: 与哪张表关联   to_field: 关联哪一个字段, 不写默认连接到表的主键字段
    # 定义的名字是department, 但是django自动会加上id, 所以实际名字是department_id
    # on_delete=models.CASCADE  关联的部门被删除, 关联的用户也删除
    department = models.ForeignKey(to="Department", to_field="id", on_delete=models.CASCADE, null=True, blank=True)

    # on_delete=models.SET_NULL  置空, 前提是允许为空
    # department = models.ForeignKey(to="Department", to_fields="id", null=True, blank=True, on_delete=models.SET_NULL)

    # 用 obj.department_id 获取字段值
    # 用 obj.department 会根据department_id自动获取连接到的department对象, 因此 obj.department.title 就直接获取部门名称


    # Django的约束, 代表以后只能写1, 2, 然后1,2分别代表男,女
    gender_choices = (
        (1, "男"),
        (2, "女"),
    )
    gender = models.SmallIntegerField(choices=gender_choices, null=True, blank=True)
    # 想获取对应的名称  用 obj.get_字段名_display()


class PrettyNum(models.Model):
    mobile = models.CharField(verbose_name="手机号", max_length=11)
    price = models.IntegerField(verbose_name="价格", default=0)

    level_choices = (
        (1, "1级"),
        (2, "2级"),
        (3, "3级"),
    )
    level = models.SmallIntegerField(verbose_name="级别", choices=level_choices, default=1)

    status_choices = (
        (0, "已占用"),
        (1, "未使用"),
    )
    status = models.SmallIntegerField(choices=status_choices, default=1)



