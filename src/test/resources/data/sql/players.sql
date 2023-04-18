CREATE TABLE IF NOT EXISTS PLAYER (
  id int PRIMARY KEY NOT NULL,
  country_code text, 
  age int, 
  height int, 
  points int, 
  rank int, 
  weight int, 
  firstname text, 
  lastname text, 
  picture text, 
  sex text, 
  shortname text
);

CREATE TABLE IF NOT EXISTS PLAYER_LAST (
  player_id int,
  last int
);

CREATE TABLE IF NOT EXISTS COUNTRY (
  code text PRIMARY KEY NOT NULL,
  picture text
);

INSERT INTO PLAYER (id, firstname, lastname, weight, height, country_code, age, points, rank, sex, shortname) VALUES (52, 'Novak', 'Djokovic', 80000, 188, 'SRB', 31, 2542, 1, 'M', 'N.DJO');

INSERT INTO PLAYER_LAST (player_id, last) VALUES (52, 1);
INSERT INTO PLAYER_LAST (player_id, last) VALUES (52, 1);
INSERT INTO PLAYER_LAST (player_id, last) VALUES (52, 1);
INSERT INTO PLAYER_LAST (player_id, last) VALUES (52, 1);
INSERT INTO PLAYER_LAST (player_id, last) VALUES (52, 1);

INSERT INTO PLAYER (id, firstname, lastname, weight, height, country_code, age, points, rank, sex, shortname) VALUES (95, 'Venus', 'Williams', 74000, 185, 'USA', 38, 1105, 2, 'F', 'V.WIL');

INSERT INTO PLAYER_LAST (player_id, last) VALUES (95, 0);
INSERT INTO PLAYER_LAST (player_id, last) VALUES (95, 1);
INSERT INTO PLAYER_LAST (player_id, last) VALUES (95, 0);
INSERT INTO PLAYER_LAST (player_id, last) VALUES (95, 0);
INSERT INTO PLAYER_LAST (player_id, last) VALUES (95, 1);

INSERT INTO PLAYER (id, firstname, lastname, weight, height, country_code, age, points, rank, sex, shortname) VALUES (65, 'Stan', 'Wawrinka', 81000, 183, 'SUI', 37, 3521, 4, 'F', 'S.WIL');

INSERT INTO PLAYER_LAST (player_id, last) VALUES (65, 1);
INSERT INTO PLAYER_LAST (player_id, last) VALUES (65, 1);
INSERT INTO PLAYER_LAST (player_id, last) VALUES (65, 1);
INSERT INTO PLAYER_LAST (player_id, last) VALUES (65, 0);
INSERT INTO PLAYER_LAST (player_id, last) VALUES (65, 1);

INSERT INTO PLAYER (id, firstname, lastname, weight, height, country_code, age, points, rank, sex, shortname) VALUES (102, 'Serena', 'Williams', 72000, 175, 'USA', 33, 1784, 3, 'M', 'S.WAW');

INSERT INTO PLAYER_LAST (player_id, last) VALUES (102, 0);
INSERT INTO PLAYER_LAST (player_id, last) VALUES (102, 1);
INSERT INTO PLAYER_LAST (player_id, last) VALUES (102, 1);
INSERT INTO PLAYER_LAST (player_id, last) VALUES (102, 1);
INSERT INTO PLAYER_LAST (player_id, last) VALUES (102, 0);

INSERT INTO PLAYER (id, firstname, lastname, weight, height, country_code, age, points, rank, sex, shortname) VALUES (17, 'Rafael', 'Nadal', 85000, 185, 'ESP', 33, 1982, 5, 'M', 'R.NAD');

INSERT INTO PLAYER_LAST (player_id, last) VALUES (17, 1);
INSERT INTO PLAYER_LAST (player_id, last) VALUES (17, 0);
INSERT INTO PLAYER_LAST (player_id, last) VALUES (17, 0);
INSERT INTO PLAYER_LAST (player_id, last) VALUES (17, 0);
INSERT INTO PLAYER_LAST (player_id, last) VALUES (17, 1);

INSERT INTO COUNTRY (code, picture) VALUES ('SRB', 'https://data.latelier.co/training/tennis_stats/resources/Serbie.png');
INSERT INTO COUNTRY (code, picture) VALUES ('USA', 'https://data.latelier.co/training/tennis_stats/resources/USA.png');
INSERT INTO COUNTRY (code, picture) VALUES ('SUI', 'https://data.latelier.co/training/tennis_stats/resources/Suisse.png');
INSERT INTO COUNTRY (code, picture) VALUES ('ESP', 'https://data.latelier.co/training/tennis_stats/resources/Espagne.png');