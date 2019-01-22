create database hibernate;
use hibernate;

insert into employee values(1,"aman",21);
insert into employee values(2,"singh",23);
insert into employee values(3,"thakur",41);
insert into employee values(4,"haha",36);
insert into employee values(5,"lala",17);

insert into company values(101,"cisco",1);
insert into company values(102,"accolite",2);
insert into company values(103,"accolite",3);
insert into company values(104,"citrix",5);
insert into company values(105,"TCS",4);


delete from employee where employeeID=102;