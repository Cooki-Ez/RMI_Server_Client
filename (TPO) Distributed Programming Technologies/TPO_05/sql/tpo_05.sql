DROP TABLE UserResource;
DROP TABLE Users;
DROP TABLE Resources;

-- CREATING
CREATE TABLE Users (
  id_usr        SERIAL      NOT NULL PRIMARY KEY,
  usr_login  VARCHAR(50) NOT NULL,
  usr_password VARCHAR(50) NOT NULL,
  usr_first_name VARCHAR(50)
);

CREATE TABLE Resources (
  id_resource   SERIAL      NOT NULL PRIMARY KEY,
  resource_name VARCHAR(50) NOT NULL,
  content       VARCHAR(100) NOT NULL
);

CREATE TABLE UserResource (
  id_usr      INT NOT NULL REFERENCES Users (id_usr),
  id_resource INT NOT NULL REFERENCES Resources (id_resource),
  PRIMARY KEY (id_usr, id_resource)
);

----------------------------------------------------
-- INSERTING

-- User
INSERT INTO Users (usr_login, usr_password, usr_first_name) VALUES ('user1', 'user1', 'Torin');
INSERT INTO Users (usr_login, usr_password, usr_first_name) VALUES ('user2', 'user2', 'Suellen');
INSERT INTO Users (usr_login, usr_password, usr_first_name) VALUES ('user3', 'user3', 'Kirsteni');
INSERT INTO Users (usr_login, usr_password, usr_first_name) VALUES ('user4', 'user4', 'Malena');
INSERT INTO Users (usr_login, usr_password, usr_first_name) VALUES ('user5', 'user5', 'Joellyn');
INSERT INTO Users (usr_login, usr_password, usr_first_name) VALUES ('user6', 'user6', 'Avram');
INSERT INTO Users (usr_login, usr_password, usr_first_name) VALUES ('user7', 'user7', 'Katti');
INSERT INTO Users (usr_login, usr_password, usr_first_name) VALUES ('user8', 'user8', 'Jody');
INSERT INTO Users (usr_login, usr_password, usr_first_name) VALUES ('user9', 'user9', 'Elsa');
INSERT INTO Users (usr_login, usr_password, usr_first_name) VALUES ('user10', 'user10', 'Osborn');

INSERT INTO Users (usr_login, usr_password) VALUES ('admin', 'admin');

-- Resource
INSERT INTO Resources (resource_name, content) VALUES ('The deepest MEOW', 'uV6nVH2KH7I');
INSERT INTO Resources (resource_name, content) VALUES ('Game of Thrones S6 trailer', '4xMiyG4S0v4');
INSERT INTO Resources (resource_name, content) VALUES ('David Bowie and Kristen Wiig - Space Oddity', 'ruQvohDUyow');
INSERT INTO Resources (resource_name, content) VALUES ('The Rains Of Castamere', 'ECewrAld3zw');
INSERT INTO Resources (resource_name, content) VALUES ('Desiigner - Panda', 'E5ONTXHS2mM');
INSERT INTO Resources (resource_name, content) VALUES ('Kendrick Lamar - HUMBLE.', 'tvTRZJ-4EyI');
INSERT INTO Resources (resource_name, content) VALUES ('Kendrick Lamar - DNA.', 'NLZRYQMLDW4');
INSERT INTO Resources (resource_name, content) VALUES ('Котлетки с пюрешкой', 'A1Qb4zfurA8');
INSERT INTO Resources (resource_name, content) VALUES ('Detevminism vs Free Will', 'vCGtkDzELAI');
INSERT INTO Resources (resource_name, content) VALUES ('Ламповая няша', 'cwJKjuyLv80');
INSERT INTO Resources (resource_name, content) VALUES ('368 THE UNANSWERED QUESTION?', 'ZWhfSmk3fSI');
INSERT INTO Resources (resource_name, content) VALUES ('How Dark Patterns Trick You Online', 'kxkrdLI6e6M');
INSERT INTO Resources (resource_name, content) VALUES ('Egoistic Altruism', 'rvskMHn0sqQ');
INSERT INTO Resources (resource_name, content) VALUES ('Boston Dynamics Abusing Robots', 'aFuA50H9uek');
INSERT INTO Resources (resource_name, content) VALUES ('Where Be Aliens?', '7cidUaUCb5M');
INSERT INTO Resources (resource_name, content) VALUES ('String Theory', 'Da-2h2B4faU');
INSERT INTO Resources (resource_name, content) VALUES ('Radiohead - Creep', 'XFkzRNyygfk');
INSERT INTO Resources (resource_name, content) VALUES ('Антоха МС - Время Ток', 'JDSPAPOUU0U');
INSERT INTO Resources (resource_name, content) VALUES ('Bike Lanes by Casey Neistat', 'bzE-IMaegzQ');
INSERT INTO Resources (resource_name, content) VALUES ('LONELY.', '_QPcclYWOr4');
INSERT INTO Resources (resource_name, content) VALUES ('Is Anything Real?', 'L45Q1_psDqk');
INSERT INTO Resources (resource_name, content) VALUES ('joji - demons', 'Yw1tCJ1y34o');
INSERT INTO Resources (resource_name, content) VALUES ('Why does Microsoft even bother with Edge?', '2irD_HtUkls');
INSERT INTO Resources (resource_name, content) VALUES ('How To Uninstall McAfee Antivirus', 'bKgf5PaBzyg');
INSERT INTO Resources (resource_name, content) VALUES ('HACKERMAN''S HACKING TUTORIALS - How To Hack Time', 'KEkrWRHCDQU');
INSERT INTO Resources (resource_name, content) VALUES ('Yung Lean - Kyoto', 'tMgkt9jdjTU');
INSERT INTO Resources (resource_name, content) VALUES ('Вечерний Ургант. Луна — «Jukebox»', 'JGewzxVQBn4');
INSERT INTO Resources (resource_name, content) VALUES ('Dr. Dre - Still D.R.E. ft. Snoop Dogg', '_CL6n0FJZpk');
INSERT INTO Resources (resource_name, content) VALUES ('The meaning of knowledge', 'kXhJ3hHK9hQ');
INSERT INTO Resources (resource_name, content) VALUES ('Make It Count', 'WxfZkMm3wcg');
INSERT INTO Resources (resource_name, content) VALUES ('SUPER HIDDEN VIDEO FOR ADMIN', 'NHEaYbDWyQE');

