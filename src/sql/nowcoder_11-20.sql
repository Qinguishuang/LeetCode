# 11. 获取所有员工当前的manager, 如果当前的manager是自己的话结果不显示, 当前表示to_date='9999-01-01'
select dept_emp.emp_no, dept_manager.emp_no manager_no
from dept_emp
         inner join dept_manager on dept_emp.dept_no = dept_manager.dept_no
where dept_emp.to_date = '9999-01-01'
  and dept_manager.to_date = '9999-01-01'
  and dept_emp.emp_no <> dept_manager.emp_no;

# 12. 获取所有部门中当前员工薪水最高的相关信息, 给出dept_no, emp_no以及其对应的salary
select dept_emp.dept_no, dept_emp.emp_no, max(salaries.salary)
from salaries
         left join dept_emp on dept_emp.emp_no = salaries.emp_no
where dept_emp.to_date = '9999-01-01'
  and salaries.to_date = '9999-01-01'
group by dept_emp.dept_no;

select de.dept_no, s.emp_no, max(salary) salary
from dept_emp de,
     salaries s
where de.emp_no = s.emp_no
  and de.to_date = '9999-01-01'
  and s.to_date = '9999-01-01'
group by de.dept_no;

# 13. 从titles表获取按照title进行分组, 每组个数大于等于2, 给出title以及对应的数目t.
select titles.title, count(titles.title) as t
from titles
group by titles.title
having count(titles.title) > 2;

# 14.从titles表获取按照title进行分组, 每组个数大于等于2, 给出title以及对应的数目t.
# 注意对于重复的title进行忽略.

select titles.title, count(distinct titles.emp_no)
from titles
group by titles.title
having count(titles.title) > 2;

# 15.查找employees表所有emp_no为奇数, 且last_name不为Mary的员工信息, 并按照hire_date逆序排列
select employees.*
from employees
where employees.emp_no % 2 = 1
  and employees.last_name != 'Mary'
order by employees.hire_date desc;

# 16.统计出当前各个title类型对应的员工当前（to_date='9999-01-01'）薪水对应的平均工资.结果给出title以及平均工资avg.
select titles.title, avg(s.salary) as avg
from titles
         left join salaries s on titles.emp_no = s.emp_no
where titles.to_date = '9999-01-01'
  and s.to_date = '9999-01-01'
group by titles.title;

# 17.获取当前(to_date='9999-01-01')薪水第二多的员工的emp_no以及其对应的薪水salary
select salaries.emp_no, salaries.salary
from salaries
where salaries.to_date = '9999-01-01'
  and salaries.salary = (select distinct salaries.salary
                         from salaries
                         order by salaries.salary desc
                         limit 1, 1);

# 18. 查找当前薪水(to_date='9999-01-01')排名第二多的员工编号emp_no, 薪水salary, last_name以及first_name, 不准使用order by

select e.emp_no, s.salary, e.last_name, e.first_name
from employees e
         left join salaries s on e.emp_no = s.emp_no
where s.to_date = '9999-01-01'
  and s.salary = (
    select max(salary)
    from salaries
    where salaries.salary < (
        select max(s.salary)
        from salaries s));

# 19.查找所有员工的last_name和first_name以及对应的dept_name，也包括暂时没有分配部门的员工
select e.last_name, e.first_name, d.dept_name
from employees e
         left join dept_emp de on e.emp_no = de.emp_no
         left join departments d on de.dept_no = d.dept_no;

# 20. 查找员工编号emp_no为10001其自入职以来的薪水salary涨幅值growth
select max(salary) - min(salary) as growth
from salaries
where emp_no = '10001';
select (select salary from salaries where emp_no = '10001' order by to_date desc limit 1) -
       (select salary from salaries where emp_no = '10001' order by to_date limit 1) as growth;


