from django.db import models


# 创建一张表
# 会自动给一个id字段, 带主键和自增
class UserInfo(models.Model):
    name = models.CharField(max_length=32)
    pwd = models.CharField(max_length=32)
    level = models.CharField(max_length=32, default="user")
    # data = models.IntegerField(null=True, blank=True)

    # 如果如果新增字段, 需要设置一个默认值, default= ;或者选择 1),迁移的时候设置默认值; 或者允许为空null=True, blank=True
    # 如果想删除字段, 直接将字段删除或注释掉



'''
想要创建表, 需要先将app在setting里面注册, 否则迁移失败
cmd执行操作
python manage.py makemigrations
python manage.py migrate
'''
