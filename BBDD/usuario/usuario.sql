\echo ---------- taula usuario

CREATE TABLE usuario (
	nom_usuari TEXT PRIMARY KEY,
	contrasenya TEXT,
	correu TEXT,
	tipus TEXT CHECK (tipus IN ('jugador', 'admin', 	'superadmin'))
);