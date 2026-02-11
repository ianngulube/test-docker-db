CREATE TABLE IF NOT EXISTS "users" (
    id BIGINT PRIMARY KEY,
    userId VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    dateCreated TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
create sequence users_SEQ start with 1 increment by 1;
