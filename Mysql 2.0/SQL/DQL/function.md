### 聚合函数

```sql
select count(*) from goods where price > 3000;  
-- count(*) 返回所有满足条件的行数   count(列) 同样, 但会排除为null的情况
select sum(price) from goods;
select avg(price) from goods;
select max(price) from goods;   -- 有max和min两个方法
```