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
-- 可以将数据进行加法后再显示, 用()括起来
```

```sql
select * from goods order by price desc;   -- 降序显示, 不写的话默认是升序(asc)
```

```sql
select * from goods limit 0, 3;   -- limit start n;  从 start+1 页开始, 读取n行
```

```sql
select id, avg(price) from goods group by id;  -- 以group的不同值划分成多个组, 分组显示数据
select id, a(price) from goods group by id having sum(price) > 3000;   -- 过滤
select id, count(*), avg(price) from goods group by id;   -- 分组, 每个组单独计算
```

顺序: where .. group by .. having .. order by .. limit .. ;



#### 多表查询select

```sql
select * from users, goods;  -- 会得到所有组合
-- 如果想避免出现笛卡尔集, 条件要 >= 表数-1
select * from users, goods where users.id = goods.id;  
-- 解读: 从所有组合中, 选择user.id和goods.id相等的数据, 组成一张表
```

```sql
-- 自连接: 有很多方式, eg:内连接
select A.name as 'higher', B.name as 'lower' from goods as A, goods as B where A.id = B.id and A.price > B.price; 
```

```sql
-- 内连接: 只选择满足连接条件的数据
select users.id, goods.name from users inner join goods on users.id = goods.id;
```

```sql
-- 左外连接: 左表完全显示, 右表数据插进来, 如果右表没有数据就给null
select users.id, users.name, goods.name from users left join goods on users.id = goods.id; 
-- 右外连接: 与左连接相反
select users.id, users.name, goods.name from users right join goods on users.id = goods.id; 
```



```sql
-- 子查询: 子查询先查出来一个数据, 然后父查询再用该数据进行过滤
select * from goods where id = (select id from goods where name = 'Mac');
-- 子查询还可以当做临时表使用
select customers.id, price from (select id from users) as customers, goods where customers.id = goods.id;
-- all any使用
-- Q: 查询表中价格比id = 2商品高的所有商品的名称
select name from goods where price > all(select price from goods where id = 2);   -- 和所有比
select name from goods where price > any(select price from goods where id = 2);   -- 和任意一个比
-- 多列子查询
-- Q: 查询id, price和Mac都相同的商品
select * from goods where (id, price) = (select id, price from goods where name = 'Mac');
```



#### 合并查询

```sql
-- 合并多个select结果, 需要列数相同
select * from users
union all	-- union all:不会去重   union:会去重
select * from goods;
```





##### where条件过滤  特殊

```sql
like 模糊查询  -- %: 0到多个任意字符  _:单个任意字符
not like
between .. and .. 左闭右闭
in

is null 判断是否为空
= 判断是否相等
```

