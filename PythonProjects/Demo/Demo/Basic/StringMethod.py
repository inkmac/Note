s = "PhysicsOnTop"

# 获取长度
size = len(s)

# 判断是否已xx开头
res1: bool = s.startswith("Physics")
res2: bool = s.endswith("Top")

# 判断是否为数字
res3: bool = s.isdecimal()

# 转换为大小写
msg1 = s.upper()
msg2 = s.lower()

# 去除两侧空白和\n, 必须要一个string来接收, 不然去除无效
msg3 = s.strip()

# 替换内容(替换所有的内容)
msg4 = s.replace("A", "B")   # A -> B

# 分割字符串, 得到一个字符串list
msg5: list[str] = s.split("On")   # 得到 n + 1 条数据!!!!
print(msg5)

# 索引(不支持修改)
index = s[0]

# 切片
part = s[0:6]   # 左闭右开

# 获取一个内容出现的次数
count = s.count("P")

# for循环遍历string
for i in s:
    print(i, end="")

