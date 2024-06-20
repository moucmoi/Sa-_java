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

    INSERT INTO ATHLETE VALUES
(1,"Guo","Ling","H",14,1
,14,1, 0, 0, 0),
(1,"Fontaine","Alice","H",20,19
,13,2, 0, 0, 0),
(2,"Blanc","Camille","H",6,18
,1,3, 0, 0, 0),
(3,"Perez","Emma","F",20,15
,4,4, 0, 0, 0),
(3,"Li","Zhao","F",8,18
,16,5, 0, 0, 0),
(4,"Huang","Hui","F",20,15
,3,6, 0, 0, 0),
(5,"Hoffmann","Tim","F",7,16
,4,7, 0, 0, 0),
(5,"Huang","Zhang","F",5,3
,12,8, 0, 0, 0),
(6,"Yamamoto","Ryota","H",8,16
,7,9, 0, 0, 0),
(7,"Garcia","Léa","F",18,9
,15,10, 0, 0, 0),
(7,"Inoue","Saki","H",16,6
,17,11, 0, 0, 0),
(8,"Faure","Gabin","H",15,4
,1,12, 0, 0, 0),
(9,"Barbier","Juliette","H",18,15
,1,13, 0, 0, 0),
(9,"Fujita","Shiori","H",10,13
,11,14, 0, 0, 0),
(10,"Matsumoto","Daiki","F",15,10
,11,15, 0, 0, 0),
(11,"Laurent","Alice","H",9,14
,14,16, 0, 0, 0),
(11,"Zhao","Xiang","H",1,3
,13,17, 0, 0, 0),
(12,"Sakamoto","Yuna","F",2,11
,8,18, 0, 0, 0),
(13,"Sato","Aoi","H",5,16
,6,19, 0, 0, 0),
(14,"Sakai","Yuki","H",4,16
,5,20, 0, 0, 0),
(15,"Wagner","Ben","F",6,6
,10,21, 0, 0, 0),
(16,"Zhu","Jun","H",20,6
,19,22, 0, 0, 0),
(17,"Gao","Zhu","H",8,9
,13,23, 0, 0, 0),
(18,"Hasegawa","Shiori","F",5,3
,17,24, 0, 0, 0),
(19,"Leroy","Arthur","H",12,12
,4,25, 0, 0, 0),
(19,"Durand","Juliette","H",12,12
,16,26, 0, 0, 0),
(19,"Braun","Luca","H",16,13
,13,27, 0, 0, 0),
(19,"Saito","Riko","H",15,15
,11,28, 0, 0, 0),
(19,"Zhang","Chen","H",18,20
,20,29, 0, 0, 0),
(20,"Hasegawa","Takumi","H",6,8
,7,30, 0, 0, 0),
(20,"Yang","Hu","F",6,18
,17,31, 0, 0, 0),
(21,"Schröder","Luisa","F",5,6
,19,32, 0, 0, 0),
(21,"Sakai","Hana","F",1,6
,4,33, 0, 0, 0),
(21,"Xu","Li","F",6,8
,9,34, 0, 0, 0),
(21,"Lehmann","Emily","H",18,16
,14,35, 0, 0, 0),
(22,"Faure","Lola","F",8,12
,7,36, 0, 0, 0),
(23,"Takahashi","Akira","F",7,5
,18,37, 0, 0, 0),
(23,"Gao","Chen","F",6,3
,6,38, 0, 0, 0),
(24,"Sun","Xiang","F",5,7
,18,39, 0, 0, 0),
(24,"Zhang","Wang","H",20,1
,16,40, 0, 0, 0),
(24,"Inoue","Kazuki","F",15,2
,6,41, 0, 0, 0),
(25,"Wu","Ling","H",11,2
,20,42, 0, 0, 0),
(25,"Huang","Lan","F",4,14
,12,43, 0, 0, 0),
(25,"Bauer","Anna","F",13,8
,18,44, 0, 0, 0),
(26,"Kobayashi","Riku","H",15,7
,5,45, 0, 0, 0),
(26,"Hu","Ma","F",10,7
,7,46, 0, 0, 0),
(27,"Petit","Raphaël","H",18,9
,16,47, 0, 0, 0),
(28,"Muller","Léa","H",9,7
,10,48, 0, 0, 0),
(29,"Blanc","Gabin","H",1,15
,4,49, 0, 0, 0),
(30,"Weber","Maja","F",16,19
,10,50, 0, 0, 0),
(31,"Yoshida","Yuki","H",3,12
,16,51, 0, 0, 0),
(31,"Zhu","Shuang","F",17,7
,16,52, 0, 0, 0),
(32,"Mercier","Noé","F",7,10
,18,53, 0, 0, 0),
(33,"Kimura","Kazuki","F",16,16
,6,54, 0, 0, 0),
(33,"Garcia","Tom","H",12,15
,12,55, 0, 0, 0),
(33,"Fujita","Mio","F",15,13
,17,56, 0, 0, 0),
(33,"Zhou","Shuang","H",4,20
,20,57, 0, 0, 0),
(33,"Morel","Nolan","H",18,6
,6,58, 0, 0, 0),
(33,"Kato","Takeshi","H",18,6
,14,59, 0, 0, 0),
(33,"Guerin","Juliette","F",6,7
,2,60, 0, 0, 0),
(34,"Watanabe","Aoi","H",3,8
,18,61, 0, 0, 0),
(34,"Mori","Ryota","F",5,18
,2,62, 0, 0, 0),
(35,"Lambert","Léna","F",19,15
,12,63, 0, 0, 0),
(36,"Yang","Li","H",5,8
,10,64, 0, 0, 0),
(37,"Yang","Yan","F",5,2
,4,65, 0, 0, 0),
(38,"Morel","Zoé","F",6,2
,8,66, 0, 0, 0),
(38,"Xu","Liu","H",20,2
,7,67, 0, 0, 0),
(38,"Matsumoto","Kokoro","H",11,13
,17,68, 0, 0, 0),
(38,"Muller","Louise","F",14,17
,9,69, 0, 0, 0),
(39,"Zhao","Chen","H",2,13
,17,70, 0, 0, 0),
(39,"Wang","Yan","F",8,4
,12,71, 0, 0, 0),
(39,"Dubois","Ethan","F",1,10
,19,72, 0, 0, 0),
(40,"Zhou","Zhu","H",9,16
,16,73, 0, 0, 0),
(40,"Zhang","Sun","F",14,9
,11,74, 0, 0, 0),
(40,"Saito","Sakura","H",20,2
,9,75, 0, 0, 0),
(41,"Moreau","Théo","H",15,9
,3,76, 0, 0, 0),
(41,"Roux","Hugo","H",8,14
,9,77, 0, 0, 0),
(41,"Murakami","Riku","F",12,5
,18,78, 0, 0, 0),
(42,"Schulze","Leon","F",7,19
,1,79, 0, 0, 0),
(43,"Richard","Paul","F",13,17
,15,80, 0, 0, 0),
(44,"Guerin","Clara","H",14,9
,18,81, 0, 0, 0),
(45,"Zhu","Li","F",5,7
,6,82, 0, 0, 0),
(45,"Watanabe","Takeshi","H",10,14
,2,83, 0, 0, 0),
(45,"Bernard","Jules","H",11,17
,20,84, 0, 0, 0),
(46,"He","Qian","H",8,14
,3,85, 0, 0, 0),
(46,"Petit","Lola","H",5,7
,4,86, 0, 0, 0),
(47,"Zhao","Shuang","F",3,5
,18,87, 0, 0, 0),
(47,"Zhou","Wei","F",8,4
,16,88, 0, 0, 0),
(47,"Krüger","Ben","F",6,7
,1,89, 0, 0, 0),
(47,"Morel","Manon","H",13,4
,2,90, 0, 0, 0),
(48,"Mori","Yusuke","H",9,14
,19,91, 0, 0, 0),
(49,"Dubois","Lucas","H",18,11
,8,92, 0, 0, 0),
(50,"Michel","Louise","H",1,17
,6,93, 0, 0, 0),
(51,"Zhou","Hong","F",9,12
,12,94, 0, 0, 0),
(52,"Wang","Jun","F",4,17
,16,95, 0, 0, 0),
(52,"Kato","Kokoro","H",10,7
,7,96, 0, 0, 0),
(53,"Gao","Fang","F",7,14
,11,97, 0, 0, 0),
(54,"Kobayashi","Yuto","F",16,1
,1,98, 0, 0, 0),
(55,"Hartmann","Niklas","H",9,2
,17,99, 0, 0, 0),
(56,"Morel","Arthur","H",14,1
,16,100, 0, 0, 0),
(56,"He","Yang","F",8,20
,9,101, 0, 0, 0),
(57,"Guo","Min","H",18,14
,12,102, 0, 0, 0),
(57,"Ito","Haruto","F",12,9
,9,103, 0, 0, 0),
(58,"Sakai","Hinata","H",4,16
,13,104, 0, 0, 0),
(58,"Moreau","Maëlys","H",2,15
,3,105, 0, 0, 0),
(58,"Leroy","Sacha","H",10,10
,17,106, 0, 0, 0),
(59,"Hoffmann","Jakob","H",13,2
,14,107, 0, 0, 0),
(59,"Wu","Sun","H",6,17
,1,108, 0, 0, 0),
(59,"Zhou","Chen","F",20,8
,6,109, 0, 0, 0),
(60,"Zhao","Jun","H",12,2
,4,110, 0, 0, 0),
(61,"Sasaki","Yuto","H",16,15
,11,111, 0, 0, 0),
(62,"Hofmann","Simon","H",6,8
,4,112, 0, 0, 0),
(62,"Suzuki","Yui","F",16,10
,8,113, 0, 0, 0),
(62,"Goto","Sora","F",18,6
,17,114, 0, 0, 0),
(62,"Sun","Li","F",6,3
,7,115, 0, 0, 0),
(63,"Li","Hu","H",9,2
,5,116, 0, 0, 0),
(63,"Vincent","Nolan","H",11,10
,20,117, 0, 0, 0),
(64,"Lefebvre","Tom","H",7,4
,18,118, 0, 0, 0),
(64,"Becker","Paul","F",18,16
,4,119, 0, 0, 0),
(64,"Sun","Lan","F",14,1
,8,120, 0, 0, 0),
(64,"Lambert","Paul","F",16,9
,8,121, 0, 0, 0),
(64,"Huang","Zhou","F",11,14
,9,122, 0, 0, 0),
(65,"Hasegawa","Ren","H",2,8
,14,123, 0, 0, 0),
(66,"Suzuki","Kazuki","F",14,10
,15,124, 0, 0, 0),
(67,"Garcia","Tom","F",12,5
,2,125, 0, 0, 0),
(68,"Wang","Yan","F",14,8
,15,126, 0, 0, 0),
(69,"Yamada","Yuna","H",14,15
,12,127, 0, 0, 0),
(69,"Laurent","Alice","H",18,9
,12,128, 0, 0, 0),
(70,"Kobayashi","Kokoro","F",15,10
,15,129, 0, 0, 0),
(70,"Werner","Emma","F",1,18
,9,130, 0, 0, 0),
(71,"Robert","Sacha","F",20,20
,18,131, 0, 0, 0),
(71,"Sakamoto","Yui","F",19,6
,4,132, 0, 0, 0),
(71,"Schäfer","Tim","H",8,10
,16,133, 0, 0, 0),
(72,"Lin","Ma","H",15,20
,2,134, 0, 0, 0),
(73,"Sasaki","Yuma","H",6,2
,2,135, 0, 0, 0),
(73,"Thomas","Jules","F",20,12
,19,136, 0, 0, 0),
(74,"Ogawa","Naoki","H",16,14
,2,137, 0, 0, 0),
(74,"Zhao","Wei","F",11,10
,2,138, 0, 0, 0),
(75,"Perez","Jules","H",11,3
,13,139, 0, 0, 0),
(76,"Lambert","Louise","F",11,10
,9,140, 0, 0, 0),
(77,"Garcia","Jade","F",7,8
,2,141, 0, 0, 0),
(78,"Hu","Jing","F",3,1
,9,142, 0, 0, 0),
(79,"Xu","Wei","F",1,6
,14,143, 0, 0, 0),
(80,"Ogawa","Mio","H",10,8
,3,144, 0, 0, 0),
(81,"Sakai","Shiori","F",9,5
,19,145, 0, 0, 0),
(81,"Yamamoto","Haruto","F",10,4
,3,146, 0, 0, 0),
(81,"Yamamoto","Aoi","F",18,11
,15,147, 0, 0, 0),
(82,"Dubois","Léna","H",12,11
,17,148, 0, 0, 0),
(83,"Saito","Yuna","F",11,12
,17,149, 0, 0, 0),
(83,"Leroy","Nolan","H",15,19
,15,150, 0, 0, 0),
(83,"Schmitt","Lina","F",18,17
,19,151, 0, 0, 0),
(83,"Chen","Ting","F",5,11
,7,152, 0, 0, 0),
(84,"Tanaka","Yuto","H",13,11
,11,153, 0, 0, 0),
(85,"Shibata","Kazuki","F",11,15
,5,154, 0, 0, 0),
(86,"Gao","Zhao","H",7,8
,19,155, 0, 0, 0),
(86,"Köhler","Anna","H",2,17
,1,156, 0, 0, 0),
(86,"Goto","Rin","F",11,13
,18,157, 0, 0, 0),
(86,"Barbier","Tom","H",18,1
,3,158, 0, 0, 0),
(86,"Fontaine","Maëlys","H",1,4
,10,159, 0, 0, 0),
(87,"Suzuki","Yuto","H",1,3
,8,160, 0, 0, 0),
(87,"Sakamoto","Haruka","F",1,15
,13,161, 0, 0, 0),
(87,"Muller","Nolan","H",19,2
,13,162, 0, 0, 0),
(88,"Mori","Haruka","H",12,13
,5,163, 0, 0, 0),
(89,"Girard","Ethan","H",2,8
,1,164, 0, 0, 0),
(89,"Ishii","Shiori","F",9,17
,8,165, 0, 0, 0),
(89,"Wu","Jun","H",18,1
,6,166, 0, 0, 0),
(89,"Zhou","Yang","F",18,6
,15,167, 0, 0, 0),
(89,"Leroy","Emma","H",9,13
,12,168, 0, 0, 0),
(89,"Liu","Guo","F",19,4
,5,169, 0, 0, 0),
(90,"Krüger","Lena","H",8,11
,3,170, 0, 0, 0),
(91,"Krüger","Luca","H",6,10
,19,171, 0, 0, 0),
(91,"Zhao","Jing","H",11,20
,14,172, 0, 0, 0),
(91,"Fujita","Kaito","F",15,5
,14,173, 0, 0, 0),
(91,"Schäfer","Emma","H",8,1
,1,174, 0, 0, 0),
(92,"Richard","Nathan","H",19,19
,18,175, 0, 0, 0),
(92,"Kondo","Takumi","F",1,5
,5,176, 0, 0, 0),
(92,"Blanc","Sacha","H",19,9
,4,177, 0, 0, 0),
(93,"Mori","Yusuke","H",11,11
,3,178, 0, 0, 0),
(93,"Vincent","Mathis","F",2,11
,13,179, 0, 0, 0),
(93,"Li","Yan","H",10,12
,20,180, 0, 0, 0),
(94,"Zhang","Shuang","F",14,20
,20,181, 0, 0, 0),
(94,"Lin","Yan","F",11,2
,13,182, 0, 0, 0),
(94,"Shibata","Sora","F",1,20
,17,183, 0, 0, 0),
(94,"Hu","Guo","F",4,20
,5,184, 0, 0, 0),
(95,"Fontaine","Gabin","F",4,10
,16,185, 0, 0, 0),
(95,"Sakai","Naoki","H",12,11
,13,186, 0, 0, 0),
(96,"Wang","Yang","F",13,2
,19,187, 0, 0, 0),
(97,"Zhou","Yan","H",6,16
,5,188, 0, 0, 0),
(97,"Zhu","Wu","H",4,11
,14,189, 0, 0, 0),
(98,"Hu","Xue","F",2,13
,10,190, 0, 0, 0),
(98,"Robin","Paul","F",2,3
,9,191, 0, 0, 0),
(99,"He","Xiang","H",7,9
,16,192, 0, 0, 0),
(99,"Muller","Camille","F",15,3
,8,193, 0, 0, 0),
(100,"Wolf","Jonas","H",10,10
,3,194, 0, 0, 0),
(100,"Garcia","Lola","F",9,9
,13,195, 0, 0, 0),
(100,"Saito","Ryota","F",13,17
,12,196, 0, 0, 0),
(100,"Kobayashi","Daiki","H",14,20
,20,197, 0, 0, 0),
(100,"Wang","Xue","F",15,18
,11,198, 0, 0, 0),
(101,"Vincent","Sarah","H",4,9
,20,199, 0, 0, 0),
(102,"Barbier","Nolan","H",17,9
,17,200, 0, 0, 0),
(102,"Saito","Mio","H",5,2
,17,201, 0, 0, 0),
(103,"Hu","Xu","H",20,11
,7,202, 0, 0, 0),
(103,"Mori","Mio","H",12,8
,13,203, 0, 0, 0),
(104,"Zhao","Xia","F",3,20
,6,204, 0, 0, 0),
(105,"Zhou","Shuang","F",5,10
,13,205, 0, 0, 0),
(105,"Shibata","Sora","F",20,1
,11,206, 0, 0, 0),
(106,"Matsumoto","Shiori","H",10,14
,6,207, 0, 0, 0),
(107,"Huang","Liu","F",14,4
,15,208, 0, 0, 0),
(108,"Kondo","Sora","H",11,14
,9,209, 0, 0, 0),
(109,"Wu","Ling","H",6,11
,13,210, 0, 0, 0),
(110,"Nakamura","Kaito","F",6,6
,4,211, 0, 0, 0),
(111,"Sasaki","Saki","F",13,3
,2,212, 0, 0, 0),
(111,"Kimura","Asuka","H",2,18
,6,213, 0, 0, 0),
(111,"Schulz","Jakob","F",19,7
,16,214, 0, 0, 0),
(112,"Zhao","Min","H",11,18
,8,215, 0, 0, 0),
(113,"Fujita","Yuto","H",2,3
,12,216, 0, 0, 0),
(114,"Dubois","Lola","H",2,11
,7,217, 0, 0, 0),
(114,"Morel","Tom","F",17,2
,10,218, 0, 0, 0),
(114,"Sato","Yuto","F",11,18
,15,219, 0, 0, 0),
(115,"Roux","Léna","F",15,5
,14,220, 0, 0, 0),
(115,"Goto","Akira","F",6,8
,20,221, 0, 0, 0),
(115,"Robin","Louis","H",10,5
,8,222, 0, 0, 0),
(115,"Kobayashi","Akira","H",2,10
,9,223, 0, 0, 0),
(116,"Kimura","Ryota","F",1,6
,3,224, 0, 0, 0),
(117,"Zhao","Xin","F",6,11
,17,225, 0, 0, 0),
(118,"Schulze","Maja","F",13,18
,9,226, 0, 0, 0),
(118,"Schmitz","Hannah","H",10,16
,8,227, 0, 0, 0),
(119,"Martin","Ethan","H",14,4
,7,228, 0, 0, 0),
(120,"Garcia","Inès","H",10,2
,3,229, 0, 0, 0),
(121,"Liu","Hu","F",19,18
,2,230, 0, 0, 0),
(122,"Sato","Hiroshi","F",14,4
,6,231, 0, 0, 0),
(123,"Ma","Xue","H",10,1
,20,232, 0, 0, 0),
(124,"Wang","Guo","F",16,16
,18,233, 0, 0, 0),
(124,"Lin","Jing","F",18,14
,10,234, 0, 0, 0),
(125,"Ito","Kazuki","H",3,10
,6,235, 0, 0, 0),
(126,"Lin","Hong","F",17,13
,4,236, 0, 0, 0),
(126,"Xu","Yan","F",15,18
,6,237, 0, 0, 0),
(126,"Sato","Shiori","H",4,3
,8,238, 0, 0, 0),
(127,"Wang","Shuang","H",15,6
,17,239, 0, 0, 0),
(127,"Richter","Lea","F",5,7
,4,240, 0, 0, 0),
(128,"Shibata","Naoki","F",17,18
,9,241, 0, 0, 0),
(129,"Saito","Haruto","F",3,4
,11,242, 0, 0, 0),
(130,"Rousseau","Raphaël","H",13,1
,15,243, 0, 0, 0),
(131,"Meier","Jonas","H",13,10
,1,244, 0, 0, 0),
(132,"Yamada","Takeshi","H",19,19
,1,245, 0, 0, 0),
(132,"Zhu","Hong","F",15,15
,9,246, 0, 0, 0),
(133,"Schwarz","Emilia","H",2,5
,20,247, 0, 0, 0),
(134,"Gao","Chen","H",3,2
,17,248, 0, 0, 0),
(134,"Leroy","Ethan","H",7,18
,14,249, 0, 0, 0),
(135,"Yamada","Ren","H",4,8
,11,250, 0, 0, 0),
(135,"Garcia","Camille","H",8,5
,9,251, 0, 0, 0),
(135,"Saito","Daiki","H",2,5
,16,252, 0, 0, 0),
(135,"Krause","Lena","F",13,13
,17,253, 0, 0, 0),
(136,"Moreau","Emma","H",16,16
,5,254, 0, 0, 0),
(137,"Vincent","Clara","H",8,5
,15,255, 0, 0, 0),
(137,"Fournier","Paul","H",13,4
,14,256, 0, 0, 0),
(138,"Roux","Tom","F",14,17
,9,257, 0, 0, 0),
(138,"Lange","Lena","F",6,15
,15,258, 0, 0, 0),
(138,"Michel","Mathis","F",5,20
,18,259, 0, 0, 0),
(139,"Faure","Sacha","H",7,14
,9,260, 0, 0, 0),
(140,"Hasegawa","Yuna","F",12,6
,15,261, 0, 0, 0),
(140,"Zhu","Yan","H",14,1
,14,262, 0, 0, 0),
(140,"Kondo","Yui","H",14,5
,5,263, 0, 0, 0),
(140,"Xu","Xue","F",8,3
,16,264, 0, 0, 0),
(140,"Zhang","Lan","F",2,20
,12,265, 0, 0, 0),
(141,"Shimizu","Hinata","H",10,12
,13,266, 0, 0, 0),
(142,"Hu","Zhu","H",14,10
,3,267, 0, 0, 0),
(143,"Sun","Wei","H",14,8
,7,268, 0, 0, 0),
(143,"Herrmann","Tim","H",3,20
,10,269, 0, 0, 0),
(144,"Matsumoto","Asuka","F",19,11
,5,270, 0, 0, 0),
(144,"Zhang","Wang","F",15,1
,3,271, 0, 0, 0),
(144,"Zhao","Min","F",11,6
,16,272, 0, 0, 0),
(145,"Sasaki","Akira","H",9,12
,7,273, 0, 0, 0),
(145,"Maeda","Kokoro","H",11,17
,4,274, 0, 0, 0),
(146,"Gao","Wang","H",7,15
,13,275, 0, 0, 0),
(147,"Ma","Hu","H",8,12
,6,276, 0, 0, 0),
(148,"Martin","Zoé","H",7,17
,3,277, 0, 0, 0),
(149,"Watanabe","Ren","H",20,9
,11,278, 0, 0, 0),
(150,"Huang","Ting","H",13,5
,15,279, 0, 0, 0),
(150,"Tanaka","Takeshi","F",13,14
,5,280, 0, 0, 0),
(150,"Sato","Haruka","F",15,9
,12,281, 0, 0, 0),
(150,"Dubois","Arthur","H",13,3
,10,282, 0, 0, 0),
(150,"Richard","Nolan","F",2,4
,9,283, 0, 0, 0),
(151,"Hu","Huang","H",14,1
,12,284, 0, 0, 0),
(152,"Mori","Sakura","F",5,10
,16,285, 0, 0, 0),
(153,"Xu","Ling","H",4,14
,19,286, 0, 0, 0),
(154,"Hayashi","Hiroshi","F",11,17
,20,287, 0, 0, 0),
(155,"Vincent","Inès","H",20,12
,20,288, 0, 0, 0),
(156,"Zhao","Lan","H",19,5
,18,289, 0, 0, 0),
(157,"Sato","Akira","H",19,20
,12,290, 0, 0, 0),
(158,"Fournier","Alice","F",2,2
,3,291, 0, 0, 0),
(158,"Richter","Niklas","F",5,8
,17,292, 0, 0, 0),
(158,"Klein","Lukas","H",19,15
,16,293, 0, 0, 0),
(159,"Maeda","Akira","H",9,18
,6,294, 0, 0, 0),
(159,"Huang","Hong","F",11,1
,1,295, 0, 0, 0),
(160,"Richard","Noé","F",12,9
,14,296, 0, 0, 0),
(160,"Wang","Ling","F",5,9
,8,297, 0, 0, 0),
(161,"Richard","Nolan","H",13,1
,6,298, 0, 0, 0),
(161,"Hasegawa","Saki","F",9,8
,6,299, 0, 0, 0),
(161,"Ma","Lan","F",11,11
,9,300, 0, 0, 0),
(162,"Lambert","Camille","H",1,14
,3,301, 0, 0, 0),
(162,"Saito","Rina","H",5,13
,18,302, 0, 0, 0),
(163,"Yang","Ma","F",8,3
,20,303, 0, 0, 0),
(164,"Moreau","Anna","H",3,5
,10,304, 0, 0, 0),
(165,"He","Hu","H",4,19
,12,305, 0, 0, 0),
(165,"Meier","Elias","F",14,16
,14,306, 0, 0, 0),
(166,"Mercier","Chloé","F",7,19
,16,307, 0, 0, 0),
(166,"Zhang","Hong","H",13,20
,17,308, 0, 0, 0),
(167,"Blanc","Paul","F",6,4
,15,309, 0, 0, 0),
(168,"Saito","Takumi","H",16,5
,20,310, 0, 0, 0),
(168,"Mori","Ryota","F",4,16
,4,311, 0, 0, 0),
(168,"Schmitt","David","H",4,15
,5,312, 0, 0, 0),
(168,"Lefebvre","Mathis","H",8,6
,10,313, 0, 0, 0),
(169,"Guo","Shuang","F",19,12
,18,314, 0, 0, 0),
(169,"Schmitt","David","F",1,11
,12,315, 0, 0, 0),
(170,"Chen","Jing","H",16,18
,9,316, 0, 0, 0),
(170,"Hasegawa","Kaito","H",15,9
,15,317, 0, 0, 0),
(170,"Huang","Zhu","H",18,17
,11,318, 0, 0, 0),
(171,"Mori","Naoki","F",5,1
,6,319, 0, 0, 0),
(172,"Sakai","Aoi","H",9,2
,2,320, 0, 0, 0),
(172,"Takahashi","Saki","F",2,12
,20,321, 0, 0, 0),
(173,"Robert","Manon","F",3,7
,14,322, 0, 0, 0),
(174,"Leroy","Louis","F",2,4
,3,323, 0, 0, 0),
(175,"Shimizu","Asuka","F",15,12
,6,324, 0, 0, 0),
(175,"Sato","Takumi","F",9,11
,5,325, 0, 0, 0),
(176,"Takahashi","Yuna","F",16,6
,11,326, 0, 0, 0),
(177,"Shibata","Ryota","H",8,10
,11,327, 0, 0, 0),
(178,"Schulze","Anna","F",14,9
,15,328, 0, 0, 0),
(179,"Goto","Riko","H",19,8
,10,329, 0, 0, 0),
(180,"Li","Chen","H",13,3
,1,330, 0, 0, 0),
(180,"Lefebvre","Emma","H",16,5
,11,331, 0, 0, 0),
(180,"Richard","Emma","H",9,11
,15,332, 0, 0, 0),
(180,"Leroy","Jules","H",20,20
,2,333, 0, 0, 0),
(181,"Watanabe","Yusuke","F",1,18
,16,334, 0, 0, 0),
(182,"Guo","Zhou","H",8,18
,16,335, 0, 0, 0),
(183,"Mercier","Camille","H",7,16
,1,336, 0, 0, 0),
(183,"Fujita","Nana","H",17,7
,5,337, 0, 0, 0),
(183,"Matsumoto","Asuka","H",11,9
,17,338, 0, 0, 0),
(184,"Inoue","Riko","F",4,2
,12,339, 0, 0, 0),
(185,"Sato","Hiroshi","F",12,5
,11,340, 0, 0, 0),
(186,"Takahashi","Haruto","F",4,12
,7,341, 0, 0, 0),
(186,"Roux","Ethan","F",5,20
,8,342, 0, 0, 0),
(186,"Suzuki","Naoki","F",15,19
,9,343, 0, 0, 0),
(186,"Ogawa","Yuma","H",19,13
,17,344, 0, 0, 0),
(186,"Thomas","Hugo","H",20,9
,20,345, 0, 0, 0),
(187,"Perez","Paul","F",7,12
,7,346, 0, 0, 0),
(187,"Mercier","Clara","F",18,9
,13,347, 0, 0, 0),
(188,"Yang","Hui","F",1,15
,7,348, 0, 0, 0),
(189,"Kondo","Takumi","F",13,10
,12,349, 0, 0, 0),
(189,"Kondo","Yuto","F",19,11
,17,350, 0, 0, 0),
(189,"Ito","Yuto","H",14,9
,3,351, 0, 0, 0),
(190,"Yamamoto","Daiki","F",19,17
,19,352, 0, 0, 0),
(191,"Blanc","Emma","F",10,17
,18,353, 0, 0, 0),
(191,"Ito","Hinata","H",17,16
,4,354, 0, 0, 0),
(192,"Sasaki","Hiroshi","F",4,8
,13,355, 0, 0, 0),
(193,"Hayashi","Hinata","H",5,17
,9,356, 0, 0, 0),
(193,"Wu","Xue","H",14,16
,2,357, 0, 0, 0),
(193,"Yoshida","Aoi","H",19,19
,8,358, 0, 0, 0),
(194,"Hayashi","Ren","F",13,16
,7,359, 0, 0, 0),
(195,"Xu","Yan","H",19,17
,19,360, 0, 0, 0),
(196,"Shibata","Kokoro","H",16,18
,5,361, 0, 0, 0);

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
(35,"Australie_Natation relais libre_H", "AUS", 0, 0, 0),
(36,"Japon_Athlétisme relais 400m_F", "JPN", 0, 0, 0),
(37,"France_Escrime fleuret_F_S15", "FRA", 0, 0, 0),
(38,"Chine_Volley-Ball_F", "CHN", 0, 0, 0),
(39,"Brésil_Escrime épée_F_S16", "BRA", 0, 0, 0),
(40,"Australie_Escrime fleuret_H_S17", "AUS", 0, 0, 0),
(41,"Maroc_Volley-Ball_F", "MAR", 0, 0, 0),
(42,"USA_Natation 100 brasse_H_S18", "USA", 0, 0, 0),
(43,"Chine_Escrime épée_F_S19", "CHN", 0, 0, 0),
(44,"Maroc_Handball_F", "MAR", 0, 0, 0),
(45,"Kenya_Escrime fleuret_H_S20", "KEN", 0, 0, 0),
(46,"Australie_Athlétisme relais 400m_F", "AUS", 0, 0, 0),
(47,"Turquie_Athlétisme relais 400m_H", "TUR", 0, 0, 0),
(48,"Japon_Athlétisme relais 400m_H", "JPN", 0, 0, 0),
(49,"Allemagne_Volley-Ball_H", "DEU", 0, 0, 0),
(50,"USA_Athlétisme relais 400m_F", "USA", 0, 0, 0),
(51,"Maroc_Natation 100 brasse_H_S21", "MAR", 0, 0, 0),
(52,"Brésil_Natation relais libre_F", "BRA", 0, 0, 0),
(53,"Brésil_Volley-Ball_F", "BRA", 0, 0, 0),
(54,"Turquie_Escrime fleuret_F_S22", "TUR", 0, 0, 0),
(55,"Brésil_Natation 100 brasse_H_S23", "BRA", 0, 0, 0),
(56,"Japon_Escrime épée_F_S24", "JPN", 0, 0, 0),
(57,"Kenya_Natation 100 brasse_H_S25", "KEN", 0, 0, 0),
(58,"Allemagne_Escrime fleuret_H_S26", "DEU", 0, 0, 0),
(59,"France_Escrime épée_H_S27", "FRA", 0, 0, 0),
(60,"Brésil_Volley-Ball_F", "BRA", 0, 0, 0),
(61,"Brésil_Natation 100 brasse_H_S28", "BRA", 0, 0, 0),
(62,"Australie_Volley-Ball_F", "AUS", 0, 0, 0),
(63,"Kenya_Natation relais libre_F", "KEN", 0, 0, 0),
(64,"Kenya_Natation relais libre_H", "KEN", 0, 0, 0),
(65,"Allemagne_Natation relais libre_F", "DEU", 0, 0, 0),
(66,"Allemagne_Escrime épée_F_S29", "DEU", 0, 0, 0),
(67,"Brésil_Escrime épée_H_S30", "BRA", 0, 0, 0),
(68,"France_Natation 100 brasse_H_S31", "FRA", 0, 0, 0),
(69,"Kenya_Natation relais libre_F", "KEN", 0, 0, 0),
(70,"Japon_Natation 100 brasse_H_S32", "JPN", 0, 0, 0),
(71,"Japon_Escrime fleuret_F_S33", "JPN", 0, 0, 0),
(72,"Brésil_Volley-Ball_F", "BRA", 0, 0, 0),
(73,"Brésil_Escrime épée_H_S34", "BRA", 0, 0, 0),
(74,"Allemagne_Escrime fleuret_F_S35", "DEU", 0, 0, 0),
(75,"Allemagne_Volley-Ball_H", "DEU", 0, 0, 0),
(76,"Chine_Escrime épée_H_S36", "CHN", 0, 0, 0),
(77,"Chine_Escrime épée_H_S37", "CHN", 0, 0, 0),
(78,"Brésil_Natation relais libre_F", "BRA", 0, 0, 0),
(79,"Chine_Volley-Ball_F", "CHN", 0, 0, 0),
(80,"France_Natation relais libre_F", "FRA", 0, 0, 0),
(81,"USA_Athlétisme relais 400m_H", "USA", 0, 0, 0),
(82,"France_Escrime fleuret_F_S38", "FRA", 0, 0, 0),
(83,"Kenya_Escrime épée_H_S39", "KEN", 0, 0, 0),
(84,"Kenya_Athlétisme relais 400m_H", "KEN", 0, 0, 0),
(85,"Japon_Escrime épée_H_S40", "JPN", 0, 0, 0),
(86,"Kenya_Volley-Ball_H", "KEN", 0, 0, 0),
(87,"Australie_Natation 100 brasse_F_S41", "AUS", 0, 0, 0),
(88,"Brésil_Escrime fleuret_F_S42", "BRA", 0, 0, 0),
(89,"Kenya_Escrime fleuret_F_S43", "KEN", 0, 0, 0),
(90,"Australie_Athlétisme relais 400m_H", "AUS", 0, 0, 0),
(91,"Brésil_Natation relais libre_H", "BRA", 0, 0, 0),
(92,"Turquie_Athlétisme relais 400m_H", "TUR", 0, 0, 0),
(93,"Turquie_Natation relais libre_H", "TUR", 0, 0, 0),
(94,"Kenya_Athlétisme relais 400m_F", "KEN", 0, 0, 0),
(95,"Turquie_Escrime fleuret_F_S44", "TUR", 0, 0, 0),
(96,"USA_Volley-Ball_H", "USA", 0, 0, 0),
(97,"Kenya_Volley-Ball_F", "KEN", 0, 0, 0),
(98,"Australie_Handball_F", "AUS", 0, 0, 0),
(99,"Brésil_Athlétisme relais 400m_H", "BRA", 0, 0, 0),
(100,"Turquie_Escrime épée_H_S45", "TUR", 0, 0, 0),
(101,"USA_Athlétisme relais 400m_F", "USA", 0, 0, 0),
(102,"Allemagne_Natation 100 brasse_H_S46", "DEU", 0, 0, 0),
(103,"Brésil_Handball_F", "BRA", 0, 0, 0),
(104,"Japon_Escrime épée_H_S47", "JPN", 0, 0, 0),
(105,"Japon_Escrime fleuret_H_S48", "JPN", 0, 0, 0),
(106,"Chine_Athlétisme relais 400m_H", "CHN", 0, 0, 0),
(107,"Chine_Escrime fleuret_H_S49", "CHN", 0, 0, 0),
(108,"Allemagne_Escrime épée_H_S50", "DEU", 0, 0, 0),
(109,"USA_Natation relais libre_F", "USA", 0, 0, 0),
(110,"Allemagne_Athlétisme relais 400m_H", "DEU", 0, 0, 0),
(111,"Kenya_Athlétisme relais 400m_H", "KEN", 0, 0, 0),
(112,"USA_Escrime fleuret_H_S51", "USA", 0, 0, 0),
(113,"Australie_Natation 100 brasse_F_S52", "AUS", 0, 0, 0),
(114,"Turquie_Escrime fleuret_F_S53", "TUR", 0, 0, 0),
(115,"Japon_Handball_F", "JPN", 0, 0, 0),
(116,"Kenya_Escrime épée_H_S54", "KEN", 0, 0, 0),
(117,"France_Volley-Ball_H", "FRA", 0, 0, 0),
(118,"Australie_Natation 100 brasse_H_S55", "AUS", 0, 0, 0),
(119,"Kenya_Natation 100 brasse_F_S56", "KEN", 0, 0, 0),
(120,"USA_Natation 100 brasse_F_S57", "USA", 0, 0, 0),
(121,"USA_Escrime fleuret_F_S58", "USA", 0, 0, 0),
(122,"Allemagne_Volley-Ball_F", "DEU", 0, 0, 0),
(123,"Japon_Handball_H", "JPN", 0, 0, 0),
(124,"USA_Handball_F", "USA", 0, 0, 0),
(125,"Brésil_Natation relais libre_F", "BRA", 0, 0, 0),
(126,"Australie_Natation relais libre_F", "AUS", 0, 0, 0),
(127,"Chine_Natation 100 brasse_H_S59", "CHN", 0, 0, 0),
(128,"Australie_Natation relais libre_H", "AUS", 0, 0, 0),
(129,"Australie_Escrime épée_F_S60", "AUS", 0, 0, 0),
(130,"France_Natation relais libre_F", "FRA", 0, 0, 0),
(131,"Chine_Escrime fleuret_F_S61", "CHN", 0, 0, 0),
(132,"Allemagne_Escrime fleuret_F_S62", "DEU", 0, 0, 0),
(133,"Japon_Natation relais libre_H", "JPN", 0, 0, 0),
(134,"Australie_Athlétisme relais 400m_H", "AUS", 0, 0, 0),
(135,"Kenya_Escrime fleuret_H_S63", "KEN", 0, 0, 0),
(136,"Maroc_Handball_F", "MAR", 0, 0, 0),
(137,"Turquie_Escrime épée_H_S64", "TUR", 0, 0, 0),
(138,"Brésil_Athlétisme relais 400m_F", "BRA", 0, 0, 0),
(139,"Allemagne_Volley-Ball_H", "DEU", 0, 0, 0),
(140,"Japon_Natation relais libre_F", "JPN", 0, 0, 0),
(141,"France_Athlétisme relais 400m_F", "FRA", 0, 0, 0),
(142,"Chine_Athlétisme relais 400m_F", "CHN", 0, 0, 0),
(143,"Japon_Athlétisme relais 400m_F", "JPN", 0, 0, 0),
(144,"Maroc_Volley-Ball_H", "MAR", 0, 0, 0),
(145,"Maroc_Escrime épée_F_S65", "MAR", 0, 0, 0),
(146,"Australie_Escrime fleuret_F_S66", "AUS", 0, 0, 0),
(147,"Australie_Volley-Ball_F", "AUS", 0, 0, 0),
(148,"Allemagne_Natation relais libre_H", "DEU", 0, 0, 0),
(149,"Australie_Escrime épée_F_S67", "AUS", 0, 0, 0),
(150,"Allemagne_Natation 100 brasse_H_S68", "DEU", 0, 0, 0),
(151,"France_Escrime épée_F_S69", "FRA", 0, 0, 0),
(152,"USA_Natation relais libre_F", "USA", 0, 0, 0),
(153,"Kenya_Natation relais libre_H", "KEN", 0, 0, 0),
(154,"Allemagne_Natation relais libre_F", "DEU", 0, 0, 0),
(155,"USA_Escrime fleuret_H_S70", "USA", 0, 0, 0),
(156,"Australie_Escrime fleuret_H_S71", "AUS", 0, 0, 0),
(157,"Turquie_Escrime fleuret_F_S72", "TUR", 0, 0, 0),
(158,"Maroc_Natation 100 brasse_H_S73", "MAR", 0, 0, 0),
(159,"Japon_Handball_H", "JPN", 0, 0, 0),
(160,"Allemagne_Natation 100 brasse_H_S74", "DEU", 0, 0, 0),
(161,"USA_Escrime épée_F_S75", "USA", 0, 0, 0),
(162,"USA_Athlétisme relais 400m_H", "USA", 0, 0, 0),
(163,"Japon_Natation relais libre_H", "JPN", 0, 0, 0),
(164,"Japon_Escrime fleuret_H_S76", "JPN", 0, 0, 0),
(165,"USA_Natation 100 brasse_F_S77", "USA", 0, 0, 0),
(166,"France_Escrime fleuret_H_S78", "FRA", 0, 0, 0),
(167,"Japon_Natation 100 brasse_F_S79", "JPN", 0, 0, 0),
(168,"Kenya_Escrime épée_H_S80", "KEN", 0, 0, 0),
(169,"Chine_Athlétisme relais 400m_F", "CHN", 0, 0, 0),
(170,"USA_Natation relais libre_H", "USA", 0, 0, 0),
(171,"Allemagne_Escrime épée_H_S81", "DEU", 0, 0, 0),
(172,"Chine_Natation 100 brasse_H_S82", "CHN", 0, 0, 0),
(173,"USA_Natation 100 brasse_F_S83", "USA", 0, 0, 0),
(174,"Chine_Athlétisme relais 400m_H", "CHN", 0, 0, 0),
(175,"USA_Natation 100 brasse_H_S84", "USA", 0, 0, 0),
(176,"USA_Escrime fleuret_F_S85", "USA", 0, 0, 0),
(177,"Chine_Athlétisme relais 400m_H", "CHN", 0, 0, 0),
(178,"Turquie_Escrime épée_H_S86", "TUR", 0, 0, 0),
(179,"USA_Escrime épée_F_S87", "USA", 0, 0, 0),
(180,"USA_Natation relais libre_H", "USA", 0, 0, 0),
(181,"Maroc_Escrime épée_F_S88", "MAR", 0, 0, 0),
(182,"Maroc_Escrime épée_F_S89", "MAR", 0, 0, 0),
(183,"Chine_Escrime fleuret_F_S90", "CHN", 0, 0, 0),
(184,"Kenya_Volley-Ball_F", "KEN", 0, 0, 0),
(185,"Australie_Escrime épée_F_S91", "AUS", 0, 0, 0),
(186,"Maroc_Natation relais libre_H", "MAR", 0, 0, 0),
(187,"Brésil_Natation relais libre_F", "BRA", 0, 0, 0),
(188,"Japon_Escrime épée_H_S92", "JPN", 0, 0, 0),
(189,"Kenya_Volley-Ball_H", "KEN", 0, 0, 0),
(190,"Allemagne_Escrime épée_F_S93", "DEU", 0, 0, 0),
(191,"Allemagne_Handball_F", "DEU", 0, 0, 0),
(192,"Japon_Escrime épée_H_S94", "JPN", 0, 0, 0),
(193,"USA_Handball_F", "USA", 0, 0, 0),
(194,"Brésil_Natation 100 brasse_H_S95", "BRA", 0, 0, 0),
(195,"Allemagne_Escrime épée_F_S96", "DEU", 0, 0, 0),
(196,"Maroc_Escrime fleuret_F_S97", "MAR", 0, 0, 0),
(197,"Japon_Natation 100 brasse_H_S98", "JPN", 0, 0, 0),
(198,"Brésil_Natation relais libre_F", "BRA", 0, 0, 0),
(199,"Australie_Volley-Ball_H", "AUS", 0, 0, 0),
(200,"Maroc_Escrime fleuret_H_S99", "MAR", 0, 0, 0),
(201,"Japon_Natation relais libre_H", "JPN", 0, 0, 0),
(202,"Japon_Escrime épée_H_S100", "JPN", 0, 0, 0),
(203,"Chine_Athlétisme relais 400m_H", "CHN", 0, 0, 0),
(204,"Brésil_Athlétisme relais 400m_F", "BRA", 0, 0, 0),
(205,"France_Escrime fleuret_F_S101", "FRA", 0, 0, 0),
(206,"Australie_Athlétisme relais 400m_F", "AUS", 0, 0, 0),
(207,"Chine_Natation relais libre_H", "CHN", 0, 0, 0),
(208,"Brésil_Athlétisme relais 400m_F", "BRA", 0, 0, 0),
(209,"Australie_Natation relais libre_H", "AUS", 0, 0, 0),
(210,"France_Athlétisme relais 400m_H", "FRA", 0, 0, 0),
(211,"Kenya_Athlétisme relais 400m_F", "KEN", 0, 0, 0),
(212,"Kenya_Natation 100 brasse_F_S102", "KEN", 0, 0, 0),
(213,"Allemagne_Escrime épée_H_S103", "DEU", 0, 0, 0),
(214,"Brésil_Athlétisme relais 400m_F", "BRA", 0, 0, 0),
(215,"Kenya_Volley-Ball_H", "KEN", 0, 0, 0),
(216,"Maroc_Handball_H", "MAR", 0, 0, 0),
(217,"Chine_Natation 100 brasse_H_S104", "CHN", 0, 0, 0),
(218,"Allemagne_Natation 100 brasse_F_S105", "DEU", 0, 0, 0),
(219,"Brésil_Volley-Ball_F", "BRA", 0, 0, 0),
(220,"Brésil_Escrime fleuret_F_S106", "BRA", 0, 0, 0),
(221,"Allemagne_Escrime fleuret_F_S107", "DEU", 0, 0, 0),
(222,"Allemagne_Escrime épée_H_S108", "DEU", 0, 0, 0),
(223,"USA_Natation relais libre_H", "USA", 0, 0, 0),
(224,"Maroc_Athlétisme relais 400m_F", "MAR", 0, 0, 0),
(225,"Maroc_Volley-Ball_F", "MAR", 0, 0, 0),
(226,"Maroc_Escrime fleuret_F_S109", "MAR", 0, 0, 0),
(227,"Australie_Athlétisme relais 400m_H", "AUS", 0, 0, 0),
(228,"Allemagne_Volley-Ball_H", "DEU", 0, 0, 0),
(229,"Australie_Natation relais libre_H", "AUS", 0, 0, 0),
(230,"Chine_Athlétisme relais 400m_F", "CHN", 0, 0, 0),
(231,"Australie_Handball_F", "AUS", 0, 0, 0),
(232,"Turquie_Volley-Ball_H", "TUR", 0, 0, 0),
(233,"France_Escrime épée_F_S110", "FRA", 0, 0, 0),
(234,"France_Handball_F", "FRA", 0, 0, 0),
(235,"Maroc_Volley-Ball_H", "MAR", 0, 0, 0),
(236,"France_Natation 100 brasse_F_S111", "FRA", 0, 0, 0),
(237,"Maroc_Natation 100 brasse_F_S112", "MAR", 0, 0, 0),
(238,"Maroc_Natation relais libre_H", "MAR", 0, 0, 0),
(239,"Allemagne_Escrime épée_H_S113", "DEU", 0, 0, 0),
(240,"Chine_Handball_F", "CHN", 0, 0, 0),
(241,"Chine_Handball_F", "CHN", 0, 0, 0),
(242,"USA_Athlétisme relais 400m_F", "USA", 0, 0, 0),
(243,"Maroc_Athlétisme relais 400m_H", "MAR", 0, 0, 0),
(244,"Allemagne_Natation relais libre_H", "DEU", 0, 0, 0),
(245,"USA_Escrime épée_H_S114", "USA", 0, 0, 0),
(246,"USA_Volley-Ball_F", "USA", 0, 0, 0),
(247,"USA_Handball_H", "USA", 0, 0, 0),
(248,"Chine_Escrime fleuret_H_S115", "CHN", 0, 0, 0),
(249,"Allemagne_Athlétisme relais 400m_H", "DEU", 0, 0, 0),
(250,"Chine_Escrime fleuret_H_S116", "CHN", 0, 0, 0),
(251,"Turquie_Escrime épée_H_S117", "TUR", 0, 0, 0),
(252,"Australie_Escrime fleuret_H_S118", "AUS", 0, 0, 0),
(253,"Brésil_Athlétisme relais 400m_F", "BRA", 0, 0, 0),
(254,"USA_Athlétisme relais 400m_H", "USA", 0, 0, 0),
(255,"Kenya_Escrime fleuret_H_S119", "KEN", 0, 0, 0),
(256,"France_Athlétisme relais 400m_H", "FRA", 0, 0, 0),
(257,"Australie_Natation 100 brasse_F_S120", "AUS", 0, 0, 0),
(258,"Kenya_Escrime fleuret_F_S121", "KEN", 0, 0, 0),
(259,"Allemagne_Handball_F", "DEU", 0, 0, 0),
(260,"France_Natation relais libre_H", "FRA", 0, 0, 0),
(261,"Australie_Escrime fleuret_F_S122", "AUS", 0, 0, 0),
(262,"Chine_Escrime fleuret_H_S123", "CHN", 0, 0, 0),
(263,"Chine_Natation 100 brasse_H_S124", "CHN", 0, 0, 0),
(264,"Turquie_Escrime épée_F_S125", "TUR", 0, 0, 0),
(265,"Allemagne_Volley-Ball_F", "DEU", 0, 0, 0),
(266,"Turquie_Handball_H", "TUR", 0, 0, 0),
(267,"Turquie_Natation relais libre_H", "TUR", 0, 0, 0),
(268,"Chine_Escrime épée_H_S126", "CHN", 0, 0, 0),
(269,"Turquie_Volley-Ball_H", "TUR", 0, 0, 0),
(270,"Brésil_Escrime épée_F_S127", "BRA", 0, 0, 0),
(271,"Australie_Escrime épée_F_S128", "AUS", 0, 0, 0),
(272,"Turquie_Athlétisme relais 400m_F", "TUR", 0, 0, 0),
(273,"Brésil_Escrime fleuret_H_S129", "BRA", 0, 0, 0),
(274,"France_Athlétisme relais 400m_H", "FRA", 0, 0, 0),
(275,"Maroc_Handball_H", "MAR", 0, 0, 0),
(276,"Brésil_Volley-Ball_H", "BRA", 0, 0, 0),
(277,"Maroc_Natation relais libre_H", "MAR", 0, 0, 0),
(278,"Allemagne_Handball_H", "DEU", 0, 0, 0),
(279,"Allemagne_Escrime épée_H_S130", "DEU", 0, 0, 0),
(280,"France_Escrime épée_F_S131", "FRA", 0, 0, 0),
(281,"Allemagne_Escrime fleuret_F_S132", "DEU", 0, 0, 0),
(282,"France_Escrime épée_H_S133", "FRA", 0, 0, 0),
(283,"Turquie_Natation relais libre_F", "TUR", 0, 0, 0),
(284,"Allemagne_Natation relais libre_H", "DEU", 0, 0, 0),
(285,"USA_Athlétisme relais 400m_F", "USA", 0, 0, 0),
(286,"Kenya_Athlétisme relais 400m_H", "KEN", 0, 0, 0),
(287,"Chine_Athlétisme relais 400m_F", "CHN", 0, 0, 0),
(288,"Chine_Handball_H", "CHN", 0, 0, 0),
(289,"Chine_Volley-Ball_H", "CHN", 0, 0, 0),
(290,"Japon_Volley-Ball_H", "JPN", 0, 0, 0),
(291,"USA_Escrime épée_F_S134", "USA", 0, 0, 0),
(292,"Turquie_Escrime épée_F_S135", "TUR", 0, 0, 0),
(293,"Brésil_Natation relais libre_H", "BRA", 0, 0, 0),
(294,"Maroc_Natation 100 brasse_H_S136", "MAR", 0, 0, 0),
(295,"USA_Natation relais libre_F", "USA", 0, 0, 0),
(296,"France_Escrime épée_F_S137", "FRA", 0, 0, 0),
(297,"Maroc_Volley-Ball_F", "MAR", 0, 0, 0),
(298,"Kenya_Escrime fleuret_H_S138", "KEN", 0, 0, 0),
(299,"Chine_Escrime épée_F_S139", "CHN", 0, 0, 0),
(300,"Maroc_Volley-Ball_F", "MAR", 0, 0, 0),
(301,"France_Escrime fleuret_H_S140", "FRA", 0, 0, 0),
(302,"Brésil_Athlétisme relais 400m_H", "BRA", 0, 0, 0),
(303,"Australie_Athlétisme relais 400m_F", "AUS", 0, 0, 0),
(304,"Allemagne_Volley-Ball_H", "DEU", 0, 0, 0),
(305,"Chine_Natation 100 brasse_H_S141", "CHN", 0, 0, 0),
(306,"Australie_Natation relais libre_F", "AUS", 0, 0, 0),
(307,"Kenya_Natation 100 brasse_F_S142", "KEN", 0, 0, 0),
(308,"Allemagne_Athlétisme relais 400m_H", "DEU", 0, 0, 0),
(309,"Australie_Volley-Ball_F", "AUS", 0, 0, 0),
(310,"Brésil_Escrime épée_H_S143", "BRA", 0, 0, 0),
(311,"Brésil_Escrime fleuret_F_S144", "BRA", 0, 0, 0),
(312,"Chine_Escrime épée_H_S145", "CHN", 0, 0, 0),
(313,"Kenya_Natation relais libre_H", "KEN", 0, 0, 0),
(314,"Turquie_Natation 100 brasse_F_S146", "TUR", 0, 0, 0),
(315,"Brésil_Natation relais libre_F", "BRA", 0, 0, 0),
(316,"Brésil_Natation 100 brasse_H_S147", "BRA", 0, 0, 0),
(317,"USA_Natation 100 brasse_H_S148", "USA", 0, 0, 0),
(318,"Australie_Volley-Ball_H", "AUS", 0, 0, 0),
(319,"Chine_Natation relais libre_F", "CHN", 0, 0, 0),
(320,"Japon_Natation 100 brasse_H_S149", "JPN", 0, 0, 0),
(321,"Chine_Handball_F", "CHN", 0, 0, 0),
(322,"Kenya_Athlétisme relais 400m_F", "KEN", 0, 0, 0),
(323,"USA_Handball_F", "USA", 0, 0, 0),
(324,"Allemagne_Natation 100 brasse_F_S150", "DEU", 0, 0, 0),
(325,"Brésil_Natation relais libre_F", "BRA", 0, 0, 0),
(326,"Australie_Athlétisme relais 400m_F", "AUS", 0, 0, 0),
(327,"USA_Volley-Ball_H", "USA", 0, 0, 0),
(328,"Maroc_Athlétisme relais 400m_F", "MAR", 0, 0, 0),
(329,"Maroc_Natation relais libre_H", "MAR", 0, 0, 0),
(330,"Allemagne_Natation 100 brasse_H_S151", "DEU", 0, 0, 0),
(331,"Allemagne_Escrime épée_H_S152", "DEU", 0, 0, 0),
(332,"Turquie_Escrime épée_H_S153", "TUR", 0, 0, 0),
(333,"Turquie_Athlétisme relais 400m_H", "TUR", 0, 0, 0),
(334,"Brésil_Athlétisme relais 400m_F", "BRA", 0, 0, 0),
(335,"France_Natation relais libre_H", "FRA", 0, 0, 0),
(336,"Kenya_Escrime épée_H_S154", "KEN", 0, 0, 0),
(337,"Chine_Escrime épée_H_S155", "CHN", 0, 0, 0),
(338,"Kenya_Natation relais libre_H", "KEN", 0, 0, 0),
(339,"Kenya_Athlétisme relais 400m_F", "KEN", 0, 0, 0),
(340,"Japon_Natation relais libre_F", "JPN", 0, 0, 0),
(341,"Australie_Natation 100 brasse_F_S156", "AUS", 0, 0, 0),
(342,"France_Natation 100 brasse_F_S157", "FRA", 0, 0, 0),
(343,"Kenya_Escrime épée_F_S158", "KEN", 0, 0, 0),
(344,"Australie_Escrime fleuret_H_S159", "AUS", 0, 0, 0),
(345,"Turquie_Handball_H", "TUR", 0, 0, 0),
(346,"Turquie_Natation 100 brasse_F_S160", "TUR", 0, 0, 0),
(347,"France_Natation relais libre_F", "FRA", 0, 0, 0),
(348,"Brésil_Handball_F", "BRA", 0, 0, 0),
(349,"Australie_Escrime épée_F_S161", "AUS", 0, 0, 0),
(350,"Kenya_Escrime épée_F_S162", "KEN", 0, 0, 0),
(351,"Brésil_Volley-Ball_H", "BRA", 0, 0, 0),
(352,"France_Athlétisme relais 400m_F", "FRA", 0, 0, 0),
(353,"Brésil_Escrime fleuret_F_S163", "BRA", 0, 0, 0),
(354,"Maroc_Handball_H", "MAR", 0, 0, 0),
(355,"Kenya_Handball_F", "KEN", 0, 0, 0),
(356,"Kenya_Escrime fleuret_H_S164", "KEN", 0, 0, 0),
(357,"France_Escrime fleuret_H_S165", "FRA", 0, 0, 0),
(358,"Australie_Natation relais libre_H", "AUS", 0, 0, 0),
(359,"Kenya_Volley-Ball_F", "KEN", 0, 0, 0),
(360,"Maroc_Handball_H", "MAR", 0, 0, 0),
(361,"Brésil_Natation 100 brasse_H_S166", "BRA", 0, 0, 0);

