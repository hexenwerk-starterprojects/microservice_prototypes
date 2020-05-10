create table if not exists legal_entity
(
    id            varchar(36)  not null constraint legal_entity_pk primary key,
    name          varchar(255) not null,
    category_id   integer,
    category_name varchar(255),
    modified_date timestamp    not null,
    created_date  timestamp    not null
);

INSERT INTO public.legal_entity (id, name, category_id, category_name, modified_date, created_date)
VALUES ('00042D28-27D2-4A51-9018-73195CE981B0', 'MEADE COUNTY BANK', 1, 'Banks', '2020-04-04 22:22:27.000000',
        '2020-04-04 22:22:31.000000'),
       ('00051D75-F41F-4867-BCEA-88E16F9B0BCB', 'SPAREBANKEN DIN', 1, 'Banks', '2020-04-04 22:23:21.000000',
        '2020-04-04 22:23:23.000000'),
       ('00062886-0C81-47E0-A8A9-973E260CAACE', '21ST CENTURY FOX AMERICA INC', 3, 'Corporations',
        '2020-04-04 22:24:18.000000', '2020-04-04 22:24:25.000000'),
       ('0021821D-2C0B-4853-9AE5-D00E1862BD80', 'PEOPLE''S GOVERNMENT OF CHONGQING TONGLIANG', 26, 'Subsovereign',
        '2020-04-04 22:25:23.000000', '2020-04-04 22:25:25.000000')
ON CONFLICT DO NOTHING;