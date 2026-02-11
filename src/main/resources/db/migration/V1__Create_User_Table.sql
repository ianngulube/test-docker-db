CREATE TABLE IF NOT EXISTS "users" (
    id SERIAL PRIMARY KEY,
    userId VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(150) NOT NULL,
    dateCreated TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
create sequence users_SEQ start with 1 increment by 1;
