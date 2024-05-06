CREATE TABLE PAYS (
    PRIMARY KEY varchar(3) CodePays;
    varchar(15) NomPays;
    int nbMedailleOr;
    int nbMedailleArgent;
    int nbMedailleBronze;
);

CREATE TABLE Athlete (
    PRIMARY KEY varchar(15) Nom;
    PRIMARY KEY varchar(15) Prenom;
    varchar(1) Sexe;
    int Force;
    int Agilite;
    int endurance;
);

CREATE TABLE Epreuve (
    PRIMARY KEY varchar(15) NomEpreuve;
    boolean Homme;
    boolean Individuel;
);

CREATE TABLE Equipe (
    PRIMARY KEY varchar(15) NomEquipe;
);