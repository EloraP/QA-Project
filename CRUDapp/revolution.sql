CREATE DATABASE revolution;

use revolution;

CREATE TABLE tradeUnions(
id INT NOT NULL UNIQUE AUTO_INCREMENT,
fullName VARCHAR(200),
TUName VARCHAR(200),
numberOfMembers int,
established int, 
PRIMARY KEY(id));

INSERT INTO tradeUnions(fullName, TUName, numberOfMembers, established) VALUES(
"National Union of Rail, Maritime and Transport Workers", "RMT", 80000, 1990);

INSERT INTO tradeUnions(fullName, TUName, numberOfMembers, established) VALUES(
"Unite the Union", "Unite", 1291017, 2007);

INSERT INTO tradeUnions(fullName, TUName, numberOfMembers, established) VALUES(
"Communication Workers Union", "CWU", 201900, 1995);


CREATE TABLE leaders(
id INT NOT NULL UNIQUE AUTO_INCREMENT,
leaderName VARCHAR(200) NOT NULL, 
age int, 
yearsOfExperience int,
tradeUnionID int,
PRIMARY KEY(id), 
FOREIGN KEY(tradeUnionID) REFERENCES tradeUnions(id));

INSERT INTO leaders(leaderName, age, yearsOfExperience, tradeUnionID) VALUES(
'Harry Gairn', 22, 10, 2);

INSERT INTO leaders(leaderName, age, yearsOfExperience, tradeUnionID) VALUES(
"Ben O'Connor", 24, 5, 3);


CREATE TABLE strikes(
id INT NOT NULL UNIQUE AUTO_INCREMENT,
dateOfStrike datetime NOT NULL,
location VARCHAR(200) NOT NULL,
tradeUnionID int,
workArea VARCHAR(200),
capacity int, 
PRIMARY KEY (id),
FOREIGN KEY(tradeUnionID) REFERENCES tradeUnions(id));

INSERT INTO strikes(dateOfStrike, location, tradeUnionID, workArea, capacity) VALUES (
'2022-08-20 12:00:00', "Greenwich, London", 2, "Transport", 300);

INSERT INTO strikes(dateOfStrike, location, tradeUnionID, workArea, capacity) VALUES (
'2023-01-16 19:00:00', 'Fort William, Scotland', 2, "Catering", 1000);

SELECT * FROM strikes; 



SELECT * FROM strikes;
SELECT * FROM leaders;
SELECT * FROM tradeUnions;


DROP DATABASE revolution;