import time
from datetime import datetime, timedelta

v = time.time()   # 时间戳, 可以用来计算时间差
print(v)

time.sleep(1)


v = datetime.now()  # 本地时间
print(v)

v = datetime.utcnow()  # utc时间
print(v)

v = v + timedelta(days=7, hours=3)  # 加7d, 3h
print(v)

v = v.strftime("%Y-%m-%d %H:%M:%S")   # 转换成format字符串
print(v)

