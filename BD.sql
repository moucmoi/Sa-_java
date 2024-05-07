CREATE TABLE PAYS (
    PRIMARY KEY varchar(3) CodePays;
    varchar(15) NomPays;
    int nbMedailleOr;
    int nbMedailleArgent;
    int nbMedailleBronze;
);

CREATE TABLE ATHLETE (
    PRIMARY KEY varchar(15) NumAthlete;
    varchar(15) Nom;
    varchar(15) Prenom;
    varchar(1) Sexe;
    int Force;
    int Agilite;
    int endurance;
    varchar(15) NomSport;
    varchar(15) NomEquipe;
    varchar(3) CodePays;
);

CREATE TABLE EPREUVE (
    PRIMARY KEY varchar(15) NomEpreuve;
    boolean Homme;
    boolean Individuel;
    varchar(15) NomSport;
);

CREATE TABLE EQUIPE (
    PRIMARY KEY varchar(15) NomEquipe;
);

CREATE TABLE SPORT (
    PRIMARY KEY varchar(15) NomSport;
);

CREATE TABLE PARTICIPER (
    PRIMARY KEY varchar(15) NomEpreuve; 
    PRIMARY KEY varchar(15) NumAthlete;
);

ALTER TABLE ATHLETE ADD FOREIGN KEY (NomSport) REFERENCES SPORT(NomSport);
ALTER TABLE ATHLETE ADD FOREIGN KEY (NomEquipe) REFERENCES EQUIPE(NomEquipe);
ALTER TABLE ATHLETE ADD FOREIGN KEY (CodePays) REFERENCES PAYS(CodePays);
ALTER TABLE EPREUVE ADD FOREIGN KEY (NomSport) REFERENCES SPORT(NomSport);
ALTER TABLE PARTICIPER ADD FOREIGN KEY (NomEpreuve) REFERENCES EPREUVE(NomEpreuve);
ALTER TABLE PARTICIPER ADD FOREIGN KEY (NumAthlete) REFERENCES ATHLETE(NumAthlete);


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