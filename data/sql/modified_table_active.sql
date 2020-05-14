begin;
alter table stations add column station_active int not null default 0;
alter table tickets add column ticket_active int not null default 0;
commit;