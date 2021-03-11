CREATE TABLE if NOT EXISTS diak(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	nev VARCHAR(100) NOT NULL,
	osztaly char(4));

CREATE TABLE if NOT EXISTS tevekenyseg(
	id INT NOT NULL PRIMARY KEY UNIQUE,
	nev VARCHAR(100),
	iskolai BOOLEAN);

CREATE TABLE if NOT EXISTS munka(
	id INT NOT NULL PRIMARY KEY UNIQUE,
	datum DATE,
	kezdes TIME,
	hossz INT,
	maxletszam INT,
	tevekenysegid INT,
	FOREIGN KEY (tevekenysegid) REFERENCES tevekenyseg(id));

CREATE TABLE if NOT EXISTS jelentkezes(
	diakid INT NOT NULL,
	munkaid INT NOT NULL,
	ervenyes BOOLEAN,
	elfogadva BOOLEAN,
	teljesitve BOOLEAN,
	PRIMARY KEY (diakid,munkaid),
	FOREIGN KEY (diakid) REFERENCES diak(id),
	FOREIGN KEY (munkaid) REFERENCES munka(id));
