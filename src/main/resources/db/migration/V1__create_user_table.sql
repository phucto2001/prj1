CREATE TABLE user
(
    id           BINARY(16)   NOT NULL,
    username     VARCHAR(255) NULL,
    password     VARCHAR(255) NULL,
    display_name VARCHAR(255) NULL,
    CONSTRAINT pk_user PRIMARY KEY (id)
);