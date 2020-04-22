begin;
create table if not exists admins
(
	admin_id serial not null
		constraint admins_pkey
			primary key,
	admin_name varchar(30) not null
		constraint admins_admin_name_key
			unique,
	password varchar(20) not null
)
;
INSERT INTO public.admins (admin_name, password) VALUES ('admin', 'password');
commit;