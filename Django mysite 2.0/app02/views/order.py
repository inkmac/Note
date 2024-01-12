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
    queryset = models.Order.objects.all().order_by('-id')
    form = OrderModelForm()
    content = {
        "queryset": queryset,
        "form": form,
    }
    return render(request, "order_list.html", content)


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


def order_delete(request):
    uid = request.GET.get("uid")
    exist =  models.Order.objects.filter(id=uid).exists()
    if exist:
        models.Order.objects.filter(id=uid).delete()
        return JsonResponse({"status": True})
    else:
        return JsonResponse({"status": False, "error": "数据不存在"})


@csrf_exempt
def order_edit(request):
    uid = request.GET.get("uid")
    if request.method == "GET":
        # 将数据转换成字典
        obj_dict = models.Order.objects.filter(id=uid).values("id", "title", "price", "status").first()
        if obj_dict:
            return JsonResponse({"status": True, "data": obj_dict})
        else:
            return JsonResponse({"status": False, "error": "数据不存在"})


# 暂时有bug: 修改数据 -> 会新增数据而不是修改
