package cz;

/**
 * select d.Name Department. e.Name, max(e.Salary)
 * from Employee e
 * left join Department d
 * on e.DepartmentId = d.Id
 * group by e.DepartmentId
 */
public class No184 {

}
/*

select Department.name as Department, Employee.name as Employee, Salary
from Employee join Department on Employee.DepartmentId = Department.Id
where (Employee.DepartmentId, Salary) in
      (select DepartmentId, max(Salary) from Employee group by DepartmentId)


*/

// ["Id","Name","Salary","DepartmentId"],
// [1,"Joe",70000,1],
// [2,"Jim",90000,1],
// [5,"Max",90000,1]],
// [3,"Henry",80000,2],
// [4,"Sam",60000,2],
//
// "Department":[[1,"IT"],[2,"Sales"]]}}

