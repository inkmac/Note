```sql
-- 行锁, 因为id有索引
update course set name = 'SpringBoot' where id = 2 ;

-- 表锁, 因为name无索引
update course set name = 'SpringBoot' where name = 'PHP' ;
```

InnoDB的行锁是针对索引加的锁，不是针对记录加的锁 ,并且该索引不能失效，否则会从行锁升级为表锁 。