class Message:
    to = "Windows"      # static属性(用对象访问不是static的, 用类访问是static的)
    content = "Hello, World"

    def __init__(self, to, content):   # 构造器
        self.to = to
        self.content = content
        self.memberAttr = None   # 成员属性

    def send(self):
        print(f"TO {self.to}: {self.content}")

    @staticmethod
    def s_method():   # static方法
        print("This is a static method")


obj = Message("Linux", "Hello,world")
obj.send()
print(Message.content)
Message.s_method()
