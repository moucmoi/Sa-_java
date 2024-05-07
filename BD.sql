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
