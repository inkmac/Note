from bs4 import BeautifulSoup
import requests

url = "https://www.rust-lang.org/"   # 外网web
resp = requests.get(url)
resp.encoding = "utf-8"

print(resp.text)

# 将页面源代码交给BeautifulSoup处理, 生成bs对象
page = BeautifulSoup(resp.text, "html.parser")  # 指定html解析器

# 从bs对象中查找数据
# find(标签, 属性=值)
# find_all(标签, 属性=值)
result = page.find("table", class_="")
result = page.find("table", attrs={"class": ""})   # 和上一行一个作用

name = result.text   # 获取文本
src = result.get("")   # 获取标签的属性

resp.close()