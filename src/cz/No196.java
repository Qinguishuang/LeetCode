package cz;

public class No196 {

}

/*
delete from Person
where id not in
(select t.id from (select min(id) from Person group by email))

*/
