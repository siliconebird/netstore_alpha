create table orders(
orderId varchar(100) primary key,
orderNum varchar(100) not null unique,
quantity int ,
amount float(10,2),
status int ,
customerId varchar(100) not null,
constraint customer_id_fk foreign key (customerId) references customers(id));

create table orderitems(
orderItemId varchar(100) primary key,
quantity int ,
price float(10,2),
bookId varchar(100) not null,
orderId varchar(100) not null,
constraint book_id_fk foreign key (bookId) references books(id),
constraint order_id_fk foreign key (orderId) references orders(orderId));





