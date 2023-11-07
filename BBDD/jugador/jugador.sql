\echo ---------- taula jugador

CREATE TABLE jugador (
	nom text REFERENCES usuario (nom_usuari),
	data_registre DATE,
	ultim_registre DATE,
	hores_jugades FLOAT,
	num_logros INT
);