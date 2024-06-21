package src.Modele;

import java.util.List;
import java.util.ArrayList;
/**
 * Classe Pays
 */
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
     * Constructeur de la classe avec les médailles en paramètres
     * @param nomPays le nom du pays
     * @param codePays le code du pays
     * @param nb_medaille_or le nombre de médailles d'or
     * @param nb_medaille_argent le nombre de médailles d'argent
     * @param nb_medaille_bronze le nombre de médailles de bronze
     */
    public Pays(String nomPays, String codePays, int nb_medaille_or, int nb_medaille_argent, int nb_medaille_bronze) {
        this.nomPays = nomPays;
        this.codePays = codePays;
        this.lesEquipes = new ArrayList<>();
        this.nbMedailleBronze = nb_medaille_bronze;
        this.nbMedailleArgent = nb_medaille_argent;
        this.nbMedailleOr = nb_medaille_or;
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
     * met à jour le nombre de médaille du pays
     */
    public void majMedaille(){
        for(Equipe e:this.lesEquipes){
                this.nbMedailleOr+=e.getOr();
                this.nbMedailleArgent+=e.getArgent();
                this.nbMedailleBronze+=e.getBronze();
        }
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
