insert into usr (id, banned, active, password, username)
    values (1, false, true, 'admin','admin');

insert into user_role (user_id, roles)
    values (1, 'USER'), (1, 'ADMIN');