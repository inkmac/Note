from urllib.request import urlopen

url = "https://www.baidu.com"
resp = urlopen(url)

print(resp.read().decode("utf-8"))  # 读取到网页源代码