-- UserResource
INSERT INTO UserResource(id_usr, id_resource) VALUES (1,1);
INSERT INTO UserResource(id_usr, id_resource) VALUES (1,2);
INSERT INTO UserResource(id_usr, id_resource) VALUES (1,3);
INSERT INTO UserResource(id_usr, id_resource) VALUES (2,4);
INSERT INTO UserResource(id_usr, id_resource) VALUES (2,5);
INSERT INTO UserResource(id_usr, id_resource) VALUES (2,6);
INSERT INTO UserResource(id_usr, id_resource) VALUES (3,7);
INSERT INTO UserResource(id_usr, id_resource) VALUES (3,8);
INSERT INTO UserResource(id_usr, id_resource) VALUES (3,9);
INSERT INTO UserResource(id_usr, id_resource) VALUES (4,10);
INSERT INTO UserResource(id_usr, id_resource) VALUES (4,11);
INSERT INTO UserResource(id_usr, id_resource) VALUES (4,12);
INSERT INTO UserResource(id_usr, id_resource) VALUES (5,13);
INSERT INTO UserResource(id_usr, id_resource) VALUES (5,14);
INSERT INTO UserResource(id_usr, id_resource) VALUES (5,15);
INSERT INTO UserResource(id_usr, id_resource) VALUES (6,16);
INSERT INTO UserResource(id_usr, id_resource) VALUES (6,17);
INSERT INTO UserResource(id_usr, id_resource) VALUES (6,18);
INSERT INTO UserResource(id_usr, id_resource) VALUES (7,19);
INSERT INTO UserResource(id_usr, id_resource) VALUES (7,20);
INSERT INTO UserResource(id_usr, id_resource) VALUES (7,21);
INSERT INTO UserResource(id_usr, id_resource) VALUES (8,22);
INSERT INTO UserResource(id_usr, id_resource) VALUES (8,23);
INSERT INTO UserResource(id_usr, id_resource) VALUES (8,24);
INSERT INTO UserResource(id_usr, id_resource) VALUES (9,25);
INSERT INTO UserResource(id_usr, id_resource) VALUES (9,26);
INSERT INTO UserResource(id_usr, id_resource) VALUES (9,27);
INSERT INTO UserResource(id_usr, id_resource) VALUES (10,28);
INSERT INTO UserResource(id_usr, id_resource) VALUES (10,29);
INSERT INTO UserResource(id_usr, id_resource) VALUES (10,30);
--admin
INSERT INTO UserResource(id_usr, id_resource) VALUES (11,1);
INSERT INTO UserResource(id_usr, id_resource) VALUES (11,2);
INSERT INTO UserResource(id_usr, id_resource) VALUES (11,3);
INSERT INTO UserResource(id_usr, id_resource) VALUES (11,4);
INSERT INTO UserResource(id_usr, id_resource) VALUES (11,5);
INSERT INTO UserResource(id_usr, id_resource) VALUES (11,6);
INSERT INTO UserResource(id_usr, id_resource) VALUES (11,7);
INSERT INTO UserResource(id_usr, id_resource) VALUES (11,8);
INSERT INTO UserResource(id_usr, id_resource) VALUES (11,9);
INSERT INTO UserResource(id_usr, id_resource) VALUES (11,10);
INSERT INTO UserResource(id_usr, id_resource) VALUES (11,11);
INSERT INTO UserResource(id_usr, id_resource) VALUES (11,12);
INSERT INTO UserResource(id_usr, id_resource) VALUES (11,13);
INSERT INTO UserResource(id_usr, id_resource) VALUES (11,14);
INSERT INTO UserResource(id_usr, id_resource) VALUES (11,15);
INSERT INTO UserResource(id_usr, id_resource) VALUES (11,16);
INSERT INTO UserResource(id_usr, id_resource) VALUES (11,17);
INSERT INTO UserResource(id_usr, id_resource) VALUES (11,18);
INSERT INTO UserResource(id_usr, id_resource) VALUES (11,19);
INSERT INTO UserResource(id_usr, id_resource) VALUES (11,20);
INSERT INTO UserResource(id_usr, id_resource) VALUES (11,21);
INSERT INTO UserResource(id_usr, id_resource) VALUES (11,22);
INSERT INTO UserResource(id_usr, id_resource) VALUES (11,23);
INSERT INTO UserResource(id_usr, id_resource) VALUES (11,24);
INSERT INTO UserResource(id_usr, id_resource) VALUES (11,25);
INSERT INTO UserResource(id_usr, id_resource) VALUES (11,26);
INSERT INTO UserResource(id_usr, id_resource) VALUES (11,27);
INSERT INTO UserResource(id_usr, id_resource) VALUES (11,28);
INSERT INTO UserResource(id_usr, id_resource) VALUES (11,29);
INSERT INTO UserResource(id_usr, id_resource) VALUES (11,30);
INSERT INTO UserResource(id_usr, id_resource) VALUES (11,31);