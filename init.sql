-- auto-generated definition
CREATE SCHEMA spring_boot_demo;
create table user
(
  id          int auto_increment
    primary key,
  name        varchar(30) null,
  create_time datetime    null
);

create table user_log
(
	id int auto_increment
		primary key,
	create_time date null,
	user_name varchar(60) null,
	user_ip varchar(60) null
) ;

