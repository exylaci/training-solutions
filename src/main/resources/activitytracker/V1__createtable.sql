-- DROP DATABASE IF EXISTS `activity_tracker`;
-- CREATE DATABASE if NOT EXISTS activity_tracker DEFAULT CHARACTER SET UTF8 COLLATE UTF8_HUNGARIAN_CI;
-- USE activity_tracker;

DROP TABLE IF EXISTS activity;
CREATE TABLE activity (
    id INT PRIMARY KEY AUTO_INCREMENT,
    start_time TIMESTAMP,
    description VARCHAR(255),
    activity_type VARCHAR(10));

DROP TABLE IF EXISTS track_point;
CREATE TABLE track_point (
  	id INT PRIMARY KEY AUTO_INCREMENT,
  	register_time DATE,
   	lat DOUBLE,
   	lon DOUBLE,
   	activity_id INT,
   	FOREIGN  KEY (activity_id) REFERENCES activity(id));