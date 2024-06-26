package src.Modele;
import java.util.List;
import java.util.ArrayList;
/**
 * Classe Equipe
 */
public class Equipe implements Comparable<Equipe>{
    private int numEquipe;
    private String nomEquipe;
    private Pays pays;
    private List<Epreuve> lesEpreuves;
    private List<Athlete> lesAthletes;
    private int nbOr;
    private int nbArgent;
    private int nbBronze;

    /**
     * Constructeur demandant un nom et un pays
     * @param numEquipe le numéro de l'équipe
     * @param nomEquipe le nom de l'équipe
     * @param pays le nom du pays de l'équipe
     */
    public Equipe(int numEquipe, String nomEquipe,Pays pays){
        this.numEquipe = numEquipe;
        this.nomEquipe = nomEquipe;
        this.pays=pays;
        this.lesAthletes = new ArrayList<>();
        this.lesEpreuves=new ArrayList<>();
        this.nbOr=0;
        this.nbArgent=0;
        this.nbBronze=0;
    }

    public int getOr() {
        return this.nbOr;
    }

    /**
     * Retourne le nombre de médaille en argent du pays
     * @return nombre de médaille en argent du pays
     */
    public int getArgent() {
        return this.nbArgent;
    }

    /**
     * Retourne le nombre de médaille en bronze du pays
     * @return nombre de médaille en bronze du pays
     */
    public int getBronze() {
        return this.nbBronze;
    }

    /**
     * ajoute un athlete dans la liste d'athlete
     * @param athlete un athlete
     */
    public void ajouteAthlete(Athlete athlete) {
        this.lesAthletes.add(athlete);
    }

    /**
     * donne le numéro de l'équipe
     * @return le numéro de l'équipe
     */
    public int getNum() {
        return this.numEquipe;
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
     * change le numéro de l'équipe
     * @param num le nouveau numéro de l'équipe
     */
    public void setNum(int num) {
        this.numEquipe = num;
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

    public void ajouterMedaille(String medaille){
        if (medaille.equals("Or")){
            this.nbOr++;
        }
        if(medaille.equals("Argent")){
            this.nbArgent++;
        }
        if(medaille.equals("Bronze")){
            this.nbBronze++;
        }
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