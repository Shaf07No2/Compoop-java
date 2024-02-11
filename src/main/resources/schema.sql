-- DROP TABLE IF EXISTS user_information_schema CASCADE;

DROP TABLE IF EXISTS UserLogin.reactions;
DROP TABLE IF EXISTS UserLogin.user_posts;
DROP TABLE IF EXISTS UserLogin.user_friend;
DROP TABLE IF EXISTS UserLogin.user_friends;
DROP TABLE IF EXISTS user_information_schema;

CREATE TABLE IF NOT EXISTS user_information_schema (
	id BIGINT AUTO_INCREMENT,
	first_name VARCHAR(50) NOT NULL,
	last_name VARCHAR(50) NOT NULL,
	password VARCHAR(50) NOT NULL,
	email VARCHAR(50) NOT NULL,
    user_name VARCHAR(50) NOT NULL,
    profile_pic VARCHAR(500),
	role VARCHAR(50) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS user_friend (
    user_id BIGINT,
    friend_id BIGINT,
    PRIMARY KEY (user_id, friend_id),
    FOREIGN KEY (user_id) REFERENCES user_information_schema(id),
    FOREIGN KEY (friend_id) REFERENCES user_information_schema(id)
);

CREATE TABLE IF NOT EXISTS user_posts (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(50),
    description VARCHAR(500),
    picture VARCHAR(500),
    user_id BIGINT NOT NULL,
    date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES user_information_schema(id)
);



