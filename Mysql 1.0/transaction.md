#### 事务操作

```sql
create table demo (
	id int,
    name varchar(10)
);

start transaction;   -- 开始事务
savepoint a;  -- 设置保存点
insert into demo values(1, 'bob');  -- 执行dml操作
savepoint b;
insert into demo values(2, 'steve');
rollback to b;  -- 回退到b
rollback to a;
rollback;  -- 表示会直接退到事务开始的状态
commit;   -- 提交事务, 事件完结
```

```sql
-- 需要innodb的引擎
-- 也可以用 set autocommit=off 来开始一个事务
```



#### 隔离级别

```sql
-- 查看当前会话的隔离级别
select @@tx_isolation;
-- 查看当前系统的隔离级别
select @@global.tx_isolation;
-- 设置当前会话隔离级别
set session transaction isolation level Read uncommitted;
-- 设置系统当前隔离级别
set global transaction isolation level [级别];

-- mysql默认隔离级别是 Repeatable Read
-- 如果需要全局修改, 可以在ini文件中配置默认的隔离级别
-- transaction-isolation = Repeatable-Read
-- 可选模式: Read-Uncommitted, Read-Committed, Repeatable-Read, Serializable
-- 需要重启mysql才能生效
```



#### 隔离级别详解

```sql
下面是SQL标准中定义的四种隔离级别，按照严格程度递增：

Read Uncommitted（读未提交）:
允许一个事务读取另一个事务未提交的数据。
可能导致脏读（读取到其他事务未提交的数据）、不可重复读和幻读。

Read Committed（读已提交）:
保证一个事务不会读取到另一个事务未提交的数据。
可能导致不可重复读和幻读。

Repeatable Read（可重复读）:
确保一个事务在执行期间多次读取同一行的结果始终一致。
防止脏读和不可重复读，但仍可能出现幻读。

Serializable（串行化）:
提供最高的隔离级别，确保事务是完全隔离的，防止脏读、不可重复读和幻读。
通过在事务执行期间锁定相关数据，防止其他事务访问。
```

```sql
脏读（Dirty Read）:
脏读发生在一个事务读取了另一个事务未提交的数据时。如果这个事务后来回滚，那么读取的数据就是无效的，因此称为“脏”。
例如，事务A修改了一行数据，但还没有提交。此时，事务B读取了这行数据并使用了它。如果事务A后来回滚了，那么事务B读取的数据就是不正确的。

不可重复读（Non-repeatable Read）:
不可重复读发生在一个事务内多次读取同一行数据时，得到的结果不一致。
例如，事务A在读取某一行数据后，事务B修改了这行数据并提交。当事务A再次读取同一行数据时，得到的值与之前不同，造成不一致。

幻读（Phantom Read）:
幻读是在一个事务中读取了一组数据，然后另一个事务在这之间插入了新的数据，导致第一个事务看到了“幻影”行。
例如，事务A查询了一个范围的数据，然后事务B插入了一行新数据。当事务A再次查询相同范围的数据时，发现有一行之前不存在的数据，产生了幻读现象。
```



#### 事务的ACID

```sql
原子性（Atomicity）:
事务是原子性的，这意味着它要么完全执行，要么完全不执行。如果事务的任何部分失败，整个事务都将回滚到起始点，保持数据库状态的一致性。

一致性（Consistency）:
事务使数据库从一种一致的状态转移到另一种一致的状态。在事务开始之前和结束之后，数据库必须始终保持一致性。事务的执行不会使数据库从一个一致状态转移到另一个不一致的状态。

隔离性（Isolation）:
隔离性确保一个事务的执行不会受到其他事务的干扰。即使多个事务同时运行，每个事务的结果对其他事务是隔离的。这防止了由并发事务引发的数据一致性问题，例如脏读、不可重复读和幻读。

持久性（Durability）:
持久性确保一旦事务被提交，其结果将永久保存在数据库中，并对系统故障具有恢复能力。即使在发生硬件故障、数据库崩溃或其他问题时，已提交的事务的效果也不会丢失。
```







