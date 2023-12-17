#### 字符串函数

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

补充: 这些都是针对列的方法, 效果会作用于整列, 用字符串是为了方便演示



#### 数学函数

```sql
select abs(-122) from dual;  -- 绝对值
select ceiling(6.5) from dual;  -- 向上取整
select floor(6.5) from dual;  -- 向下取整
select format(78.24788, 2) from dual;  -- 保留2位小数
select least(1, -2, 5, -3, 4) from dual;  -- 求最小值; 求最大值是greatest
select () from dual;  -- 
select () from dual;  -- 
select () from dual;  -- 
select bin(6) from dual;  -- 10进制转2进制
select conv(100, 2, 10) from dual;  -- 从2进制转成10进制 
```

