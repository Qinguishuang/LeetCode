# 31.获取select * from employees对应的执行计划
explain
select *
from employees;

# 32.将employees表的所有员工的last_name和first_name拼接起来作为Name，中间以一个空格区分
select last_name || ' ' || first_name as name
from employees;
select concat(concat(last_name, ' '), first_name) as neame
from employees;

# 33. 创建一个actor表，包含如下列信息
# 列表 	类型 	是否为NULL 	含义
# actor_id 	smallint(5) 	not null 	主键id
# first_name 	varchar(45) 	not null 	名字
# last_name 	varchar(45) 	not null 	姓氏
# last_update 	timestamp 	not null 	最后更新时间，默认是系统的当前时间

create table actor
(
    actor_id    smallint(5) primary key,
    first_name  varchar(45) not null,
    last_name   varchar(45) not null,
#     last_update timestamp   not null default (datetime('now', 'localtime'))
    last_update timestamp   not null
);

# 34.对于表actor批量插入如下数据
insert into actor(actor_id, first_name, last_name, last_update)
values (1, 'penelope', 'guiness', '2006-02-15 12:34:33'),
       (2, 'NICK', 'WAHLBERG', '2006-02-15 12:34:33');
select *
from actor;

# 35. 对于表actor批量插入如下数据,如果数据已经存在，请忽略，不使用replace操作
insert ignore into actor
values (3, 'ED', 'CHASE', '2006-02-15 12:34:33');
# insert or ignore into actor values (3, 'ED', 'CHASE', '2006-02-15 12:34:33');


# 36. 创建一个actor_name表，将actor表中的所有first_name以及last_name导入改表。
create table actor_name
(
    first_name varchar(45) not null,
    last_name  varchar(45) not null
);
insert into actor_name
select first_name, last_name
from actor;

create table actor_name
select first_name, last_name
from actor;

# 37.对first_name创建唯一索引uniq_idx_firstname，对last_name创建普通索引idx_lastname
create unique index uniq_idx_first_name on actor (first_name);
create index idx_last_name on actor (last_name);

# 38. 针对actor表创建视图actor_name_view，只包含first_name以及last_name两列，
# 并对这两列重新命名，first_name为first_name_v，last_name修改为last_name_v：
create view actor_name_view(first_name_v, last_name_v) as (select first_name, last_name
                                                           from actor);

# 39. 针对salaries表emp_no字段创建索引idx_emp_no，查询emp_no为10005, 使用强制索引。
# select *
# from salaries force index idx_emp_no where emp_no=10005;

# 40.现在在last_update后面新增加一列名字为create_date, 类型为datetime, NOT NULL，默认值为'0000 00:00:00'
alter table actor
    add create_date datetime not null default '0000-00-00 00:00:00';



