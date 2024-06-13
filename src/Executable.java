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

        Epreuve centMetresH=new Epreuve("Natation 100 brasse homme", true, true, natation);
        Epreuve relaisLibreH=new Epreuve("Natation relais libre homme",true,false,natation);
        Epreuve handballH=new Epreuve("Handball homme", true, false,handball);
        Epreuve volleyBallH=new Epreuve("Volley-Ball homme",true,false,volleyBall);
        Epreuve escrimeFleuretH=new Epreuve("Escrime fleuret homme",true, true, escrime);
        Epreuve escrimeEpeeH=new Epreuve("Escrime fleuret homme",true, true, escrime);
        Epreuve centMetreHaiesH=new Epreuve("Athletisme 110 haies homme", true, true, athletisme);
        Epreuve quatreCentMetresRelaiH=new Epreuve("Athletisme 110 haies homme", true, false, athletisme);
        
        Epreuve centMetresF=new Epreuve("Natation 100 brasse femme", false, true, natation);
        Epreuve relaisLibreF=new Epreuve("Natation relais libre femme",false,false,natation);
        Epreuve handballF=new Epreuve("Handball femme", false, false,handball);
        Epreuve volleyBallF=new Epreuve("Volley-Ball femme",false,false,volleyBall);
        Epreuve escrimeFleuretF=new Epreuve("Escrime fleuret femme",false, true, escrime);
        Epreuve escrimeEpeeF=new Epreuve("Escrime fleuret femme",false, true, escrime);
        Epreuve centMetreHaiesF=new Epreuve("Athletisme 110 haies femme", false, true, athletisme);
        Epreuve quatreCentMetresRelaiF=new Epreuve("Athletisme 110 haies femme", false, false, athletisme);

        

        Equipe e1=new Equipe("Equipe1",france);
        Equipe e2=new Equipe("Equipe2",maroc);
        Equipe e3=new Equipe("Equipe3",allemagne);
        Equipe e4=new Equipe("Equipe4",etatsUnis);
        Equipe e5=new Equipe("Equipe5",chine);
        Equipe e6=new Equipe("Equipe6",japon);
        Equipe e7=new Equipe("Equipe7",kenya);
        Equipe e8=new Equipe("Equipe8",australie);
        Equipe e9=new Equipe("Equipe9",bresil);
        Equipe e10=new Equipe("Equipe10",turquie);

        Athlete noa=new Athlete("Fonteny", "Noa", "H",10 , 15, 5);
        Athlete marin=new Athlete("Chesneau", "Marin", "H", 12,2 , 12);
        Athlete loris=new Athlete("Grandchamp", "Loris", "H", 10, 5, 20);

        natation.ajouteEpreuve(centMetresF);
        natation.ajouteEpreuve(centMetresH);
        natation.ajouteEpreuve(relaisLibreF);
        natation.ajouteEpreuve(relaisLibreH);
        handball.ajouteEpreuve(handballF);
        handball.ajouteEpreuve(handballH);
        volleyBall.ajouteEpreuve(volleyBallH);
        volleyBall.ajouteEpreuve(volleyBallF);
        escrime.ajouteEpreuve(escrimeEpeeF);
        escrime.ajouteEpreuve(escrimeEpeeH);
        escrime.ajouteEpreuve(escrimeFleuretF);
        escrime.ajouteEpreuve(escrimeFleuretH);
        athletisme.ajouteEpreuve(quatreCentMetresRelaiF);
        athletisme.ajouteEpreuve(quatreCentMetresRelaiH);
        athletisme.ajouteEpreuve(centMetreHaiesH);
        athletisme.ajouteEpreuve(centMetreHaiesF);
        
        e1.ajouteAthlete(noa);
        e1.ajouteAthlete(marin);
        e1.ajouteAthlete(loris);

        Athlete amine=new Athlete("Yahyaoui", "Mohamed-Amine", "H", 10, 10, 10);
        Athlete imad=new Athlete("Assou", "Imad", "H", 10, 5, 15);
        e2.ajouteAthlete(amine);
        e2.ajouteAthlete(imad);

        Athlete jade=new Athlete("Laurent", "Jade", "F", 3, 20, 3);
        Athlete sarah=new Athlete("Faure", "Sarah", "F", 8, 2, 16);
        e3.ajouteAthlete(jade);
        e3.ajouteAthlete(sarah);

        Athlete sosuke=new Athlete("Kondo", "Sosuke", "H", 5, 18, 9);
        Athlete leon=new Athlete("Hartmann", "Leon", "H", 2, 7, 20);
        e4.ajouteAthlete(sosuke);
        e4.ajouteAthlete(leon);

        Athlete ryota=new Athlete("Shibata", "Ryota", "H", 17, 7, 4);
        Athlete zhu=new Athlete("Lin", "Zhu", "H", 12, 18, 3);
        e5.ajouteAthlete(ryota);
        e5.ajouteAthlete(zhu);

        Athlete david=new Athlete("Weber", "David", "H", 15, 1, 4);
        Athlete arthur=new Athlete("Perez", "Arthur", "H", 12, 2, 14);
        e6.ajouteAthlete(david);
        e6.ajouteAthlete(arthur);

        Athlete hugo=new Athlete("Muller", "Hugo", "H", 15, 15, 2);
        Athlete nathan=new Athlete("Michel", "Nathan", "H", 10, 4, 6);
        e7.ajouteAthlete(hugo);
        e7.ajouteAthlete(nathan);

        Athlete sophie=new Athlete("Schulz", "Sophie", "F", 6, 10, 1);
        Athlete rin=new Athlete("Yamaguchi", "Rin", "F", 17, 9, 9);
        e8.ajouteAthlete(sophie);
        e8.ajouteAthlete(rin);

        Athlete theo=new Athlete("Richard", "Théo", "h", 14, 2, 1);
        Athlete min=new Athlete("Sato", "Min", "H", 20, 8, 10);
        e9.ajouteAthlete(theo);
        e9.ajouteAthlete(min);

        Athlete lucas=new Athlete("Werner", "Lucas", "h", 19, 12, 4);
        Athlete johan=new Athlete("Gao", "Johan", "H", 8, 2, 15);
        e10.ajouteAthlete(lucas);
        e10.ajouteAthlete(johan);

        france.ajouteEquipe(e1);
        maroc.ajouteEquipe(e2);
        allemagne.ajouteEquipe(e3);
        etatsUnis.ajouteEquipe(e4);
        chine.ajouteEquipe(e5);
        japon.ajouteEquipe(e6);
        kenya.ajouteEquipe(e7);
        australie.ajouteEquipe(e8);
        bresil.ajouteEquipe(e9);
        turquie.ajouteEquipe(e10);

        noa.ajouteEquipe(e1);
        marin.ajouteEquipe(e1);
        loris.ajouteEquipe(e1);
        amine.ajouteEquipe(e2);
        imad.ajouteEquipe(e2);
        jade.ajouteEquipe(e3);
        sarah.ajouteEquipe(e3);
        sosuke.ajouteEquipe(e4);
        leon.ajouteEquipe(e4);
        ryota.ajouteEquipe(e5);
        zhu.ajouteEquipe(e5);
        arthur.ajouteEquipe(e6);
        david.ajouteEquipe(e6);
        hugo.ajouteEquipe(e7);
        nathan.ajouteEquipe(e7);
        sophie.ajouteEquipe(e8);
        rin.ajouteEquipe(e8);
        theo.ajouteEquipe(e9);
        min.ajouteEquipe(e9);
        lucas.ajouteEquipe(e10);
        johan.ajouteEquipe(e10);

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

        e3.ajouteEpreuve(quatreCentMetresRelaiF);
        e3.ajouteEpreuve(centMetresF);
        e3.ajouteEpreuve(relaisLibreF);
        e3.ajouteEpreuve(handballF);
        e3.ajouteEpreuve(volleyBallF);
        e3.ajouteEpreuve(escrimeEpeeF);
        e3.ajouteEpreuve(escrimeFleuretF);
        e3.ajouteEpreuve(centMetreHaiesF);

        e4.ajouteEpreuve(quatreCentMetresRelaiH);
        e4.ajouteEpreuve(centMetresH);
        e4.ajouteEpreuve(relaisLibreH);
        e4.ajouteEpreuve(handballH);
        e4.ajouteEpreuve(volleyBallH);
        e4.ajouteEpreuve(escrimeEpeeH);
        e4.ajouteEpreuve(escrimeFleuretH);
        e4.ajouteEpreuve(centMetreHaiesH);

        e5.ajouteEpreuve(quatreCentMetresRelaiH);
        e5.ajouteEpreuve(centMetresH);
        e5.ajouteEpreuve(relaisLibreH);
        e5.ajouteEpreuve(handballH);
        e5.ajouteEpreuve(volleyBallH);
        e5.ajouteEpreuve(escrimeEpeeH);
        e5.ajouteEpreuve(escrimeFleuretH);
        e5.ajouteEpreuve(centMetreHaiesH);

        e6.ajouteEpreuve(quatreCentMetresRelaiH);
        e6.ajouteEpreuve(centMetresH);
        e6.ajouteEpreuve(relaisLibreH);
        e6.ajouteEpreuve(handballH);
        e6.ajouteEpreuve(volleyBallH);
        e6.ajouteEpreuve(escrimeEpeeH);
        e6.ajouteEpreuve(escrimeFleuretH);
        e6.ajouteEpreuve(centMetreHaiesH);

        e7.ajouteEpreuve(quatreCentMetresRelaiH);
        e7.ajouteEpreuve(centMetresH);
        e7.ajouteEpreuve(relaisLibreH);
        e7.ajouteEpreuve(handballH);
        e7.ajouteEpreuve(volleyBallH);
        e7.ajouteEpreuve(escrimeEpeeH);
        e7.ajouteEpreuve(escrimeFleuretH);
        e7.ajouteEpreuve(centMetreHaiesH);

        e8.ajouteEpreuve(quatreCentMetresRelaiF);
        e8.ajouteEpreuve(centMetresF);
        e8.ajouteEpreuve(relaisLibreF);
        e8.ajouteEpreuve(handballF);
        e8.ajouteEpreuve(volleyBallF);
        e8.ajouteEpreuve(escrimeEpeeF);
        e8.ajouteEpreuve(escrimeFleuretF);
        e8.ajouteEpreuve(centMetreHaiesF);

        e9.ajouteEpreuve(quatreCentMetresRelaiH);
        e9.ajouteEpreuve(centMetresH);
        e9.ajouteEpreuve(relaisLibreH);
        e9.ajouteEpreuve(handballH);
        e9.ajouteEpreuve(volleyBallH);
        e9.ajouteEpreuve(escrimeEpeeH);
        e9.ajouteEpreuve(escrimeFleuretH);
        e9.ajouteEpreuve(centMetreHaiesH);

        e10.ajouteEpreuve(quatreCentMetresRelaiH);
        e10.ajouteEpreuve(centMetresH);
        e10.ajouteEpreuve(relaisLibreH);
        e10.ajouteEpreuve(handballH);
        e10.ajouteEpreuve(volleyBallH);
        e10.ajouteEpreuve(escrimeEpeeH);
        e10.ajouteEpreuve(escrimeFleuretH);
        e10.ajouteEpreuve(centMetreHaiesH);


        System.out.println(noa.participer());
        System.out.println(marin.participer());
        System.out.println(loris.participer());
        System.out.println(amine.participer());
        System.out.println(imad.participer());
        System.out.println(jade.participer());
        System.out.println(sarah.participer());
        System.out.println(sosuke.participer());
        System.out.println(leon.participer());
        System.out.println(ryota.participer());
        System.out.println(zhu.participer());
        System.out.println(arthur.participer());
        System.out.println(david.participer());
        System.out.println(hugo.participer());
        System.out.println(nathan.participer());
        System.out.println(sophie.participer());
        System.out.println(rin.participer());
        System.out.println(theo.participer());
        System.out.println(min.participer());
        System.out.println(lucas.participer());
        System.out.println(johan.participer());


        System.out.println(france.calculerScore());
        System.out.println(maroc.calculerScore());
        System.out.println(allemagne.calculerScore());
        System.out.println(etatsUnis.calculerScore());
        System.out.println(chine.calculerScore());
        System.out.println(japon.calculerScore());
        System.out.println(kenya.calculerScore());
        System.out.println(australie.calculerScore());
        System.out.println(bresil.calculerScore());
        System.out.println(turquie.calculerScore());


        System.out.println("Bonjour");
        System.out.println("Pour répondre aux question il faut mettre le numéro de la question");
        System.out.println(" _________________________________________\n"+
                           "|========================================|\n"+
                           "|           Que veux tu faire ?          |\n"+
                           "|========================================|\n"+
                           "|                                        |\n"+
                           "|   1 - Avoir des infos sur les sports   |\n"+
                           "|   2 - Avoir des infos sur les équipes  |\n"+
                           "|   3 - Avoir des infos sur les pays     |\n"+
                           "|   4 - Avoir les infos sur les athletes |\n"+
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
                               "|   4 - Quitter                                |\n"+
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
                                rep+=a+"\n";
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

