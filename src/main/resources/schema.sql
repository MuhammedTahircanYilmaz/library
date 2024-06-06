CREATE TABLE IF NOT EXISTS Item(
    id SERIAL PRIMARY KEY,
    title varchar(255) NOT NULL,
    description text,
    author_studio varchar(255),
    rating integer,
    item_type VARCHAR(50) NOT NULL,
    status VARCHAR(20) NOT NULL,
    date_created TIMESTAMP NOT NULL,
    date_updated TIMESTAMP
);

INSERT INTO Item(title,description,author_studio,status,item_type,date_created)
VALUES ('Past Life Returner','Seon Hu comes back, rules the world','Hedgethehog','ONGOING','WEBNOVEL',CURRENT_TIMESTAMP)