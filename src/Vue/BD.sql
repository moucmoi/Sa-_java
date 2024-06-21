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
  ("Volley-ball homme", TRUE, FALSE, "Volley-ball"),
  ("Escrime fleuret homme", TRUE, TRUE, "Escrime"),
  ("Escrime épée homme", TRUE, TRUE, "Escrime"),
  ("Athlétisme 110 haies homme", TRUE, TRUE, "Athlétisme"),
  ("Athlétisme relais 400m homme", TRUE, FALSE, "Athlétisme"),
  ("Natation 100 brasse femme", FALSE, TRUE, "Natation"),
  ("Natation relais libre femme", FALSE, FALSE, "Natation"),
  ("Handball femme", FALSE, FALSE, "Natation"),
  ("Volley-ball femme", FALSE, FALSE, "Volley-ball"),
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

INSERT INTO EQUIPE VALUES
(1,"France_Escrime épée_H_S1", "FRA", 0, 0, 0),
(2,"Chine_Natation relais libre_H", "CHN", 0, 0, 0),
(3,"Kenya_Volley-Ball_H", "KEN", 0, 0, 0),
(4,"Turquie_Escrime épée_F_S2", "TUR", 0, 0, 0),
(5,"Brésil_Volley-Ball_F", "BRA", 0, 0, 0),
(6,"USA_Natation relais libre_F", "USA", 0, 0, 0),
(7,"Turquie_Escrime épée_F_S3", "TUR", 0, 0, 0),
(8,"USA_Volley-Ball_F", "USA", 0, 0, 0),
(9,"Turquie_Volley-Ball_H", "TUR", 0, 0, 0),
(10,"Turquie_Natation 100 brasse_F_S4", "TUR", 0, 0, 0),
(11,"Australie_Natation relais libre_H", "AUS", 0, 0, 0),
(12,"Kenya_Athlétisme relais 400m_H", "KEN", 0, 0, 0),
(13,"Maroc_Natation 100 brasse_H_S5", "MAR", 0, 0, 0),
(14,"Chine_Volley-Ball_H", "CHN", 0, 0, 0),
(15,"France_Volley-Ball_F", "FRA", 0, 0, 0),
(16,"Chine_Natation 100 brasse_H_S6", "CHN", 0, 0, 0),
(17,"Chine_Handball_H", "CHN", 0, 0, 0),
(18,"Kenya_Athlétisme relais 400m_F", "KEN", 0, 0, 0),
(19,"USA_Natation relais libre_H", "USA", 0, 0, 0),
(20,"Japon_Handball_H", "JPN", 0, 0, 0),
(21,"Japon_Athlétisme relais 400m_F", "JPN", 0, 0, 0),
(22,"Chine_Athlétisme relais 400m_H", "CHN", 0, 0, 0),
(23,"Maroc_Natation relais libre_H", "MAR", 0, 0, 0),
(24,"Australie_Handball_F", "AUS", 0, 0, 0),
(25,"Chine_Escrime fleuret_H_S7", "CHN", 0, 0, 0),
(26,"Maroc_Escrime épée_H_S8", "MAR", 0, 0, 0),
(27,"Turquie_Natation 100 brasse_H_S9", "TUR", 0, 0, 0),
(28,"France_Escrime épée_H_S10", "FRA", 0, 0, 0),
(29,"USA_Handball_H", "USA", 0, 0, 0),
(30,"Kenya_Natation 100 brasse_H_S11", "KEN", 0, 0, 0),
(31,"Allemagne_Handball_F", "DEU", 0, 0, 0),
(32,"Japon_Natation 100 brasse_F_S12", "JPN", 0, 0, 0),
(33,"USA_Natation 100 brasse_F_S13", "USA", 0, 0, 0),
(34,"Allemagne_Natation 100 brasse_F_S14", "DEU", 0, 0, 0),
(35,"France_Escrime fleuret_F_S15", "FRA", 0, 0, 0),
(36,"Chine_Volley-Ball_F", "CHN", 0, 0, 0),
(37,"Brésil_Escrime épée_F_S16", "BRA", 0, 0, 0),
(38,"Australie_Escrime fleuret_H_S17", "AUS", 0, 0, 0),
(39,"Maroc_Volley-Ball_F", "MAR", 0, 0, 0),
(40,"USA_Natation 100 brasse_H_S18", "USA", 0, 0, 0),
(41,"Chine_Escrime épée_F_S19", "CHN", 0, 0, 0),
(42,"Maroc_Handball_F", "MAR", 0, 0, 0),
(43,"Kenya_Escrime fleuret_H_S20", "KEN", 0, 0, 0),
(44,"Australie_Athlétisme relais 400m_F", "AUS", 0, 0, 0),
(45,"Turquie_Athlétisme relais 400m_H", "TUR", 0, 0, 0),
(46,"Japon_Athlétisme relais 400m_H", "JPN", 0, 0, 0),
(47,"Allemagne_Volley-Ball_H", "DEU", 0, 0, 0),
(48,"USA_Athlétisme relais 400m_F", "USA", 0, 0, 0),
(49,"Maroc_Natation 100 brasse_H_S21", "MAR", 0, 0, 0),
(50,"Brésil_Natation relais libre_F", "BRA", 0, 0, 0),
(51,"Turquie_Escrime fleuret_F_S22", "TUR", 0, 0, 0),
(52,"Brésil_Natation 100 brasse_H_S23", "BRA", 0, 0, 0),
(53,"Japon_Escrime épée_F_S24", "JPN", 0, 0, 0),
(54,"Kenya_Natation 100 brasse_H_S25", "KEN", 0, 0, 0),
(55,"Allemagne_Escrime fleuret_H_S26", "DEU", 0, 0, 0),
(56,"France_Escrime épée_H_S27", "FRA", 0, 0, 0),
(57,"Brésil_Natation 100 brasse_H_S28", "BRA", 0, 0, 0),
(58,"Australie_Volley-Ball_F", "AUS", 0, 0, 0),
(59,"Kenya_Natation relais libre_F", "KEN", 0, 0, 0),
(60,"Kenya_Natation relais libre_H", "KEN", 0, 0, 0),
(61,"Allemagne_Natation relais libre_F", "DEU", 0, 0, 0),
(62,"Allemagne_Escrime épée_F_S29", "DEU", 0, 0, 0),
(63,"Brésil_Escrime épée_H_S30", "BRA", 0, 0, 0),
(64,"France_Natation 100 brasse_H_S31", "FRA", 0, 0, 0),
(65,"Japon_Natation 100 brasse_H_S32", "JPN", 0, 0, 0),
(66,"Japon_Escrime fleuret_F_S33", "JPN", 0, 0, 0),
(67,"Brésil_Escrime épée_H_S34", "BRA", 0, 0, 0),
(68,"Allemagne_Escrime fleuret_F_S35", "DEU", 0, 0, 0),
(69,"Chine_Escrime épée_H_S36", "CHN", 0, 0, 0),
(70,"Chine_Escrime épée_H_S37", "CHN", 0, 0, 0),
(71,"France_Natation relais libre_F", "FRA", 0, 0, 0),
(72,"USA_Athlétisme relais 400m_H", "USA", 0, 0, 0),
(73,"France_Escrime fleuret_F_S38", "FRA", 0, 0, 0),
(74,"Kenya_Escrime épée_H_S39", "KEN", 0, 0, 0),
(75,"Japon_Escrime épée_H_S40", "JPN", 0, 0, 0),
(76,"Australie_Natation 100 brasse_F_S41", "AUS", 0, 0, 0),
(77,"Brésil_Escrime fleuret_F_S42", "BRA", 0, 0, 0),
(78,"Kenya_Escrime fleuret_F_S43", "KEN", 0, 0, 0),
(79,"Australie_Athlétisme relais 400m_H", "AUS", 0, 0, 0),
(80,"Brésil_Natation relais libre_H", "BRA", 0, 0, 0),
(81,"Turquie_Natation relais libre_H", "TUR", 0, 0, 0),
(82,"Turquie_Escrime fleuret_F_S44", "TUR", 0, 0, 0),
(83,"USA_Volley-Ball_H", "USA", 0, 0, 0),
(84,"Kenya_Volley-Ball_F", "KEN", 0, 0, 0),
(85,"Brésil_Athlétisme relais 400m_H", "BRA", 0, 0, 0),
(86,"Turquie_Escrime épée_H_S45", "TUR", 0, 0, 0),
(87,"Allemagne_Natation 100 brasse_H_S46", "DEU", 0, 0, 0),
(88,"Brésil_Handball_F", "BRA", 0, 0, 0),
(89,"Japon_Escrime épée_H_S47", "JPN", 0, 0, 0),
(90,"Japon_Escrime fleuret_H_S48", "JPN", 0, 0, 0),
(91,"Chine_Escrime fleuret_H_S49", "CHN", 0, 0, 0),
(92,"Allemagne_Escrime épée_H_S50", "DEU", 0, 0, 0),
(93,"Allemagne_Athlétisme relais 400m_H", "DEU", 0, 0, 0),
(94,"USA_Escrime fleuret_H_S51", "USA", 0, 0, 0),
(95,"Australie_Natation 100 brasse_F_S52", "AUS", 0, 0, 0),
(96,"Turquie_Escrime fleuret_F_S53", "TUR", 0, 0, 0),
(97,"Japon_Handball_F", "JPN", 0, 0, 0),
(98,"Kenya_Escrime épée_H_S54", "KEN", 0, 0, 0),
(99,"France_Volley-Ball_H", "FRA", 0, 0, 0),
(100,"Australie_Natation 100 brasse_H_S55", "AUS", 0, 0, 0),
(101,"Kenya_Natation 100 brasse_F_S56", "KEN", 0, 0, 0),
(102,"USA_Natation 100 brasse_F_S57", "USA", 0, 0, 0),
(103,"USA_Escrime fleuret_F_S58", "USA", 0, 0, 0),
(104,"Allemagne_Volley-Ball_F", "DEU", 0, 0, 0),
(105,"USA_Handball_F", "USA", 0, 0, 0),
(106,"Australie_Natation relais libre_F", "AUS", 0, 0, 0),
(107,"Chine_Natation 100 brasse_H_S59", "CHN", 0, 0, 0),
(108,"Australie_Escrime épée_F_S60", "AUS", 0, 0, 0),
(109,"Chine_Escrime fleuret_F_S61", "CHN", 0, 0, 0),
(110,"Allemagne_Escrime fleuret_F_S62", "DEU", 0, 0, 0),
(111,"Japon_Natation relais libre_H", "JPN", 0, 0, 0),
(112,"Kenya_Escrime fleuret_H_S63", "KEN", 0, 0, 0),
(113,"Turquie_Escrime épée_H_S64", "TUR", 0, 0, 0),
(114,"Brésil_Athlétisme relais 400m_F", "BRA", 0, 0, 0),
(115,"Japon_Natation relais libre_F", "JPN", 0, 0, 0),
(116,"France_Athlétisme relais 400m_F", "FRA", 0, 0, 0),
(117,"Chine_Athlétisme relais 400m_F", "CHN", 0, 0, 0),
(118,"Maroc_Volley-Ball_H", "MAR", 0, 0, 0),
(119,"Maroc_Escrime épée_F_S65", "MAR", 0, 0, 0),
(120,"Australie_Escrime fleuret_F_S66", "AUS", 0, 0, 0),
(121,"Allemagne_Natation relais libre_H", "DEU", 0, 0, 0),
(122,"Australie_Escrime épée_F_S67", "AUS", 0, 0, 0),
(123,"Allemagne_Natation 100 brasse_H_S68", "DEU", 0, 0, 0),
(124,"France_Escrime épée_F_S69", "FRA", 0, 0, 0),
(125,"USA_Escrime fleuret_H_S70", "USA", 0, 0, 0),
(126,"Australie_Escrime fleuret_H_S71", "AUS", 0, 0, 0),
(127,"Turquie_Escrime fleuret_F_S72", "TUR", 0, 0, 0),
(128,"Maroc_Natation 100 brasse_H_S73", "MAR", 0, 0, 0),
(129,"Allemagne_Natation 100 brasse_H_S74", "DEU", 0, 0, 0),
(130,"USA_Escrime épée_F_S75", "USA", 0, 0, 0),
(131,"Japon_Escrime fleuret_H_S76", "JPN", 0, 0, 0),
(132,"USA_Natation 100 brasse_F_S77", "USA", 0, 0, 0),
(133,"France_Escrime fleuret_H_S78", "FRA", 0, 0, 0),
(134,"Japon_Natation 100 brasse_F_S79", "JPN", 0, 0, 0),
(135,"Kenya_Escrime épée_H_S80", "KEN", 0, 0, 0),
(136,"Allemagne_Escrime épée_H_S81", "DEU", 0, 0, 0),
(137,"Chine_Natation 100 brasse_H_S82", "CHN", 0, 0, 0),
(138,"USA_Natation 100 brasse_F_S83", "USA", 0, 0, 0),
(139,"USA_Natation 100 brasse_H_S84", "USA", 0, 0, 0),
(140,"USA_Escrime fleuret_F_S85", "USA", 0, 0, 0),
(141,"Turquie_Escrime épée_H_S86", "TUR", 0, 0, 0),
(142,"USA_Escrime épée_F_S87", "USA", 0, 0, 0),
(143,"Maroc_Escrime épée_F_S88", "MAR", 0, 0, 0),
(144,"Maroc_Escrime épée_F_S89", "MAR", 0, 0, 0),
(145,"Chine_Escrime fleuret_F_S90", "CHN", 0, 0, 0),
(146,"Australie_Escrime épée_F_S91", "AUS", 0, 0, 0),
(147,"Japon_Escrime épée_H_S92", "JPN", 0, 0, 0),
(148,"Allemagne_Escrime épée_F_S93", "DEU", 0, 0, 0),
(149,"Japon_Escrime épée_H_S94", "JPN", 0, 0, 0),
(150,"Brésil_Natation 100 brasse_H_S95", "BRA", 0, 0, 0),
(151,"Allemagne_Escrime épée_F_S96", "DEU", 0, 0, 0),
(152,"Maroc_Escrime fleuret_F_S97", "MAR", 0, 0, 0),
(153,"Japon_Natation 100 brasse_H_S98", "JPN", 0, 0, 0),
(154,"Australie_Volley-Ball_H", "AUS", 0, 0, 0),
(155,"Maroc_Escrime fleuret_H_S99", "MAR", 0, 0, 0),
(156,"Japon_Escrime épée_H_S100", "JPN", 0, 0, 0),
(157,"France_Escrime fleuret_F_S101", "FRA", 0, 0, 0),
(158,"France_Athlétisme relais 400m_H", "FRA", 0, 0, 0),
(159,"Kenya_Natation 100 brasse_F_S102", "KEN", 0, 0, 0),
(160,"Allemagne_Escrime épée_H_S103", "DEU", 0, 0, 0),
(161,"Maroc_Handball_H", "MAR", 0, 0, 0),
(162,"Chine_Natation 100 brasse_H_S104", "CHN", 0, 0, 0),
(163,"Allemagne_Natation 100 brasse_F_S105", "DEU", 0, 0, 0),
(164,"Brésil_Escrime fleuret_F_S106", "BRA", 0, 0, 0),
(165,"Allemagne_Escrime fleuret_F_S107", "DEU", 0, 0, 0),
(166,"Allemagne_Escrime épée_H_S108", "DEU", 0, 0, 0),
(167,"Maroc_Athlétisme relais 400m_F", "MAR", 0, 0, 0),
(168,"Maroc_Escrime fleuret_F_S109", "MAR", 0, 0, 0),
(169,"France_Escrime épée_F_S110", "FRA", 0, 0, 0),
(170,"France_Handball_F", "FRA", 0, 0, 0),
(171,"France_Natation 100 brasse_F_S111", "FRA", 0, 0, 0),
(172,"Maroc_Natation 100 brasse_F_S112", "MAR", 0, 0, 0),
(173,"Allemagne_Escrime épée_H_S113", "DEU", 0, 0, 0),
(174,"Chine_Handball_F", "CHN", 0, 0, 0),
(175,"Maroc_Athlétisme relais 400m_H", "MAR", 0, 0, 0),
(176,"USA_Escrime épée_H_S114", "USA", 0, 0, 0),
(177,"Chine_Escrime fleuret_H_S115", "CHN", 0, 0, 0),
(178,"Chine_Escrime fleuret_H_S116", "CHN", 0, 0, 0),
(179,"Turquie_Escrime épée_H_S117", "TUR", 0, 0, 0),
(180,"Australie_Escrime fleuret_H_S118", "AUS", 0, 0, 0),
(181,"Kenya_Escrime fleuret_H_S119", "KEN", 0, 0, 0),
(182,"Australie_Natation 100 brasse_F_S120", "AUS", 0, 0, 0),
(183,"Kenya_Escrime fleuret_F_S121", "KEN", 0, 0, 0),
(184,"France_Natation relais libre_H", "FRA", 0, 0, 0),
(185,"Australie_Escrime fleuret_F_S122", "AUS", 0, 0, 0),
(186,"Chine_Escrime fleuret_H_S123", "CHN", 0, 0, 0),
(187,"Chine_Natation 100 brasse_H_S124", "CHN", 0, 0, 0),
(188,"Turquie_Escrime épée_F_S125", "TUR", 0, 0, 0),
(189,"Turquie_Handball_H", "TUR", 0, 0, 0),
(190,"Chine_Escrime épée_H_S126", "CHN", 0, 0, 0),
(191,"Brésil_Escrime épée_F_S127", "BRA", 0, 0, 0),
(192,"Australie_Escrime épée_F_S128", "AUS", 0, 0, 0),
(193,"Turquie_Athlétisme relais 400m_F", "TUR", 0, 0, 0),
(194,"Brésil_Escrime fleuret_H_S129", "BRA", 0, 0, 0),
(195,"Brésil_Volley-Ball_H", "BRA", 0, 0, 0),
(196,"Allemagne_Handball_H", "DEU", 0, 0, 0),
(197,"Allemagne_Escrime épée_H_S130", "DEU", 0, 0, 0),
(198,"France_Escrime épée_F_S131", "FRA", 0, 0, 0),
(199,"Allemagne_Escrime fleuret_F_S132", "DEU", 0, 0, 0),
(200,"France_Escrime épée_H_S133", "FRA", 0, 0, 0),
(201,"Turquie_Natation relais libre_F", "TUR", 0, 0, 0),
(202,"Japon_Volley-Ball_H", "JPN", 0, 0, 0),
(203,"USA_Escrime épée_F_S134", "USA", 0, 0, 0),
(204,"Turquie_Escrime épée_F_S135", "TUR", 0, 0, 0),
(205,"Maroc_Natation 100 brasse_H_S136", "MAR", 0, 0, 0),
(206,"France_Escrime épée_F_S137", "FRA", 0, 0, 0),
(207,"Kenya_Escrime fleuret_H_S138", "KEN", 0, 0, 0),
(208,"Chine_Escrime épée_F_S139", "CHN", 0, 0, 0),
(209,"France_Escrime fleuret_H_S140", "FRA", 0, 0, 0),
(210,"Chine_Natation 100 brasse_H_S141", "CHN", 0, 0, 0),
(211,"Kenya_Natation 100 brasse_F_S142", "KEN", 0, 0, 0),
(212,"Brésil_Escrime épée_H_S143", "BRA", 0, 0, 0),
(213,"Brésil_Escrime fleuret_F_S144", "BRA", 0, 0, 0),
(214,"Chine_Escrime épée_H_S145", "CHN", 0, 0, 0),
(215,"Turquie_Natation 100 brasse_F_S146", "TUR", 0, 0, 0),
(216,"Brésil_Natation 100 brasse_H_S147", "BRA", 0, 0, 0),
(217,"USA_Natation 100 brasse_H_S148", "USA", 0, 0, 0),
(218,"Chine_Natation relais libre_F", "CHN", 0, 0, 0),
(219,"Japon_Natation 100 brasse_H_S149", "JPN", 0, 0, 0),
(220,"Allemagne_Natation 100 brasse_F_S150", "DEU", 0, 0, 0),
(221,"Allemagne_Natation 100 brasse_H_S151", "DEU", 0, 0, 0),
(222,"Allemagne_Escrime épée_H_S152", "DEU", 0, 0, 0),
(223,"Turquie_Escrime épée_H_S153", "TUR", 0, 0, 0),
(224,"Kenya_Escrime épée_H_S154", "KEN", 0, 0, 0),
(225,"Chine_Escrime épée_H_S155", "CHN", 0, 0, 0),
(226,"Australie_Natation 100 brasse_F_S156", "AUS", 0, 0, 0),
(227,"France_Natation 100 brasse_F_S157", "FRA", 0, 0, 0),
(228,"Kenya_Escrime épée_F_S158", "KEN", 0, 0, 0),
(229,"Australie_Escrime fleuret_H_S159", "AUS", 0, 0, 0),
(230,"Turquie_Natation 100 brasse_F_S160", "TUR", 0, 0, 0),
(231,"Australie_Escrime épée_F_S161", "AUS", 0, 0, 0),
(232,"Kenya_Escrime épée_F_S162", "KEN", 0, 0, 0),
(233,"Brésil_Escrime fleuret_F_S163", "BRA", 0, 0, 0),
(234,"Kenya_Handball_F", "KEN", 0, 0, 0),
(235,"Kenya_Escrime fleuret_H_S164", "KEN", 0, 0, 0),
(236,"France_Escrime fleuret_H_S165", "FRA", 0, 0, 0),
(237,"Brésil_Natation 100 brasse_H_S166", "BRA", 0, 0, 0);

