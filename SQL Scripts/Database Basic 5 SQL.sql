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

SET profiling = 1;

select * from student;
select * from studentcourse;


show profiles;

show profile for QUERY 4;

show profile CPU for query 4;