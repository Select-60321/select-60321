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
    ticket_active  integer default 0 not null
);

alter table tickets
    owner to checker;

INSERT INTO public.tickets (ticket_id, order_id, carriage_id, depart_journey, arrive_journey, depart_date, ticket_price, seat_type_id, ticket_active) VALUES (2, 1, 1, 27309, 27312, '2020-05-30', 29, 1, 0);
INSERT INTO public.tickets (ticket_id, order_id, carriage_id, depart_journey, arrive_journey, depart_date, ticket_price, seat_type_id, ticket_active) VALUES (3, 4, 1, 27309, 27312, '2020-06-01', 50, 1, 0);
INSERT INTO public.tickets (ticket_id, order_id, carriage_id, depart_journey, arrive_journey, depart_date, ticket_price, seat_type_id, ticket_active) VALUES (4, 4, 1, 27309, 27312, '2020-06-02', 50, 1, 0);
INSERT INTO public.tickets (ticket_id, order_id, carriage_id, depart_journey, arrive_journey, depart_date, ticket_price, seat_type_id, ticket_active) VALUES (1, 1, 1, 27309, 27312, '2020-05-31', 29, 1, 1);