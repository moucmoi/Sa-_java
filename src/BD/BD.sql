DROP TABLE IF EXISTS ATHLETE;
DROP TABLE IF EXISTS PAYS;
DROP TABLE IF EXISTS EQUIPE;
DROP TABLE IF EXISTS EPREUVE;
DROP TABLE IF EXISTS SPORT;
DROP TABLE IF EXISTS UTILISATEUR;
DROP TABLE IF EXISTS ROLES;

CREATE TABLE PAYS (
    PRIMARY KEY code_pays varchar(3),
    nom_pays varchar(15),
    nb_medaille_or int,
    nb_medaille_argent int,
    nb_medaille_bronze int
);



CREATE TABLE ATHLETE (
    PRIMARY KEY num_athlete int,
    nom varchar(25),
    prenom varchar(25),
    sexe varchar(1),
    forcee int,
    agilite int,
    endurance int,
    nom_equipe varchar(25),
    medaille_or int,
    medaille_argent int,
    medaille_bronze int
);

CREATE TABLE EPREUVE (
    PRIMARY KEY nom_epreuve varchar(35),
    homme boolean,
    individuel boolean,
    nom_sport varchar(20)
);

CREATE TABLE EQUIPE (
    PRIMARY KEY numero_equipe int,
    nom_equipe varchar(25),
    nom_pays varchar(25),
    medaille_or int,
    medaille_argent int,
    medaille_bronze int
);

CREATE TABLE SPORT (
    PRIMARY KEY nom_sport varchar(20),
    coeff_force float,
    coeff_agilite float,
    coeff_endurance float
);  

CREATE TABLE PARTICIPER (
    PRIMARY KEY nom_epreuve varchar(35),
    PRIMARY KEY num_athlete int
);

CREATE TABLE ROLES(
    PRIMARY KEY id_role int,
    nom_role varchar(20)
);

CREATE TABLE UTILISATEUR(
    PRIMARY KEY nom_utilisateur varchar(30),
    mdp varchar(30),
    id_role int
    
);

ALTER TABLE ATHLETE ADD FOREIGN KEY (nom_equipe) REFERENCES EQUIPE(nom_equipe);
ALTER TABLE EPREUVE ADD FOREIGN KEY (nom_sport) REFERENCES SPORT(nom_sport);
ALTER TABLE PARTICIPER ADD FOREIGN KEY (nom_epreuve) REFERENCES EPREUVE(nom_epreuve);
ALTER TABLE PARTICIPER ADD FOREIGN KEY (num_athlete) REFERENCES ATHLETE(num_athlete);
ALTER TABLE EQUIPE ADD FOREIGN KEY (nom_pays) REFERENCES PAYS(nom_pays);
ALTER TABLE UTILISATEUR ADD FOREIGN KEY (id_role) REFERENCES ROLE(id_role);


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
    ("Athlétisme")
);

INSERT INTO EPREUVE VALUES (
  ("Natation 100 brasse"),
  ("Natation relais libre"),
  ("Handball"),
  ("Volley-Ball"),
  ("Escrime fleuret"),
  ("Escrime épée"),
  ("Athlétisme 110 haies"),
  ("Athlétisme relais 400m")
);

INSERT INTO ROLES VALUES(
    (0,"Journaliste"),
    (1,"Organisateur"),
    (2,"Administrateur")
);

INSERT INTO UTILISATEUR VALUES(
    ("Rogez","mdp1",0),
    ("Meunier","mdp2",0),
    ("Grison","mdp3",1),
    ("Ouapiti","mdp4",1),
    ("Limet","mdp5",2),
    ("Dalaigre","mdp6",2)
);