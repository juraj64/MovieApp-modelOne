-- ###########################################
-- # Drop
-- ###########################################
-- Drop index

-- Drop many to many relations

-- Drop normal entities
DROP TABLE MOVIE CASCADE;
DROP TABLE DIRECTOR CASCADE;
DROP TABLE ACTOR CASCADE;

-- Drop pk sequence
DROP SEQUENCE hibernate_sequence;

-- ###########################################
-- # Create
-- ###########################################
-- Create pk sequence
CREATE SEQUENCE hibernate_sequence;

-- Create normal entities
CREATE TABLE ACTOR (
	ID BIGINT NOT NULL,
	FIRSTNAME VARCHAR(100) NOT NULL,
	LASTNAME VARCHAR(100) NOT NULL,
	DATEOFBIRTH TIMESTAMP NOT NULL,
	UUID VARCHAR(36) NOT NULL,
	GENDER VARCHAR(1),
	CREATEDDATE TIMESTAMP,
	CREATEDBY VARCHAR(50),
	LASTUPDATED TIMESTAMP,
	LASTUPDATEDBY VARCHAR(50),
	VERSION BIGINT NOT NULL
);

CREATE TABLE DIRECTOR (
	ID BIGINT NOT NULL,
	FNAME VARCHAR(100) NOT NULL,
	LNAME VARCHAR(100) NOT NULL,
	DOFBIRTH TIMESTAMP NOT NULL,
	NATIONALITY VARCHAR(100) NOT NULL,
	UUID VARCHAR(36) NOT NULL,
	CREATEDDATE TIMESTAMP,
	CREATEDBY VARCHAR(50),
	LASTUPDATED TIMESTAMP,
	LASTUPDATEDBY VARCHAR(50),
	VERSION BIGINT NOT NULL
);

CREATE TABLE MOVIE (
	ID BIGINT NOT NULL,
	MOVIENAME VARCHAR(100) NOT NULL,
	MOVIELENGTH INTEGER NOT NULL,
	MOVIELANG VARCHAR(100) NOT NULL,
	RELEASEDATE TIMESTAMP NOT NULL,
	AGECERTIFICATE VARCHAR(100) NOT NULL,
	DOMESTICTAKINGS INTEGER NOT NULL,
	INTERNATIONALTAKINGS INTEGER NOT NULL,
	UUID VARCHAR(36) NOT NULL,
	CREATEDDATE TIMESTAMP,
	CREATEDBY VARCHAR(50),
	LASTUPDATED TIMESTAMP,
	LASTUPDATEDBY VARCHAR(50),
	VERSION BIGINT NOT NULL
);


-- Create many to many relations

-- Primary keys
ALTER TABLE ACTOR ADD CONSTRAINT PK_ACTOR
	PRIMARY KEY (ID);
ALTER TABLE DIRECTOR ADD CONSTRAINT PK_DIRECTOR
	PRIMARY KEY (ID);
ALTER TABLE MOVIE ADD CONSTRAINT PK_MOVIE
	PRIMARY KEY (ID);

-- Unique constraints
ALTER TABLE ACTOR
	ADD CONSTRAINT UQ_ACTOR UNIQUE (UUID);
ALTER TABLE DIRECTOR
	ADD CONSTRAINT UQ_DIRECTOR UNIQUE (UUID);
ALTER TABLE MOVIE
	ADD CONSTRAINT UQ_MOVIE UNIQUE (UUID);

-- Foreign key constraints


-- Index