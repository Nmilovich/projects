-- start 2 требуется, если админа добавляем с помощью миграции. если этого не сделать,
-- то при регистрации пользователей, будет ругаться на на уже существующий id 1
create sequence hibernate_sequence start 2 increment 1;

create table ad (
    id int8 not null,
    ad_name varchar(80) not null,
    price int4 not null check (price>=1 AND price<=1000000),
    user_id int8,
    primary key (id)
    );

create table user_role (
    user_id int8 not null,
    roles varchar(255)
    );

create table usr (
    id int8 not null,
    banned boolean not null,
    activation_code varchar(255),
    active boolean not null,
    email varchar(255),
    password varchar(255) not null,
    username varchar(255) not null,
    primary key (id)
    );

-- требуется так как таблицы соединены c id юзера
alter table if exists ad
    add constraint ad_user_fk
    foreign key (user_id) references usr;

alter table if exists user_role
    add constraint user_role_user_fk
    foreign key (user_id) references usr;