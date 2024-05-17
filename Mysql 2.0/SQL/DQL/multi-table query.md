### 多表查询select

**再创建一张users表**
```sql
create table users(
    uid int primary key auto_increment,
    uname varchar(5),
    goods_id int
    -- constraint goods_id_fk foreign key (goods_id) references goods(id)
);

insert into users(uname, goods_id) values 
    ('A', 1), ('B', 2), ('C', 3), ('D', 2), ('E', 1),
    ('F', 4), ('G', 5), ('H', 6), ('I', 7), ('G', 7),
    ('K', 4), ('L', 9), ('M', 8), ('N', 3), ('O', 5),
    ('P', 10)
    ;
```


**笛卡尔积**
```sql
select * from users, goods;  -- 会得到所有组合
-- 如果想避免出现笛卡尔集, 条件要 >= 表数-1
select * from users, goods where users.uid = goods.id;  
-- 解读: 从所有组合中, 选择users.uid和goods.id相等的数据, 组成一张表
```

**内连接: 查询A, B两表交集**
```sql
-- 隐式内连接
select * from users, goods where users.goods_id = goods.id;

-- 显式内连接 (inner关键字可省略)
select * from users inner join goods on users.goods_id = goods.id;
```

**外连接**
```sql
-- 左外连接: 查询左表数据(users)的全部数据, 右表数据插进来, 如果右表没有数据就给null  (outer关键字可省略)
select * from users left outer join goods on users.goods_id = goods.id; 
-- 右外连接: 与左连接相反
select * from users right outer join goods on users.goods_id = goods.id; 
```

**自连接**
```sql
-- 自连接: 就是查询的两张表相同, 可用 内连接/外连接 实现 
select A.corporation, A.name higher, B.name lower from goods A, goods B where A.corporation = B.corporation and A.price > B.price; 
```

**联合查询**
```sql
-- 合并多个select结果, 需要列数相同
select * from goods where id > 5 
union all	  -- union all:不会去重   union:会去重
select * from goods where price < 3600;
```

**子查询**
```sql
-- 标量子查询: 子查询查出来的结果是单个值
select * from users where goods_id = (select id from goods where name = 'Macbook');

-- 列子查询
-- 常见操作符: in, not in, all, any/some 
select * from users where goods_id in (select id from goods where price < 5000); 
select name from goods where price > all(select price from goods where corporation = 'Xiaomi');   -- 和所有比
select name from goods where price > any(select price from goods where corporation = 'Apple');   -- 和任意一个比

-- 行子查询
-- 案例: 查询corporation, price和Mac都相同的商品
select * from goods where (corporation, price) = (select corporation, price from goods where name = 'Macbook');

-- 表子查询
-- 常见操作符: in
-- 案例: 查询与Macbook, RedMi的公司和价格相同的商品
select * from goods where (corporation, price) in (select corporation, price from goods where name = 'Macbook' or name = 'RedMi')

-- 表子查询还可以当做临时表使用
-- 案例: 查询购买5000块以下手机的用户
select * from (select * from goods where price < 5000) cheap_goods left join users on users.goods_id = cheap_goods.id; 
```





