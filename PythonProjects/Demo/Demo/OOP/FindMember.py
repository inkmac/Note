class Father:
    a = 1
    def f1(self):
        print(self.a)    # python的属性和方法都统统从运行类型开始寻找

class Son(Father):
    a = 2

son = Son()
son.f1()

father = Father()
father.f1()