DROP TABLE IF EXISTS CLIENTS CASCADE;

CREATE TABLE IF NOT EXISTS CLIENTS
(
    ID LONG NOT NULL AUTO_INCREMENT,
    Surname VARCHAR(255) NOT NULL,
    Name VARCHAR(255) NOT NULL,
    Patronymic VARCHAR(255),
    PhoneNumber VARCHAR(255) NOT NULL,
    PRIMARY KEY (ID)
);


insert into CLIENTS (Surname, Name, Patronymic, PhoneNumber) VALUES ('Curm',	'Ansley',	'Ai',	'257-852-2840');
insert into CLIENTS (Surname, Name, Patronymic, PhoneNumber) VALUES	('Volk',	'Stan',	'Dorothee',	'731-575-1552');
insert into CLIENTS (Surname, Name, Patronymic, PhoneNumber) VALUES	('Hardman',	'Teddie',	'Anais',	'859-377-4876');
insert into CLIENTS (Surname, Name, Patronymic, PhoneNumber) VALUES	('Burnyeat',	'Raeann',	'Torbjorn',	'120-145-4212');
insert into CLIENTS (Surname, Name, Patronymic, PhoneNumber) VALUES	('Handman',	'Rani',	'Aurelie',	'909-800-8294');
insert into CLIENTS (Surname, Name, Patronymic, PhoneNumber) VALUES	('Hopkynson',	'Julianna',	'Anae',	'211-688-8023');
insert into CLIENTS (Surname, Name, Patronymic, PhoneNumber) VALUES	('Gilders',	'Putnem',	'Creez',	'113-513-5239');
insert into CLIENTS (Surname, Name, Patronymic, PhoneNumber) VALUES	('Nickels',	'Lucais',	'Berengere',	'597-226-8113');
insert into CLIENTS (Surname, Name, Patronymic, PhoneNumber) VALUES	('Whitlock',	'Hester',	'Leone',	'699-726-4310');
insert into CLIENTS (Surname, Name, Patronymic, PhoneNumber) VALUES	('Sparhawk',	'Maryjo',	'Asa',	'458-642-0611');
insert into CLIENTS (Surname, Name, Patronymic, PhoneNumber) VALUES	('Test', 'Test', 'Test', 'Test');