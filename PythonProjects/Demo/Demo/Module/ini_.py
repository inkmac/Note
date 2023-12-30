import configparser

# 自动对文件进行解析
parser = configparser.ConfigParser()
parser.read("my.ini", encoding="UTF-8")

v1 = parser.sections()
print(v1)

v2 = parser.items("mysql_safe")
print(v2)

v3 = parser.get("mysql", "socket")
print(v3)

# TODO