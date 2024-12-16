/**
 *
 * Author: Pablo Jacobo
 * Refactor Date: 14/12/2024
 * Feature: was migrated DDL for supported a idempotent structure
 */


do $$
begin

	/**
	 *
	 * schema = {}
	 *
	 * described the initial definition ready for launching and set respective
	 * configuration for any DBMS with support of postgreSQL
	 *
	 */

	if not exists (
        select 1
        from information_schema.schemata
        where schema_name = 'syncfy_configuration'
    ) then
    	create schema syncfy_configuration;
    end if;

   -- Set the search_path to include the new schema
	set search_path to syncfy_configuration, "$user", public;
	-- Set the search_path for DDL objects
	set search_path to syncfy_configuration;

	/**
	 *
	 * tables = {}
	 *
	 * all tables was described ahead for handle the entire DDL and provide
	 * a clear visibility for someone change or new definition
	 */

	-- object = {}, tbl_db_auth
	create table if not exists tbl_db_auth (
		auth_id serial primary key not null,
		sub VARCHAR(255) UNIQUE NOT NULL,
		create_at TIMESTAMPTZ DEFAULT NOW(),
		updated_at  TIMESTAMPTZ DEFAULT NOW(),
		is_active BOOLEAN DEFAULT TRUE
	);

	-- object = {}, tbl_db_notification
	create table if not exists tbl_db_notification (
    	notification_id serial primary key not null,
    	auth_id INT NOT NULL,
    	type VARCHAR(50) NOT NULL, -- e.g., email, SMS, in-app
    	status BOOLEAN DEFAULT TRUE,
    	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    	updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
	);

	-- object = {}, tbl_db_notification_log
	create table if not exists tbl_db_notification_log (
	    log_id serial PRIMARY KEY,
	    auth_id INT NOT NULL,
	    notification_id INT NOT NULL,
	    message TEXT NOT NULL,
	    status VARCHAR(20) DEFAULT 'pending', -- e.g., sent, failed
	    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP
	);

	-- object = {}, tbl_db_file
	create table if not exists tbl_db_file (
	    file_id serial PRIMARY KEY,
	    auth_id INT NOT NULL,
	    event_id INT NOT NULL,
	    job_id INT NOT NULL,
	    path TEXT NOT NULL,
	    file_name VARCHAR(255) NOT NULL,
	    file_type VARCHAR(50) NOT NULL, -- e.g., pdf, pptx, mp4
	    size BIGINT NOT NULL, -- File size in bytes
	    status VARCHAR(20) DEFAULT 'active', -- e.g., active, archived
	    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
	);

	-- object = {}, tbl_db_event; it works at logger for a events
	create table if not exists tbl_db_event (
	    event_id serial PRIMARY KEY,
	    file_id INT NOT NULL,
	    auth_id INT NOT NULL,
	    event_type VARCHAR(50) NOT NULL, -- e.g., upload, download, delete
	    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	    description TEXT
	);

	-- object = {}, tbl_db_job
	create table if not exists tbl_db_job (
	    job_id SERIAL PRIMARY KEY,
	    auth_id INT NOT NULL,
	    event_id INT NOT NULL,
	    path TEXT NOT NULL,
	    status VARCHAR(20) DEFAULT 'pending', -- e.g., pending, completed, failed
	    frequency VARCHAR(20), -- e.g., daily, weekly
	    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	    last_run TIMESTAMP,
	    next_run TIMESTAMP,
	    description TEXT
	);

	-- object = {}, tbl_db_bucket
	create table if not exists tbl_db_bucket (
	    key_id SERIAL PRIMARY KEY,
	    auth_id INT NOT NULL,
	    key_name VARCHAR(100) NOT NULL,
	    api_key VARCHAR(255) NOT NULL,
	    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	    last_used TIMESTAMP,
	    status VARCHAR(20) DEFAULT 'active' -- e.g., active, revoked
	);

	--  object = {}, tbl_db_kafka_topic
	create table if not exists tbl_db_kafka_topic (
	   	kafka_topic_id SERIAL PRIMARY KEY,
	    name VARCHAR(100) NOT NULL,
	    partition_count INT DEFAULT 1,
	    replication_factor INT DEFAULT 1,
	    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	    event_id INT NOT NULL,
	    log_id INT not null
	);

	--  object = {}, file_tag
	create table if not exists tbl_db_file_tag (
	    file_tag_id SERIAL PRIMARY KEY,
	    name VARCHAR(50) UNIQUE NOT NULL
	);

	--  object = {}, tbl_db_file_assoc (MANY-TO-MANY RELATIONSHIP)
	create table if not exists tbl_db_file_assoc (
	    file_assoc_id serial PRIMARY KEY,
	    file_tag_id INT NOT NULL,
	    file_id INT not null
	);


	/**
	 *
	 * constraints = {}
	 *
	 * in this case the approach was creating all constraints separated for handle
	 * the name and the full reference inside of one script
	 */

	-- add constraints for tbl_db_notification
	 if not exists (
     	select 1 from pg_constraint where conname = 'fk_notification_auth'
    ) then
    	alter table tbl_db_notification
        add constraint fk_notification_auth
        foreign key (auth_id) references tbl_db_auth(auth_id);
    end if;

   -- add constraints for tbl_db_notification_log
   if not exists (
     	select 1 from pg_constraint where conname = 'fk_log_auth'
    ) then
    	alter table tbl_db_notification_log
        add constraint fk_log_auth
       	foreign key (auth_id) references tbl_db_auth(auth_id);
    end if;


   if not exists (
     	select 1 from pg_constraint where conname = 'fk_log_notification'
    ) then
    	alter table tbl_db_notification_log
        add constraint fk_log_notification
       	foreign key (notification_id) references tbl_db_notification(notification_id);
    end if;

   -- add constraints for tbl_db_file
    if not exists (
     	select 1 from pg_constraint where conname = 'fk_file_auth'
    ) then
    	alter table tbl_db_file
        add constraint fk_file_auth
       	foreign key (auth_id) references tbl_db_auth(auth_id);
    end if;

   if not exists (
     	select 1 from pg_constraint where conname = 'fk_file_event'
    ) then
    	alter table tbl_db_file
        add constraint fk_file_event
       	foreign key (event_id) REFERENCES tbl_db_event(event_id);
    end if;

    if not exists (
     	select 1 from pg_constraint where conname = 'fk_file_job'
    ) then
    	alter table tbl_db_file
        add constraint fk_file_job
       	foreign key (job_id) references tbl_db_job(job_id);
    end if;

   -- add constraints for tbl_db_event
   if not exists (
     	select 1 from pg_constraint where conname = 'fk_event_file'
    ) then
    	alter table tbl_db_event
        add constraint fk_event_file
       	foreign key (file_id) references tbl_db_file(file_id);
    end if;

   if not exists (
     	select 1 from pg_constraint where conname = 'fk_event_auth'
    ) then
    	alter table tbl_db_event
        add constraint fk_event_auth
       	foreign key (auth_id) references tbl_db_auth(auth_id);
    end if;

   -- add constraints for tbl_db_job
    if not exists (
     	select 1 from pg_constraint where conname = 'fk_job_auth'
    ) then
    	alter table tbl_db_job
        add constraint fk_job_auth
       	foreign key (auth_id) references tbl_db_auth(auth_id);
    end if;

   if not exists (
     	select 1 from pg_constraint where conname = 'fk_job_event'
    ) then
    	alter table tbl_db_job
        add constraint fk_job_event
       	foreign key (event_id) references tbl_db_event(event_id);
    end if;

   -- add constraints for tbl_db_bucket
   if not exists (
     	select 1 from pg_constraint where conname = 'fk_bucket_auth'
    ) then
    	alter table tbl_db_bucket
        add constraint fk_bucket_auth
       	foreign key (auth_id) references tbl_db_auth(auth_id);
    end if;

   -- add constraints for tbl_db_kafka_topic
   if not exists (
     	select 1 from pg_constraint where conname = 'fk_kafka_event'
    ) then
    	alter table tbl_db_kafka_topic
        add constraint fk_kafka_event
       	foreign key (event_id) references tbl_db_event(event_id);
    end if;

   if not exists (
     	select 1 from pg_constraint where conname = 'fk_kafka_log'
    ) then
    	alter table tbl_db_kafka_topic
        add constraint fk_kafka_log
       	foreign key (log_id) references tbl_db_notification_log(log_id);
    end if;

   -- add constraints for tbl_db_file_assoc
   if not exists (
     	select 1 from pg_constraint where conname = 'fk_file_assoc_file'
    ) then
    	alter table tbl_db_file_assoc
        add constraint fk_file_assoc_file
       	foreign  key (file_id) references tbl_db_file(file_id);
    end if;

   if not exists (
     	select 1 from pg_constraint where conname = 'fk_file_assoc_file_tag'
    ) then
    	alter table tbl_db_file_assoc
        add constraint fk_file_assoc_file_tag
       	foreign key (file_tag_id) references tbl_db_file_tag(file_tag_id);
    end if;

end;
$$



/***
 * just for a dev-profile
 *
 * DROP TABLE <table_name> CASCADE;
 *
 */