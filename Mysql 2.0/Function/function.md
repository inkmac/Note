### 字符串函数

```sql
select charset(name) from goods;   -- 获得某列的编码
select concat(name, ' is ', price, '￥') from goods;   -- 拼接字符串
select instr('inkmac', 'mac');  -- 返回substring出现的位置, 没有返回0
select ucase('hello, world');  -- ucase转成大写  lcase转成小写
select left('helloworld', 5);  -- 从左边取5个字符; right() 就是从右边
select length('长度');  -- 统计字符串所占字节大小
select replace(name, 'MacBook', 'Macbook') from goods;   -- 替换显示的数据(不修改实际数据)
select strcmp('inkmac', 'inksac');  -- 比较是否相同
select substring('inkmac', 4, 3);  -- 从第4个位置开始[索引从1开始], 取3个字符; 如果取多少个字符不写, 默认取到末尾
select ltrim('  inkmac');  -- ltrim去除左边空格  rtrim去除右边  trim去除两边
```

补充: 这些都可以对列的使用, 效果会作用于整列



### 数学函数

```sql
select abs(-122);  -- 绝对值
select ceiling(6.5);  -- 向上取整
select floor(6.5);  -- 向下取整
select format(78.24788, 2);  -- 保留2位小数
select least(1, -2, 5, -3, 4);  -- 求最小值; 求最大值是greatest
select mod(10, 3);  -- 取余 
select rand();  -- [0-1]的随机数, 如果()内加上数字, 生成的数就是固定的
select bin(6);  -- 10进制转2进制
select conv(100, 2, 10);  -- 从2进制转成10进制 
```



### 日期函数

```sql
select current_date();  -- 日期
select current_time();  -- 时间
select now();  -- 日期+时间
select year(now());  -- 只获取year 

select date(now());  -- 只显示日期部分
select date_add(now(), interval 20 year);  -- 日期相加; date_sub就是减
select datediff(now(), '2023-12-1');  -- 得到相差的days 

select unix_timestamp();  -- 时间戳
select from_unixtime(170000000, '%Y-%m-%d %H:%i:%s');  -- 时间戳转换成时间

-- mysql中, 日期可以直接比较
```



### 加密和系统函数

```sql
select user();  -- 用户@IP
select database();  -- 查询当前使用的数据库
select md5('hello, world');  -- md5加密
select password('hello, world');  -- password加密
```



### 流程控制函数

```sql
select if(true, 'hello', 'world');  -- 如果为true, 就返回第二个, 否则返回第三个
select ifnull(null, 'default value');   -- 如果为null, 就返回第二个

-- case的条件为 true
select case when true then 'expr1' when true then 'expr2' else 'else' end;  
-- case的条件为 'condition'
select case 'condition' when true then 'expr1' when 'condition' then 'expr2' else 'else' end;  
```

案例
```sql
-- 现有一个表:  id | math | chinese | english | total
create table scores (  
    id int primary key auto_increment,  
    math int not null,  
    chinese int not null,  
    english int not null,  
    total int not null  
);

insert into scores (math, chinese, english, total) values  
(85, 90, 88, 263),  
(92, 88, 90, 270),  
(78, 85, 82, 245),  
(95, 92, 93, 280),
(70, 70, 78, 218),
(60, 66, 70, 196),
(50, 60, 59, 169),
(60, 60, 60, 180)
;

-- 查询 成绩合格情况
select 
	id,
	case when math >= 60 then concat(math, ' 及格') else concat(math, ' 不及格') end math,
	case when chinese >= 60 then concat(chinese, ' 及格') else concat(chinese, ' 不及格') end chinese,
	case when english >= 60 then concat(english, ' 及格') else concat(english, ' 不及格') end english,
	case when total >= 250 then concat(total, ' A') when total < 250 and total >= 180 then concat(total, ' B') 
		else concat(total, ' C') end total
from scores;
```


