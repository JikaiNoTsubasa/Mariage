create table mariage_user(
	id int auto_increment primary key,
	name varchar(255) not null,
	code varchar(10) not null,
	type varchar(1) not null,
	lang varchar(2) not null,
	solo bool not null
)engine=innodb;