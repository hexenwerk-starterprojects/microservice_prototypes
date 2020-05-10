create table users
(
    id         bigint not null
        constraint users_pkey
            primary key,
    dob        date,
    email      varchar(255),
    first_name varchar(255),
    gender     varchar(255),
    last_name  varchar(255),
    password   varchar(255),
    role       varchar(255)
);

alter table users
    owner to "crud-users-postgres-user";


INSERT INTO public.users (id, dob, email, first_name, gender, last_name, password, role)
VALUES (1, '1979-03-23', 'admin@admin.cz', 'Jan', 'Male', 'Kotek', 'test12', 'Admin');