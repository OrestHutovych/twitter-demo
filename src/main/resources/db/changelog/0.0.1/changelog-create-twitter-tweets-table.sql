--liquibase formatted sql

--changeset OrestHutovych:create-twitter-tweets-table
--comment create table twitter.tweets
create table twitter.tweets(
    id                  serial primary key,
    message             varchar(180) not null,
    user_profile_id     integer      not null,
    created_timestamp   timestamp    not null
);
--rollback drop table twitter.tweets;

--changeset OrestHutovych:add-twitter-tweets-constraints
--comment add constraints to twitter.tweets table
alter table twitter.tweets
    add constraint tweets__user_profile__fk
        foreign key (user_profile_id) references twitter.user_profiles (id);
--rollback alter table twitter.tweets drop constraints tweets__user_profile__fk;