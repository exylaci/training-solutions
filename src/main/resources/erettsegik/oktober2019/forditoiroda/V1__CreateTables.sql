CREATE TABLE if NOT EXISTS nyelv(
 	id INT AUTO_INCREMENT PRIMARY KEY,
 	fnyelv VARCHAR(20),
 	cnyelv VARCHAR(20),
 	egysegar INT);

CREATE TABLE if NOT EXISTS doku(
	id INT AUTO_INCREMENT PRIMARY KEY,
	terjedelem INT,
	szakterulet VARCHAR(50),
	nyelvid INT,
	munkaido INT,
	FOREIGN KEY(nyelvid) REFERENCES nyelv(id));

CREATE TABLE if NOT EXISTS szemely(
	id INT AUTO_INCREMENT PRIMARY KEY,
	nev VARCHAR(50) UNIQUE,
	elerheto BOOLEAN);

CREATE TABLE if NOT EXISTS fordito(
	nyelvid INT NOT null,
	szemelyid INT NOT NULL,
	PRIMARY KEY(nyelvid,szemelyid),
	FOREIGN KEY(nyelvid) REFERENCES nyelv(id),
	FOREIGN KEY(szemelyid) REFERENCES szemely(id));