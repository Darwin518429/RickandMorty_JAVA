DROP DATABASE IF EXISTS rickandmorty;
CREATE DATABASE IF NOT EXISTS rickandmorty;
USE rickandmorty;

CREATE TABLE localitzacions (
    id_localitzacions INT         ,
    nom               VARCHAR(45)  NOT NULL,
    tipus             VARCHAR(45),
    CONSTRAINT pk_localitzacions PRIMARY KEY(id_localitzacions)
);

CREATE TABLE episodis (
    id_episodis INT,
    name        VARCHAR(45)  NOT NULL,
    data        DATE,
    episodi     VARCHAR(45),
    CONSTRAINT pk_episodis PRIMARY KEY(id_episodis)
);

CREATE TABLE personatges (
    id_personatge INT          PRIMARY KEY,
    nom           VARCHAR(100) NOT NULL,
    status        CHAR(15),
    especies      VARCHAR(25),
    tipus         VARCHAR(45),
    genere        VARCHAR(45),
    origen        INT,
    localitzacio  INT 
  ,CONSTRAINT fk_personatges_localitzacions_origen  FOREIGN KEY (origen)       REFERENCES localitzacions(id_localitzacions),
   CONSTRAINT fk_persontages_localitzacions_localitzacio FOREIGN KEY (localitzacio) REFERENCES localitzacions(id_localitzacions)
);
-- TRUNCATE TABLE personatges_episodis;

CREATE TABLE personatges_episodis (
    personatges_id_personatge INT NOT NULL,
    episodis_id_episodis      INT NOT NULL,
	CONSTRAINT  personatges_episodis PRIMARY KEY (personatges_id_personatge, episodis_id_episodis),
	CONSTRAINT	fk_personatges_personatges_episodis  FOREIGN KEY (personatges_id_personatge) REFERENCES personatges(id_personatge) ON DELETE CASCADE ON UPDATE CASCADE ,
    CONSTRAINT 	fk_episodis_personatges_episodis FOREIGN KEY (episodis_id_episodis) REFERENCES episodis(id_episodis) ON DELETE CASCADE ON UPDATE CASCADE 
);