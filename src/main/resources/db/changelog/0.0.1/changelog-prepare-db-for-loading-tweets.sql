--liquibase formatted sql

--changeset OrestHutovych:create-public-famous_quotes
--comment create table public.famous_quotes
CREATE TABLE public.famous_quotes
(
    quote      varchar(255) not null
);
--rollback drop table public.famous_quotes;