USE graduate_project;

DROP TABLE IF EXISTS cities;

CREATE TABLE cities (
	zip CHAR(4) NOT NULL,
	city VARCHAR(50) NOT NULL);

CREATE TABLE citizens (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	citizen_name VARCHAR(100) NOT NULL,
	zip CHAR(4) NOT NULL,
	age TINYINT UNSIGNED NOT NULL,
	email VARCHAR(100) NOT NULL,
	taj CHAR(9) UNIQUE NOT NULL ,
	number_of_vaccinations TINYINT UNSIGNED DEFAULT 0,
	last_vacciantion DATE);

CREATE TABLE vaccination(
	id INT NOT NULL,
	FOREIGN KEY (id) REFERENCES citizens(id),
	vaccination_date DATE,
	vaccine VARCHAR(20),
	result VARCHAR(10),
	note VARCHAR(200));

INSERT INTO `cities` (`zip`, `city`) VALUES ('2021', 'Tahitótfalu, Tótfalu');
INSERT INTO `cities` (`zip`, `city`) VALUES ('2022', 'Tahitótfalu, Tahi');
INSERT INTO `cities` (`zip`, `city`) VALUES ('2023', 'Dunabogdány');
INSERT INTO `cities` (`zip`, `city`) VALUES ('2024', 'Kisoroszi');
INSERT INTO `cities` (`zip`, `city`) VALUES ('2025', 'Visegrád');
INSERT INTO `cities` (`zip`, `city`) VALUES ('2026', 'Visegrád, Gizellatel');
INSERT INTO `cities` (`zip`, `city`) VALUES ('2027', 'Dömös');
INSERT INTO `cities` (`zip`, `city`) VALUES ('2028', 'Pilismarót');
INSERT INTO `cities` (`zip`, `city`) VALUES ('2030', 'Érd');
INSERT INTO `cities` (`zip`, `city`) VALUES ('2038', 'Sóskút');
INSERT INTO `cities` (`zip`, `city`) VALUES ('2066', 'Szár');
INSERT INTO `cities` (`zip`, `city`) VALUES ('2066', 'Újbarok');
INSERT INTO `cities` (`zip`, `city`) VALUES ('4128', 'Bedő');
