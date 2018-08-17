DROP TABLE IF EXISTS Person;

CREATE TABLE Person (
    ID int NOT NULL AUTO_INCREMENT,
    first_name varchar(255) NOT NULL,
    last_name varchar(255),
    PRIMARY KEY (ID)
); 