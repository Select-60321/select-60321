begin;
create table if not exists tickets
(
	ticket_id serial not null
		constraint tickets_pkey
			primary key,
	order_id int not null
		constraint tickets_orders_fkey
			references orders,
	carriage_id int not null,
	depart_journey int not null
		constraint tickets_journeys_fkey1
			references journeys,
	arrive_journey int not null
		constraint tickets_journeys_fkey2
			references journeys,
	depart_date date not null,
	seat_num varchar(10) not null
)
;
commit;