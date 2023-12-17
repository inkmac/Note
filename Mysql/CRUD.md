### CRUD

```sql
-- 先创建一张表
create table goods (
	id int,
    name varchar(10),
    price double
);
```



#### insert

```sql
insert into goods(id, name, price) values(1, 'Huawei', 2000);
```

```detail
若插入多条数据, values的()用逗号隔开  values(),(),();
如果是给所有字段添加数据, 可以不写 字段名称
当不给某个字段值时候, 如果有默认值就给默认值, 否则报错
```



#### update

```sql
update goods set price = 2500;
update goods set price = 8000 where name = 'Mac';
update goods set price = price + 500 where name = 'Mac';
```

```detail
如果没有where, 会将name列全部修改
如果想一次修改多个数据, 将set后面修改的多个数据用逗号隔开
```



#### delete

```sql
delete from table_name;   -- 删除表中的所有行，但保留表的结构
delete from goods where name = 'Huawei';   -- 删除符合指定条件的行
```



#### select

```sql
select name, price from goods;
select name as OS from goods;   -- 用OS这个别名代替name显示

select * from goods order by price desc;   -- 降序显示, 不写的话默认是升序(asc)

select count(*) from goods where price > 3000; 
select sum(price) from goods;
select avg(price) from goods;
select max(price) from goods;  -- 有max和min两个方法

select id, max(price) from goods group by id;  -- 以group的不同值划分成多个组, 分组显示数据
select id, max(price) from goods group by id having sum(price) > 3000;   -- 过滤
```

```detail
可以将数据进行加法后再显示, 用()括起来
order by应该写在where语句之后
count(*) 返回满足条件个数   count(列) 同样, 但会排除为null的情况

```





###### where条件过滤  特殊

```sql
like 模糊查询
not like
between .. and .. 左闭右闭
in

is null 判断是否为空
= 判断是否相等
```

