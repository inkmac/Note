# 'w'模式: 覆盖之前内容
# 'a'模式: 追加到之前内容的末尾

path = open("C:/JavaIO/PythonIO/Writer.txt", mode='w', encoding="UTF-8")

path.write("Hello, Writer")
path.write("\nThis is Windows")

path.flush()
path.close()

