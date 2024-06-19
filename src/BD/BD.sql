CREATE TABLE PAYS (
    PRIMARY KEY varchar(3) code_pays;
    varchar(15) nom_pays;
    int nb_medaille_or;
    int nb_medaille_argent;
    int nb_medaille_bronze;
);

CREATE TABLE ATHLETE (
    PRIMARY KEY varchar(15) num_athlete;
    varchar(15) nom;
    varchar(15) prenom;
    varchar(1) sexe;
    int force;
    int agilite;
    int endurance;
    varchar(15) nom_equipe;
    int medaille_or;
    int medaille_argent;
    int medaille_bronze;
);

CREATE TABLE EPREUVE (
    PRIMARY KEY varchar(15) nom_epreuve;
    boolean homme;
    boolean individuel;
    varchar(15) nom_sport;
);

CREATE TABLE EQUIPE (
    PRIMARY KEY varchar(15) numero_equipe;
    varchar(15) nom_equipe;
    varchar(15) nom_pays;
);

CREATE TABLE SPORT (
    PRIMARY KEY varchar(15) nom_sport;
    float coeff_force;
    float coeff_agilite;
    float coeff_endurance;
);  

CREATE TABLE PARTICIPER (
    PRIMARY KEY varchar(15) nom_epreuve; 
    PRIMARY KEY varchar(15) num_athlete;
);

ALTER TABLE ATHLETE ADD FOREIGN KEY (nom_equipe) REFERENCES EQUIPE(nom_equipe);
ALTER TABLE EPREUVE ADD FOREIGN KEY (nom_sport) REFERENCES SPORT(nom_sport);
ALTER TABLE PARTICIPER ADD FOREIGN KEY (nom_epreuve) REFERENCES EPREUVE(nom_epreuve);
ALTER TABLE PARTICIPER ADD FOREIGN KEY (num_athlete) REFERENCES ATHLETE(num_athlete);
ALTER TABLE EQUIPE ADD FOREIGN KEY (nom_pays) REFERENCES PAYS(nom_pays);



INSERT INTO PAYS VALUES (
    ("USA", "USA", 0, 0, 0),
    ("CHN", "Chine", 0, 0, 0),
    ("JPN", "Japon", 0, 0, 0),
    ("KEN", "Kenya", 0, 0, 0), 
    ("FRA", "France", 0, 0, 0),
    ("MAR", "Maroc", 0, 0, 0),
    ("DEU", "Allemagne", 0, 0, 0),
    ("AUS", "Australie", 0, 0, 0),
    ("BRA", "Brésil", 0, 0, 0),
    ("TUR", "Turquie", 0, 0, 0)
);

INSERT INTO SPORT VALUES (
    ("Natation"),
    ("Handball"),
    ("Volley-Ball"),
    ("Escrime"),
    ("Athlétisme"),
);

INSERT INTO EPREUVE VALUES (
  ("Natation 100 brasse"),
  ("Natation relais libre"),
  ("Handball"),
  ("Volley-Ball"),
  ("Escrime fleuret"),
  ("Escrime épée"),
  ("Athlétisme 110 haies"),
  ("Athlétisme relais 400m"),
);