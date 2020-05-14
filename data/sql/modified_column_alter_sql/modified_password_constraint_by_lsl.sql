alter table users alter column password type varchar(100) using password::varchar(100);
create unique index users_user_name_uindex
	on users (user_name);
alter table admins alter column password type varchar(100) using password::varchar(100);