# 选择读取模式'r'
path = open("C:/JavaIO/PythonIO/new3.txt", mode='r', encoding="UTF-8")

# 读取指定字节内容, 不指定默认读取全部
print(f"读取10bytes的结果: {path.read(8)}")
print(f"读取全部内容的结果: {path.read()}")  # 会接着上一次读取到的位置继续读取

# 需要重新打开, 才能重新读
# readlines表示的是读取全部文件, 封装到列表中
path = open("C:/JavaIO/PythonIO/new3.txt", mode='r', encoding="UTF-8")
lines = path.readlines()
print(f"line的读取内容: {lines}")


# readline方法, 一次只读取一行
path = open("C:/JavaIO/PythonIO/new3.txt", mode='r', encoding="UTF-8")
line1 = path.readline()
line2 = path.readline()
print(f"第一行数据: {line1}")
print(f"第二行数据: {line2}")


# for循环读取, 每次读取的是一行
path = open("C:/JavaIO/PythonIO/new3.txt", mode='r', encoding="UTF-8")
for line in path:
    print(f"每一行数据: {line}")


# 关闭文件!!!
path.close()


# with open(path) 语法, 会自动关闭文件
with open("C:/JavaIO/PythonIO/new3.txt", mode='r', encoding="UTF-8") as path:
    print("with()")
    for line in path:
        print(f"每一行数据: {line}")

