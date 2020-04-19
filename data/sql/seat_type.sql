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
INSERT INTO public.seat_type (seat_name, seat_basic_price) VALUES ('����������', 1.486);
INSERT INTO public.seat_type (seat_name, seat_basic_price) VALUES ('����һ����', 0.74);
INSERT INTO public.seat_type (seat_name, seat_basic_price) VALUES ('����������', 0.46);
INSERT INTO public.seat_type (seat_name, seat_basic_price) VALUES ('����һ����', 0.37);
INSERT INTO public.seat_type (seat_name, seat_basic_price) VALUES ('����������', 0.30);
INSERT INTO public.seat_type (seat_name, seat_basic_price) VALUES ('�߼�����', 0.643);
INSERT INTO public.seat_type (seat_name, seat_basic_price) VALUES ('����', 0.357);
INSERT INTO public.seat_type (seat_name, seat_basic_price) VALUES ('Ӳ��', 0.230);
INSERT INTO public.seat_type (seat_name, seat_basic_price) VALUES ('Ӳ��', 0.067);
INSERT INTO public.seat_type (seat_name, seat_basic_price) VALUES ('����', 0.067);
INSERT INTO public.seat_type (seat_name, seat_basic_price) VALUES ('�տ�����', 0.342);
INSERT INTO public.seat_type (seat_name, seat_basic_price) VALUES ('�տ�Ӳ��', 0.215);
INSERT INTO public.seat_type (seat_name, seat_basic_price) VALUES ('�տ�Ӳ��', 0.058);
INSERT INTO public.seat_type (seat_name, seat_basic_price) VALUES ('�տ�����', 0.058);
INSERT INTO public.seat_type (seat_name, seat_basic_price) VALUES ('��ͨ����', 0.327);
INSERT INTO public.seat_type (seat_name, seat_basic_price) VALUES ('��ͨӲ��', 0.20);
INSERT INTO public.seat_type (seat_name, seat_basic_price) VALUES ('��ͨӲ��', 0.049);
INSERT INTO public.seat_type (seat_name, seat_basic_price) VALUES ('��ͨ����', 0.049);
commit;