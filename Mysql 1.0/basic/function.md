### 统计函数

```sql
select count(*) from goods where price > 3000;  
-- count(*) 返回满足条件的行数   count(列) 同样, 但会排除为null的情况
select sum(price) from goods;
select avg(price) from goods;
select max(price) from goods;  -- 有max和min两个方法
```



### 字符串函数

```sql
select charset(name) from goods;   -- 获得某列的编码
select concat(name, ' is ', price, '￥') from goods;   -- 拼接字符串
select instr('inkmac', 'mac') from dual;  -- 返回substring出现的位置, 没有返回0
-- dual 亚元表,系统表 可以作为测试表使用
select ucase('hello,world') from dual;  -- ucase转成大写  lcase转成小写
select left('helloworld', 5) from dual;  -- 从左边取5个字符; right就是从右边
select length('长度') from dual;  -- 统计字符串所占字节大小
select replace(name, 'MacBook', 'Macbook') from goods;   -- 替换显示的数据(不修改实际数据)
select strcmp('inkmac', 'inksac') from dual;  -- 比较是否相同
select substring('inkmac', 4, 3) from dual;  -- 从第4个位置开始[从1开始], 取3个字符; 如果取多少个字符不写, 默认取到末尾
select ltrim('  inkmac') from dual;  -- ltrim去除左边空格  rtrim去除右边  trim去除两边
```

补充: 这些都可以对列的使用, 效果会作用于整列



### 数学函数

```sql
select abs(-122) from dual;  -- 绝对值
select ceiling(6.5) from dual;  -- 向上取整
select floor(6.5) from dual;  -- 向下取整
select format(78.24788, 2) from dual;  -- 保留2位小数
select least(1, -2, 5, -3, 4) from dual;  -- 求最小值; 求最大值是greatest
select mod(10, 3) from dual;  -- 取余 
select rand() from dual;  -- [0-1]的随机数, 如果()内加上数字, 生成的数就是固定的
select bin(6) from dual;  -- 10进制转2进制
select conv(100, 2, 10) from dual;  -- 从2进制转成10进制 
```



### 日期函数

```sql
select current_date() from dual;  -- 日期
select current_time() from dual;  -- 时间
select now() from dual;  -- 日期+时间
select year(now());  -- 只获取year 

select date(now()) from dual;  -- 只显示日期部分
select date_add(now(), interval 20 year) from dual;  -- 日期相加; date_sub就是减
select datediff(now(), '2023-12-1') from dual;  -- 得到相差的days 

select unix_timestamp() from dual;  -- 时间戳
select from_unixtime(170000000, '%Y-%m-%d %H:%i:%s');  -- 时间戳转换成时间

-- mysql中, 日期可以直接比较
```



### 加密和系统函数

```sql
select user() from dual;  -- 用户@IP
select database() from dual;  -- 查询当前使用的数据库
select md5('hello, world') from dual;  -- md5加密
select password('hello, world') from dual;  -- password加密
```



### 流程控制函数

```sql
select if(true, 'hello', 'world') from dual;  -- 如果为true, 就返回第二个, 否则返回第三个
select ifnull(null, 'return null') from dual;   -- 如果为null, 就显示第二个
select case when true then 'expr1' when true then 'expr2' else 'else' end;  -- 多分支  
```



### 自定义函数

```sql
delimiter $$  -- 将终止符换成$$
create function f1(i1 int, i2 int) returns int
BEGIN
	declare result i;
	set result = x + y;
	return result;
END $$
delimiter ;  
```

```sql
select f1(11,22) from dual;   -- 执行函数
drop function f1;   -- 删除函数
```











