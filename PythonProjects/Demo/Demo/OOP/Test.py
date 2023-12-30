class test:
    n = 10

    def __init__(self):
        self.n += 10    # 当做实例属性
        print(f"{self.n} + self")
        test.n += 10    # 当做静态属性
        print(f"{self.n} + static")

print(test.n)
a = test()
b = test()
c = test()
