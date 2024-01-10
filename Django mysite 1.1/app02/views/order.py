import random
from datetime import datetime
from django.shortcuts import HttpResponse, redirect, render
from django.views.decorators.csrf import csrf_exempt
from django.http import JsonResponse
from app02 import models
from app02.utils.boostrap import BootStrapModelForm


class OrderModelForm(BootStrapModelForm):
    class Meta:
        model = models.Order
        exclude = ["oid", "admin"]


def order_list(request):
    form = OrderModelForm()
    return render(request, "order_list.html", {"form": form})


@csrf_exempt
def order_add(request):
    form = OrderModelForm(data=request.POST)
    if form.is_valid():
        # 增加oid的值
        form.instance.oid = datetime.now().strftime("%Y%m%d%H%M%S") + str(random.randint(1000, 9999))
        # 获取当前登录的admin的信息  通过session获取
        form.instance.admin_id = request.session["info"]["id"]

        form.save()
        return JsonResponse({"status": True})

    return JsonResponse({"status": False, "error": form.errors})