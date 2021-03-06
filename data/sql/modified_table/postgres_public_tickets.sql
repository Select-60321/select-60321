create table tickets
(
    ticket_id      serial            not null
        constraint tickets_pkey
            primary key,
    order_id       integer           not null
        constraint tickets_orders_fkey
            references orders,
    carriage_id    integer           not null,
    depart_journey integer           not null
        constraint tickets_journeys_fkey1
            references journeys,
    arrive_journey integer           not null
        constraint tickets_journeys_fkey2
            references journeys,
    depart_date    date              not null,
    ticket_price   double precision,
    seat_type_id   integer
        constraint seat_type_tickets_fkey
            references seat_type,
    ticket_active  integer default 0 not null,
    seat_num varchar
);