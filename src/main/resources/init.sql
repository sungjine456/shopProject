drop table IF EXISTS user;

create table user (
     idx int(20),
     password varchar(500),
     email varchar(20),
     name varchar(20),
     role varchar(10)
);

insert into user
values(1, 'admin', 'email', 'name', 'admin');