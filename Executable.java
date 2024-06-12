public class Executable{
    public static void main(String[] args) {
        
        Pays france=new Pays("France","FRA");
        Pays etatsUnis=new Pays("USA","USA");
        Pays chine=new Pays("Chine","CHN");
        Pays japon=new Pays("Japon","JPN");
        Pays kenya=new Pays("Kenya","KEN");
        Pays maroc=new Pays("Maroc","MAR");
        Pays allemagne=new Pays("Allemagne","DEU");
        Pays australie=new Pays("Australie","AUS");
        Pays bresil=new Pays("Brésil","BRA");
        Pays turquie=new Pays("Turquie","TUR");


        Sport natation=new Sport("Natation",1,0.5,2.5);
        Sport handball=new Sport("HandBall",1,1.5,1.5);
        Sport volleyBall=new Sport("VolleyBall",1.5,1,1.5);
        Sport escrime=new Sport("Escrime",0.5,2.5,1);
        Sport athletisme=new Sport("Athletisme",0.5,1,2.5);

        Epreuve centMetresH=new Epreuve("Natation 100 brasse", true, true, natation);
        Epreuve relaisLibreH=new Epreuve("Natation relais libre",true,false,natation);
        Epreuve handballH=new Epreuve("Handball", true, false,handball);
        Epreuve volleyBallH=new Epreuve("Volley-Ball",true,false,volleyBall);
        Epreuve escrimeFleuretH=new Epreuve("Escrime fleuret",true, true, escrime);
        Epreuve escrimeEpeeH=new Epreuve("Escrime fleuret ",true, true, escrime);
        Epreuve centMetreHaiesH=new Epreuve("Athletisme 110 haies", true, true, athletisme);
        Epreuve quatreCentMetresRelaiH=new Epreuve("Athletisme 110 haies", true, false, athletisme);
        
        Epreuve centMetresF=new Epreuve("Natation 100 brasse", false, true, natation);
        Epreuve relaisLibreF=new Epreuve("Natation relais libre",false,false,natation);
        Epreuve handballF=new Epreuve("Handball", false, false,handball);
        Epreuve volleyBallF=new Epreuve("Volley-Ball",false,false,volleyBall);
        Epreuve escrimeFleuretF=new Epreuve("Escrime fleuret",false, true, escrime);
        Epreuve escrimeEpeeF=new Epreuve("Escrime fleuret",false, true, escrime);
        Epreuve centMetreHaiesf=new Epreuve("Athletisme 110 haies", false, true, athletisme);
        Epreuve quatreCentMetresRelaiF=new Epreuve("Athletisme 110 haies", false, false, athletisme);

        Equipe e1=new Equipe("Equipe1",france);
        Equipe e2=new Equipe("Equipe2",maroc);

        Athlete noa=new Athlete("Fonteny", "Noa", "H",10 , 15, 5);
        Athlete marin=new Athlete("Chesneau", "Marin", "H", 12,2 , 12);
        Athlete loris=new Athlete("Grandchamp", "Loris", "H", 10, 5, 20);
        Athlete amine=new Athlete("Yahyaoui", "Mohamed-Amine", "H", 10, 10, 10);

        e1.ajouteAthlete(noa);
        e1.ajouteAthlete(marin);
        e2.ajouteAthlete(loris);
        e2.ajouteAthlete(amine);
        france.ajouteEquipe(e1);
        maroc.ajouteEquipe(e2);

        noa.ajouteEquipe(e1);
        marin.ajouteEquipe(e1);
        amine.ajouteEquipe(e2);
        loris.ajouteEquipe(e2);


        e1.ajouteEpreuve(quatreCentMetresRelaiH);
        e1.ajouteEpreuve(centMetresH);
        e1.ajouteEpreuve(relaisLibreH);
        e1.ajouteEpreuve(handballH);
        e1.ajouteEpreuve(volleyBallH);
        e1.ajouteEpreuve(escrimeEpeeH);
        e1.ajouteEpreuve(escrimeFleuretH);
        e1.ajouteEpreuve(centMetreHaiesH);

        e2.ajouteEpreuve(quatreCentMetresRelaiH);
        e2.ajouteEpreuve(centMetresH);
        e2.ajouteEpreuve(relaisLibreH);
        e2.ajouteEpreuve(handballH);
        e2.ajouteEpreuve(volleyBallH);
        e2.ajouteEpreuve(escrimeEpeeH);
        e2.ajouteEpreuve(escrimeFleuretH);
        e2.ajouteEpreuve(centMetreHaiesH);

        System.out.println(noa.participer());
        System.out.println(marin.participer());
        System.out.println(amine.participer());
        System.out.println(loris.participer());

        System.out.println(france.calculerScore());
        System.out.println(maroc.calculerScore());
    }
}

