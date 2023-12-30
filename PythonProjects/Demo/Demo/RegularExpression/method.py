import re

text = "Hello, 123 want 123@World"
data = re.findall(".." ,text)   # 获取所有匹配成功的数据
print(data)


text = "逗2B最逗3B欢乐"
data = re.finditer("逗\dB", text)   # 获取所有匹配成功的数据, 返回一个迭代器
for each in data:
    print(each.group())


text = "逗2B最逗3B欢乐"
data = re.match("逗\dB", text)   # 从文本开头匹配, 如果开头不匹配就返回None
print(data)   # 是一个对象
print(data.group())   # 用data.group()提取数据


text = "大小逗2B最逗3B欢乐"
data = re.search("逗\dB", text)  # 只获取第一个匹配成功的数据
print(data.group())


# 预加载正则表达式
pattern = re.compile(r"逗\dB")
# pattern = re.compile(r"逗\dB", flags=re.S)  使用re.S会使.匹配任何字符, 包括\n
text = "大小逗2B最逗3B欢乐"
data = pattern.finditer(text)