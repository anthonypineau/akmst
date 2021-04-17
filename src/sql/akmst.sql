create table User
(id int not null auto_increment,
name varchar(45) not null,
status varchar(45) not null,
email varchar(45) unique not null,
password varchar(45) not null,
constraint pk_Item_classes primary key(id))
ENGINE=INNODB;

create table Customer
(id int not null auto_increment,
name varchar(45) not null,
constraint pk_Item_classes primary key(id))
ENGINE=INNODB;

create table Quotation
(id int not null auto_increment,
customer int not null,
title varchar(45) not null,
price int,
primary key (id),
FOREIGN KEY (customer) REFERENCES Customer(id))
ENGINE=INNODB;