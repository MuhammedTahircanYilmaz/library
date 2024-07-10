CREATE TABLE IF NOT EXISTS user_entity(
    user_id SERIAL PRIMARY KEY,
    username varchar(50) NOT NULL UNIQUE,
    email varchar(100) NOT NULL,
    password text NOT NULL
);


CREATE TABLE IF NOT EXISTS media(
    media_id SERIAL PRIMARY KEY,
    username VARCHAR(50) REFERENCES user_entity(username),
    user_id INTEGER REFERENCES user_entity(user_id),
    title varchar(255) NOT NULL,
    description text,
    author_studio varchar(255),
    rating integer,
    item_type VARCHAR(50) NOT NULL,
    status VARCHAR(20) NOT NULL,
    date_created TIMESTAMP,
    date_updated TIMESTAMP
);

CREATE TABLE IF NOT EXISTS roles(
    id SERIAL PRIMARY KEY,
    name varchar(20) NOT NULL
);
