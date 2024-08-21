CREATE SCHEMA IF NOT EXISTS users_scheme;

CREATE TABLE IF NOT EXISTS users_scheme.city
(
    id   BIGSERIAL PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS users_scheme.university
(
    id   BIGSERIAL PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS users_scheme.users
(
    id   BIGSERIAL PRIMARY KEY,
    created       TIMESTAMP WITH TIME ZONE NOT NULL,
    deleted       BOOLEAN DEFAULT FALSE,
    email         VARCHAR(255)             NOT NULL,
    first_name    VARCHAR(255)             NOT NULL,
    last_name     VARCHAR(255)             NOT NULL,
    birthdate     DATE,
    gender        VARCHAR(1),
    avatar        TEXT,
    info          TEXT,
    city_id       UUID,
    university_id UUID
);

CREATE TABLE IF NOT EXISTS users_scheme.friend
(
    id   BIGSERIAL PRIMARY KEY,
    user_id_from UUID NOT NULL,
    user_id_to   UUID NOT NULL
);

create sequence users_scheme.city_id_seq;

alter sequence users_scheme.city_id_seq owner to "test-user";

alter sequence users_scheme.city_id_seq owned by users_scheme.city.id;

create sequence users_scheme.university_id_seq;

alter sequence users_scheme.university_id_seq owner to "test-user";

alter sequence users_scheme.university_id_seq owned by users_scheme.university.id;

create sequence users_scheme.users_id_seq;

alter sequence users_scheme.users_id_seq owner to "test-user";

alter sequence users_scheme.users_id_seq owned by users_scheme.users.id;

create sequence users_scheme.friend_id_seq;

alter sequence users_scheme.friend_id_seq owner to "test-user";

alter sequence users_scheme.friend_id_seq owned by users_scheme.friend.id;
