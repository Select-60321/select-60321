begin;
create table if not exists seat_type
(
	seat_type_id serial not null
		constraint carriages_pkey
			primary key,
	seat_name varchar(20) not null
		constraint stations_seat_name_key
			unique,
	seat_basic_price float not null
)
;
INSERT INTO public.seat_type (seat_name, seat_basic_price) VALUES ('高铁商务座', 1.486);
INSERT INTO public.seat_type (seat_name, seat_basic_price) VALUES ('高铁一等座', 0.74);
INSERT INTO public.seat_type (seat_name, seat_basic_price) VALUES ('高铁二等座', 0.46);
INSERT INTO public.seat_type (seat_name, seat_basic_price) VALUES ('动车一等座', 0.37);
INSERT INTO public.seat_type (seat_name, seat_basic_price) VALUES ('动车二等座', 0.30);
INSERT INTO public.seat_type (seat_name, seat_basic_price) VALUES ('高级软卧', 0.643);
INSERT INTO public.seat_type (seat_name, seat_basic_price) VALUES ('软卧', 0.357);
INSERT INTO public.seat_type (seat_name, seat_basic_price) VALUES ('硬卧', 0.230);
INSERT INTO public.seat_type (seat_name, seat_basic_price) VALUES ('硬座', 0.067);
INSERT INTO public.seat_type (seat_name, seat_basic_price) VALUES ('无座', 0.067);
INSERT INTO public.seat_type (seat_name, seat_basic_price) VALUES ('普快软卧', 0.342);
INSERT INTO public.seat_type (seat_name, seat_basic_price) VALUES ('普快硬卧', 0.215);
INSERT INTO public.seat_type (seat_name, seat_basic_price) VALUES ('普快硬座', 0.058);
INSERT INTO public.seat_type (seat_name, seat_basic_price) VALUES ('普快无座', 0.058);
INSERT INTO public.seat_type (seat_name, seat_basic_price) VALUES ('普通软卧', 0.327);
INSERT INTO public.seat_type (seat_name, seat_basic_price) VALUES ('普通硬卧', 0.20);
INSERT INTO public.seat_type (seat_name, seat_basic_price) VALUES ('普通硬座', 0.049);
INSERT INTO public.seat_type (seat_name, seat_basic_price) VALUES ('普通无座', 0.049);
commit;