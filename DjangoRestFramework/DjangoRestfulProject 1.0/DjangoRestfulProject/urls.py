"""
URL configuration for DjangoRestfulProject project.

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
from django.urls import path, include
from rest_framework.authtoken import views
from rest_framework.documentation import include_docs_urls
from rest_framework.schemas import get_schema_view


urlpatterns = [
    path('api-token-auth/', views.obtain_auth_token),   # 获取Token的接口
    path('api-auth/', include('rest_framework.urls')),   # DRF 的登录和退出
    path('admin/', admin.site.urls),
    path('app01/', include('app01.urls')),     # 加入app01的路由, 根目录为 app01/
    path('schema/', get_schema_view(title="DRF API文档", description=None)),      # 加入文档视图
    path('docs/', include_docs_urls(title="DRF API文档", description=None)),
]

