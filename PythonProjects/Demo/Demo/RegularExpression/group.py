import re

# 对于findall
text = "Hello, 123want123@World"
data = re.findall("(want(.+))", text)    # 分组, 结果获取()内的值
print(data)

# 对于finditer
data = re.finditer("(?P<outer>want(?P<inner>.+))", text)    # 用 ?P<> 分组
for each in data:
    print(each.group("inner"))
    print(each.group("outer"))


# | 的使用
data = re.findall("123(\w+t|.+)", text)    # 或, 可以与()或[]配合使用
print(data)
