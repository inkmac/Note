```sql
create table demo (
	id int,
    name varchar(10) check (name in('bob', 'steve')),
	sal double check (sal between 1000 and 2000)
);
-- mysql 5.7 暂不支持
```

