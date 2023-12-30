import re

text = "Hello,world"
data = re.findall("l.+o", text)    # 贪婪匹配: 在匹配的情况下尽可能匹配最长的字符串
print(data)

# 在 + * 这种可以不限长度的符号后面加上 ? 就可以变成非贪婪匹配
data = re.findall("l.+?o", text)   # 非贪婪匹配
print(data)
