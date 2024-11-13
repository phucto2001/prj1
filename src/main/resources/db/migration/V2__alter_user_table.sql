ALTER TABLE user
    MODIFY username VARCHAR(50) NOT NULL,
    MODIFY password VARCHAR(100) NOT NULL,
    MODIFY display_name VARCHAR(100) NOT NULL,
    ADD COLUMN created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    ADD COLUMN updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    ADD CONSTRAINT uk_user_username UNIQUE (username);