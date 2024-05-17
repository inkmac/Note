
```sql
create [or replace] view myview as select... [with [cascade | local] check option] 

-- 修改成新的视图
alter view myview as select...   
create or replace view myview as select... [with [cascade | local] check option] 

desc myview;  -- 显示视图结构
show create view myview;  -- 查看视图的基本属性

drop view myview01, myview02;  -- 删除视图
```


**with check option**
- with cascade check option :
  通过视图进行的修改操作必须满足该视图定义中 WHERE 子句的条件

- with local check option :
  修改操作不仅需要满足当前视图的where条件, 而且还需要满足该视图所基于的基表的条件


**视图的更新**
要使视图可更新, 视图中的行与基础表中的行之间必须存在一对一的关系。
如果视图包含以下任何一项, 则该视图不可更新:

1. 聚合函数或窗口函数
2. distinct
3. group by
4. having
5. union 或者 union all


