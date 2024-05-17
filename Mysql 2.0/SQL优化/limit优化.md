优化思路: 
- 一般分页查询时，通过创建 覆盖索引 能够比较好地提高性能，可以通过覆盖索引加子查询形式进行优化。

```sql
-- 示例:
explain select * from tb_sku t , (select id from tb_sku order by id limit 2000000,10) a 
where t.id = a.id;
```