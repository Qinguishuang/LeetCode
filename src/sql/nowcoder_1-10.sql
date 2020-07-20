# 1. 查找最晚入职员工的所有信息
select *
from employees
where hire_date = (select max(hire_date) from employees);

# 2.查找入职员工时间排名倒数第三的员工所有信息
# limit a, b 从a开始取b条数据 从0开始
# limit a 从0开始取a条数据 (limit 0, a)
select *
from employees
where hire_date = (
    select distinct hire_date
    from employees
    order by hire_date desc
    limit 2, 1
);

# 3.查找各个部门当前(to_date='9999-01-01')领导当前薪水详情以及其对应部门编号dept_no
# left join 返回左表的所有记录以及右表中连接字段相等的记录
# right join 返回右表所有的记录以及左表中链接字段相等的记录
# inner join 返回连个表中连接字段相等的记录(等值连接 join) 任何一方缺失便不显示
# outer join 返回两个表中所有记录 对方没有也显示
# natural join

#  sql 执行顺序
# from  join  on  where  groupBy  having  select  distinct  orderBy  limit

# 数据库多表连接是会生成一张中间表, 返回用户
# left join 时 where 和 on的区别
# on 生成表的限定条件, 无论on是否为真, 都返回左表的全部
# where 临时表生成后, 过滤返回剩下的部分

select s.*, dm.dept_no
from salaries as s
         left join dept_manager dm on s.emp_no = dm.emp_no
where s.to_date - '9999-01-01';


# 4. 查找所有已经分配部门的员工的last_name和first_name
select e.last_name, e.first_name, dept_emp.dept_no
from dept_emp
         inner join employees e on dept_emp.emp_no = e.emp_no;

select e.last_name, e.first_name, dept_emp.dept_no
from dept_emp
         natural join employees e;

# 5. 查找所有员工的last_name和first_name以及对应部门编号dept_no, 也包括展示没有分配具体部门的员工

select employees.last_name, employees.first_name, de.dept_no
from employees
         left join dept_emp de on employees.emp_no = de.emp_no;

# 6. 查找所有员工入职时候的薪水情况, 给出emp_no以及salary,  并按照emp_no进行逆序
select employees.emp_no, s.salary
from employees
         left join salaries s on employees.emp_no = s.emp_no
    and employees.hire_date = s.from_date
order by emp_no desc;

# 7. 查找薪水涨幅超过15次的员工号emp_no以及其对应的涨幅次数t
select emp_no, count(*)
from salaries
group by emp_no
having count(*) > 15;

# 8. 找出所有员工当前(to_date='9999-01-01')具体的薪水salary情况, 对于相同的薪水只显示一次,并按照逆序显示
# where 过滤行 having 过滤行
# select salary from salaries group by salary having to_date='9999-01-01' order by salary desc 错误
select distinct salary
from salaries
where to_date = '9999-01-01'
order by salary desc;

# 9. 获取所有部门当前manager的当前薪水情况, 给出dept_no, emp_no以及salary, 当前表示to_date='9999-01-01'
select dept_manager.dept_no, dept_manager.emp_no, salaries.salary
from dept_manager,
     salaries
where dept_manager.emp_no = salaries.emp_no
  and dept_manager.to_date = '9999-01-01'
  and salaries.to_date = '9999-01-01';

# 10. 获取所有非manager的员工emp_no
select employees.emp_no
from employees
where employees.emp_no not in (select dept_manager.emp_no from dept_manager);

select t.emp_no
from (select *
      from employees e
               left join dept_emp de on e.emp_no = de.emp_no) as t
where dept_no is null;
