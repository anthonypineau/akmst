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