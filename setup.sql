CREATE DATABASE QuestionsDB;
USE QuestionsDB;
CREATE TABLE Questions (id INT NOT NULL auto_increment, Question TEXT, Answer TEXT, PRIMARY KEY (id));
INSERT INTO Questions VALUES(1, 'What is love?', 'Baby dont hurt me, no more');
INSERT INTO Questions VALUES(2, 'Whats cookin?', 'Meth!');
INSERT INTO Questions VALUES(3, 'What would you never do to me?', 'Never gona give you up, Never gona let you down, Never gona turn around or desert you!');

create table Users (
   id BIGINT NOT NULL AUTO_INCREMENT,
   sso_id VARCHAR(30) NOT NULL,
   password VARCHAR(100) NOT NULL,
   first_name VARCHAR(30) NOT NULL,
   last_name  VARCHAR(30) NOT NULL,
   email VARCHAR(30) NOT NULL,
   state VARCHAR(30) NOT NULL,  
   PRIMARY KEY (id),
   UNIQUE (sso_id));
   
create table Roles(
   id BIGINT NOT NULL AUTO_INCREMENT,
   type VARCHAR(30) NOT NULL,
   PRIMARY KEY (id),
   UNIQUE (type)
);
   
CREATE TABLE UsersProfile (
	user_id BIGINT NOT NULL,
    user_profile_id BIGINT NOT NULL,
    PRIMARY KEY (user_id, user_profile_id),
    CONSTRAINT FK_Users FOREIGN KEY (user_id) REFERENCES Users (id),
    CONSTRAINT FK_Roles FOREIGN KEY (user_profile_id) REFERENCES Roles (id)
);

INSERT INTO Roles(type)
VALUES ('USER');
 
INSERT INTO Roles(type)
VALUES ('ADMIN');
 
INSERT INTO Roles(type)
VALUES ('DBA');
 
INSERT INTO Users(sso_id, password, first_name, last_name, email, state)
VALUES ('Yimbo','Titkos123', 'Hoho','Haha','hoho@haha.com', 'Active');
 
INSERT INTO Users(sso_id, password, first_name, last_name, email, state)
VALUES ('Zorn','Titkos123', 'Ize','Hoze','ize@hoze.com', 'Active');
 
INSERT INTO Users(sso_id, password, first_name, last_name, email, state)
VALUES ('Zuzu','Titkos123', 'Zuzu','Petals','zuzuy@petals.com', 'Active');
 
INSERT INTO UsersProfile (user_id, user_profile_id)
  SELECT user.id, profile.id FROM Users user, Roles profile  
  where user.sso_id='Yimbo' and profile.type='USER';
 
INSERT INTO UsersProfile (user_id, user_profile_id)
  SELECT user.id, profile.id FROM Users user, Roles profile
  where user.sso_id='Zorn' and profile.type='USER';
 
INSERT INTO UsersProfile (user_id, user_profile_id)
  SELECT user.id, profile.id FROM Users user, Roles profile
  where user.sso_id='Zuzu' and profile.type='USER';
 