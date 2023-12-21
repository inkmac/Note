```sql
create user 'newer'@'localhost' identified by '123456';
-- '用户名'@'IP'   '123456'是密码, mysql存储的是加密过的

drop user 'newer'@'localhost'  -- 删除用户

-- 登录后可以直接修改自己的密码
set password = password('Bugjump');
-- 修改他人密码, 需要权限
set password for 'others'@'localhost' = password('123456');  -- 权限不够会被拒绝


select * from mysql.user;  -- 查看所有用户
```

```sql
-- 创建用户时候, 如果不指定IP, 则为%, %表示所有IP都可以连接
create user jack;

-- 也可以指定一个范围
create user 'smith'@'192.168.1.%';
```



#### 用户授权

```sql
grant 权限 on 库.对象名 to '用户名'@'IP' (idenified by 'pwd');
-- 权限 可以有多个 用逗号隔开
-- 对象: 表, 视图, 存储过程等
-- idenified by 可以省略, 也可以写出, 若写出: 如果用户存在就是修改用户密码, 如果不存在就是创建该用户

-- 回收用户权限
revoke 权限 on 库.对象名 from '用户名'@'IP';

-- 如果给了权限但没有生效, 可以刷新一下
flush privileges;
```







