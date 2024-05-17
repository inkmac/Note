查询权限
```sql
show grants for 'user'@'IP';
```

授予权限
```sql
grant 权限 on 库.对象名 to 'user'@'IP';
-- 权限可以有多个, 用逗号隔开
-- 库或表可以用 * 通配符, 表示所有

-- 如果给了权限但没有生效, 可以刷新一下
flush privileges;
```

撤销权限
```sql
revoke 权限 on 库.对象名 from 'user'@'IP';
```


**权限列表**
```sql
all, all privileges   所有权限
select                查询数据
insert                插入数据
update                修改数据
delete                删除数据
alter                 修改表
drop                  删除数据库/表/视图
create                创建数据库/表/视图
```


