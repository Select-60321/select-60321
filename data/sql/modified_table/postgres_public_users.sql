create table users
(
    user_id      serial       not null
        constraint users_pkey
            primary key,
    user_name    varchar(30)  not null,
    phone_number char(11)     not null,
    id_card_num  char(18)     not null
        constraint users_id_card_num_key
            unique,
    password     varchar(100) not null
);

create unique index users_user_name_uindex
    on users (user_name);