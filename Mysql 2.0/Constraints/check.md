```sql
create table demo (
	id int,
    name varchar(5) check (length(name) >= 2),
	sal double check (sal between 1000 and 2000)   
    -- check: 保证字段值满足某一个条件
    -- 用法:check (condition)
);
-- mysql 8.0.16 后支持
```

