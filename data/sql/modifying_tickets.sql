alter table tickets add column ticket_price float;
update tickets t set ticket_price =
    round(((
    (select j.distance
        from journeys j
        where j.journey_id = t.arrive_journey) -
    (select j.distance
        from journeys j
        where j.journey_id = t.depart_journey)) *
    (select st.seat_basic_price
        from carriages c
            join journeys j
                on c.train_number = j.train_id
            join seat_type st
                on c.seat_type_id = st.seat_type_id
    where j.journey_id = t.arrive_journey
      and c.carriage_index = t.carriage_id))::numeric, 2)
where t.ticket_price is null or t.ticket_price = 0;
update orders o set order_price =
    (select sum(t.ticket_price) from tickets t
        where o.order_id = t.order_id)
where o.order_price is null or o.order_price = 0;
alter table tickets add column seat_type_id int constraint seat_type_tickets_fkey references seat_type;
update tickets t set seat_type_id =
    (select c.seat_type_id
        from carriages c
            join journeys j
                on c.train_number = j.train_id
    where j.journey_id = t.arrive_journey
      and c.carriage_index = t.carriage_id)
where seat_type_id is null or seat_type_id = 0;