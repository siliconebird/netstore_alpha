create table users(
id int primary key,
nickName varchar(100) ,
userName varchar(100) not null unique,
passWord varchar(100) );

create table rolers(
id int primary key,
rolerName varchar(100) not null unique ,
rolerDescripe varchar(255));

create table functions(
id int primary key,
funcName varchar(100) not null unique ,
uri varchar(255));

create table users_rolers(
u_id int not null,
r_id int not null ,
primary key(u_id,r_id),
constraint user_id_fk foreign key (u_id) references users(id),
constraint rolers_id_fk foreign key (r_id) references rolers(id));

create table rolers_functions(
r_id int not null,
f_id int not null ,
primary key(r_id,f_id),
constraint rolerss_id_fk foreign key (r_id) references rolers(id),
constraint functions_id_fk foreign key (f_id) references functions(id));









