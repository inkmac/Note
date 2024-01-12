from django.shortcuts import render, redirect, HttpResponse
from django.http import JsonResponse


def chart_list(request):
    return render(request, 'chart_list.html')


def chart_bar(request):
    legend = ["销量", "业绩"]
    series_list = [
        {
            "name": '销量',
            "type": 'bar',
            "data": [5, 20, 36, 10, 20]
        },
        {
            "name": '业绩',
            "type": 'bar',
            "data": [15, 20, 16, 50, 10]
        }
    ]
    x_axis = ['1', '2', '3', '4', '5']

    result = {
        "status": True,
        "data": {
            "legend": legend,
            "series_list": series_list,
            "x_axis": x_axis
        }
    }

    return JsonResponse(result)

