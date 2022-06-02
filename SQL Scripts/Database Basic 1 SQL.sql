create database xenonstack;
use xenonstack;
create table employee(employee_name varchar(20), street varchar(20), city varchar(20));
create table work(employee_name varchar(20), comp_name varchar(20), salary int);
create table company(comp_name varchar(20), city varchar(20));
create table manages(employee_name varchar(20), manager_name varchar(20));

insert into employee values("akash", "dharampur","dehradun");
insert into employee values("ravi","sec=17","mohali");
insert into employee values("rahul","raipur","dehradun");
insert into employee values("annu","bandra","mumbai");

insert into work values("akash","google",45000);
insert into work values("ravi","flipkart",4000);
insert into work values("rahul","abc",4500);
insert into work values("annu","amazon",12000);

select * from work;

insert into company values("google","california");
insert into company values("flipkart","mohali");
insert into company values("abc","Delhi");
insert into company values("amazon","chandigarh");

insert into manages values("akash","Robert");
insert into manages values("ravi","Rahul");
insert into manages values("rahul","harman");
insert into manages values("annu","mansi");

select e.employee_name,e.street,e.city from employee e JOIN work w ON (e.employee_name = w.employee_name);

select e.employee_name,e.street,e.city from employee e JOIN work w USING(employee_name);