```sql
create view myview as select... 
alter view myview as select...   -- 更新成新的视图
show create view myview;  -- 查看视图的基本属性
drop view myview01, myview02;  -- 删除视图
desc myview;  -- 显示视图结构
```



```sql
CRUD 和 table 一模一样
修改视图, 会影响基表; 修改基表, 也会影响视图
视图中可以再使用视图
```





```sql
总结:
视图是根据基表(可以是多个基表)创建的, 是虚拟的表
视图也有列, 数据来自基表
通过视图可以修改基表的数据 
基表的改变, 也会影响到视图的数据 
```

