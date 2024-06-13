
import java.util.ArrayList;
import java.util.List;
public class Sport{
    private String nomSport;
    private List<Epreuve> lesEpreuves;
    private double coeffForce;
    private double coeffAgilite;
    private double coeffEndurance;
  
    public Sport(String nomSport, double coeffForce, double coeffAgilite, double coeffEndurance) {
        /**
         * Contructeur de la classe
         * @param nomSport le nom du sport
         * @param coeffForce le coefficient en force
         * @param coeffAgilite le coefficient en agilite
         * @param coeffEndurance le coefficient en endurance
         * 
         */
        this.nomSport = nomSport;
        this.coeffForce = coeffForce;
        this.coeffAgilite = coeffAgilite;
        this.coeffEndurance = coeffEndurance;
        this.lesEpreuves = new ArrayList<>();
    }

    public String getNomSport() {
        /**
         * Retourne le nom du sport de la classe
         * @return le nom du sport
         */
        return nomSport;
    }

    public List<Epreuve> getLesEpreuves() {
        /**
         * Retourne la liste des Epreuves de la classe
         * @return la liste des épreuves
         */
        return lesEpreuves;
    }

    public void ajouteEpreuve(Epreuve epreuve) {
        /**
         * Ajoute une epreuve à la classe
         * @param epreuve l'Epreuve à ajouter
         */
        this.lesEpreuves.add(epreuve);
    }

    public void setNomSport(String nomSport) {
        /**
         * Set le nom du sport
         * @param nomSport le sport implémenté
         */
        this.nomSport = nomSport;
    }

    public double getCoeffForce() {
        /**
         * Retourne le coefficient en force de la classe
         * @return le coefficient en force
         */
        return coeffForce;
    }

    public void setCoeffForce(double coeffForce) {
        /**
         * Set le coeff de force
         * @param coeffForce le coefficient en force de la classe
         */
        this.coeffForce = coeffForce;
    }

    public double getCoeffAgilite() {
        /**
         * Retourne le coefficient en agilité de la classe
         * @return le coefficient en agilité
         */
        return coeffAgilite;
    }

    public void setCoeffAgilite(double coeffAgilite) {
        /**
         * Set le coeff d'agilite
         * @param coeffAgilite le coefficient en agilite de la classe
         */
        this.coeffAgilite = coeffAgilite;
    }

    public double getCoeffEndurance() {
        /**
         * Retourne le coefficient en endurance de la classe
         * @return le coefficient en endurance
         */
        return coeffEndurance;
    }

    public void setCoeffEndurance(double coeffEndurance) {
        /**
         * Set le coeff d'endurance
         * @param coeffEndurance le coefficient en endurance de la classe
         */
        this.coeffEndurance = coeffEndurance;
    }

    public double calculerScore(Athlete athlete) {
        /**
         * Retourne le score pour un athlete
         * @param athlete l'athlete pour lequel on calcule son score
         * @return le score calculé
         */
        return this.coeffForce*athlete.getForce() + this.coeffAgilite*athlete.getAgilite() + this.coeffEndurance*athlete.getEndurance();
    }
}