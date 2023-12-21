#### 索引优化

```sql
create demo (
	id int primary key,
    name varchar(10)
);

create index id_index on demo(id);    -- 在demo的id上创建索引, 名为id_index
-- 产生一个二叉树索引

-- 会占用一定磁盘空间
-- 对 update delete insert 效率产生影响
```



#### 索引类型

```sql
-- unique索引
create unique index id_index on demo(id);
-- 普通索引
create index id_index on demo(id);
alter table demo add index id_index (id);  -- way2
-- 主键索引 
alter table demo add primary key (id);

-- mysql自带的 fullindex 一般不使用, 选择 solr 和 ElasticSearch
```

```sql
-- 查询表是否有索引
show indexes from demo;
show index from demo;
show keys from demo;
```

```sql
-- 删除索引
drop index id_index on demo;
-- 删除主键索引 
alter table demo drop primary key;
```



#### 什么时候创建索引

```sql
较频繁作为where查询条件的字段应该创建索引
唯一性太差的字段不适合单独创建索引
更新很频繁的字段不适合创建索引
不会出现在where中作为查询条件的字段不该创建索引
```

