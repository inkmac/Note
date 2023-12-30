# 函数的类型注解
def calc(x: int, y:int) -> int:
    return x + y


# 函数接收多个返回值
def test():
    return 1, "Hello", True

a, b, c = test()


# 不定长参数
def VaraPara1(*args):
    print(args)

VaraPara1(1, "Hello", False)

# 不定长k-v对
def VaraPara2(**kwargs):
    print(kwargs)

VaraPara2(name="Hello", age=11)


# 将函数当做参数传给另一个参数(回调函数)
def add(x, y):
    return x + y

def apply(fun, x, y):
    res = fun(x, y)
    print(res)

apply(add, 1, 2)


# lambda表达式
# lambda 参数: 要执行的语句(只能有一句)
var = lambda x, y: print(x + y)     # 可以用一个变量接收这个lambda表达式, 多次使用
var(1, 5)
var(2, 3)


# 指定一个默认值, 没有默认值的参数应该放在有默认值的参数之前
def output(m = 666):  # 如果输入就覆盖, 没输入就使用默认值
    print(m)

output()
output(111)


# 函数引用
def func():
    print("Hello! func()")

funcRefer = func
funcRefer()   # 这里调用的是 func
