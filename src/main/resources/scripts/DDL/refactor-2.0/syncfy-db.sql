create schema syncfy_configuration
set search_path to syncfy_configuration, "$user", public

create table tbl_db_auth (
	auth_id serial primary key not null,
	sub VARCHAR(255) UNIQUE NOT NULL,
	create_at TIMESTAMPTZ DEFAULT NOW(),
	updated_at  TIMESTAMPTZ DEFAULT NOW(),
	is_active BOOLEAN DEFAULT TRUE
);


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

-- nestjs service

create table tbl_db_task (
	task_id serial primary key not null,
	name varchar(40),
	run_each varchar(100),
	created_at date
)


create table tbl_db_task_detail (
	task_detail_id serial primary key not null,
	alert_id integer,
	notification_id integer
)