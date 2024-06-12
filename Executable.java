import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


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
       List<Pays> pays=Arrays.asList(france,etatsUnis,chine,japon,kenya,maroc,allemagne,australie,bresil,turquie);


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


        System.out.println("Bonjour");
        System.out.println("Pour répondre aux question il faut mettre le numéro de la question");
        System.out.println(" _________________________________________\n"+
                           "|========================================|\n"+
                           "|Sur quoi veux tu avoir des information ?|\n"+
                           "|========================================|\n"+
                           "|                                        |\n"+
                           "|   1 - Les sports                       |\n"+
                           "|   2 - Les équipes                      |\n"+
                           "|   3 - Les pays                         |\n"+
                           "|   4 - Les athletes                     |\n"+
                           "|   5 - Quitter                          |\n"+
                           "|                                        |\n"+
                           "|                                        |\n"+
                           "|________________________________________|\n");

        Scanner scan1=new Scanner(System.in);
        System.out.println("Ta réponse :");
        String rep1=scan1.nextLine();
        
        if (rep1.equals("1")){
            System.out.println(" _________________________________________\n"+
                           "|========================================|\n"+
                           "|   Que veux tu savoir sur les sports ?  |\n"+
                           "|========================================|\n"+
                           "|                                        |\n"+
                           "|   1 - Liste des sports                 |\n"+
                           "|   2 - Liste des épreuves dans un sport |\n"+
                           "|   3 - Quitter                          |\n"+
                           "|                                        |\n"+
                           "|________________________________________|\n");
            Scanner scanSport=new Scanner(System.in);
            System.out.println("Ta réponse :");
            String  repScanSport=scanSport.nextLine();
            if(repScanSport.equals("1")){
                String rep="";
                for(Pays p:pays){
                    for(Equipe e:p.getLesEquipes()){
                        for(Epreuve ep:e.getLesEpreuves()){
                            Sport s=ep.getSport();
                            if(!(rep.contains(s.getNomSport()))){
                                rep+=s.getNomSport()+"\n";
                            }
                        }
                    }
                }
                System.out.println(rep);
                System. exit(0);
            }
            if(repScanSport.equals("2")){
                Scanner quelSport=new Scanner(System.in);
                System.out.println("De quel sport veux tu connaître les épreuves");
                String  repSport1=quelSport.nextLine();
                String rep="";
                List<Sport> listeSport=new ArrayList<>();
                for(Pays p:pays){
                    for(Equipe e:p.getLesEquipes()){
                        for(Epreuve ep:e.getLesEpreuves()){
                            if(!(listeSport.contains(ep.getSport()))){
                                listeSport.add(ep.getSport());
                            }
                        }
                    }
                }
                for(Sport spo:listeSport){
                    if(spo.getNomSport().equals(repSport1)){
                        for(Epreuve ep:spo.getLesEpreuves()){
                            rep+=ep.getNom()+"\n";
                        }
                    }
                }
                System.out.println(rep);
                System. exit(0);
            }
            else{
                System. exit(0);
            }
        }
        if(rep1.equals("2")){
            System.out.println(" ______________________________________________\n"+
                               "|==============================================|\n"+
                               "|     Que veux tu savoir sur les équipes ?     |\n"+
                               "|==============================================|\n"+
                               "|                                              |\n"+
                               "|   1 - Connaître le classement des équipes    |\n"+
                               "|   2 - Savoir le nombre de point des équipes  |\n"+
                               "|   3 - Connaître les membre d'une équipe      |\n"+
                               "|   5 - Quitter                                |\n"+
                               "|                                              |\n"+
                               "|                                              |\n"+
                               "|______________________________________________|\n");
            Scanner scanEquipe =new Scanner(System.in);
            System.out.println("Ta réponse :");
            String  repScanEquipe=scanEquipe.nextLine();
            if(repScanEquipe.equals("1")){
                String rep="";
                List<Equipe> listeEquipes=new ArrayList<>();
                for(Pays p:pays){
                    for(Equipe e:p.getLesEquipes()){
                        listeEquipes.add(e);
                    }
                    
                }
                Collections.sort(listeEquipes);
                Collections.reverse(listeEquipes);

                for(int i=1;i<=listeEquipes.size();i++){
                    rep+=i+" : "+listeEquipes.get(i-1).getNom()+" venant du "+listeEquipes.get(i-1).getPays().getNomPays()+"\n";
                }
                System.out.println(rep);
                System. exit(0);
            }
            if(repScanEquipe.equals("2")){
                String rep="";
                List<Equipe> listeEquipes=new ArrayList<>();
                for(Pays p:pays){
                    for(Equipe e:p.getLesEquipes()){
                        listeEquipes.add(e);
                    }
                }
                for(Equipe eq:listeEquipes){
                    rep+="L'équipe "+eq.getNom()+" a "+eq.calculerScore()+ " points"+"\n";
                }
                System.out.println(rep);
                System.exit(0);
            }
            if(repScanEquipe.equals("3")){
                Scanner quelEquipe=new Scanner(System.in);
                System.out.println("De quel équipe veux tu connaître les membres ?");
                String  repQuelEquipe=quelEquipe.nextLine();
                String rep="";
                List<Equipe> listeEquipes=new ArrayList<>();
                for(Pays p:pays){
                    for(Equipe e:p.getLesEquipes()){
                        listeEquipes.add(e);
                    }
                }
                for(Equipe e:listeEquipes){
                    if(e.getNom().equals(repQuelEquipe)){
                        for(Athlete a:e.getLesAthletes()){
                            rep+=a.getNom()+"\n";
                        }
                    }
                }
                System.out.println(rep);
                System.exit(0);
            }
            else{
                System.exit(0);
            }
        }
        if(rep1.equals("3")){
            System.out.println(" _______________________________________________\n"+
                               "|===============================================|\n"+
                               "|      Que veux tu savoir sur les pays ?        |\n"+
                               "|===============================================|\n"+
                               "|                                               |\n"+
                               "|   1 - Connaître le classement des pays        |\n"+
                               "|   2 - Savoir le nombre de point des pays      |\n"+
                               "|   3 - Connaître les équipes d'un pays         |\n"+
                               "|   4 - Connaître les membre d'un pays          |\n"+
                               "|   5 - Quitter                                 |\n"+
                               "|                                               |\n"+
                               "|                                               |\n"+
                               "|_______________________________________________|\n");
            Scanner scanPays =new Scanner(System.in);
            System.out.println("Ta réponse :");
            String  repScanPays=scanPays.nextLine();

            if(repScanPays.equals("1")){
                String rep="";
                Collections.sort(pays);
                Collections.reverse(pays);

                for(int i=1;i<=pays.size();i++){
                    rep+=i+" : "+pays.get(i-1).getNomPays()+"\n";
                }
                System.out.println(rep);
                System. exit(0);
            }
            if(repScanPays.equals("2")){
                String rep="";
                for(Pays p:pays){
                    rep+="Le pays "+p.getNomPays()+" a "+p.calculerScore()+ " points"+"\n";
                }
                System.out.println(rep);
                System.exit(0);
            }
            if(repScanPays.equals("3")){
                Scanner quelPays=new Scanner(System.in);
                System.out.println("De quel pays veux tu connaître les équipes ?");
                String  repQuelPays=quelPays.nextLine();
                String rep="";
                
                for(Pays p:pays){
                    if(p.getNomPays().equals(repQuelPays)){
                        for(Equipe e:p.getLesEquipes()){
                            rep+=e.getNom()+"\n";
                        }
                    }
                }
                System.out.println(rep);
                System.exit(0);
            }
            if(repScanPays.equals("4")){
                Scanner quelPays2=new Scanner(System.in);
                System.out.println("De quel pays veux tu connaître les équipes ?");
                String  repQuelPays2=quelPays2.nextLine();
                String rep="";
                
                for(Pays p:pays){
                    if(p.getNomPays().equals(repQuelPays2)){
                        for(Equipe e:p.getLesEquipes()){
                            for(Athlete a:e.getLesAthletes())
                                rep+=a.getNom()+"\n";
                        }
                    }
                }
                System.out.println(rep);
                System.exit(0);
            }
            else{
                System.exit(0);
            }
        }
        if(rep1.equals("4")){
            System.out.println(" ___________________________________________________\n"+
                               "|===================================================|\n"+
                               "|        Que veux tu savoir sur les athletes ?      |\n"+
                               "|===================================================|\n"+
                               "|                                                   |\n"+
                               "|   1 - Connaître le classement des athletes        |\n"+
                               "|   2 - Savoir le nombre de point des athletes      |\n"+
                               "|   3 - Connaître les équipes d'un athlete          |\n"+
                               "|   4 - Connaître le pays d'un athlete              |\n"+
                               "|   5 - Quitter                                     |\n"+
                               "|                                                   |\n"+
                               "|                                                   |\n"+
                               "|___________________________________________________|\n");
            Scanner scanAthlete =new Scanner(System.in);
            System.out.println("Ta réponse :");
            String  repScanAthlete=scanAthlete.nextLine();
            if(repScanAthlete.equals("1")){
                String rep="";
                List<Athlete> listeAthletes=new ArrayList<>();
                for(Pays p:pays){
                    for(Equipe e:p.getLesEquipes()){
                        for(Athlete a:e.getLesAthletes())
                            listeAthletes.add(a);
                    }
                }
                Collections.sort(listeAthletes);
                Collections.reverse(listeAthletes);
                for(int i=1;i<=listeAthletes.size();i++){
                    rep+=i+" : "+listeAthletes.get(i-1)+"\n";
                }
                System.out.println(rep);
                System.exit(0);
            }
            if(repScanAthlete.equals("2")){
                String rep="";
                List<Athlete> listeAthletes=new ArrayList<>();
                for(Pays p:pays){
                    for(Equipe e:p.getLesEquipes()){
                        for(Athlete a:e.getLesAthletes())
                            listeAthletes.add(a);
                    }
                }
                for(Athlete at:listeAthletes){
                    rep+="L'athlete "+at.getNom()+" a "+at.participer()+ " points"+"\n";
                }
                System.out.println(rep);
                System.exit(0);
            }
            if(repScanAthlete.equals("3")){
                String rep="";
                List<Athlete> listeAthletes=new ArrayList<>();
                for(Pays p:pays){
                    for(Equipe e:p.getLesEquipes()){
                        for(Athlete a:e.getLesAthletes())
                            listeAthletes.add(a);
                    }
                }
                Scanner quelAthlete=new Scanner(System.in);
                System.out.println("De quel athlete veux tu connaître les équipes ?");
                String  repQuelAthlete=quelAthlete.nextLine();
                for(Athlete at:listeAthletes){
                    if(at.getNom().equals(repQuelAthlete)){
                        for(Equipe eq:at.getEquipes()){
                            rep+=eq.getNom()+"\n";
                        }
                    }
                }
                System.out.println(rep);
                System.exit(0);
            }
            if(repScanAthlete.equals("4")){
                String rep="";
                List<Athlete> listeAthletes=new ArrayList<>();
                for(Pays p:pays){
                    for(Equipe e:p.getLesEquipes()){
                        for(Athlete a:e.getLesAthletes())
                            listeAthletes.add(a);
                    }
                }
                Scanner quelAthlete2=new Scanner(System.in);
                System.out.println("De quel athlete veux tu connaître le pays ?");
                String  repQuelAthlete2=quelAthlete2.nextLine();
                for(Athlete at:listeAthletes){
                    if(at.getNom().equals(repQuelAthlete2)){
                        System.out.println(at.getEquipes().get(0).getPays().getNomPays());
                    }
                }
            }
            else{
                System.exit(0);
            }
        }
        else{
            System.exit(0);
        }
    }
}

