create table if not exists role
(
    id        int auto_increment
        primary key,
    role_name varchar(20) not null,
    constraint id
        unique (id),
    constraint role_name
        unique (role_name)
);

create table if not exists user
(
    id                int auto_increment
        primary key,
    lastname          varchar(40)                               not null,
    user_name         varchar(20)                               not null,
    patronymic        varchar(40)                               not null,
    email             varchar(50)                               not null,
    role_id           int                                       not null,
    creation_date     timestamp(6) default CURRENT_TIMESTAMP(6) not null,
    modification_date timestamp(6) default CURRENT_TIMESTAMP(6) not null,
    constraint id
        unique (id),
    constraint user_role_id_fk
        foreign key (role_id) references role (id)
);
