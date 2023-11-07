\echo ---------- taula logrosJugador

CREATE TABLE logrosJugador (
	jugador TEXT REFERENCES usuario(nom_usuari)
		ON DELETE SET NULL
		ON UPDATE CASCADE,
	logro TEXT REFERENCES logro(nom),
	UNIQUE(jugador,logro)
);