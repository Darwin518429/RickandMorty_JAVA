DROP DATABASE IF EXISTS rickandmorty;
CREATE DATABASE IF NOT EXISTS rickandmorty;
USE rickandmorty;

CREATE TABLE localitzacions (
    id_localitzacions INT         ,
    nom               VARCHAR(45)  NOT NULL,
    tipus             VARCHAR(45),
    CONSTRAINT pk_localitzacions PRIMARY KEY(id_localitzacions)
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
