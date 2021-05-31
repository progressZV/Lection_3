create table client
(
    id          bigint       not null
        primary key,
    apps_number int          null,
    name        varchar(255) null
);

create table room
(
    id          bigint not null
        primary key,
    cost        double not null,
    fix_status  bit    not null,
    free_status bit    not null,
    number      int    not null,
    rooms_count int    not null,
    stars_count int    not null
);

create table service
(
    id   bigint       not null
        primary key,
    cost double       not null,
    name varchar(255) null
);

