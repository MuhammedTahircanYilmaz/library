CREATE TABLE IF NOT EXISTS Item(
    id SERIAL PRIMARY KEY,
    title varchar(255) NOT NULL,
    description text,
    authorStudio varchar(255),
    rating integer,
    itemType VARCHAR(50) NOT NULL,
    status VARCHAR(20) NOT NULL,
    dateCreated TIMESTAMP NOT NULL,
    dateUpdated TIMESTAMP
);

CREATE TABLE IF NOT EXISTS Person(
    id SERIAL PRIMARY KEY,
    username varchar(50) NOT NULL,
    email varchar(100) NOT NULL,
    password text NOT NULL
);

INSERT INTO Item(title,description,authorStudio,status,itemType,dateCreated)
VALUES ('Past Life Returner','Seon Hu comes back, rules the world','Hedgethehog','ONGOING','WEBNOVEL',CURRENT_TIMESTAMP);

INSERT INTO Person(username, email, password) VALUES ('Tahir', 'someemail@gmail.com', 'password')