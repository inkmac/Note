"""
URL configuration for mysite project.

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/4.2/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  path('', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  path('', Home.as_view(), name='home')
Including another URLconf
    1. Import the include() function: from django.urls import include, path
    2. Add a URL to urlpatterns:  path('blog/', include('blog.urls'))
"""
from django.contrib import admin
from django.urls import path, re_path
from django.views.static import serve
from django.conf import settings
from app01 import views
from app02.views import user, pretty, admin, account, task, order, chart, upload


urlpatterns = [
    # www.xxx.com/admin/  访问这个网页就会执行 admin.site.urls 函数
    # path('admin/', admin.site.urls),

    path('index/', views.index),
    path('app01/user/list/', views.app01_user_list),
    path('tmpl/', views.tmpl),
    path('sth/', views.sth),    # 请求和响应
    path('login/', views.login),   # 登录界面
    path('orm/', views.orm),
    path('app01/user/add/', views.app01_user_add),


    # app02
    path('app02/user/list/', user.user_list),
    path('app02/user/add/', user.user_add),
    path('app02/user/delete/', user.user_delete),
    path('app02/user/<int:nid>/edit/', user.user_edit),
    path('app02/user/modelform/add/', user.user_modelform_add),

    path('app02/pretty/list/', pretty.pretty_list),
    path('app02/pretty/add/', pretty.pretty_add),
    path('app02/pretty/<int:nid>/edit/', pretty.pretty_edit),
    path('app02/pretty/<int:nid>/delete/', pretty.pretty_delete),

    path('app02/admin/list/', admin.admin_list),
    path('app02/admin/add/', admin.admin_add),
    path('app02/admin/<int:nid>/edit/', admin.admin_edit),
    path('app02/admin/<int:nid>/delete/', admin.admin_delete),

    path('app02/login/', account.login),
    path('app02/logout/', account.logout),
    path('image/code/', account.image_code),

    path('task/', task.task),
    path('task/ajax/', task.task_ajax),
    path('task/add/', task.task_add),

    path('app02/order/list/', order.order_list),
    path('app02/order/add/', order.order_add),
    path('app02/order/delete/', order.order_delete),
    path('app02/order/edit/', order.order_edit),

    path('app02/chart/list/', chart.chart_list),
    path('app02/chart/bar/', chart.chart_bar),

    path('app02/upload/list/', upload.upload_list),
    path('app02/upload/modelform/', upload.upload_modelform),

    # 用户可以直接查看media文件夹的数据
    re_path(r'^media/(?P<path>.*)$', serve, {'document_root': settings.MEDIA_ROOT}, name="media")
]
