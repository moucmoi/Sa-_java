public class Executable{
    public static void main(String[] args) {
        
        Pays France=new Pays("France","FRA");
        Pays EtatsUnis=new Pays("USA","USA");
        Pays Chine=new Pays("Chine","CHN");
        Pays Japon=new Pays("Japon","JPN");
        Pays Kenya=new Pays("Kenya","KEN");
        Pays Maroc=new Pays("Maroc","MAR");
        Pays Allemagne=new Pays("Allemagne","DEU");
        Pays Australie=new Pays("Australie","AUS");
        Pays Bresil=new Pays("Brésil","BRA");
        Pays Turquie=new Pays("Turquie","TUR");


        Sport Natation=new Sport("Natation",1,0.5,2.5);
        Sport Handball=new Sport("HandBall",1,1.5,1.5);
        Sport VolleyBall=new Sport("VolleyBall",1.5,1,1.5);
        Sport Escrime=new Sport("Escrime",0.5,2.5,1);
        Sport Athletisme=new Sport("Athletisme",0.5,1,2.5);

        Epreuve CentMetresH=new Epreuve("Natation 100 brasse", true, true, Natation);
        Epreuve RelaisLibreH=new Epreuve("Natation relais libre",true,false,Natation);
        Epreuve HandballH=new Epreuve("Handball", true, false,Handball);
        Epreuve  VolleyBallH=new Epreuve("Volley-Ball",true,false,VolleyBall);
        Epreuve EscrimeFleuretH=new Epreuve("Escrime fleuret",true, true, Escrime);
        Epreuve EscrimeEpeeH=new Epreuve("Escrime fleuret ",true, true, Escrime);
        Epreuve CentMetreHaiesH=new Epreuve("Athlétisme 110 haies", true, true, Athletisme);
        Epreuve QuatreCentMetresRelaiH=new Epreuve("Athlétisme 110 haies", true, false, Athletisme);
        
        Epreuve CentMetresF=new Epreuve("Natation 100 brasse", false, true, Natation);
        Epreuve RelaisLibreF=new Epreuve("Natation relais libre",false,false,Natation);
        Epreuve HandballF=new Epreuve("Handball", false, false,Handball);
        Epreuve  VolleyBallF=new Epreuve("Volley-Ball",false,false,VolleyBall);
        Epreuve EscrimeFleuretF=new Epreuve("Escrime fleuret",false, true, Escrime);
        Epreuve EscrimeEpeeF=new Epreuve("Escrime fleuret",false, true, Escrime);
        Epreuve CentMetreHaiesF=new Epreuve("Athlétisme 110 haies", false, true, Athletisme);
        Epreuve QuatreCentMetresRelaiF=new Epreuve("Athlétisme 110 haies", false, false, Athletisme);

        Equipe e1=new Equipe("Equipe1",France);
        Equipe e2=new Equipe("Equipe2",Maroc);

        Athlete Noa=new Athlete("Fonteny", "Noa", "H",10 , 15, 5);
        Athlete Marin=new Athlete("Chesneau", "Marin", "H", 12,2 , 12);
        Athlete Loris=new Athlete("Grandchamp", "Loris", "H", 10, 5, 20);
        Athlete Amine=new Athlete("Yahyaoui", "Mohamed-Amine", "H", 10, 10, 10);

        e1.ajouteAthlete(Noa);
        e1.ajouteAthlete(Marin);
        e2.ajouteAthlete(Loris);
        e2.ajouteAthlete(Amine);
        France.ajouteEquipe(e1);
        Maroc.ajouteEquipe(e2);

        Noa.ajouteEquipe(e1);
        Marin.ajouteEquipe(e1);
        Amine.ajouteEquipe(e2);
        Loris.ajouteEquipe(e2);


        e1.ajouteEpreuve(QuatreCentMetresRelaiH);
        e1.ajouteEpreuve(CentMetresH);
        e1.ajouteEpreuve(RelaisLibreH);
        e1.ajouteEpreuve(HandballH);
        e1.ajouteEpreuve(VolleyBallH);
        e1.ajouteEpreuve(EscrimeEpeeH);
        e1.ajouteEpreuve(EscrimeFleuretH);
        e1.ajouteEpreuve(CentMetreHaiesH);

        e2.ajouteEpreuve(QuatreCentMetresRelaiH);
        e2.ajouteEpreuve(CentMetresH);
        e2.ajouteEpreuve(RelaisLibreH);
        e2.ajouteEpreuve(HandballH);
        e2.ajouteEpreuve(VolleyBallH);
        e2.ajouteEpreuve(EscrimeEpeeH);
        e2.ajouteEpreuve(EscrimeFleuretH);
        e2.ajouteEpreuve(CentMetreHaiesH);

        System.out.println(Noa.participer());
        System.out.println(Marin.participer());
        System.out.println(Amine.participer());
        System.out.println(Loris.participer());

        System.out.println(France.calculerScore());
        System.out.println(Maroc.calculerScore());
    }
}

