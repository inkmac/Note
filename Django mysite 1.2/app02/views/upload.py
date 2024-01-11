from django.shortcuts import render, HttpResponse, redirect

def upload_list(request):
    if request.method == "GET":
        return render(request, "upload_list.html")

    print(request.FILES)   # request发过来的文件
    file_obj = request.FILES.get("avatar")
    file_name = file_obj.name   # 获取文件名

    with open("avatar.png", mode='wb') as f:
        for chunk in file_obj.chunks():
            f.write(chunk)

    return HttpResponse("...")
