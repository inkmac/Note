name = "bob"
age = 10

# format
text = "姓名={0}, 年龄={1}; 可以复用{0}".format(name,age)  # 根据索引来
text2 = "姓名={}, 年龄={}".format(name,age)  # 直接对号入座
print(text)

# f-string格式
text = f"姓名={name}, 年龄={age}"
print(text)

# r-string: \ 不生效
# 正则表达式里面建议全部使用r-string
text = r"Hello\tWorld"
print(text)
