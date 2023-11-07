\echo ---------- taula personaje

CREATE TABLE personaje (
	nom TEXT PRIMARY KEY,
	dany FLOAT,
	rang FLOAT,
	velocitat FLOAT,
	objeto TEXT REFERENCES objeto
		ON DELETE SET NULL
		ON UPDATE CASCADE
);