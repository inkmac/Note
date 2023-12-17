```sql
# 创建数据库
CREATE DATABASE db02;
# 删除数据库
DROP DATABASE db02;

# 创建数据库, 使用utf8格式, 并带有校对规则
CREATE DATABASE db02 CHARACTER SET utf8 COLLATE utf8_bin;
# 校对规则 utf8_bin 区分大小写   默认的utf8_general_ci 不区分大小写 !
```



```sql
# 显示所有数据库
SHOW DATABASES;
# 显示之前创建的db02数据库的信息
SHOW CREATE DATABASE db02;
```



```sql
# 进入数据库
use db02;
```



##### 关键字冲突解决

```sql
# 创建数据库,表的时候; 为了规避关键字,可以用反引号解决
CREATE DATABASE `CREATE`;
# 相对应的, 删除数据库也要带上反引号
DROP DATABASE `CREATE`;
```



#### 备份恢复数据库

```cmd
# 备份数据库(cmd中运行)
mysqldump -u root -p db01 db02 > D:\\copy.sql

# 恢复数据库(cmd中运行)
source D:\\copy.sql

# 只备份数据库的表
mysqldump -u root -p db01 table1 table2 > D:\\copy.sql
```