INSERT INTO ATHLETE VALUES
(1,"Guo","Ling","H",14,1
,14,1, 0, 0, 0),
(2,"Fontaine","Alice","H",20,19
,13,2, 0, 0, 0),
(3,"Blanc","Camille","H",6,18
,1,3, 0, 0, 0),
(4,"Perez","Emma","F",20,15
,4,4, 0, 0, 0),
(5,"Li","Zhao","F",8,18
,16,5, 0, 0, 0),
(6,"Huang","Hui","F",20,15
,3,6, 0, 0, 0),
(7,"Hoffmann","Tim","F",7,16
,4,7, 0, 0, 0),
(8,"Huang","Zhang","F",5,3
,12,8, 0, 0, 0),
(9,"Yamamoto","Ryota","H",8,16
,7,9, 0, 0, 0),
(10,"Garcia","Léa","F",18,9
,15,10, 0, 0, 0),
(11,"Inoue","Saki","H",16,6
,17,11, 0, 0, 0),
(12,"Faure","Gabin","H",15,4
,1,12, 0, 0, 0),
(13,"Barbier","Juliette","H",18,15
,1,13, 0, 0, 0),
(14,"Fujita","Shiori","H",10,13
,11,14, 0, 0, 0),
(15,"Matsumoto","Daiki","F",15,10
,11,15, 0, 0, 0),
(16,"Laurent","Alice","H",9,14
,14,16, 0, 0, 0),
(17,"Zhao","Xiang","H",1,3
,13,17, 0, 0, 0),
(18,"Sakamoto","Yuna","F",2,11
,8,18, 0, 0, 0),
(19,"Sato","Aoi","H",5,16
,6,19, 0, 0, 0),
(20,"Sakai","Yuki","H",4,16
,5,20, 0, 0, 0),
(21,"Wagner","Ben","F",6,6
,10,21, 0, 0, 0),
(22,"Zhu","Jun","H",20,6
,19,22, 0, 0, 0),
(23,"Gao","Zhu","H",8,9
,13,23, 0, 0, 0),
(24,"Hasegawa","Shiori","F",5,3
,17,24, 0, 0, 0),
(25,"Leroy","Arthur","H",12,12
,4,25, 0, 0, 0),
(26,"Durand","Juliette","H",12,12
,16,26, 0, 0, 0),
(27,"Braun","Luca","H",16,13
,13,27, 0, 0, 0),
(28,"Saito","Riko","H",15,15
,11,28, 0, 0, 0),
(29,"Zhang","Chen","H",18,20
,20,29, 0, 0, 0),
(30,"Hasegawa","Takumi","H",6,8
,7,30, 0, 0, 0),
(31,"Yang","Hu","F",6,18
,17,31, 0, 0, 0),
(32,"Schröder","Luisa","F",5,6
,19,32, 0, 0, 0),
(33,"Sakai","Hana","F",1,6
,4,33, 0, 0, 0),
(34,"Xu","Li","F",6,8
,9,34, 0, 0, 0),
(35,"Lehmann","Emily","H",18,16
,14,11, 0, 0, 0),
(36,"Faure","Lola","F",8,12
,7,21, 0, 0, 0),
(37,"Takahashi","Akira","F",7,5
,18,35, 0, 0, 0),
(38,"Gao","Chen","F",6,3
,6,36, 0, 0, 0),
(39,"Sun","Xiang","F",5,7
,18,37, 0, 0, 0),
(40,"Zhang","Wang","H",20,1
,16,38, 0, 0, 0),
(41,"Inoue","Kazuki","F",15,2
,6,39, 0, 0, 0),
(42,"Wu","Ling","H",11,2
,20,40, 0, 0, 0),
(43,"Huang","Lan","F",4,14
,12,41, 0, 0, 0),
(44,"Bauer","Anna","F",13,8
,18,42, 0, 0, 0),
(45,"Kobayashi","Riku","H",15,7
,5,43, 0, 0, 0),
(46,"Hu","Ma","F",10,7
,7,44, 0, 0, 0),
(47,"Petit","Raphaël","H",18,9
,16,45, 0, 0, 0),
(48,"Muller","Léa","H",9,7
,10,46, 0, 0, 0),
(49,"Blanc","Gabin","H",1,15
,4,47, 0, 0, 0),
(50,"Weber","Maja","F",16,19
,10,48, 0, 0, 0),
(51,"Yoshida","Yuki","H",3,12
,16,49, 0, 0, 0),
(52,"Zhu","Shuang","F",17,7
,16,50, 0, 0, 0),
(53,"Mercier","Noé","F",7,10
,18,5, 0, 0, 0),
(54,"Kimura","Kazuki","F",16,16
,6,51, 0, 0, 0),
(55,"Garcia","Tom","H",12,15
,12,52, 0, 0, 0),
(56,"Fujita","Mio","F",15,13
,17,53, 0, 0, 0),
(57,"Zhou","Shuang","H",4,20
,20,54, 0, 0, 0),
(58,"Morel","Nolan","H",18,6
,6,55, 0, 0, 0),
(59,"Kato","Takeshi","H",18,6
,14,56, 0, 0, 0),
(60,"Guerin","Juliette","F",6,7
,2,5, 0, 0, 0),
(61,"Watanabe","Aoi","H",3,8
,18,57, 0, 0, 0),
(62,"Mori","Ryota","F",5,18
,2,58, 0, 0, 0),
(63,"Lambert","Léna","F",19,15
,12,59, 0, 0, 0),
(64,"Yang","Li","H",5,8
,10,60, 0, 0, 0),
(65,"Yang","Yan","F",5,2
,4,61, 0, 0, 0),
(66,"Morel","Zoé","F",6,2
,8,62, 0, 0, 0),
(67,"Xu","Liu","H",20,2
,7,63, 0, 0, 0),
(68,"Matsumoto","Kokoro","H",11,13
,17,64, 0, 0, 0),
(69,"Muller","Louise","F",14,17
,9,59, 0, 0, 0),
(70,"Zhao","Chen","H",2,13
,17,65, 0, 0, 0),
(71,"Wang","Yan","F",8,4
,12,66, 0, 0, 0),
(72,"Dubois","Ethan","F",1,10
,19,5, 0, 0, 0),
(73,"Zhou","Zhu","H",9,16
,16,67, 0, 0, 0),
(74,"Zhang","Sun","F",14,9
,11,68, 0, 0, 0),
(75,"Saito","Sakura","H",20,2
,9,47, 0, 0, 0),
(76,"Moreau","Théo","H",15,9
,3,69, 0, 0, 0),
(77,"Roux","Hugo","H",8,14
,9,70, 0, 0, 0),
(78,"Murakami","Riku","F",12,5
,18,50, 0, 0, 0),
(79,"Schulze","Leon","F",7,19
,1,36, 0, 0, 0),
(80,"Richard","Paul","F",13,17
,15,71, 0, 0, 0),
(81,"Guerin","Clara","H",14,9
,18,72, 0, 0, 0),
(82,"Zhu","Li","F",5,7
,6,73, 0, 0, 0),
(83,"Watanabe","Takeshi","H",10,14
,2,74, 0, 0, 0),
(84,"Bernard","Jules","H",11,17
,20,12, 0, 0, 0),
(85,"He","Qian","H",8,14
,3,75, 0, 0, 0),
(86,"Petit","Lola","H",5,7
,4,3, 0, 0, 0),
(87,"Zhao","Shuang","F",3,5
,18,76, 0, 0, 0),
(88,"Zhou","Wei","F",8,4
,16,77, 0, 0, 0),
(89,"Krüger","Ben","F",6,7
,1,78, 0, 0, 0),
(90,"Morel","Manon","H",13,4
,2,79, 0, 0, 0),
(91,"Mori","Yusuke","H",9,14
,19,80, 0, 0, 0),
(92,"Dubois","Lucas","H",18,11
,8,45, 0, 0, 0),
(93,"Michel","Louise","H",1,17
,6,81, 0, 0, 0),
(94,"Zhou","Hong","F",9,12
,12,18, 0, 0, 0),
(95,"Wang","Jun","F",4,17
,16,82, 0, 0, 0),
(96,"Kato","Kokoro","H",10,7
,7,83, 0, 0, 0),
(97,"Gao","Fang","F",7,14
,11,84, 0, 0, 0),
(98,"Kobayashi","Yuto","F",16,1
,1,24, 0, 0, 0),
(99,"Hartmann","Niklas","H",9,2
,17,85, 0, 0, 0),
(100,"Morel","Arthur","H",14,1
,16,86, 0, 0, 0),
(101,"He","Yang","F",8,20
,9,48, 0, 0, 0),
(102,"Guo","Min","H",18,14
,12,87, 0, 0, 0),
(103,"Ito","Haruto","F",12,9
,9,88, 0, 0, 0),
(104,"Sakai","Hinata","H",4,16
,13,89, 0, 0, 0),
(105,"Moreau","Maëlys","H",2,15
,3,90, 0, 0, 0),
(106,"Leroy","Sacha","H",10,10
,17,22, 0, 0, 0),
(107,"Hoffmann","Jakob","H",13,2
,14,91, 0, 0, 0),
(108,"Wu","Sun","H",6,17
,1,92, 0, 0, 0),
(109,"Zhou","Chen","F",20,8
,6,6, 0, 0, 0),
(110,"Zhao","Jun","H",12,2
,4,93, 0, 0, 0),
(111,"Sasaki","Yuto","H",16,15
,11,12, 0, 0, 0),
(112,"Hofmann","Simon","H",6,8
,4,94, 0, 0, 0),
(113,"Suzuki","Yui","F",16,10
,8,95, 0, 0, 0),
(114,"Goto","Sora","F",18,6
,17,96, 0, 0, 0),
(115,"Sun","Li","F",6,3
,7,97, 0, 0, 0),
(116,"Li","Hu","H",9,2
,5,98, 0, 0, 0),
(117,"Vincent","Nolan","H",11,10
,20,99, 0, 0, 0),
(118,"Lefebvre","Tom","H",7,4
,18,100, 0, 0, 0),
(119,"Becker","Paul","F",18,16
,4,101, 0, 0, 0),
(120,"Sun","Lan","F",14,1
,8,102, 0, 0, 0),
(121,"Lambert","Paul","F",16,9
,8,103, 0, 0, 0),
(122,"Huang","Zhou","F",11,14
,9,104, 0, 0, 0),
(123,"Hasegawa","Ren","H",2,8
,14,20, 0, 0, 0),
(124,"Suzuki","Kazuki","F",14,10
,15,105, 0, 0, 0),
(125,"Garcia","Tom","F",12,5
,2,50, 0, 0, 0),
(126,"Wang","Yan","F",14,8
,15,106, 0, 0, 0),
(127,"Yamada","Yuna","H",14,15
,12,107, 0, 0, 0),
(128,"Laurent","Alice","H",18,9
,12,11, 0, 0, 0),
(129,"Kobayashi","Kokoro","F",15,10
,15,108, 0, 0, 0),
(130,"Werner","Emma","F",1,18
,9,71, 0, 0, 0),
(131,"Robert","Sacha","F",20,20
,18,109, 0, 0, 0),
(132,"Sakamoto","Yui","F",19,6
,4,110, 0, 0, 0),
(133,"Schäfer","Tim","H",8,10
,16,111, 0, 0, 0),
(134,"Lin","Ma","H",15,20
,2,79, 0, 0, 0),
(135,"Sasaki","Yuma","H",6,2
,2,112, 0, 0, 0),
(136,"Thomas","Jules","F",20,12
,19,42, 0, 0, 0),
(137,"Ogawa","Naoki","H",16,14
,2,113, 0, 0, 0),
(138,"Zhao","Wei","F",11,10
,2,114, 0, 0, 0),
(139,"Perez","Jules","H",11,3
,13,47, 0, 0, 0),
(140,"Lambert","Louise","F",11,10
,9,115, 0, 0, 0),
(141,"Garcia","Jade","F",7,8
,2,116, 0, 0, 0),
(142,"Hu","Jing","F",3,1
,9,117, 0, 0, 0),
(143,"Xu","Wei","F",1,6
,14,21, 0, 0, 0),
(144,"Ogawa","Mio","H",10,8
,3,118, 0, 0, 0),
(145,"Sakai","Shiori","F",9,5
,19,119, 0, 0, 0),
(146,"Yamamoto","Haruto","F",10,4
,3,120, 0, 0, 0),
(147,"Yamamoto","Aoi","F",18,11
,15,58, 0, 0, 0),
(148,"Dubois","Léna","H",12,11
,17,121, 0, 0, 0),
(149,"Saito","Yuna","F",11,12
,17,122, 0, 0, 0),
(150,"Leroy","Nolan","H",15,19
,15,123, 0, 0, 0),
(151,"Schmitt","Lina","F",18,17
,19,124, 0, 0, 0),
(152,"Chen","Ting","F",5,11
,7,6, 0, 0, 0),
(153,"Tanaka","Yuto","H",13,11
,11,60, 0, 0, 0),
(154,"Shibata","Kazuki","F",11,15
,5,61, 0, 0, 0),
(155,"Gao","Zhao","H",7,8
,19,125, 0, 0, 0),
(156,"Köhler","Anna","H",2,17
,1,126, 0, 0, 0),
(157,"Goto","Rin","F",11,13
,18,127, 0, 0, 0),
(158,"Barbier","Tom","H",18,1
,3,128, 0, 0, 0),
(159,"Fontaine","Maëlys","H",1,4
,10,20, 0, 0, 0),
(160,"Suzuki","Yuto","H",1,3
,8,129, 0, 0, 0),
(161,"Sakamoto","Haruka","F",1,15
,13,130, 0, 0, 0),
(162,"Muller","Nolan","H",19,2
,13,72, 0, 0, 0),
(163,"Mori","Haruka","H",12,13
,5,111, 0, 0, 0),
(164,"Girard","Ethan","H",2,8
,1,131, 0, 0, 0),
(165,"Ishii","Shiori","F",9,17
,8,132, 0, 0, 0),
(166,"Wu","Jun","H",18,1
,6,133, 0, 0, 0),
(167,"Zhou","Yang","F",18,6
,15,134, 0, 0, 0),
(168,"Leroy","Emma","H",9,13
,12,135, 0, 0, 0),
(169,"Liu","Guo","F",19,4
,5,117, 0, 0, 0),
(170,"Krüger","Lena","H",8,11
,3,19, 0, 0, 0),
(171,"Krüger","Luca","H",6,10
,19,136, 0, 0, 0),
(172,"Zhao","Jing","H",11,20
,14,137, 0, 0, 0),
(173,"Fujita","Kaito","F",15,5
,14,138, 0, 0, 0),
(174,"Schäfer","Emma","H",8,1
,1,22, 0, 0, 0),
(175,"Richard","Nathan","H",19,19
,18,139, 0, 0, 0),
(176,"Kondo","Takumi","F",1,5
,5,140, 0, 0, 0),
(177,"Blanc","Sacha","H",19,9
,4,22, 0, 0, 0),
(178,"Mori","Yusuke","H",11,11
,3,141, 0, 0, 0),
(179,"Vincent","Mathis","F",2,11
,13,142, 0, 0, 0),
(180,"Li","Yan","H",10,12
,20,19, 0, 0, 0),
(181,"Zhang","Shuang","F",14,20
,20,143, 0, 0, 0),
(182,"Lin","Yan","F",11,2
,13,144, 0, 0, 0),
(183,"Shibata","Sora","F",1,20
,17,145, 0, 0, 0),
(184,"Hu","Guo","F",4,20
,5,84, 0, 0, 0),
(185,"Fontaine","Gabin","F",4,10
,16,146, 0, 0, 0),
(186,"Sakai","Naoki","H",12,11
,13,23, 0, 0, 0),
(187,"Wang","Yang","F",13,2
,19,50, 0, 0, 0),
(188,"Zhou","Yan","H",6,16
,5,147, 0, 0, 0),
(189,"Zhu","Wu","H",4,11
,14,3, 0, 0, 0),
(190,"Hu","Xue","F",2,13
,10,148, 0, 0, 0),
(191,"Robin","Paul","F",2,3
,9,31, 0, 0, 0),
(192,"He","Xiang","H",7,9
,16,149, 0, 0, 0),
(193,"Muller","Camille","F",15,3
,8,105, 0, 0, 0),
(194,"Wolf","Jonas","H",10,10
,3,150, 0, 0, 0),
(195,"Garcia","Lola","F",9,9
,13,151, 0, 0, 0),
(196,"Saito","Ryota","F",13,17
,12,152, 0, 0, 0),
(197,"Kobayashi","Daiki","H",14,20
,20,153, 0, 0, 0),
(198,"Wang","Xue","F",15,18
,11,50, 0, 0, 0),
(199,"Vincent","Sarah","H",4,9
,20,154, 0, 0, 0),
(200,"Barbier","Nolan","H",17,9
,17,155, 0, 0, 0),
(201,"Saito","Mio","H",5,2
,17,111, 0, 0, 0),
(202,"Hu","Xu","H",20,11
,7,156, 0, 0, 0),
(203,"Mori","Mio","H",12,8
,13,22, 0, 0, 0),
(204,"Zhao","Xia","F",3,20
,6,114, 0, 0, 0),
(205,"Zhou","Shuang","F",5,10
,13,157, 0, 0, 0),
(206,"Shibata","Sora","F",20,1
,11,44, 0, 0, 0),
(207,"Matsumoto","Shiori","H",10,14
,6,2, 0, 0, 0),
(208,"Huang","Liu","F",14,4
,15,114, 0, 0, 0),
(209,"Kondo","Sora","H",11,14
,9,11, 0, 0, 0),
(210,"Wu","Ling","H",6,11
,13,158, 0, 0, 0),
(211,"Nakamura","Kaito","F",6,6
,4,18, 0, 0, 0),
(212,"Sasaki","Saki","F",13,3
,2,159, 0, 0, 0),
(213,"Kimura","Asuka","H",2,18
,6,160, 0, 0, 0),
(214,"Schulz","Jakob","F",19,7
,16,114, 0, 0, 0),
(215,"Zhao","Min","H",11,18
,8,3, 0, 0, 0),
(216,"Fujita","Yuto","H",2,3
,12,161, 0, 0, 0),
(217,"Dubois","Lola","H",2,11
,7,162, 0, 0, 0),
(218,"Morel","Tom","F",17,2
,10,163, 0, 0, 0),
(219,"Sato","Yuto","F",11,18
,15,5, 0, 0, 0),
(220,"Roux","Léna","F",15,5
,14,164, 0, 0, 0),
(221,"Goto","Akira","F",6,8
,20,165, 0, 0, 0),
(222,"Robin","Louis","H",10,5
,8,166, 0, 0, 0),
(223,"Kobayashi","Akira","H",2,10
,9,19, 0, 0, 0),
(224,"Kimura","Ryota","F",1,6
,3,167, 0, 0, 0),
(225,"Zhao","Xin","F",6,11
,17,39, 0, 0, 0),
(226,"Schulze","Maja","F",13,18
,9,168, 0, 0, 0),
(227,"Schmitz","Hannah","H",10,16
,8,79, 0, 0, 0),
(228,"Martin","Ethan","H",14,4
,7,47, 0, 0, 0),
(229,"Garcia","Inès","H",10,2
,3,11, 0, 0, 0),
(230,"Liu","Hu","F",19,18
,2,117, 0, 0, 0),
(231,"Sato","Hiroshi","F",14,4
,6,24, 0, 0, 0),
(232,"Ma","Xue","H",10,1
,20,9, 0, 0, 0),
(233,"Wang","Guo","F",16,16
,18,169, 0, 0, 0),
(234,"Lin","Jing","F",18,14
,10,170, 0, 0, 0),
(235,"Ito","Kazuki","H",3,10
,6,118, 0, 0, 0),
(236,"Lin","Hong","F",17,13
,4,171, 0, 0, 0),
(237,"Xu","Yan","F",15,18
,6,172, 0, 0, 0),
(238,"Sato","Shiori","H",4,3
,8,23, 0, 0, 0),
(239,"Wang","Shuang","H",15,6
,17,173, 0, 0, 0),
(240,"Richter","Lea","F",5,7
,4,174, 0, 0, 0),
(241,"Shibata","Naoki","F",17,18
,9,174, 0, 0, 0),
(242,"Saito","Haruto","F",3,4
,11,48, 0, 0, 0),
(243,"Rousseau","Raphaël","H",13,1
,15,175, 0, 0, 0),
(244,"Meier","Jonas","H",13,10
,1,121, 0, 0, 0),
(245,"Yamada","Takeshi","H",19,19
,1,176, 0, 0, 0),
(246,"Zhu","Hong","F",15,15
,9,8, 0, 0, 0),
(247,"Schwarz","Emilia","H",2,5
,20,29, 0, 0, 0),
(248,"Gao","Chen","H",3,2
,17,177, 0, 0, 0),
(249,"Leroy","Ethan","H",7,18
,14,93, 0, 0, 0),
(250,"Yamada","Ren","H",4,8
,11,178, 0, 0, 0),
(251,"Garcia","Camille","H",8,5
,9,179, 0, 0, 0),
(252,"Saito","Daiki","H",2,5
,16,180, 0, 0, 0),
(253,"Krause","Lena","F",13,13
,17,114, 0, 0, 0),
(254,"Moreau","Emma","H",16,16
,5,72, 0, 0, 0),
(255,"Vincent","Clara","H",8,5
,15,181, 0, 0, 0),
(256,"Fournier","Paul","H",13,4
,14,158, 0, 0, 0),
(257,"Roux","Tom","F",14,17
,9,182, 0, 0, 0),
(258,"Lange","Lena","F",6,15
,15,183, 0, 0, 0),
(259,"Michel","Mathis","F",5,20
,18,31, 0, 0, 0),
(260,"Faure","Sacha","H",7,14
,9,184, 0, 0, 0),
(261,"Hasegawa","Yuna","F",12,6
,15,185, 0, 0, 0),
(262,"Zhu","Yan","H",14,1
,14,186, 0, 0, 0),
(263,"Kondo","Yui","H",14,5
,5,187, 0, 0, 0),
(264,"Xu","Xue","F",8,3
,16,188, 0, 0, 0),
(265,"Zhang","Lan","F",2,20
,12,104, 0, 0, 0),
(266,"Shimizu","Hinata","H",10,12
,13,189, 0, 0, 0),
(267,"Hu","Zhu","H",14,10
,3,81, 0, 0, 0),
(268,"Sun","Wei","H",14,8
,7,190, 0, 0, 0),
(269,"Herrmann","Tim","H",3,20
,10,9, 0, 0, 0),
(270,"Matsumoto","Asuka","F",19,11
,5,191, 0, 0, 0),
(271,"Zhang","Wang","F",15,1
,3,192, 0, 0, 0),
(272,"Zhao","Min","F",11,6
,16,193, 0, 0, 0),
(273,"Sasaki","Akira","H",9,12
,7,194, 0, 0, 0),
(274,"Maeda","Kokoro","H",11,17
,4,158, 0, 0, 0),
(275,"Gao","Wang","H",7,15
,13,161, 0, 0, 0),
(276,"Ma","Hu","H",8,12
,6,195, 0, 0, 0),
(277,"Martin","Zoé","H",7,17
,3,23, 0, 0, 0),
(278,"Watanabe","Ren","H",20,9
,11,196, 0, 0, 0),
(279,"Huang","Ting","H",13,5
,15,197, 0, 0, 0),
(280,"Tanaka","Takeshi","F",13,14
,5,198, 0, 0, 0),
(281,"Sato","Haruka","F",15,9
,12,199, 0, 0, 0),
(282,"Dubois","Arthur","H",13,3
,10,200, 0, 0, 0),
(283,"Richard","Nolan","F",2,4
,9,201, 0, 0, 0),
(284,"Hu","Huang","H",14,1
,12,121, 0, 0, 0),
(285,"Mori","Sakura","F",5,10
,16,48, 0, 0, 0),
(286,"Xu","Ling","H",4,14
,19,12, 0, 0, 0),
(287,"Hayashi","Hiroshi","F",11,17
,20,117, 0, 0, 0),
(288,"Vincent","Inès","H",20,12
,20,17, 0, 0, 0),
(289,"Zhao","Lan","H",19,5
,18,14, 0, 0, 0),
(290,"Sato","Akira","H",19,20
,12,202, 0, 0, 0),
(291,"Fournier","Alice","F",2,2
,3,203, 0, 0, 0),
(292,"Richter","Niklas","F",5,8
,17,204, 0, 0, 0),
(293,"Klein","Lukas","H",19,15
,16,80, 0, 0, 0),
(294,"Maeda","Akira","H",9,18
,6,205, 0, 0, 0),
(295,"Huang","Hong","F",11,1
,1,6, 0, 0, 0),
(296,"Richard","Noé","F",12,9
,14,206, 0, 0, 0),
(297,"Wang","Ling","F",5,9
,8,39, 0, 0, 0),
(298,"Richard","Nolan","H",13,1
,6,207, 0, 0, 0),
(299,"Hasegawa","Saki","F",9,8
,6,208, 0, 0, 0),
(300,"Ma","Lan","F",11,11
,9,39, 0, 0, 0),
(301,"Lambert","Camille","H",1,14
,3,209, 0, 0, 0),
(302,"Saito","Rina","H",5,13
,18,85, 0, 0, 0),
(303,"Yang","Ma","F",8,3
,20,44, 0, 0, 0),
(304,"Moreau","Anna","H",3,5
,10,47, 0, 0, 0),
(305,"He","Hu","H",4,19
,12,210, 0, 0, 0),
(306,"Meier","Elias","F",14,16
,14,106, 0, 0, 0),
(307,"Mercier","Chloé","F",7,19
,16,211, 0, 0, 0),
(308,"Zhang","Hong","H",13,20
,17,93, 0, 0, 0),
(309,"Blanc","Paul","F",6,4
,15,58, 0, 0, 0),
(310,"Saito","Takumi","H",16,5
,20,212, 0, 0, 0),
(311,"Mori","Ryota","F",4,16
,4,213, 0, 0, 0),
(312,"Schmitt","David","H",4,15
,5,214, 0, 0, 0),
(313,"Lefebvre","Mathis","H",8,6
,10,60, 0, 0, 0),
(314,"Guo","Shuang","F",19,12
,18,215, 0, 0, 0),
(315,"Schmitt","David","F",1,11
,12,50, 0, 0, 0),
(316,"Chen","Jing","H",16,18
,9,216, 0, 0, 0),
(317,"Hasegawa","Kaito","H",15,9
,15,217, 0, 0, 0),
(318,"Huang","Zhu","H",18,17
,11,154, 0, 0, 0),
(319,"Mori","Naoki","F",5,1
,6,218, 0, 0, 0),
(320,"Sakai","Aoi","H",9,2
,2,219, 0, 0, 0),
(321,"Takahashi","Saki","F",2,12
,20,174, 0, 0, 0),
(322,"Robert","Manon","F",3,7
,14,18, 0, 0, 0),
(323,"Leroy","Louis","F",2,4
,3,105, 0, 0, 0),
(324,"Shimizu","Asuka","F",15,12
,6,220, 0, 0, 0),
(325,"Sato","Takumi","F",9,11
,5,50, 0, 0, 0),
(326,"Takahashi","Yuna","F",16,6
,11,44, 0, 0, 0),
(327,"Shibata","Ryota","H",8,10
,11,83, 0, 0, 0),
(328,"Schulze","Anna","F",14,9
,15,167, 0, 0, 0),
(329,"Goto","Riko","H",19,8
,10,23, 0, 0, 0),
(330,"Li","Chen","H",13,3
,1,221, 0, 0, 0),
(331,"Lefebvre","Emma","H",16,5
,11,222, 0, 0, 0),
(332,"Richard","Emma","H",9,11
,15,223, 0, 0, 0),
(333,"Leroy","Jules","H",20,20
,2,45, 0, 0, 0),
(334,"Watanabe","Yusuke","F",1,18
,16,114, 0, 0, 0),
(335,"Guo","Zhou","H",8,18
,16,184, 0, 0, 0),
(336,"Mercier","Camille","H",7,16
,1,224, 0, 0, 0),
(337,"Fujita","Nana","H",17,7
,5,225, 0, 0, 0),
(338,"Matsumoto","Asuka","H",11,9
,17,60, 0, 0, 0),
(339,"Inoue","Riko","F",4,2
,12,18, 0, 0, 0),
(340,"Sato","Hiroshi","F",12,5
,11,115, 0, 0, 0),
(341,"Takahashi","Haruto","F",4,12
,7,226, 0, 0, 0),
(342,"Roux","Ethan","F",5,20
,8,227, 0, 0, 0),
(343,"Suzuki","Naoki","F",15,19
,9,228, 0, 0, 0),
(344,"Ogawa","Yuma","H",19,13
,17,229, 0, 0, 0),
(345,"Thomas","Hugo","H",20,9
,20,189, 0, 0, 0),
(346,"Perez","Paul","F",7,12
,7,230, 0, 0, 0),
(347,"Mercier","Clara","F",18,9
,13,71, 0, 0, 0),
(348,"Yang","Hui","F",1,15
,7,88, 0, 0, 0),
(349,"Kondo","Takumi","F",13,10
,12,231, 0, 0, 0),
(350,"Kondo","Yuto","F",19,11
,17,232, 0, 0, 0),
(351,"Ito","Yuto","H",14,9
,3,195, 0, 0, 0),
(352,"Yamamoto","Daiki","F",19,17
,19,116, 0, 0, 0),
(353,"Blanc","Emma","F",10,17
,18,233, 0, 0, 0),
(354,"Ito","Hinata","H",17,16
,4,161, 0, 0, 0),
(355,"Sasaki","Hiroshi","F",4,8
,13,234, 0, 0, 0),
(356,"Hayashi","Hinata","H",5,17
,9,235, 0, 0, 0),
(357,"Wu","Xue","H",14,16
,2,236, 0, 0, 0),
(358,"Yoshida","Aoi","H",19,19
,8,11, 0, 0, 0),
(359,"Hayashi","Ren","F",13,16
,7,84, 0, 0, 0),
(360,"Xu","Yan","H",19,17
,19,161, 0, 0, 0),
(361,"Shibata","Kokoro","H",16,18
,5,237, 0, 0, 0);

