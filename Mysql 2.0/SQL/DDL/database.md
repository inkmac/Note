## Database

```sql
# 创建数据库                           使用的字符集              校对规则
create database [if not exists] db02 [default charset utf8mb4] [collate utf8_bin];
# utf8mb4存储的容量比utf8更大
# 校对规则 utf8_bin 区分大小写   默认的utf8_general_ci 不区分大小写 

# 删除数据库
drop database [if exists] db02;
```



```sql
# 显示所有数据库
show database;
# 显示db02的 建库语句
show create database db02;
# 查看当前所在数据库
select database();
```



```sql
# 进入数据库
use db02;
```



##### 关键字冲突解决

```sql
# 创建数据库,表的时候; 为了规避关键字,可以用反引号解决
create database `create`;
# 相对应的, 删除数据库也要带上反引号
drop database `create`;
```



#### 备份恢复数据库

```cmd
# 备份数据库(cmd中运行)
mysql> mysqldump -u root -p db01 db02 > D:\\copy.sql

# 恢复数据库(cmd中运行)
mysql> source D:\\copy.sql

# 只备份数据库的表
mysql> mysqldump -u root -p db01 table1 table2 > D:\\copy.sql
```







