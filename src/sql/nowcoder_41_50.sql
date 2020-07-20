# 41. 构造一个触发器audit_log, 在向employees_test表中插入一条数据的时候, 触发插入相关的数据到audit中.
# create trigger audit_log
#     after insert
#     on employees_test
# begin
#     insert into audit values (NEW.ID, NEW.NAME);
# end;

# 42. 删除emp_no重复的记录，只保留最小的id对应的记录

delete
from titles_test
where id not in (select tmp.id
                 from (
                              (select min(titles_test.id) as id from titles_test group by emp_no)) as tmp);

# 43. 将所有to_date为9999-01-01的全部更新为NULL,且 from_date更新为2001-01-01。
update titles_test
set from_date='2001-01-01',
    to_date=NULL
where to_date = '9999-01-01';

# 44. 将id=5以及emp_no=10001的行数据替换成id=5以及emp_no=10005,其他数据保持不变，使用replace实现。
# 运用replace(X,Y,Z)函数。其中X是要处理的字段，Y是X中将要被替换的字符串，Z是用来替换Y的字符串，最终返回替换后的字符串。
# X是要处理的字段, Y是原来的, Z是替换后的
update titles_test
set emp_no=replace(emp_no, 10001, 10005)
where id = 5;
# 直接使用REPLACE INTO的话，就需要重新插入一条完整的新纪录，
replace into titles_test
select 5, 10005, title, from_date, to_date
from titles_test
where id = 5;

# 45. 将titles_test表名修改为titles_2017。
alter table titles_test rename to titles_2017;
rename table titles_test to titles_2017;

# 46. 在audit表上创建外键约束，其emp_no对应employees_test表的主键id。
alter table audit
    add foreign key (emp_no) references employees_test (id);

drop table audit;
create table audit
(
    emp_no      int      not null,
    create_date datetime not null,
    foreign key (emp_no) references employees_test (id)
);
create table audit
(
    emp_no      int      not null references employees_test (id),
    create_date datetime not null
);

# 47. create view emp_v as select * from employees where emp_no >10005;
# 获取emp_v和employees中相同的数据？
select *
from emp_v,
     employees
where emp_v.emp_no = employees.emp_no;
select emp_v.*
from emp_v,
     employees
where emp_v.emp_no = employees.emp_no;

# 48. 将所有获取奖金的员工当前的薪水增加10%。
update salaries s
set s.salary=s.salary * (1 + 0.1)
where s.emp_no
          in (select emp_no from emp_bonus);

# 49. 针对库中的所有表生成select count(*)对应的SQL语句
select concat('select count(*) from', ' ', TABLE_NAME, ';') as cnts
from (select table_name from information_schema.tables where table_schema = 'shop') as hi;
# 获取所有表名
# select table_name from information_schema.tables where table_schema='database_name' ;

# select "select count(*) from " || name || ";" as cnts from split_master where type="table";

# 50. 将employees表中的所有员工的last_name和first_name通过(')连接起来。
select concat(last_name, '\'', first_name)
from employees;
select last_name || '\'' || first_name
from employees;






