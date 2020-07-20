# 51. 查找字符串'10,A,B' 中逗号','出现的次数cnt.
select (length('10,A,B') - length(replace('10,A,B', ',', ''))) / length(',') as cnt;

# 52. 获取Employees中的first_name, 查询按照first_name最后两个字母, 按照升序进行排列
select first_name
from employees
order by substr(first_name, -2);

# 53. 按照dept_no进行汇总, 属于同一个部门的emp_no按照逗号进行连接,
# 结果给出dept_no以及连接出的结果employees
# group_concat(X,Y)，其中X是要连接的字段，Y是连接时用的符号
select dept_no, group_concat(emp_no)
from dept_emp
group by dept_no;

# 54. 查找排除当前最大、最小salary之后的员工的平均工资avg_salary。
select avg(salary)
from salaries
where salary not in
      (select max(salary) from salaries where to_date = '9999-01-01')
  and salary not in (select min(salary) from salaries where to_date = '9999-01-01');


# 55 分页查询employees表，每5行一页，返回第2页的数据
# 在 LIMIT X,Y 中，Y代表返回几条记录，X代表从第几条记录开始返回
# LIMIT 后的数字代表返回几条记录，OFFSET 后的数字代表从第几条记录开始返回(0开始)
select *
from employees
limit 5, 5;
select *
from employees
limit 5 offset 5;

# 56. 获取所有员工的emp_no、部门编号dept_no以及对应的bonus类型btype和received ，
# 没有分配具体的员工不显示
select em.emp_no, de.dept_no, eb.btype, eb.recevied
from employees em
         inner join dept_emp de on em.emp_no = de.emp_no
         left join
     emp_bonus eb on de.emp_no = eb.emp_no;
select de.emp_no, de.dept_no, eb.btype, eb.recevied
from dept_emp de
         left join emp_bonus eb on de.emp_no = eb.emp_no;

# 57. 使用含有关键字exists查找未分配具体部门的员工的所有信息。
select *
from employees
where not exists(
        select emp_no from dept_emp where dept_emp.emp_no = employees.emp_no
    );
select *
from employees
where not exists(select *
                 from dept_emp
                 where dept_emp.emp_no = employees.emp_no);

# 58. 存在如下的视图.获取employees中的行数据，且这些行也存在于emp_v中。
# 注意不能使用intersect关键字。
select *
from emp_v;

# 59. 获取有奖金的员工相关信息。
select e.emp_no, e.first_name, e.last_name, b.btype, s.salary, (s.salary * b.btype / 10) as bouns
from employees e
         inner join emp_bonus b on e.emp_no = b.emp_no
         inner join salaries s on e.emp_no = s.emp_no and s.to_date = '9999-01-01';

# 60.按照salary的累计和running_total，其中running_total为前两个员工的salary累计和，其他以此类推
select s2.emp_no, s2.salary, sum(s1.salary)
from salaries s1
         inner join salaries s2
                    on s1.emp_no <= s2.emp_no
where s1.to_date = '9999-01-01'
  and s2.to_date = '9999-01-01'
group by s2.emp_no;
select *
from salaries s1
         inner join salaries s2
                    on s1.emp_no <= s2.emp_no
where s1.to_date = '9999-01-01'
  and s2.to_date = '9999-01-01';

# 61. 对于employees表中，给出奇数行的first_name
SELECT E1.first_name
FROM employees E1
WHERE (SELECT COUNT(*) FROM employees E2 WHERE E1.first_name >= E2.first_name) % 2 = 1;

