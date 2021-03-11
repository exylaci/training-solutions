CREATE TABLE if NOT EXISTS diak(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	nev VARCHAR(100) NOT NULL,
	osztaly VARCHAR(4));

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

LOAD DATA LOCAL INFILE 'src/main/resources/erettsegik/oktober2020/kozossegiszolgalat/diak.txt'
	REPLACE INTO TABLE kozossegi.diak
	CHARACTER SET utf8
	FIELDS TERMINATED BY '\t'
	LINES TERMINATED BY '\r\n'
	IGNORE 1 LINES (id,nev,osztaly);

LOAD DATA LOCAL INFILE 'src/main/resources/erettsegik/oktober2020/kozossegiszolgalat/tevekenyseg.txt'
	REPLACE INTO TABLE kozossegi.tevekenyseg
	CHARACTER SET utf8
	FIELDS TERMINATED BY '\t'
	LINES TERMINATED BY '\r\n'
	IGNORE 1 LINES (id,nev,iskolai);

LOAD DATA LOCAL INFILE 'src/main/resources/erettsegik/oktober2020/kozossegiszolgalat/munka.txt'
	REPLACE INTO TABLE kozossegi.munka
	CHARACTER SET utf8
	FIELDS TERMINATED BY '\t'
	LINES TERMINATED BY '\r\n'
	IGNORE 1 LINES (id,datum,kezdes,hossz,maxletszam,tevekenysegid);

LOAD DATA LOCAL INFILE 'src/main/resources/erettsegik/oktober2020/kozossegiszolgalat/jelentkezes.txt'
	REPLACE INTO TABLE kozossegi.jelentkezes
	CHARACTER SET utf8
	FIELDS TERMINATED BY '\t'
	LINES TERMINATED BY '\r\n'
	IGNORE 1 LINES (diakid,munkaid,ervenyes,elfogadva,teljesitve);

