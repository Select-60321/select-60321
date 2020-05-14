create or replace function update_ticket_price()
    returns trigger
as $$
    begin
        if new.seat_basic_price <> old.seat_basic_price
        then
            update tickets
            set ticket_price =
                round((ticket_price / old.seat_basic_price * new.seat_basic_price)::numeric, 2)
            where tickets.seat_type_id = new.seat_type_id;
        end if;
        return new;
    end;
$$
language plpgsql;

create trigger seat_price_trigger
    after update on seat_type
    for each row
execute procedure update_ticket_price();

create or replace function update_order_price()
    returns trigger
as $$
    begin
        if new.ticket_price <> old.ticket_price or new.ticket_active <> old.ticket_active
        then
            update orders o
            set order_price =
                (select sum(t.ticket_price) from tickets t where t.order_id = o.order_id)
            where o.order_id = new.order_id;
        end if;
        return new;
    end;
$$
language plpgsql;

create trigger new_ticket_price_trigger
    after update on tickets
    for each row
execute procedure update_order_price();