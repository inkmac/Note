from django.db import models


class Teacher(models.Model):
    name = models.CharField(max_length=255, unique=True)


class Student(models.Model):
    name = models.CharField(max_length=255, unique=True)
    age = models.IntegerField()
    description = models.TextField(null=True, blank=True)
    created_time = models.DateTimeField(auto_now_add=True)   # 自动设置为创建时间
    teacher = models.ForeignKey(Teacher, on_delete=models.CASCADE, null=True, blank=True)   # 外键字段, 关联Teacher表

    class Meta:
        ordering = ('created_time',)   # 查询时得到结构默认按照created_time字段升序排序
