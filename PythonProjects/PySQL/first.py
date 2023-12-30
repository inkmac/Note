import pymysql

# 连接mysql
conn = pymysql.connect(host="127.0.0.1", port=3306,
                       user="root", password="None", charset="utf8")
cursor = conn.cursor()

# 如果要查看数据, 需要 cursor.fetchall
cursor.execute("use db01")
cursor.execute("show tables")
result = cursor.fetchall()
print(result)

# 如果要修改数据, 需要 commit
cursor.execute("insert into t1 values('Python insertion')")
conn.commit()

# 关闭连接
cursor.close()
conn.close()
