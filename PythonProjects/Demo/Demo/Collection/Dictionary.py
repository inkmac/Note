info: dict = {"k": "sa", "a": 10}

# 获取k对应的v, 如果没有就返回None
value = info.get("k")

# 获取k对应的v, 如果没有就报错
value2 = info["k"]

# 获取所有的k, v, k-v
list1 = info.keys()
list2 = info.values()
list3 = info.items()

# 获取长度
size = len(info)
