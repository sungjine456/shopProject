drop table IF EXISTS users;

create table users (
     idx int(20),
     password varchar(500),
     email varchar(20),
     name varchar(20),
     role varchar(10)
);

insert into users
values(1, 'admin', 'email', 'name', 'ADMIN');