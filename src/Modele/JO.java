package src.Modele;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.FileNotFoundException;
import java.sql.*;

public class JO {
    private List<Pays> pays;
    private List<Equipe> equipes;
    private List<Athlete> athletes;
    private List<Epreuve> epreuves;
    private List<Sport> sports;
    private ConnexionMySQL connexion;
    private OutilsRequete requete;
    private boolean lancer;

    public boolean getLancer(){
        return this.lancer;
    }

    public void changerLancer(){
        this.lancer=true;
    }


    public JO() throws ClassNotFoundException , SQLException, FileNotFoundException,NullPointerException{
        this.connexion = new ConnexionMySQL();
        connexion.connecter("ConfigBD.txt");
        this.requete = new OutilsRequete(this.connexion);
        this.pays=this.requete.listerPays();
        this.equipes=this.requete.listerEquipe();
        this.athletes=this.requete.listerAthletes();
        this.epreuves=this.requete.listerEpreuve();
        this.sports=this.requete.listerSport();
        this.lancer=false;
        
    }
        
    public void simulationJO(){
        List<Equipe> equipeNatation=new ArrayList<>();
        List<Equipe> equipeHandBall=new ArrayList<>();
        List<Equipe> equipeVolleyBall=new ArrayList<>();
        List<Equipe> equipeEscrime=new ArrayList<>();
        List<Equipe> equipeAthletisme=new ArrayList<>();
        for(Equipe eq:this.equipes){

            if(eq.getLesEpreuves().get(0).getSport().getNomSport().equals("Natation")){
                equipeNatation.add(eq);
                System.out.println("natation");
            }
            else if(eq.getLesEpreuves().get(0).getSport().getNomSport().equals("HandBall")){
                equipeHandBall.add(eq);
                System.out.println("hand");
            }
            else if(eq.getLesEpreuves().get(0).getSport().getNomSport().equals("VolleyBall")){
                equipeVolleyBall.add(eq);
                System.out.println("volley");
            }
            else if(eq.getLesEpreuves().get(0).getSport().getNomSport().equals("Escrime")){
                equipeEscrime.add(eq);
                System.out.println("escrime");
            }
            else if(eq.getLesEpreuves().get(0).getSport().getNomSport().equals("Athlétisme")){
                equipeAthletisme.add(eq);
                System.out.println("athle");
            }
        }
        List<List<Equipe>> equipeParSport=Arrays.asList(equipeAthletisme,equipeEscrime,equipeHandBall,equipeNatation,equipeVolleyBall);
        for(Epreuve e:epreuves){
            for(List<Equipe> eq:equipeParSport){
                List<Equipe> ordre=e.simulerEpreuve(eq);
                if(ordre.size()>0){
                    ordre.get(0).ajouterMedaille("Or");
                    for(Athlete a:ordre.get(0).getLesAthletes()){
                        a.ajouterMedaille("Or");
                    }
                    if(ordre.size()>1){
                        ordre.get(1).ajouterMedaille("Argent");
                        for(Athlete a:ordre.get(1).getLesAthletes()){
                            a.ajouterMedaille("Argent");
                        }
                        if(ordre.size()>2){
                            ordre.get(2).ajouterMedaille("Bronze");
                            
                            for(Athlete a:ordre.get(2).getLesAthletes()){
                                a.ajouterMedaille("Bronze");
                            }
                        }
                    }
                }
            }
        }
        for(Pays p:pays){
            p.majMedaille();
        }
    }
    
    public OutilsRequete getOutilsRequete(){
        return this.requete;
    }
}
