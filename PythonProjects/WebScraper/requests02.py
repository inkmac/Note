import re
import requests


url = "https://dytt89.com/"
resp = requests.get(url=url, verify=False)   # verify=False 去掉安全验证
# 出现乱码, 原因resp会自动识别并转换编码格式, 但有时会出错, 需要指定编码方式, 编码方式在html <head>中找
resp.encoding = "gb2312"


pattern = re.compile(r'2023必看热片.*?<ul>(.*?)</ul>', flags=re.S)
result = pattern.findall(resp.text)
for each in result:
    print(each)

print("END---------")
resp.close()