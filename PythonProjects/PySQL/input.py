import pymysql

user = input("user: ")
password = input("password: ")


# 连接mysql
conn = pymysql.connect(host="127.0.0.1", port=3306,
                       user="root", password=f"{password}", charset="utf8")
cursor = conn.cursor()

# 关闭连接
cursor.close()
conn.close()