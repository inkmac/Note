```sql
create table class (
	id int primary key,
    name varchar(10)
);

create table stu (
	id int primary key,
    name varchar(10),
    room int,
    constraint fk foreign key (room) references class(id)   -- 让room指向class的id
);

insert into class values(100, 'java'), (200, 'web');
insert into stu value(1, 'tom', 100), (2, 'jack', 200);
insert into stu value(3, 'hsp', 300);   -- 加入失败, 因为 class 300 不存在
select * from stu;

-- 外键指向的字段, 要求为 primary key 或者 unique
-- 表的类型必须是innodb, 这样的表才支持外键
-- 外键的数据类型必须和指向的数据类型保持一致
-- 外键字段的值, 必须在指向的数据中出现过, 或者为null
-- 一旦建立主外键的关系, 数据就不能随意删除了
```



**修改表**


```sql
-- 添加外键
alter table 表 add constraint 外键名称 foreign key 外键应用的字段 references 主表(关联的主表的字段);

-- 删除外键
alter table 表 drop foreign key 外键名称;
```



**删除, 更新行为**
No action, restrict, cascade, set null
```sql
-- 默认No action: 不可删除或更新 (与restict一样)

alter table 表 add constraint 外键名称 foreign key 外键应用的字段 references 主表(关联的主表的字段)
on update cascade on delete cascade;   
-- 在更新/删除主表外键字段时, 更新/删除子表中外键的数据

alter table 表 add constraint 外键名称 foreign key 外键应用的字段 references 主表(关联的主表的字段)
on update set null on delete set null;  
-- 在更新/删除主表外键字段时, 置空子表中外键的数据 (要求子表中外键允许为null)
```

