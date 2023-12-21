```sql
-- 查看所有的存储引擎
show engines;
```

```sql
-- 修改存储引擎
alter table demo engine = innodb;
```



```sql
innodb  1.支持事务 2.支持外键 3.支持行级锁
myisam  1.添加速度快 2.不支持外键,事务 3.支持表级锁
memory  1.数据存储在内存中[关闭mysql, 数据会丢失, 但表结构还在] 2.执行速度快 3.默认支持索引(基于hash) 
```



```sql
如果不需要事务, 只需要基本的CRUD, 选择Myisam
需要支持事务, 选innodb
面对大量IO操作, 且只需要短期使用, 选memory
```

