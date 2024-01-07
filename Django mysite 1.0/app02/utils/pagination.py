import math
from django.utils.safestring import mark_safe


class Pagination:
    def __init__(self, request, queryset, page_size=10, page_param="page", plus=2):
        self.page = int(request.GET.get(page_param, 1))    # if request.GET.get(page_param, 1).isdecimal() else 1
        self.page_size = page_size
        start = (self.page - 1) * page_size
        end = self.page * page_size
        self.page_queryset = queryset[start: end]
        self.page_param = page_param

        data_count = queryset.count()   # 统计数据总数
        self.page_count = math.ceil(data_count / page_size)


    def generate_html(self):
        start_page = self.page - 2 if self.page - 2 > 0 else 1
        end_page = self.page + 2 if self.page + 2 < self.page_count else self.page_count

        prev_page = self.page - 1 if self.page - 1 > 0 else 1
        prev_html = f'<li class="page-item"><a class="page-link" href="?{self.page_param}={prev_page}">上一页</a></li>'
        next_page = self.page + 1 if self.page + 1 < self.page_count else self.page_count
        next_html = f'<li class="page-item"><a class="page-link" href="?{self.page_param}={next_page}">下一页</a></li>'

        page_str_list = [prev_html]
        for i in range(start_page, end_page + 1):
            if i == self.page:
                ele = f'<li class="active page-item"><a class="page-link" href="?{self.page_param}={i}">{i}</a></li>'
            else:
                ele = f'<li class="page-item"><a class="page-link" href="?{self.page_param}={i}">{i}</a></li>'
            page_str_list.append(ele)
        page_str_list.append(next_html)
        page_str = mark_safe("".join(page_str_list))

        return page_str


    def url_param(self):
        pass



"""  
在 views function 中:
    def view(request)
        queryset = models.UserInfo.objects.all()    # 1.获取需要显示的数据
        page_sys = Pagination(request, queryset)    # 2.实例化对象
        content = {
            "queryset": page_sys.page_queryset,
            "page_str": page_sys.generate_html(),
        }
        return render(req, "user_list.html", content)


在 html 中:
    <div>
        <nav aria-label="Page navigation example">
            <ul class="pagination">
                {{ page_str }}
            </ul>
            <form class="d-flex" role="search" method="get" style="width: 250px;">
                <input name="page" class="form-control me-2" type="search" placeholder="页数" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </nav>
    </div>
"""