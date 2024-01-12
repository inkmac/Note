import json
from django.shortcuts import render, HttpResponse
from django.http import JsonResponse
from django.views.decorators.csrf import csrf_exempt
from ..utils.boostrap import BootStrapModelForm
from .. import models

class TaskModelForm(BootStrapModelForm):
    class Meta:
        model = models.Task
        fields = "__all__"


def task(request):
    queryset = models.Task.objects.all().order_by("-id")
    form = TaskModelForm()
    content = {
        "form": form,
        "queryset": queryset,
    }
    return render(request, "task.html", content)


@csrf_exempt   # 免除POST的csrf验证
def task_ajax(request):
    print(request.GET)
    print(request.POST)

    date_dict = {"status": True, "data": [11,22,33,44]}
    json_str = json.dumps(date_dict)
    return HttpResponse(json_str)
    # return JsonResponse(date_dict)    # 用Django内置的json模块完成


@csrf_exempt
def task_add(request):
    print(request.POST)

    # 1.用户发来的数据进行校验
    form = TaskModelForm(data=request.POST)
    if form.is_valid():
        form.save()
        data_dict = {"status": True}
        return HttpResponse(json.dumps(data_dict))

    data_dict = {"status": False, "error": form.errors}
    return HttpResponse(json.dumps(data_dict))
