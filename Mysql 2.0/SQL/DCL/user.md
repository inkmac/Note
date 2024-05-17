查询用户
```sql
use mysql;
select * from user;  -- 查看所有用户
```

创建用户
```sql
create user 'newer'@'localhost' identified by '123456';
-- '用户名'@'IP'   '123456'是密码, mysql存储的密码是加密过的
-- 只能在指定IP的主机上登陆

-- 创建用户时候, 如果不指定IP, 则为%, %表示所有IP都可以连接
create user 'jack';

-- 也可以指定一个范围, 使用 % 通配符
create user 'smith'@'192.168.1.%';
```

修改用户密码
```sql
alter user 'jack' identified with mysql_native_password by '1234';
```

删除用户
```sql
drop user 'newer'@'localhost'; 
```