drop table IF EXISTS users;

create table users (
     idx int(20),
     password varchar(500),
     email varchar(20),
     name varchar(20),
     role varchar(10),
     use_yn char(1),
     reg_date TIMESTAMP(23, 10),
     up_date TIMESTAMP(23, 10)
);

insert into users
values(1, 'pass', 'email', 'name', 'ADMIN', 'Y', '2017-12-12', '2017-12-12');