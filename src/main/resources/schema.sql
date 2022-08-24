create table issues (
id SERIAL NOT NULL PRIMARY KEY,
summary VARCHAR(256) NOT NULL,
description VARCHAR(256) NOT NULL,
created_at TIMESTAMP,
updated_at TIMESTAMP
);