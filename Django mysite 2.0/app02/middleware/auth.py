from django.utils.deprecation import MiddlewareMixin
from django.shortcuts import HttpResponse, redirect

class M1(MiddlewareMixin):
    """ 中间件  需要在settings的MIDDLEWARE注册 """
    """
    如果 process_request 没有返回值, 继续向后走
    如果有返回值, 就直接退出
    """

    def process_request(self, request):
        # 0.排除那些不需要登录就可以访问的页面
        #   request.path_info 获取当前用户请求的URL /login/
        if request.path_info in ["/app02/login/", "/image/code/"]:
            return

        # 1.读取当前访问的用户的session信息, 如果读到了, 说明登陆过, 继续向后走
        info = request.session.get("info")

        # 2.没有登陆过, 返回登录页面
        if not info:
            return redirect("/app02/login/")


    def process_response(self, request, response):
        return response




