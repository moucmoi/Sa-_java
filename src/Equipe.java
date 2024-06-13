import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class Equipe implements Comparable<Equipe>{
    private String nomEquipe;
    private Pays pays;
    private List<Epreuve> lesEpreuves;
    private List<Athlete> lesAthletes;

    public Equipe(String nomEquipe,Pays pays){
        /*Constructeur demandant un nom et un pays**/
        this.nomEquipe = nomEquipe;
        this.pays=pays;
        this.lesAthletes = new ArrayList<>();
        this.lesEpreuves=new ArrayList<>();
    }

    public void ajouteAthlete(Athlete athlete) {
        /**
         * ajoute un athlete dans la liste d'athlete
         * @param un athlete
         */
        this.lesAthletes.add(athlete);
    }

    public List<Epreuve> getLesEpreuves() {
        /**
         * donne la liste des epreuves
         * @return liste des epreuves
         */
        return lesEpreuves;
    }

    public List<Athlete> getLesAthletes() {
        /**
         * donne de la liste des athletes
         * @return liste des athlete
         */
        return lesAthletes;
    }

    public void ajouteEpreuve(Epreuve epreuve){
        /**
         * ajoute une epreuve dans la liste d'epreuve
         * @param une epreuve
         */
        this.lesEpreuves.add(epreuve);
    }

    public Pays getPays() {
        /**
         * donne le pays de l'epreuve
         * @return un pays
         */
        return pays;
    }

    public void setPays(Pays pays) {
        /**
         * change le pays d'un pays
         * @param un pays
         */
        this.pays = pays;
    }

    public String getNom(){
        /**
         * donne le nom de l'equipe
         * @return le nom de l'equipe
         */
        return this.nomEquipe;
    }

    public int getNbAthletes() {
        /**
         * donne le nombre d'athlete 
         * @return le nombre d'athlete
         */
        return this.lesAthletes.size();
    }

    public double calculerScore(){
        /**
         * donne le score de l'equipe
         * @return le score de l'equipe
         */
        double res=0;
        for(Epreuve epreuve:this.lesEpreuves){
                res+=epreuve.calculerScore(this);
        }
        return res;
    }

    @Override
    public int compareTo(Equipe e){
        /**
         * compare une equipe avec une autre
         * @param une equipe
         * @return un int qui dit si l'equipe a plus de score que d'autre
         */
        return (int)this.calculerScore()-(int)e.calculerScore();
    }

    @Override
    public String toString(){
        /**
         * représentation de l'equipe
         * @return une représentation de l'equipe
         */
        return "Equipe : " + this.nomEquipe + "\n" + " Athletes : " + this.lesAthletes;
    }
}