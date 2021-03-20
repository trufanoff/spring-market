create table users(
	id 			int not null auto_increment,
	username 	varchar(30) not null,
	password 	varchar(80) not null,
	email 		varchar(50) unique,
	primary key(id)
);

create table roles(
	id 			int not null auto_increment,
	name 		varchar(50) not null,
	primary key(id)
);

create table users_roles(
	user_id 	int not null,
	role_id 	int not null,
	primary key(user_id, role_id),
	foreign key (user_id) references users(id),
	foreign key (role_id) references roles(id)
);

insert into roles(name) values ('ROLE_USER'), ('ROLE_ADMIN'), ('SOMETHING');

insert into users(username, password, email)
values
('user', '$2y$12$jYzg6TXMASp/iVc81qqFCeuuEy0MyJv2zIcXubDN4GFaW9QaUuo3C','user@gmail.com'),
('yura', '$2y$12$8pq/uL5vedfyJmfI4ro39eDP8OR74e.HWXSBFvPC6G9lU1b3U3xZa','yura@gmail.com');

insert into users_roles(user_id, role_id) values (1, 1), (1, 2);

create table products(
	id              int not null auto_increment,
	title           varchar(255),
	price           int,
	primary key(id)
);

create table orders(
	id                  int not null auto_increment,
    user_id             int not null,
	price               int,
	address             varchar(1000),
	primary key(id),
	foreign key (user_id)  references users(id)
);

create table order_items(
	id                  int not null auto_increment,
	order_id            int,
	product_id          int,
	price_per_product   int,
	price               int,
	quantity            int,
	primary key(id),
	foreign key (product_id)  references products(id),
	foreign key (order_id) references orders(id)
);

insert into products(title, price)
values
('Bread1', 25),
('Bread2', 26),
('Bread3', 27),
('Bread4', 28),
('Bread5', 29),
('Bread6', 30),
('Bread7', 31),
('Bread8', 32),
('Bread9', 33),
('Bread10', 34),
('Bread11', 35),
('Bread12', 37),
('Bread13', 38),
('Bread14', 39),
('Bread15', 40),
('Bread16', 41),
('Bread17', 42),
('Bread18', 43),
('Bread19', 44),
('Bread20', 45),
('Bread21', 46),
('Bread22', 47),
('Bread23', 48),
('Bread24', 49);
