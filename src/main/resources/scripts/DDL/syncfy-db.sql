create schema syncfy_configuration
set search_path to syncfy_configuration, "$user", public

create table tbl_db_auth (
	auth_id serial primary key not null,
	email varchar(40),
	aud varchar(100),
	iss varchar(80),
	nonce varchar(80),
	picture varchar(120)
)

create table tbl_db_alert (	
	alert_id serial primary key not null,
	name varchar(40),
	creation_date date,
	expiry_date date,
	type varchar(10),
	is_filter boolean,
	auth_id integer
)

create table tbl_db_notification(	
	notification_id serial primary key not null,
	name varchar(40),
	creation_date date,
	expiry_date date,
	type varchar(10),
	is_filter boolean,
	auth_id integer
)