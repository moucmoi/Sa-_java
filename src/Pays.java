import java.util.List;
import java.util.ArrayList;

public class Pays implements Comparable<Pays>{
    private String nomPays;
    private String codePays;
    private int nbMedailleOr;
    private int nbMedailleArgent;
    private int nbMedailleBronze;
    private List<Equipe> lesEquipes;
    
    /**
     * Constructeur de la classe, instancie les nombres de médailles à 0 et la liste vide
     * @param nomPays le nom du pays
     * @param codePays le code du pays
     */
    public Pays(String nomPays, String codePays) {
        this.nomPays = nomPays;
        this.codePays = codePays;
        this.lesEquipes = new ArrayList<>();
        this.nbMedailleBronze = 0;
        this.nbMedailleArgent = 0;
        this.nbMedailleOr = 0;
    }

    /**
     * Retourne le nom du pays 
     * @return le nom du pays
     */
    public String getNomPays() {
        return nomPays;
    }

    /**
     * Retourne le code du pays
     * @return le code du pays
     */
    public String getCodePays() {
        return codePays;
    }

    /**
     * Retourne le nombre de médaille total du pays
     * @return nombre de médaille total du pays
     */
    public int getNbMedaille() {
        return this.nbMedailleOr + this.nbMedailleArgent + this.nbMedailleBronze;
    }

    /**
     * Retourne le nombre de médaille en or du pays
     * @return nombre de médaille en or du pays
     */
    public int getNbMedailleOr() {
        return nbMedailleOr;
    }

    /**
     * Retourne le nombre de médaille en argent du pays
     * @return nombre de médaille en argent du pays
     */
    public int getNbMedailleArgent() {
        return nbMedailleArgent;
    }

    /**
     * Retourne le nombre de médaille en bronze du pays
     * @return nombre de médaille en bronze du pays
     */
    public int getNbMedailleBronze() {
        return nbMedailleBronze;
    }

    /**
     * Ajoute une équipe au pays
     * @param newEquipe l'Equipe à ajouter
     */
    public void ajouteEquipe(Equipe newEquipe) {
        this.lesEquipes.add(newEquipe);
    }

    /**
     * Retourne les équipes du pays
     * @return les équipes du pays
     */
    public List<Equipe> getLesEquipes() {
        return this.lesEquipes;
    }

    /**
     * Retourne le score pour les equipes du pays
     * @return le score calculé
     */
    public double calculerScore(){
        double res=0;
        for(Equipe equipe:this.lesEquipes){
            res+=equipe.calculerScore();
        }
        return res+nbMedailleOr+nbMedailleArgent/2+nbMedailleBronze/4;
    }

    /**
     * Ajoute une médaille d'or au pays
     */
    public void ajouteOr(){
        this.nbMedailleOr+=1;
    }

    /**
     * Ajoute une médaille de bronze au pays
     */
    public void ajouteBronze(){
        this.nbMedailleBronze+=1;
    }

    /**
     * Ajoute une médaille d'argent au pays
     */
    public void ajouteArgent(){
        this.nbMedailleArgent+=1;
    }

    /**
     * comparateur naturel du pays
     * @param p un autre Pays
     */
    @Override
    public int compareTo(Pays p){
        return (int)this.calculerScore()-(int)p.calculerScore();
    }

    /**
     * toString du pays
     * @return le string
     */
    @Override
    public String toString() {
        return "Nom: " + this.nomPays +"\n"+ " Code: " + this.codePays + "\n" + " Nombre de Médailles" +"\n"+ " Or: " + this.nbMedailleOr +"\n"+ " Argent: " + this.nbMedailleArgent +"\n"+ " Bronze " + this.nbMedailleBronze;
    }
}
