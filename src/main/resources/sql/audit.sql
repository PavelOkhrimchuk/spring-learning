
ALTER TABLE users
ADD column created_at TIMESTAMP;

ALTER TABLE users
ADD column modified_at TIMESTAMP;



ALTER TABLE users
    ADD column created_by VARCHAR(32);

ALTER TABLE users
    ADD column modified_by VARCHAR(32);
