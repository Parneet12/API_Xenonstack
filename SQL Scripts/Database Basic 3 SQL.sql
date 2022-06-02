create database task;
use task;
create table student(Roll_no int , Name varchar(20), Address varchar(20), Age int);
create table studentcourse(Course_id int, Roll_no int);

desc student;

insert into student values(1,"Parneet", "Dehradun",22);
insert into student values(2,"Annu", "Delhi",20);
insert into student values(3,"Aakash", "Deoband",21);
insert into student values(4,"Deepanshu", "Sharanpur",19);
insert into student values(5,"Harsh", "Mumbai",22);
insert into student values(6,"Subham", "Nanital",21);
insert into student values(7,"Sahil", "Shimla",20);
insert into student values(8,"Mansi", "Chandigarh",22);


insert into studentcourse values(1,1);
insert into studentcourse values(2,2);
insert into studentcourse values(2,3);
insert into studentcourse values(3,4);
insert into studentcourse values(1,5);
insert into studentcourse values(4,6);
insert into studentcourse values(3,7);
insert into studentcourse values(3,8);





select * from student;
select * from studentcourse;

INNER JOIN
SELECT studentcourse.Course_id, student.Name, student.Age FROM student
INNER JOIN studentcourse
ON student.Roll_no = studentcourse.Roll_no;

Left Join
select student.Name, studentcourse.Course_id from student LEFT JOIN studentcourse on studentcourse.Roll_no = student.Roll_no;

Right join
select student.Name, studentcourse.Course_id from student RIGHT JOIN studentcourse on studentcourse.Roll_no = student.Roll_no;

Cross join
select student.Name, student.address, studentcourse.Course_id from student cross join studentcourse;


insert into student (Roll_no,name,Age) values (9,"Hardik",22);

create unique index idx on student(Roll_no);

create index idx on student(Roll_no);

create index idx on studentcourse(Roll_no);