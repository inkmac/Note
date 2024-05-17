#### 表的复制和去重

```sql
create table copy (
	id int,
    name varchar(10),
    price double
);
```

```sql
insert into copy select * from goods;   -- 复制表的数据
```

```sql
insert into copy select * from copy;   -- 自我复制
```

```sql
create table copy02 like copy;  -- 复制表的结构
```

```sql
create table temp like goods;   -- 创建一张临时表
insert into temp select distinct * from goods;	-- 用distinct将重复的数据去除掉, 并加入到temp
delete from goods;  -- 删除goods的所有数据
insert into goods select * from temp;  -- 得到去重的数据
drop table temp;  -- 删除临时表
```

