m = 10
print(m, id(m))

def a():
    global m    # 用global声明来说明这个m是全局变量的m
    m = 100     # 如果没有用global声明, 就默认是函数内部新声明的变量
    print(m, id(m))

a()
print(m, id(m))