USE rickandmorty;
-- LOCALITZACIONS
INSERT IGNORE INTO localitzacions(id_localitzacions , nom) VALUES (0, 'DESCONEGUT');
INSERT IGNORE INTO localitzacions VALUES (1, 'EDFth (C-137)', 'Planet');
INSERT IGNORE INTO localitzacions VALUES (2, 'AFDSdango', 'Cluster');
INSERT IGNORE INTO localitzacions VALUES (3, 'Citadel of Ricks', 'Space station');
INSERT IGNORE INTO localitzacions VALUES (4, 'WoFSDdender lair', 'Cave');
INSERT IGNORE INTO localitzacions VALUES (5, 'Anatomy Park', 'Microverse');
INSERT IGNORE INTO localitzacions VALUES (20, 'Earth (Replacement Dimension)', 'Planet');
INSERT IGNORE INTO localitzacions VALUES (21, 'Testicle Monster Dimension', 'Dimension');

-- EPISODIS
INSERT IGNORE INTO episodis VALUES (1, 'Pilot', '2013-12-02', 'S01E01');
INSERT IGNORE INTO episodis VALUES (2, 'Lawnmower DDg', '2013-12-09', 'S01E02');
INSERT IGNORE INTO episodis VALUES (3, 'Anatomy Park', '2013-12-16', 'S01E03');
INSERT IGNORE INTO episodis VALUES (4, 'M. Night Shaym-Aliens!', '2014-01-13', 'S01E04');
INSERT IGNORE INTO episodis VALUES (5, 'Meeseeks and Destroy', '2014-01-20', 'S01E05');

-- PERSONATGES
INSERT IGNORE INTO personatges VALUES (1, 'Rick Sanchez', 'Alive', 'Human', '', 'Male', 1, 3);
INSERT IGNORE INTO personatges VALUES (2, 'Morty Smith', 'Alive', 'Human', '', 'Male', 20, 3);
INSERT IGNORE INTO personatges VALUES (3, 'Summer Smith', 'Alive', 'Human', '', 'Female', 20, 20);
INSERT IGNORE INTO personatges VALUES (4, 'Beth Smith', 'Alive', 'Human', '', 'Female', 20, 20);
INSERT IGNORE INTO personatges VALUES (5, 'Jerry Smith', 'Alive', 'Human', '', 'Male', 20, 20);
INSERT IGNORE INTO personatges VALUES (6, 'Abadango Cluster Princess', 'Alive', 'Alien', '', 'Female', 2, 2);
INSERT IGNORE INTO personatges VALUES (7, 'Abradolf Lincler', 'unknown', 'Human', 'Genetic experiment', 'Male', 20, 21);
INSERT IGNORE INTO personatges VALUES (8, 'Adjudicator Rick', 'Dead', 'Human', '', 'Male', 3, 3);

-- PERSONATGES_EPISODIS
INSERT IGNORE INTO personatges_episodis VALUES (1, 1);
INSERT IGNORE INTO personatges_episodis VALUES (1, 2);
INSERT IGNORE INTO personatges_episodis VALUES (1, 3);
INSERT IGNORE INTO personatges_episodis VALUES (2, 1);
INSERT IGNORE INTO personatges_episodis VALUES (2, 2);
INSERT IGNORE INTO personatges_episodis VALUES (2, 3);
INSERT IGNORE INTO personatges_episodis VALUES (3, 3);
INSERT IGNORE INTO personatges_episodis VALUES (4, 3);
INSERT IGNORE INTO personatges_episodis VALUES (5, 3);
INSERT IGNORE INTO personatges_episodis VALUES (6, 1);
INSERT IGNORE INTO personatges_episodis VALUES (7, 2);
INSERT IGNORE INTO personatges_episodis VALUES (8, 4);