\echo ---------- taula puntuacion

CREATE TABLE puntuacion (
	nom_usuari TEXT PRIMARY KEY,
	jugador TEXT REFERENCES usuario (nom_usuari)
		ON DELETE SET NULL
		ON UPDATE CASCADE
);