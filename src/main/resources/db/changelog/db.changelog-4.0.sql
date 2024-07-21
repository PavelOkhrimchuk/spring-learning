--liquibase formatted sql

--changeset ohrim:1
ALTER TABLE users
    ADD COLUMN password VARCHAR(128) DEFAULT '{noop}123';