DROP TABLE IF EXISTS song_metadata CASCADE;

CREATE TABLE song_metadata (
	album VARCHAR(255),
	artist VARCHAR(255),
	duration VARCHAR(255),
	id VARCHAR(255) NOT NULL,
	name VARCHAR(255),
	year VARCHAR(255),
	PRIMARY KEY (id)
);