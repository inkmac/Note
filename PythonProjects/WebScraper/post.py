import requests

url = "https://fanyi.baidu.com/sug"

word = input("输入要翻译的英文:")
data = {
    "kw": word
}

# 发送post请求, 发送的数据必须放在字典中
resp = requests.post(url, data=data)
print(resp.json())   # 将服务器返回内容直接处理成json() => 字典

resp.close()