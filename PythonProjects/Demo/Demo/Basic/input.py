# print每次输出都会自动换行, 如果不想自动换行需要加上 end=""
for i in range(5):
    print("hello ", end="")

# python的input默认为str类型
a: str = input("input:")

# \ 做结尾当做续行符
b = "hello" \
    "world"
print(b)