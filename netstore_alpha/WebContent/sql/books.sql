create table books(
id varchar(100) primary key,
name varchar(100) not null unique,
author varchar(100) not null ,
price float(8,2) not null,
description varchar(255) ,
categoryID varchar(100) not null,
photoPath varchar(100),
photoName varchar(100),
constraint category_id_fk foreign key (categoryID) references categorys(id));
