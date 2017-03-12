create table customers(
id varchar(100) primary key,
cusName varchar(100) not null unique,
cusPw varchar(100) not null ,
phone varchar(100) ,
address varchar(100) ,
email varchar(100) not null ,
activied bit,
keyCode varchar(100) unique);