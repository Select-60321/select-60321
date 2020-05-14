create table seat_type
(
    seat_type_id     serial           not null
        constraint carriages_pkey
            primary key,
    seat_name        varchar(20)      not null
        constraint stations_seat_name_key
            unique,
    seat_basic_price double precision not null
);

alter table seat_type
    owner to checker;

INSERT INTO public.seat_type (seat_type_id, seat_name, seat_basic_price) VALUES (1, '高铁商务座', 1.486);
INSERT INTO public.seat_type (seat_type_id, seat_name, seat_basic_price) VALUES (2, '高铁一等座', 0.74);
INSERT INTO public.seat_type (seat_type_id, seat_name, seat_basic_price) VALUES (3, '高铁二等座', 0.46);
INSERT INTO public.seat_type (seat_type_id, seat_name, seat_basic_price) VALUES (4, '动车一等座', 0.37);
INSERT INTO public.seat_type (seat_type_id, seat_name, seat_basic_price) VALUES (5, '动车二等座', 0.3);
INSERT INTO public.seat_type (seat_type_id, seat_name, seat_basic_price) VALUES (6, '高级软卧', 0.643);
INSERT INTO public.seat_type (seat_type_id, seat_name, seat_basic_price) VALUES (7, '软卧', 0.357);
INSERT INTO public.seat_type (seat_type_id, seat_name, seat_basic_price) VALUES (8, '硬卧', 0.23);
INSERT INTO public.seat_type (seat_type_id, seat_name, seat_basic_price) VALUES (9, '硬座', 0.067);
INSERT INTO public.seat_type (seat_type_id, seat_name, seat_basic_price) VALUES (10, '无座', 0.067);
INSERT INTO public.seat_type (seat_type_id, seat_name, seat_basic_price) VALUES (11, '普快软卧', 0.342);
INSERT INTO public.seat_type (seat_type_id, seat_name, seat_basic_price) VALUES (12, '普快硬卧', 0.215);
INSERT INTO public.seat_type (seat_type_id, seat_name, seat_basic_price) VALUES (13, '普快硬座', 0.058);
INSERT INTO public.seat_type (seat_type_id, seat_name, seat_basic_price) VALUES (14, '普快无座', 0.058);
INSERT INTO public.seat_type (seat_type_id, seat_name, seat_basic_price) VALUES (15, '普通软卧', 0.327);
INSERT INTO public.seat_type (seat_type_id, seat_name, seat_basic_price) VALUES (16, '普通硬卧', 0.2);
INSERT INTO public.seat_type (seat_type_id, seat_name, seat_basic_price) VALUES (17, '普通硬座', 0.049);
INSERT INTO public.seat_type (seat_type_id, seat_name, seat_basic_price) VALUES (18, '普通无座', 0.049);