INSERT INTO PARTICIPER VALUES 
("Natation 100 brasse homme", 13), 
("Natation 100 brasse homme", 16), 
("Natation 100 brasse homme", 27), 
("Natation 100 brasse homme", 30), 
("Natation 100 brasse homme", 40), 
("Natation 100 brasse homme", 49), 
("Natation 100 brasse homme", 52), 
("Natation 100 brasse homme", 54), 
("Natation 100 brasse homme", 57), 
("Natation 100 brasse homme", 64), 
("Natation 100 brasse homme", 65), 
("Natation 100 brasse homme", 87), 
("Natation 100 brasse homme", 100), 
("Natation 100 brasse homme", 107), 
("Natation 100 brasse homme", 123), 
("Natation 100 brasse homme", 128), 
("Natation 100 brasse homme", 129), 
("Natation 100 brasse homme", 137), 
("Natation 100 brasse homme", 139), 
("Natation 100 brasse homme", 150), 
("Natation 100 brasse homme", 153), 
("Natation 100 brasse homme", 162), 
("Natation 100 brasse homme", 187), 
("Natation 100 brasse homme", 205), 
("Natation 100 brasse homme", 210), 
("Natation 100 brasse homme", 216), 
("Natation 100 brasse homme", 217), 
("Natation 100 brasse homme", 219), 
("Natation 100 brasse homme", 221), 
("Natation 100 brasse homme", 237), 
("Natation relais libre homme", 2), 
("Natation relais libre homme", 11), 
("Natation relais libre homme", 19), 
("Natation relais libre homme", 23), 
("Natation relais libre homme", 60), 
("Natation relais libre homme", 80), 
("Natation relais libre homme", 81), 
("Natation relais libre homme", 111), 
("Natation relais libre homme", 121), 
("Natation relais libre homme", 184), 
("Handball homme", 17), 
("Handball homme", 20), 
("Handball homme", 29), 
("Handball homme", 161), 
("Handball homme", 189), 
("Handball homme", 196), 
("Volley-Ball homme", 3), 
("Volley-Ball homme", 9), 
("Volley-Ball homme", 14), 
("Volley-Ball homme", 47), 
("Volley-Ball homme", 83), 
("Volley-Ball homme", 99), 
("Volley-Ball homme", 118), 
("Volley-Ball homme", 154), 
("Volley-Ball homme", 195), 
("Volley-Ball homme", 202), 
("Escrime fleuret homme", 25), 
("Escrime fleuret homme", 38), 
("Escrime fleuret homme", 43), 
("Escrime fleuret homme", 55), 
("Escrime fleuret homme", 90), 
("Escrime fleuret homme", 91), 
("Escrime fleuret homme", 94), 
("Escrime fleuret homme", 112), 
("Escrime fleuret homme", 125), 
("Escrime fleuret homme", 126), 
("Escrime fleuret homme", 131), 
("Escrime fleuret homme", 133), 
("Escrime fleuret homme", 155), 
("Escrime fleuret homme", 177), 
("Escrime fleuret homme", 178), 
("Escrime fleuret homme", 180), 
("Escrime fleuret homme", 181), 
("Escrime fleuret homme", 186), 
("Escrime fleuret homme", 194), 
("Escrime fleuret homme", 207), 
("Escrime fleuret homme", 209), 
("Escrime fleuret homme", 229), 
("Escrime fleuret homme", 235), 
("Escrime fleuret homme", 236), 
("Escrime épée homme", 1), 
("Escrime épée homme", 26), 
("Escrime épée homme", 28), 
("Escrime épée homme", 56), 
("Escrime épée homme", 63), 
("Escrime épée homme", 67), 
("Escrime épée homme", 69), 
("Escrime épée homme", 70), 
("Escrime épée homme", 74), 
("Escrime épée homme", 75), 
("Escrime épée homme", 86), 
("Escrime épée homme", 89), 
("Escrime épée homme", 92), 
("Escrime épée homme", 98), 
("Escrime épée homme", 113), 
("Escrime épée homme", 135), 
("Escrime épée homme", 136), 
("Escrime épée homme", 141), 
("Escrime épée homme", 147), 
("Escrime épée homme", 149), 
("Escrime épée homme", 156), 
("Escrime épée homme", 160), 
("Escrime épée homme", 166), 
("Escrime épée homme", 173), 
("Escrime épée homme", 176), 
("Escrime épée homme", 179), 
("Escrime épée homme", 190), 
("Escrime épée homme", 197), 
("Escrime épée homme", 200), 
("Escrime épée homme", 212), 
("Escrime épée homme", 214), 
("Escrime épée homme", 222), 
("Escrime épée homme", 223), 
("Escrime épée homme", 224), 
("Escrime épée homme", 225), 
("Natation 100 brasse femme", 10), 
("Natation 100 brasse femme", 32), 
("Natation 100 brasse femme", 33), 
("Natation 100 brasse femme", 34), 
("Natation 100 brasse femme", 76), 
("Natation 100 brasse femme", 95), 
("Natation 100 brasse femme", 101), 
("Natation 100 brasse femme", 102), 
("Natation 100 brasse femme", 132), 
("Natation 100 brasse femme", 134), 
("Natation 100 brasse femme", 138), 
("Natation 100 brasse femme", 159), 
("Natation 100 brasse femme", 163), 
("Natation 100 brasse femme", 171), 
("Natation 100 brasse femme", 172), 
("Natation 100 brasse femme", 182), 
("Natation 100 brasse femme", 211), 
("Natation 100 brasse femme", 215), 
("Natation 100 brasse femme", 220), 
("Natation 100 brasse femme", 226), 
("Natation 100 brasse femme", 227), 
("Natation 100 brasse femme", 230), 
("Natation relais libre femme", 6), 
("Natation relais libre femme", 50), 
("Natation relais libre femme", 59), 
("Natation relais libre femme", 61), 
("Natation relais libre femme", 71), 
("Natation relais libre femme", 106), 
("Natation relais libre femme", 115), 
("Natation relais libre femme", 201), 
("Natation relais libre femme", 218), 
("Handball femme", 24), 
("Handball femme", 31), 
("Handball femme", 42), 
("Handball femme", 88), 
("Handball femme", 97), 
("Handball femme", 105), 
("Handball femme", 170), 
("Handball femme", 174), 
("Handball femme", 234), 
("Volley-Ball femme", 5), 
("Volley-Ball femme", 8), 
("Volley-Ball femme", 15), 
("Volley-Ball femme", 36), 
("Volley-Ball femme", 39), 
("Volley-Ball femme", 58), 
("Volley-Ball femme", 84), 
("Volley-Ball femme", 104), 
("Escrime fleuret femme", 35), 
("Escrime fleuret femme", 51), 
("Escrime fleuret femme", 66), 
("Escrime fleuret femme", 68), 
("Escrime fleuret femme", 73), 
("Escrime fleuret femme", 77), 
("Escrime fleuret femme", 78), 
("Escrime fleuret femme", 82), 
("Escrime fleuret femme", 96), 
("Escrime fleuret femme", 103), 
("Escrime fleuret femme", 109), 
("Escrime fleuret femme", 110), 
("Escrime fleuret femme", 120), 
("Escrime fleuret femme", 127), 
("Escrime fleuret femme", 140), 
("Escrime fleuret femme", 145), 
("Escrime fleuret femme", 152), 
("Escrime fleuret femme", 157), 
("Escrime fleuret femme", 164), 
("Escrime fleuret femme", 165), 
("Escrime fleuret femme", 168), 
("Escrime fleuret femme", 183), 
("Escrime fleuret femme", 185), 
("Escrime fleuret femme", 199), 
("Escrime fleuret femme", 213), 
("Escrime fleuret femme", 233), 
("Escrime épée femme", 4), 
("Escrime épée femme", 7), 
("Escrime épée femme", 37), 
("Escrime épée femme", 41), 
("Escrime épée femme", 53), 
("Escrime épée femme", 62), 
("Escrime épée femme", 108), 
("Escrime épée femme", 119), 
("Escrime épée femme", 122), 
("Escrime épée femme", 124), 
("Escrime épée femme", 130), 
("Escrime épée femme", 142), 
("Escrime épée femme", 143), 
("Escrime épée femme", 144), 
("Escrime épée femme", 146), 
("Escrime épée femme", 148), 
("Escrime épée femme", 151), 
("Escrime épée femme", 169), 
("Escrime épée femme", 188), 
("Escrime épée femme", 191), 
("Escrime épée femme", 192), 
("Escrime épée femme", 198), 
("Escrime épée femme", 203), 
("Escrime épée femme", 204), 
("Escrime épée femme", 206), 
("Escrime épée femme", 208), 
("Escrime épée femme", 228), 
("Escrime épée femme", 231), 
("Escrime épée femme", 232); 