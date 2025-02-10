from django.conf import settings
from django.db.models.signals import post_save
from django.dispatch import receiver
from rest_framework.authtoken.models import Token


# generate_token 方法会在用户被创建后自动被调用
@receiver(post_save, sender=settings.AUTH_USER_MODEL)
def generate_token(sender, instance, created, **kwargs):
    """ 创建用户时自动生成Token """
    if created:
        Token.objects.create(user=instance)
