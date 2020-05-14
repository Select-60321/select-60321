begin;
create table if not exists users
(
	user_id serial primary key,
	user_name varchar(30) not null,
	phone_number char(11) not null,
	ID_card_num char(18) not null,
	password varchar(16) not null,
	unique (ID_card_num)
)
;
insert into public.users (user_name,phone_number,ID_card_num,password) values ('黎诗龙','18911111111','420102xxxxxxxxxxxx','passwd');
insert into public.users (user_name,phone_number,ID_card_num,password) values ('聂秋实','18911111111','420106xxxxxxxxxxxx','password');
commit;
