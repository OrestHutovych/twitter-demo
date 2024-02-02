--liquibase formatted sql

--changeset OrestHutovych:create-twitter-schema
--comment create new schema
create schema twitter;
--rollback drop schema twitter;