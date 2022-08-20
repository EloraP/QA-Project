CREATE DATABASE revolution;

use revolution;

CREATE TABLE strikes(
id INT NOT NULL UNIQUE AUTO_INCREMENT,
dateOfStrike datetime NOT NULL,
location VARCHAR(200) NOT NULL,
leader VARCHAR(200),
tradeUnion VARCHAR(200),
workArea VARCHAR(200),
capacity int, 
PRIMARY KEY (id));

INSERT INTO strikes(dateOfStrike, location, leader, tradeUnion, workArea, capacity) VALUES (
'2022-08-20 12:00:00', "Greenwich, London", "Ben O'Connor", "Unite", "transport", 300);

INSERT INTO strikes(dateOfStrike, location, leader, tradeUnion, workArea, capacity) VALUES (
'2022-08-27 19:00:00', 'Fort William, Scotland', "Harry Gairn", "Unite", "chef", 1000);

SELECT * FROM strikes;

#DROP TABLES strikes;
#DROP DATABASE revolution;