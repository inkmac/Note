import requests
import re

url = "https://movie.douban.com/top250"

para = {

}

headers = {
    "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36"
}

resp = requests.get(url, headers=headers)
page = resp.text

pattern = re.compile(r'<a href=".*?" class="">.*?<span class="title">(.*?)</span>', flags=re.S)
name = pattern.findall(page)
for each in name:
    print(each)

resp.close()