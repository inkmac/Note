class Phone:
    def call(self):
        print("Use Phone to call")


class MyPhone(Phone):       # python支持多继承
    def call(self):
        print("Use MyPhone to call~")
        super().call()    # 用super().成员名 调用父类成员
        Phone.call(self)    # 直接指定调用某个类的成员


obj = MyPhone()
obj.call()
