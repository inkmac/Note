```sql
create table demo (
	id int primary key auto_increment,  -- 从1开始, 每次加入数据id自动+1
);

-- 自增一般跟 PK 或 unique 一起使用
-- 自增默认从1开始, 可以用alter table demo auto_increment = 100 修改自增开始值
-- 添加数据时候, 给自增长列有指定的值, 按指定的值为准; 且下一次自增长值 = max + 1
```

