DROP TABLE IF EXISTS USERS2;

CREATE TABLE USERS2 (
	userId		varchar(12)	NOT NULL,
	password	varchar(12)	NOT NULL,
	name		varchar(20) NOT NULL,
	email		varchar(50),
	
	PRIMARY	KEY		(userId)
);

INSERT INTO USERS2 VALUES('xx', 'xx', 'xx', 'xx@nate.com');