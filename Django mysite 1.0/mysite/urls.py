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
from django.urls import path

from app01 import views
from app02 import views as app02_views

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
    path('app02/user/list/', app02_views.user_list),
    path('app02/user/add/', app02_views.user_add),
    path('app02/user/delete/', app02_views.user_delete),
    path('app02/user/<int:nid>/edit/', app02_views.user_edit),
    path('app02/user/modelform/add/', app02_views.user_modelform_add),

    path('app02/pretty/list/', app02_views.pretty_list),
    path('app02/pretty/add/', app02_views.pretty_add),
    path('app02/pretty/<int:nid>/edit/', app02_views.pretty_edit),
    path('app02/pretty/<int:nid>/delete/', app02_views.pretty_delete),

]
