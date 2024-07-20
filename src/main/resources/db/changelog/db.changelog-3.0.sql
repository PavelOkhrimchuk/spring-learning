--liquibase formatted sql

--changeset ohrim:1
ALTER TABLE users
    ADD COLUMN image VARCHAR(64);