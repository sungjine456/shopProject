drop table IF EXISTS users;

create table users (
     idx int(20),
     password varchar(500),
     email varchar(20),
     name varchar(20),
     role varchar(10),
     use_yn tinyint(1),
     create_date TIMESTAMP(23, 10),
     update_date TIMESTAMP(23, 10)
);

insert into users
values(1, 'pass', 'email@shop.com', 'name', 'ADMIN', true, '2017-12-12', '2017-12-12');