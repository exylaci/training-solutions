CREATE TABLE if NOT EXISTS tag(
	id INT AUTO_INCREMENT PRIMARY KEY,
	nev varchar(100),
	nem CHAR(1),
	szuletett INT,
	elhunyt INT,
	identitas VARCHAR(100));

CREATE TABLE if NOT EXISTS tagsag(
	id INT AUTO_INCREMENT PRIMARY KEY,
	tagid INT,
	tipus CHAR(1),
	ev INT,
	FOREIGN KEY(tagid) REFERENCES tag(id));
