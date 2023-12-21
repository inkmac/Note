```sql
create table demo (
	id int primary key,
    name varchar(10)
);
-- 主键列的值不能重复, 且不能为null
-- 一张表最多一个主键, 但可以是复合主键
-- 用 desc table 查看pk情况
```

```sql
-- 复合主键
create table demo (
	id int,
    name varchar(10),
    primary key (id, name)  -- 把 id + name 看成一个整体, 就是复合主键
);
```

