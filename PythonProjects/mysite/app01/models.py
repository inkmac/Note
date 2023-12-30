from django.db import models

# Create your models here.

class UserInfo(models.Model):
    # 创建一张表
    name = models.CharField(max_length=32)
    pwd = models.CharField(max_length=64)
    age = models.IntegerField()


# cmd执行操作
# python manage.py makemigrations
# python manage.py migrate