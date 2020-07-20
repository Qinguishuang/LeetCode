# 21. 查找所有员工自入职以来的薪水涨幅情况, 给出员工编号emp_no以及其对应的薪水涨幅growth, 并按照growth进行升序

select curr.emp_no, curr.salary - hire.salary as growth
from (select s.emp_no, s.salary
      from employees e
               left join salaries s on e.emp_no = s.emp_no
      where s.to_date = '9999-01-01') as curr
         inner join
     (select s.emp_no, s.salary
      from employees e
               left join salaries s on e.emp_no = s.emp_no
      where s.from_date = e.hire_date) as hire on curr.emp_no = hire.emp_no
order by growth;

# 22. 统计各个部门对应员工涨幅的次数总和, 给出部门编码dept_no, 部门名称dept_name以及次数sum

# 1. 每个员工的涨幅次数
select emp_no, count(*)
from salaries
group by emp_no;
# 2. 各个部门涨幅次数之和
select de.dept_no, sum(c)
from dept_emp de
         left join
         (select emp_no, count(*) as c from salaries group by emp_no) as t
         on de.emp_no = t.emp_no
group by de.dept_no;
# 3. 部门加编号
select d.dept_no, d.dept_name, tmp.sum
from departments d
         left join
     (select de.dept_no, sum(c) as sum
      from dept_emp de
               left join
               (select emp_no, count(*) as c from salaries group by emp_no) as t
               on de.emp_no = t.emp_no
      group by de.dept_no) as tmp on d.dept_no = tmp.dept_no;

SELECT de.dept_no, dp.dept_name, COUNT(s.salary) AS sum
FROM (dept_emp AS de INNER JOIN salaries AS s ON de.emp_no = s.emp_no)
         INNER JOIN departments AS dp ON de.dept_no = dp.dept_no
GROUP BY de.dept_no;

# 23.对所有员工的当前(to_date='9999-01-01')薪水按照salary进行按照1-N的排名，相同salary并列且按照emp_no升序排列
select s1.emp_no, s1.salary, count(distinct s2.salary) as `rank`
from salaries s1,
     salaries s2
where s1.to_date = '9999-01-01'
  and s2.to_date = '9999-01-01'
  and s1.salary <= s2.salary
group by s1.emp_no;
# order by s1.salary desc, s1.emp_no asc;

# 24. 获取所有非manager员工当前的薪水情况，给出dept_no、emp_no以及salary ，当前表示to_date='9999-01-01'
select dept_emp.dept_no, dept_emp.emp_no, salary
from dept_emp
         join (
    select employees.emp_no, s.salary
    from employees
             join salaries s on employees.emp_no = s.emp_no
    where employees.emp_no not in (select emp_no from dept_manager)
      and s.to_date = '9999-01-01') as tmp on dept_emp.emp_no = tmp.emp_no;


# 25. 获取员工其当前的薪水比其manager当前薪水还高的相关信息

# manager薪水
select dept_manager.emp_no, s.salary, dept_manager.dept_no
from dept_manager
         join salaries s on dept_manager.emp_no = s.emp_no
where s.to_date = '9999-01-01';

# 26. 汇总各个部门当前员工的title类型的分配数目

select d.dept_no, d.dept_name, tmp.title, tmp.count
from departments d
         join (
    select dept_emp.dept_no, count(*) as count, t.title
    from dept_emp
             join titles t on dept_emp.emp_no = t.emp_no
    where dept_emp.to_date = '9999-01-01'
      and t.to_date = '9999-01-01'
    group by dept_emp.dept_no, t.title) as tmp on d.dept_no = tmp.dept_no;

select de.dept_no, dp.dept_name, t.title, count(*) as count
from titles t
         inner join dept_emp de on t.emp_no = de.emp_no
    and de.to_date = '9999-01-01' and t.to_date = '9999-01-01'
         inner join departments dp on de.dept_no = dp.dept_no
group by de.dept_no, t.title;

# 27.给出每个员工每年薪水涨幅超过5000的员工编号emp_no, 薪水变更开始日期from_date
# 以及薪水涨幅值salary_growth, 并按照salary_growth逆序排列.
# 提示：在sqlite中获取datetime时间对应的年份函数为strftime('%Y', to_date)

# 28. 查找描述信息中包括robot的电影对应的分类名称以及电影数目，而且还需要该分类对应电影数量>=5部
select c.name, count(*)
from film
         join film_category fc on film.film_id = fc.film_id
    and film.description like '%robot%'
         join category c on fc.category_id = c.category_id
         join (
    select category_id from film_category group by category_id having count(*) >= 5) as tmp
              on tmp.category_id = c.category_id;

# 29. 使用join查询方式找出没有分类的电影id以及名称
select film.film_id, film.title
from film
where film.film_id not in (
    select fc.film_id
    from film_category fc
);
select film.film_id, film.title
from film
         left join film_category fc on film.film_id = fc.film_id
where fc.category_id is null;

# 30. 使用子查询的方式找出属于Action分类的所有电影对应的title,description
select f.title, f.description
from film f
where f.film_id in
      (select fc.film_id
       from film_category fc
       where fc.category_id in
             (select category_id from category where name = 'Action'));





