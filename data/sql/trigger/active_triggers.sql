create or replace function update_journey_status()
    returns trigger
as $$
    begin
        if new.station_active <> old.station_active
        then
            update journeys j
            set status = new.station_active
            where j.station_id = new.station_id;
        end if;
        return new;
    end;
$$
language plpgsql;

create trigger update_status_trigger
    after update on stations
    for each row
execute procedure update_journey_status();

create or replace function update_ticket_active()
    returns trigger
as $$
    begin
        if new.status <> old.status and new.status = 1
        then
            update tickets t
            set ticket_active = 2
            where depart_journey = new.journey_id
               or arrive_journey = new.journey_id;
        end if;
        return new;
    end;
$$
language plpgsql;

create trigger update_active_trigger
    after update on journeys
    for each row
execute procedure update_ticket_active();