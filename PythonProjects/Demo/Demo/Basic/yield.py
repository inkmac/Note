# 生成器是特殊的迭代器

def generator(n):    # 生成器函数
    count = 1
    while count <= n:
        yield count
        count += 1

# 获得生成器对象
obj = generator(3)
print(next(obj))
print(next(obj))
print(next(obj))    # 迭代完就没有数据了, 需要重新获得生成器

obj = generator(3)
for i in obj:       # 用for循环遍历
    print(i, end=" ")

