import java.util.List;
import java.util.ArrayList;

public class Pays implements Comparable<Pays>{
    private String nomPays;
    private String codePays;
    private int nbMedailleOr;
    private int nbMedailleArgent;
    private int nbMedailleBronze;
    private List<Equipe> lesEquipes;
    
    public Pays(String nomPays, String codePays) {
        /**
         * Constructeur de la classe, instancie les nombres de médailles à 0 et la liste vide
         * @param nomPays le nom du pays
         * @param codePays le code du pays
         */
        this.nomPays = nomPays;
        this.codePays = codePays;
        this.lesEquipes = new ArrayList<>();
        this.nbMedailleBronze = 0;
        this.nbMedailleArgent = 0;
        this.nbMedailleOr = 0;
    }

    public String getNomPays() {
        /**
         * Retourne le nom du pays 
         * @return le nom du pays
         */
        return nomPays;
    }

    public String getCodePays() {
        /**
         * Retourne le code du pays
         * @return le code du pays
         */
        return codePays;
    }

    public int getNbMedaille() {
        /**
         * Retourne le nombre de médaille total du pays
         * @return nombre de médaille total du pays
         */
        return this.nbMedailleOr + this.nbMedailleArgent + this.nbMedailleBronze;
    }

    public int getNbMedailleOr() {
        /**
         * Retourne le nombre de médaille en or du pays
         * @return nombre de médaille en or du pays
         */
        return nbMedailleOr;
    }

    public int getNbMedailleArgent() {
        /**
         * Retourne le nombre de médaille en argent du pays
         * @return nombre de médaille en argent du pays
         */
        return nbMedailleArgent;
    }

    public int getNbMedailleBronze() {
        /**
         * Retourne le nombre de médaille en bronze du pays
         * @return nombre de médaille en bronze du pays
         */
        return nbMedailleBronze;
    }

    public void ajouteEquipe(Equipe newEquipe) {
        /**
         * Ajoute une équipe au pays
         * @param equipe l'Equipe à ajouter
         */
        this.lesEquipes.add(newEquipe);
    }

    public List<Equipe> getLesEquipes() {
        /**
         * Retourne les équipes du pays
         * @return les équipes du pays
         */
        return this.lesEquipes;
    }
    public double calculerScore(){
        /**
         * Retourne le score pour les equipes du pays
         * @return le score calculé
         */
        double res=0;
        for(Equipe equipe:this.lesEquipes){
            res+=equipe.calculerScore();
        }
        return res+nbMedailleOr+nbMedailleArgent/2+nbMedailleBronze/4;
    }

    public void ajouteOr(){
        /**
         * Ajoute une médaille d'or au pays
         */
        this.nbMedailleOr+=1;
    }

    public void ajouteBronze(){
        /**
         * Ajoute une médaille de bronze au pays
         */
        this.nbMedailleBronze+=1;
    }

    public void ajouteArgent(){
        /**
         * Ajoute une médaille d'argent au pays
         */
        this.nbMedailleArgent+=1;
    }

    @Override
    public int compareTo(Pays p){
        /**
         * comparateur naturel du pays
         * @param p un autre Pays
         */
        return (int)this.calculerScore()-(int)p.calculerScore();
    }

    @Override
    public String toString() {
        /**
         * toString du pays
         * @return le string
         */
        return "Nom: " + this.nomPays +"\n"+ " Code: " + this.codePays + "\n" + " Nombre de Médailles" +"\n"+ " Or: " + this.nbMedailleOr +"\n"+ " Argent: " + this.nbMedailleArgent +"\n"+ " Bronze " + this.nbMedailleBronze;
    }
}
