begin;
create table if not exists orders
(
	order_id  serial primary key,
	order_status int not null,
	order_price float not null,
	person int not null references users(user_id),
	create_date timestamp not null default (current_timestamp + interval '8hours')
)
;
commit; 