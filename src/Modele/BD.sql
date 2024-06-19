DROP TABLE IF EXISTS PARTICIPER;
DROP TABLE IF EXISTS EPREUVE;
DROP TABLE IF EXISTS SPORT;
DROP TABLE IF EXISTS ATHLETE;
DROP TABLE IF EXISTS EQUIPE;
DROP TABLE IF EXISTS PAYS;
DROP TABLE IF EXISTS UTILISATEUR;
DROP TABLE IF EXISTS ROLES;

CREATE TABLE PAYS (
    code_pays varchar(3),
    nom_pays varchar(15),
    nb_medaille_or int,
    nb_medaille_argent int,
    nb_medaille_bronze int,
    PRIMARY KEY(code_pays)
);

CREATE TABLE ATHLETE (
    num_athlete int,
    nom varchar(25),
    prenom varchar(25),
    sexe varchar(1),
    forcee int,
    agilite int,
    endurance int,
    numero_equipe int,
    medaille_or int,
    medaille_argent int,
    medaille_bronze int,
    PRIMARY KEY (num_athlete)
);

CREATE TABLE EPREUVE (
    nom_epreuve varchar(35),
    homme boolean,
    individuel boolean,
    nom_sport varchar(20),
    PRIMARY KEY (nom_epreuve)
);

CREATE TABLE EQUIPE (
    numero_equipe int,
    nom_equipe varchar(25),
    code_pays varchar(3),
    medaille_or int,
    medaille_argent int,
    medaille_bronze int,
    PRIMARY KEY (numero_equipe)
);

CREATE TABLE SPORT (
    nom_sport varchar(20),
    coeff_force float,
    coeff_agilite float,
    coeff_endurance float,
    PRIMARY KEY (nom_sport)
);  

CREATE TABLE PARTICIPER (
    nom_epreuve varchar(35),
    numero_equipe int,
    PRIMARY KEY (nom_epreuve, numero_equipe)
);

CREATE TABLE ROLES(
    id_role int,
    nom_role varchar(20),
    PRIMARY KEY (id_role)
);

CREATE TABLE UTILISATEUR(
    nom_utilisateur varchar(30),
    mdp varchar(30),
    id_role int,
    PRIMARY KEY (nom_utilisateur)
    
);

ALTER TABLE ATHLETE ADD FOREIGN KEY (numero_equipe) REFERENCES EQUIPE(numero_equipe);
ALTER TABLE EPREUVE ADD FOREIGN KEY (nom_sport) REFERENCES SPORT(nom_sport);
ALTER TABLE PARTICIPER ADD FOREIGN KEY (nom_epreuve) REFERENCES EPREUVE(nom_epreuve);
ALTER TABLE PARTICIPER ADD FOREIGN KEY (numero_equipe) REFERENCES ATHLETE(numero_equipe);
ALTER TABLE EQUIPE ADD FOREIGN KEY (code_pays) REFERENCES PAYS(code_pays);
ALTER TABLE UTILISATEUR ADD FOREIGN KEY (id_role) REFERENCES ROLES(id_role);


INSERT INTO PAYS VALUES
    ("USA", "USA", 0, 0, 0),
    ("CHN", "Chine", 0, 0, 0),
    ("JPN", "Japon", 0, 0, 0),
    ("KEN", "Kenya", 0, 0, 0), 
    ("FRA", "France", 0, 0, 0),
    ("MAR", "Maroc", 0, 0, 0),
    ("DEU", "Allemagne", 0, 0, 0),
    ("AUS", "Australie", 0, 0, 0),
    ("BRA", "Brésil", 0, 0, 0),
    ("TUR", "Turquie", 0, 0, 0);

INSERT INTO SPORT VALUES
    ("Natation",1,0.5,2.5),
    ("Handball",1,1.5,1.5),
    ("Volley-ball",1.5,1,1.5),
    ("Escrime",0.5,2.5,1),
    ("Athlétisme",0.5,1,2.5);

INSERT INTO EPREUVE VALUES
  ("Natation 100 brasse homme", TRUE, TRUE, "Natation"),
  ("Natation relais libre homme", TRUE, FALSE, "Natation"),
  ("Handball homme", TRUE, FALSE, "Handball"),
  ("Volley-Ball homme", TRUE, FALSE, "Volley-ball"),
  ("Escrime fleuret homme", TRUE, TRUE, "Escrime"),
  ("Escrime épée homme", TRUE, TRUE, "Escrime"),
  ("Athlétisme 110 haies homme", TRUE, TRUE, "Athlétisme"),
  ("Athlétisme relais 400m homme", TRUE, FALSE, "Athlétisme"),
  ("Natation 100 brasse femme", FALSE, TRUE, "Natation"),
  ("Natation relais libre femme", FALSE, FALSE, "Natation"),
  ("Handball femme", FALSE, FALSE, "Natation"),
  ("Volley-Ball femme", FALSE, FALSE, "Volley-ball"),
  ("Escrime fleuret femme", FALSE, TRUE, "Escrime"),
  ("Escrime épée femme", FALSE, TRUE, "Escrime"),
  ("Athlétisme 110 haies femme", FALSE, TRUE, "Athlétisme"),
  ("Athlétisme relais 400m femme", FALSE, FALSE, "Athlétisme");

INSERT INTO ROLES VALUES
    (0,"Journaliste"),
    (1,"Organisateur"),
    (2,"Administrateur");

INSERT INTO UTILISATEUR VALUES
    ("Rogez","mdp1",0),
    ("Meunier","mdp2",0),
    ("Grison","mdp3",1),
    ("Ouapiti","mdp4",1),
    ("Limet","mdp5",2),
    ("Dalaigre","mdp6",2);