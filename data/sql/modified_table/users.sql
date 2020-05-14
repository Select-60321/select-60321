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

alter table users
    owner to checker;

create unique index users_user_name_uindex
    on users (user_name);

INSERT INTO public.users (user_id, user_name, phone_number, id_card_num, password) VALUES (2, '聂秋实', '18911111111', '420106xxxxxxxxxxxx', 'password');
INSERT INTO public.users (user_id, user_name, phone_number, id_card_num, password) VALUES (3, '张三', '18933333333', '000000000000000001', 'zhangsan');
INSERT INTO public.users (user_id, user_name, phone_number, id_card_num, password) VALUES (4, '李四', '18944444444', '000000000000000002', 'lisi');
INSERT INTO public.users (user_id, user_name, phone_number, id_card_num, password) VALUES (5, '王五', '18955555555', '000000000000000003', 'wangwu');
INSERT INTO public.users (user_id, user_name, phone_number, id_card_num, password) VALUES (6, '李华', '18966666666', '000000000000000004', 'lihua');
INSERT INTO public.users (user_id, user_name, phone_number, id_card_num, password) VALUES (7, '小明', '18977777777', '000000000000000005', 'xiaoming');
INSERT INTO public.users (user_id, user_name, phone_number, id_card_num, password) VALUES (10, 'lishilong', '18995566288', '420102200002134014', '88992233');
INSERT INTO public.users (user_id, user_name, phone_number, id_card_num, password) VALUES (11, 'zhangjiaxi', '18955555244', '423002200005063043', 'zhangjiaxi');
INSERT INTO public.users (user_id, user_name, phone_number, id_card_num, password) VALUES (12, 'nqsnb', '18977777777', '420106200000004000', 'nqsnbnqsnb');
INSERT INTO public.users (user_id, user_name, phone_number, id_card_num, password) VALUES (1, '黎诗龙', '18911111111', '420102xxxxxxxxxxxx', 'lsl213');