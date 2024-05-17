#### 创建表

```sql
create table test (
	id 数据类型 [comment 注释],
	name 数据类型,
	info 数据类型
) [charset 字符集] [collate 校对规则] [engine 存储引擎] [comment 注释];

-- 如果charset不写, 默认使用数据库的字符集
-- 如果collate不写, 默认使用数据库的校对规则
-- 目前用的比较多的引擎是 INNODB
```



#### 修改表

```sql
alter table test 

add new_field datatype;

-- 修改字段名的数据类型
modify modified datatype;

-- 修改字段名和/或数据类型
change old_name new_name new_datatype;

drop dropped;

-- 修改表名
rename to 新表名;
```



#### 删除表

```sql
-- 完全删除表, 包括表的结构以及其中的所有数据
drop table [if exists] test;

-- 清空表数据
truncate table test;
```



#### 查看表

```sql
show tables;  -- 显示该数据库的所有表  
desc users;  -- 查询表结构
show create table users;  -- 显示users表的建表语句
```





##### 常用数据类型

- 整形

```sql
tinyint  1个字节
smallint  2个字节
mediumint  3个字节
int  4个字节
bigint  8个字节

tinyint unsigned  无符号
```

- 小数类型

```sql
float  4字节
double  8字节
decimal(M,D)
M代表总的数字位数, D为小数点后面数字位数, M最大是65,D最大是30, 如果M不写,默认是10, 如果D不写,默认为0
```

- 文本类型

```sql
char()  固定长度  0-255字节  (括号内填的是字符数)
varchar()  可变长度  0-65535字节  (括号内填的是字符数)   
查询速度: char > varchar
text 0~2^16-1
longtext 0~2^32-1
```

- 二进制数据  (使用较少, 因为效率不高且不方便管理, 通常二进制文件会使用专门的文件服务器进行存储)

```sql
blob 0~2^16-1
longblob 0~2^32-1
```

- 日期类型

```sql
date 日期  YYYY-MM-DD
time 时间  HH:MM:SS
year 年  YYYY
datetime 日期+时间  YYYY-MM-DD HH:MM:SS
timestamp 时间戳  YYYY-MM-DD HH:MM:SS
```



