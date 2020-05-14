create table orders
(
    order_id     serial                                                       not null
        constraint orders_pkey
            primary key,
    order_status integer                                                      not null,
    order_price  double precision                                             not null,
    person       integer                                                      not null
        constraint orders_person_fkey
            references users,
    create_date  timestamp default (CURRENT_TIMESTAMP + '08:00:00'::interval) not null
);

alter table orders
    owner to checker;

INSERT INTO public.orders (order_id, order_status, order_price, person, create_date) VALUES (1, 1, 58, 1, '2020-05-11 17:55:28.801379');
INSERT INTO public.orders (order_id, order_status, order_price, person, create_date) VALUES (2, 1, 99, 2, '2020-05-11 20:03:45.776821');
INSERT INTO public.orders (order_id, order_status, order_price, person, create_date) VALUES (3, 0, 88, 3, '2020-05-11 20:03:45.776821');
INSERT INTO public.orders (order_id, order_status, order_price, person, create_date) VALUES (4, 1, 100, 1, '2020-05-11 20:05:23.621793');
INSERT INTO public.orders (order_id, order_status, order_price, person, create_date) VALUES (5, 1, 9000, 1, '2020-05-11 20:05:23.621793');