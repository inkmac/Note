import random

v = random.randint(0, 2)  # 左闭右闭
print(v)

arr = [11, 22, 33, 44]
v = random.choice(arr)
print(v)

random.shuffle(arr)  # 打乱顺序
print(arr)