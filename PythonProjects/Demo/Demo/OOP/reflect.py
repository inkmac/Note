class Message:
    def __init__(self, to, content):
        self.to = to
        self.content = content

message = Message("Windows", "Hello, World")
setattr(message, "to", "Linux")  # 修改
getTo = getattr(message, "to")  # 获取
print(getTo)