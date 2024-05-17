```sql
-- 查询当前数据库支持的存储引擎
show engines; 
-- InnoDB在Mysql 5.5 版本开始成为表的默认存储引擎

-- 修改表引擎
alter table mytable engine = InnoDB;
```



```sql
InnoDB  1.支持事务 2.支持外键 3.支持行级锁
myisam  1.读取,插入速度快 2.不支持外键,事务 3.支持表级锁
memory  1.数据存储在内存中, 关闭mysql, 数据会丢失, 但表结构还在 2.执行速度快 3.默认支持索引(基于hash) 
```


