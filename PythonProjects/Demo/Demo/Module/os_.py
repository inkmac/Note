import os

path = os.path.abspath("Writer.py")
print(path)

path = os.path.abspath(__file__)   # 获取当前文件的绝对路径
print(path)


path = os.path.join("package", "json_.py")   # 从当前目录开始, 拼接路径, 跨平台可用
print(path)

res = os.path.exists(path)  # 判断路径是否存在
print(res)

# os.makedirs(path)   # 创建多级目录

path_list = os.listdir("D:\Coding\PythonProjects\Demo\Demo")  # 查看目录下的文件, 仅1级
print(path_list)

path_list = os.walk("D:\Coding\PythonProjects\Demo\Demo")  #TODO