INSERT INTO PARTICIPE VALUES 
("Natation 100 brasse homme", 12), 
("Natation 100 brasse homme", 16), 
("Natation 100 brasse homme", 28), 
("Natation 100 brasse homme", 35), 
("Natation 100 brasse homme", 42), 
("Natation 100 brasse homme", 46), 
("Natation 100 brasse homme", 59), 
("Natation 100 brasse homme", 62), 
("Natation 100 brasse homme", 89), 
("Natation 100 brasse homme", 103), 
("Natation 100 brasse homme", 113), 
("Natation 100 brasse homme", 121), 
("Natation 100 brasse homme", 150), 
("Natation 100 brasse homme", 155), 
("Natation 100 brasse homme", 174), 
("Natation 100 brasse homme", 184), 
("Natation 100 brasse homme", 185), 
("Natation 100 brasse homme", 186), 
("Natation 100 brasse homme", 187), 
("Natation 100 brasse homme", 203), 
("Natation 100 brasse homme", 205), 
("Natation 100 brasse homme", 219), 
("Natation 100 brasse homme", 222), 
("Natation 100 brasse homme", 266), 
("Natation relais libre homme", 6), 
("Natation relais libre homme", 24), 
("Natation relais libre homme", 39), 
("Natation relais libre homme", 40), 
("Natation relais libre homme", 61), 
("Natation relais libre homme", 65), 
("Natation relais libre homme", 101), 
("Natation relais libre homme", 111), 
("Natation relais libre homme", 215), 
("Natation relais libre homme", 272), 
("Handball homme", 4), 
("Handball homme", 5), 
("Handball homme", 8), 
("Handball homme", 91), 
("Handball homme", 96), 
("Handball homme", 99), 
("Handball homme", 100), 
("Handball homme", 193), 
("Handball homme", 216), 
("Volley-Ball homme", 11), 
("Volley-Ball homme", 45), 
("Volley-Ball homme", 50), 
("Volley-Ball homme", 58), 
("Volley-Ball homme", 72), 
("Volley-Ball homme", 125), 
("Volley-Ball homme", 145), 
("Volley-Ball homme", 154), 
("Escrime fleuret homme", 7), 
("Escrime fleuret homme", 10), 
("Escrime fleuret homme", 13), 
("Escrime fleuret homme", 26), 
("Escrime fleuret homme", 51), 
("Escrime fleuret homme", 67), 
("Escrime fleuret homme", 73), 
("Escrime fleuret homme", 81), 
("Escrime fleuret homme", 90), 
("Escrime fleuret homme", 108), 
("Escrime fleuret homme", 146), 
("Escrime fleuret homme", 148), 
("Escrime fleuret homme", 151), 
("Escrime fleuret homme", 162), 
("Escrime fleuret homme", 166), 
("Escrime fleuret homme", 189), 
("Escrime fleuret homme", 190), 
("Escrime fleuret homme", 196), 
("Escrime fleuret homme", 201), 
("Escrime fleuret homme", 210), 
("Escrime fleuret homme", 213), 
("Escrime fleuret homme", 233), 
("Escrime fleuret homme", 240), 
("Escrime fleuret homme", 253), 
("Escrime fleuret homme", 256), 
("Escrime épée homme", 2), 
("Escrime épée homme", 31), 
("Escrime épée homme", 32), 
("Escrime épée homme", 70), 
("Escrime épée homme", 75), 
("Escrime épée homme", 87), 
("Escrime épée homme", 107), 
("Escrime épée homme", 118), 
("Escrime épée homme", 119), 
("Escrime épée homme", 120), 
("Escrime épée homme", 134), 
("Escrime épée homme", 165), 
("Escrime épée homme", 167), 
("Escrime épée homme", 172), 
("Escrime épée homme", 188), 
("Escrime épée homme", 191), 
("Escrime épée homme", 192), 
("Escrime épée homme", 198), 
("Escrime épée homme", 207), 
("Escrime épée homme", 208), 
("Escrime épée homme", 217), 
("Escrime épée homme", 225), 
("Escrime épée homme", 226), 
("Escrime épée homme", 231), 
("Escrime épée homme", 246), 
("Escrime épée homme", 248), 
("Escrime épée homme", 252), 
("Escrime épée homme", 254), 
("Escrime épée homme", 258), 
("Escrime épée homme", 262), 
("Escrime épée homme", 267), 
("Escrime épée homme", 268), 
("Athétisme 110 haies homme", 3), 
("Athétisme 110 haies homme", 27), 
("Athétisme 110 haies homme", 92), 
("Athétisme 110 haies homme", 93), 
("Athétisme 110 haies homme", 95), 
("Athétisme 110 haies homme", 97), 
("Athétisme 110 haies homme", 106), 
("Athétisme 110 haies homme", 122), 
("Athétisme 110 haies homme", 137), 
("Athétisme 110 haies homme", 140), 
("Athétisme 110 haies homme", 147), 
("Athétisme 110 haies homme", 159), 
("Athétisme 110 haies homme", 161), 
("Athétisme 110 haies homme", 173), 
("Athétisme 110 haies homme", 177), 
("Athétisme 110 haies homme", 178), 
("Athétisme 110 haies homme", 182), 
("Athétisme 110 haies homme", 200), 
("Athétisme 110 haies homme", 202), 
("Athétisme 110 haies homme", 228), 
("Athétisme 110 haies homme", 245), 
("Athétisme 110 haies homme", 249), 
("Athétisme 110 haies homme", 261), 
("Natation 100 brasse femme", 1), 
("Natation 100 brasse femme", 9), 
("Natation 100 brasse femme", 23), 
("Natation 100 brasse femme", 29), 
("Natation 100 brasse femme", 41), 
("Natation 100 brasse femme", 52), 
("Natation 100 brasse femme", 77), 
("Natation 100 brasse femme", 83), 
("Natation 100 brasse femme", 94), 
("Natation 100 brasse femme", 98), 
("Natation 100 brasse femme", 102), 
("Natation 100 brasse femme", 112), 
("Natation 100 brasse femme", 139), 
("Natation 100 brasse femme", 141), 
("Natation 100 brasse femme", 152), 
("Natation 100 brasse femme", 156), 
("Natation 100 brasse femme", 168), 
("Natation 100 brasse femme", 194), 
("Natation 100 brasse femme", 206), 
("Natation 100 brasse femme", 218), 
("Natation 100 brasse femme", 223), 
("Natation 100 brasse femme", 234), 
("Natation 100 brasse femme", 235), 
("Natation 100 brasse femme", 243), 
("Natation 100 brasse femme", 257), 
("Natation 100 brasse femme", 264), 
("Natation 100 brasse femme", 269), 
("Natation relais libre femme", 19), 
("Natation relais libre femme", 22), 
("Natation relais libre femme", 53), 
("Natation relais libre femme", 64), 
("Natation relais libre femme", 69), 
("Natation relais libre femme", 82), 
("Natation relais libre femme", 149), 
("Natation relais libre femme", 176), 
("Handball femme", 21), 
("Handball femme", 33), 
("Handball femme", 34), 
("Handball femme", 37), 
("Handball femme", 57), 
("Handball femme", 142), 
("Handball femme", 153), 
("Handball femme", 160), 
("Handball femme", 183), 
("Volley-Ball femme", 47), 
("Volley-Ball femme", 48), 
("Volley-Ball femme", 49), 
("Volley-Ball femme", 79), 
("Volley-Ball femme", 104), 
("Volley-Ball femme", 117), 
("Volley-Ball femme", 130), 
("Volley-Ball femme", 131), 
("Volley-Ball femme", 236), 
("Volley-Ball femme", 260), 
("Escrime fleuret femme", 38), 
("Escrime fleuret femme", 43), 
("Escrime fleuret femme", 55), 
("Escrime fleuret femme", 71), 
("Escrime fleuret femme", 74), 
("Escrime fleuret femme", 115), 
("Escrime fleuret femme", 157), 
("Escrime fleuret femme", 158), 
("Escrime fleuret femme", 170), 
("Escrime fleuret femme", 195), 
("Escrime fleuret femme", 197), 
("Escrime fleuret femme", 204), 
("Escrime fleuret femme", 214), 
("Escrime fleuret femme", 230), 
("Escrime fleuret femme", 237), 
("Escrime fleuret femme", 238), 
("Escrime fleuret femme", 239), 
("Escrime fleuret femme", 244), 
("Escrime fleuret femme", 259), 
("Escrime fleuret femme", 265), 
("Escrime fleuret femme", 270), 
("Escrime fleuret femme", 274), 
("Escrime épée femme", 17), 
("Escrime épée femme", 18), 
("Escrime épée femme", 30), 
("Escrime épée femme", 63), 
("Escrime épée femme", 78), 
("Escrime épée femme", 88), 
("Escrime épée femme", 110), 
("Escrime épée femme", 116), 
("Escrime épée femme", 126), 
("Escrime épée femme", 128), 
("Escrime épée femme", 135), 
("Escrime épée femme", 143), 
("Escrime épée femme", 163), 
("Escrime épée femme", 169), 
("Escrime épée femme", 175), 
("Escrime épée femme", 179), 
("Escrime épée femme", 180), 
("Escrime épée femme", 181), 
("Escrime épée femme", 199), 
("Escrime épée femme", 209), 
("Escrime épée femme", 221), 
("Escrime épée femme", 224), 
("Escrime épée femme", 247), 
("Escrime épée femme", 255), 
("Escrime épée femme", 271), 
("Escrime épée femme", 273), 
("Athétisme 110 haies femme", 15), 
("Athétisme 110 haies femme", 20), 
("Athétisme 110 haies femme", 66), 
("Athétisme 110 haies femme", 68), 
("Athétisme 110 haies femme", 76), 
("Athétisme 110 haies femme", 80), 
("Athétisme 110 haies femme", 84), 
("Athétisme 110 haies femme", 85), 
("Athétisme 110 haies femme", 109), 
("Athétisme 110 haies femme", 114), 
("Athétisme 110 haies femme", 124), 
("Athétisme 110 haies femme", 127), 
("Athétisme 110 haies femme", 133), 
("Athétisme 110 haies femme", 164), 
("Athétisme 110 haies femme", 171), 
("Athétisme 110 haies femme", 211), 
("Athétisme 110 haies femme", 212), 
("Athétisme 110 haies femme", 227), 
("Athétisme 110 haies femme", 229), 
("Athétisme 110 haies femme", 232), 
("Athétisme 110 haies femme", 241), 
("Athétisme 110 haies femme", 242), 
("Athétisme 110 haies femme", 250), 
("Athétisme 110 haies femme", 251), 
("Athétisme 110 haies femme", 263);