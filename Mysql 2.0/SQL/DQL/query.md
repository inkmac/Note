### QUERY

```sql
-- 先创建一张表
create table goods (
	id int auto_increment primary key,
    name varchar(10),
    price double,
    corporation varchar(10)
);

insert into goods (name, price, corporation) values 
    ('Mate60', 6500, 'Huawei'), ('Nova', 2200, 'Huawei'),
    ('MacBook', 9000, 'Apple'), ('iPad', 6500, 'Apple'), ('iPhone', 6000, 'Apple'), 
    ('Oppo', 3000, 'OPPO'),  ('Vivo', 2000, 'OPPO'), 
    ('RedMi', 1800, 'Xiaomi'), ('XiaoMi', 3100, 'Xiaomi')
    ;
```



#### select

```sql
select name, price from goods;

select name as OS from goods;   -- 用OS这个别名代替name显示
select name from goods as it;   -- 用it作为临时表名 代替goods
-- as关键字可省略

select distinct name from goods;   -- 去除name字段相同的数据
select distinct name, price from goods; -- 将distinct作用于name,price两个字段上

-- 可以将数据进行加法后再显示, 用()括起来
```

```sql
select corporation, avg(price) from goods group by corporation;  -- 以group的不同值划分成多个组, 分组显示数据
select corporation, avg(price) from goods group by id having average(price) > 3000;   -- 用having对group进行过滤

-- 案例: 查询price > 5000的产品, 并根据公司分组, 且该公司产品总数 >= 2
select corporation, count(*), avg(price) from goods where price > 5000 group by corporation having count(*) >= 2;   
```
**where与having区别**
执行时机不同: where是分组前过滤, 不满足where条件的, 不分组; 而having是对分组后结果进行过滤
判断条件不同: where不能使用统计函数, 而having可以

**注意**
使用group by分组后, 查询字段一般都为聚合函数和被分组的字段, 查询其他字段没有任何意义
Mysql 8.0 及以后, 使用group by后, 查询的字段强制要求为聚合函数和被分组的字段

```sql
select * from goods order by price desc;   -- 降序显示, 不写的话默认是升序(asc)

-- 案例: 以price升序排序, 如果price相同, 则再按照id降序排序
select * from goods order by price asc, id desc; 
```

```sql
-- limit startIndex n;   从第 startIndex 条数据开始(从0开始), 往后查询n条数据
select * from goods limit 0, 10;   -- 查询第1 - 10条数据 (第一页)
select * from goods limit 10, 10;  -- 查询第10 - 20条数据 (第二页)

-- 分页查询不是sql自带的, 不同的数据库有不同的实现
```


书写顺序: where .. group by .. having .. order by .. limit .. 
执行顺序: from -> where -> group by -> having -> select -> order by -> limit




##### where条件过滤  特殊

```sql
=  等于
!=  <> 不等于
like 模糊查询  --  _:单个任意字符   %: 0到多个任意字符 
between .. and .. 左闭右闭
in(a, b, c, d)   看是否在列表当中
is null 判断是否为空   # Mysql特供: isnull() 函数判断


and 或 &&    
or 或 ||
not 或 !
```