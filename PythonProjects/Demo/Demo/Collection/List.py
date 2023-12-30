data: list = [1, 1, 2, 3, True]

# 末尾追加
data.append("bob")
# 插入
data.insert(3, "4")
# 根据索引删除
del data[2]   # 删除索引为 2 的元素
# 根据元素值删除元素
data.remove(True)   # 删除值为 True 的元素
# 移除最后一个元素
data.pop()

# 清空List
data.clear()
# 排序
data.sort()  # 从小到大
data.sort(reverse=True)  # 从大到小

# 获取长度
size = len(data)
# 索引处的数据
d1 = data[0]
d2 = data[-1]   # 负数从最后一个开始找
# 得到数据的索引
index = data.index(2)
# 获取数据出现的次数
num = data.count(1)

# 切片
part = data[0:2]  # 左闭右开
part1 = data[1:]  # 从1开始切一直到最后
# for循环遍历
for i in data:
    print(i)
# 倒序遍历
for item in reversed(data):
    print(item)

# 连接数组
string = ','.join(data)   # 用 , 连接数组