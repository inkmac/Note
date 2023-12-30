import json

# json格式
# {}单引号括起来, 里面的key用""括起来
# true false要小写的
# 没有元组, 只有列表
# json没法序列化所有数据类型, 可以先转换成可序列化的内容

data = '{"k1": 123, "k2": 456, "k3": true}'
data_py = json.loads(data)  # 转换成python的数据
print(data_py)

data = json.dumps(data_py)  # 转换成json格式
print(data)
