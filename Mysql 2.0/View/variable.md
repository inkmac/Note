#### 系统变量

系统变量 是MySQL服务器提供, 不是用户定义的, 属于服务器层面。分为全局变量 (global), 会话变量 (session)。

- 查询系统变量
```sql
show [session | global] variables;  -- 查看所有系统变量
show [session | global] variables LIKE '......';   -- 可以通过LIKE模糊匹配方式查找变量


select @@[session | global].系统变量名;  -- 查看指定变量的值
```

- 设置系统变量
```sql
set [session | global] 系统变量名 = 值 ;
set @@[session | global].系统变量名 = 值 ;
```

> 注意:
> 1. mysql服务重新启动之后, 所设置的全局参数会失效, 要想不失效, 可以在 my.ini 中配置
> 2. 如果没有指定 session/global, 默认是session



#### 用户自定义变量




#### 局部变量


