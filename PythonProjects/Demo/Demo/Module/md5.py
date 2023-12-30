import hashlib

#  用md5对用户密码进行加密
def encrypt(data):
    # obj = hashlib.md5()
    obj = hashlib.md5("Hello123@Tom".encode("UTF-8"))  # 给md5加盐, 更难破译
    obj.update(data.encode("UTF-8"))
    res = obj.hexdigest()
    return res


def run():
    user = input("输入用户名: ")
    pwd = input("输入密码: ")
    password = encrypt(pwd)
    print(f"{user}: {password}")


if __name__ == '__main__':
    run()