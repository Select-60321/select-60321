create table admins
(
    admin_id   serial       not null
        constraint admins_pkey
            primary key,
    admin_name varchar(30)  not null
        constraint admins_admin_name_key
            unique,
    password   varchar(100) not null
);

alter table admins
    owner to checker;

INSERT INTO public.admins (admin_id, admin_name, password) VALUES (20, 'lori', '123456');
INSERT INTO public.admins (admin_id, admin_name, password) VALUES (21, 'nqs', '123456');
INSERT INTO public.admins (admin_id, admin_name, password) VALUES (22, 'lll', '1234');
INSERT INTO public.admins (admin_id, admin_name, password) VALUES (24, 'opp', '1234');
INSERT INTO public.admins (admin_id, admin_name, password) VALUES (26, 'nqss', 'passwd');
INSERT INTO public.admins (admin_id, admin_name, password) VALUES (28, 'db307', 'psswd');
INSERT INTO public.admins (admin_id, admin_name, password) VALUES (1, 'admin', 'admin');