import java.util.List;
import java.util.ArrayList;

public class Equipe implements Comparable<Equipe>{
    private String nomEquipe;
    private Pays pays;
    private List<Epreuve> lesEpreuves;
    private List<Athlete> lesAthletes;

    /**
     * Constructeur demandant un nom et un pays
     * @param nomEquipe le nom de l'équipe
     * @param pays le nom du pays de l'équipe
     */
    public Equipe(String nomEquipe,Pays pays){
        this.nomEquipe = nomEquipe;
        this.pays=pays;
        this.lesAthletes = new ArrayList<>();
        this.lesEpreuves=new ArrayList<>();
    }

    /**
     * ajoute un athlete dans la liste d'athlete
     * @param athlete un athlete
     */
    public void ajouteAthlete(Athlete athlete) {
        this.lesAthletes.add(athlete);
    }

    /**
     * donne la liste des epreuves
     * @return liste des epreuves
     */
    public List<Epreuve> getLesEpreuves() {
        return lesEpreuves;
    }

    /**
     * donne de la liste des athletes
     * @return liste des athlete
     */
    public List<Athlete> getLesAthletes() {
        return lesAthletes;
    }

    /**
     * ajoute une epreuve dans la liste d'epreuve
     * @param epreuve une epreuve
     */
    public void ajouteEpreuve(Epreuve epreuve){
        this.lesEpreuves.add(epreuve);
    }

    /**
     * donne le pays de l'epreuve
     * @return un pays
     */
    public Pays getPays() {
        return pays;
    }

    /**
     * change le pays d'un pays
     * @param pays un pays
     */
    public void setPays(Pays pays) {
        this.pays = pays;
    }

    /**
     * donne le nom de l'équipe
     * @return le nom de l'équipe
     */
    public String getNom(){
        return this.nomEquipe;
    }

    /**
     * donne le nombre d'athlete 
     * @return le nombre d'athlete
     */
    public int getNbAthletes() {
        return this.lesAthletes.size();
    }

    /**
     * donne le score de l'équipe
     * @return le score de l'équipe
     */
    public double calculerScore(){
        double res=0;
        for(Epreuve epreuve:this.lesEpreuves){
                res+=epreuve.calculerScore(this);
        }
        return res;
    }

    /**
     * compare une équipe avec une autre
     * @param e une équipe
     * @return un int qui dit si l'équipe a plus de score que d'autre
     */
    @Override
    public int compareTo(Equipe e){
        return (int)this.calculerScore()-(int)e.calculerScore();
    }

    /**
     * représentation de l'équipe
     * @return une représentation de l'équipe
     */
    @Override
    public String toString(){
        return "Equipe : " + this.nomEquipe + "\n" + " Athletes : " + this.lesAthletes;
    }
}