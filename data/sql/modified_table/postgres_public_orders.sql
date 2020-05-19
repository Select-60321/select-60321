create table orders
(
    order_id     serial                              not null
        constraint orders_pkey
            primary key,
    order_status integer                             not null,
    order_price  double precision                    not null,
    person       integer                             not null
        constraint orders_person_fkey
            references users,
    create_date  timestamp default CURRENT_TIMESTAMP not null
);