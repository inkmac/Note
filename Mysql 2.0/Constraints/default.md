```sql
create table user (
	id int,
    status char(1) default '1',  -- 默认值
    gender char(1) not null   -- 不允许为null
)
```

