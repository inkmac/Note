### 自定义函数

```sql
delimiter $$  -- 将终止符换成$$
create function f1(i1 int, i2 int) returns int
begin
	declare result i;
	set result = x + y;
	return result;
end $$
delimiter ;  
```

```sql
select f1(11,22);   -- 执行函数
drop function f1;   -- 删除函数
```
