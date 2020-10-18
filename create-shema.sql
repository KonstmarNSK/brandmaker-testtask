create table if not exists PEOPLE(
	ID int not null primary key,
    EMAIL varchar(255) not null,
    FIRST_NAME varchar(255) not null,
    LAST_NAME varchar(255) not null,
    BIRTH_DATE DATE NOT NULL
);