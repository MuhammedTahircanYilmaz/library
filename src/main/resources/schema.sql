CREATE TABLE IF NOT EXISTS Item(
    id SERIAL PRIMARY KEY,
    title varchar(255) NOT NULL,
    description text,
    author_studio varchar(255),
    rating integer,
    item_type VARCHAR(50) NOT NULL,
    status VARCHAR(20) NOT NULL,
    date_created TIMESTAMP ,
    date_updated TIMESTAMP
);

CREATE TABLE IF NOT EXISTS user_entity(
    id SERIAL PRIMARY KEY,
    username varchar(50) NOT NULL,
    email varchar(100) NOT NULL,
    password text NOT NULL
);

CREATE TABLE IF NOT EXISTS roles(
    id SERIAL PRIMARY KEY,
    name varchar(20) NOT NULL
);

INSERT INTO Item(title,description,author_studio,status,item_type,date_created)
VALUES ('Past Life Returner','Seon Hu comes back, rules the world','Hedgethehog','ONGOING','WEBNOVEL',CURRENT_TIMESTAMP);

INSERT INTO user_entity(username, email, password) VALUES ('Tahir', 'someemail@gmail.com', 'password');

INSERT INTO roles(name) VALUES ('USER')