#### 创建表

```sql
create table table_name (
	id 数据类型,
	name 数据类型,
	info 数据类型
)character set 字符集 collate 校对规则 engine 存储引擎;

-- 如果character set不写, 默认使用数据库的字符集
-- 如果collate不写, 默认使用数据库的校对规则
-- 目前用的比较多的引擎是 INNODB
```



#### 修改表

```sql
-- 每次修改只能执行一个操作(即add,modify,drop的其中之一)
alter table table_name 
add (
    added datatype
);

-- Modifying the data type of an existing column in a table
modify (
	modified datatype
);

drop (
	dropped datatype
);

-- 显示表的结构
desc serched_table;
-- 修改表名
rename table 表名 to 新表名;
-- 修改表字符集
alter table 表名 character set 字符集;
```



#### 删除表

```sql
-- 完全删除表, 包括表的结构以及其中的所有数据
drop table table_name;
```





##### 常用数据类型

- 整形

```datatype
tinyint  1个字节
smallint  2个字节
mediumint  3个字节
int  4个字节
bigint  8个字节

-- unsigned  无符号
```

- 小数类型

```datatype
float  4字节
double  8字节
decimal(M,D)
M代表总的数字位数, D为小数点后面数字位数, M最大是65,D最大是30, 如果M不写,默认是10, 如果D不写,默认为0
```

- 文本类型

```datatype
char()  固定长度  0-255字符  
varchar()  可变长度  0-65535字节  但本身需要占用1-3bytes用于记录存放数据的大小, 且括号内写的的是字符个数(跟编码有关) 
查询速度: char > varchar
text 0~2^16-1
longtext 0~2^32-1
```

- 二进制数据

```datatype
blob 0~2^16-1
longblob 0~2^32-1
```

- 日期类型

```datatype
data 日期
time 时间
datatime 日期+时间  YYYY-MM-DD HH:mm:ss
timestamp 时间戳
```



