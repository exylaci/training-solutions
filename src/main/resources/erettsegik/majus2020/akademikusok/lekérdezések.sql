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

LOAD DATA LOCAL INFILE 'C:\\training\\training-solutions\\src\\main\\resources\\erettsegik\\majus2020\\akademikusok\\tag.txt'
	REPLACE INTO TABLE akademikusok.tag
	CHARACTER SET utf8
	FIELDS TERMINATED BY '\t'
	LINES TERMINATED BY '\r\n'
	IGNORE 1 LINES (id,nev,nem,@szuletett,@elhunyt,identitas) 
	SET szuletett= if(@szuletett='',NULL,@szuletett) ,
	    elhunyt= if(@elhunyt='',NULL,@elhunyt);

-- (2jelenleg)
SELECT nev FROM tag WHERE elhunyt='' ORDER BY nev;

-- (3mas)
SELECT nev, identitas, tipus, ev FROM tag
	JOIN tagsag ON tagid=tag.id
	WHERE identitas<>''
	ORDER BY ev,nev;

-- (4mikor)
SELECT nev, ev FROM tag
	JOIN tagsag ON tagid=tag.id
	GROUP BY tagid
	ORDER BY ev;

-- (5arany)
SELECT COUNT(id) / (SELECT COUNT(id) FROM tag) * 100
	FROM tag WHERE nem='n';

-- (6atlag)
SELECT avg(t.ev-e.ev) FROM tagsag AS e
	join tagsag AS t ON e.tagid=t.tagid
	WHERE e.tipus='l' AND t.tipus='r';

SELECT avg(r.ev-l.ev)
	FROM tagsag AS r, tagsag AS l
	WHERE r.tagid=l.tagid AND r.tipus='r' AND l.tipus='l';

-- (7teller)
SELECT nev, ev, elhunyt
	FROM tag, tagsag
	WHERE tag.id=tagid
		AND ev<=(SELECT ev FROM tagsag, tag WHERE tagsag.tagid=tag.id AND tag.nev='Teller Ede' AND tagsag.tipus='t')
		AND (elhunyt>=(SELECT elhunyt FROM tag WHERE tag.nev='Teller Ede')
		 OR elhunyt=0 )
		AND tipus='t';

-- (8rendes)
SELECT ev,
	nev,
	concat(
		szuletett,
		'-',
		case when elhunyt>0 then elhunyt END ) AS elt
	FROM tag, tagsag
	WHERE tag.id = tagid AND tipus='r' AND ev BETWEEN 1901 AND 2000
	ORDER BY ev, nev;
