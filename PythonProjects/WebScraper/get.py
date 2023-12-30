# 安装requests
# terminal 执行 pip install request
# 国内下载(清华源, 关闭vpn): pip install -i https://pypi.tuna.tsinghua.edu.cn/simple requests

import requests

url = "https://www.sogou.com/web?query=周杰伦"
header = {
    "User-Agent":"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/119.0.0.0 Safari/537.36"
}

resp = requests.get(url, headers=header)
print(resp)
print("-------")
print(resp.text)  # 页面源代码

resp.close()  # 关闭resp