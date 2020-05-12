create table customer_detail
(
    id              varchar(255) not null
        constraint customer_detail_pk
            primary key,
    name            varchar(255) not null,
    email           varchar(255),
    gender          varchar(255),
    birth_date      date,
    subsidiary      varchar(255),
    status          varchar(255),
    document_type   varchar(255) not null,
    document_value  varchar(255) not null,
    registry        varchar(255) not null,
    start_date      date         not null,
    end_date        date,
    occupation_name varchar(255),
    salary          numeric,
    phone_number    varchar(255)
);

create table squad
(
    id            bigserial    not null
        constraint squad_pkey
            primary key,
    name          varchar(255) not null,
    status        varchar(255) not null,
    create_at     timestamp    not null,
    inactivate_at timestamp
);

create table squad_members
(
    id                 bigserial    not null
        constraint squad_members_pkey
            primary key,
    squad_id           bigint       not null
        constraint squad_members_squad_id_fk
            references squad
            on delete cascade,
    customer_detail_id varchar(255) not null
        constraint squad_members_customer_detail_id_fk
            references customer_detail,
    is_leader          boolean      not null,
    is_tech            boolean      not null,
    status             varchar(255) not null,
    create_at          timestamp    not null,
    inactivate_at      timestamp
);
