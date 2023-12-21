```sql
delimiter $$ 
create procedure p1()
BEGIN
	select * from users;
END $$
delimiter ; 
```

```sql
-- 执行
call p1()

-- 删除
drop procedure p1;
```



