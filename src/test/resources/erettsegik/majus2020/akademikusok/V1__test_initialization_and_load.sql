CREATE TABLE if NOT EXISTS tag(
	id INT AUTO_INCREMENT PRIMARY KEY,
	nev varchar(100),
	nem CHAR(1),
	szuletett INT,
	elhunyt INT DEFAULT NULL,
	identitas VARCHAR(100));

CREATE TABLE if NOT EXISTS tagsag(
	id INT AUTO_INCREMENT PRIMARY KEY,
	tagid INT,
	tipus CHAR(1),
	ev INT,
	FOREIGN KEY(tagid) REFERENCES tag(id));

LOAD DATA LOCAL INFILE 'C:\\training\\training-solutions\\src\\main\\resources\\erettsegik\\majus2020\\akademikusok\\tag.txt'
    REPLACE INTO TABLE `tag`
    CHARACTER SET 'utf8'
    FIELDS TERMINATED BY '\t'
    LINES TERMINATED BY '\r\n'
    IGNORE 1 LINES
    (`id`,  `nev`,  `nem`,  @szuletett,  @elhunyt, @identitas)
    SET `elhunyt` = IF(@elhunyt = '', NULL, @elhunyt),
	`szuletett` = IF(@szuletett = '', NULL, @szuletett);
