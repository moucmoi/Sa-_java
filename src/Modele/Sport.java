package src.Modele;
import java.util.ArrayList;
import java.util.List;
/**
 * Classe Sport
 */
public class Sport{
    private String nomSport;
    private List<Epreuve> lesEpreuves;
    private double coeffForce;
    private double coeffAgilite;
    private double coeffEndurance;
  
    /**
     * Contructeur de la classe, initialise lesEpreuves en une liste vide
     * @param nomSport le nom du sport
     * @param coeffForce le coefficient en force
     * @param coeffAgilite le coefficient en agilite
     * @param coeffEndurance le coefficient en endurance
     */
    public Sport(String nomSport, double coeffForce, double coeffAgilite, double coeffEndurance) {
        this.nomSport = nomSport;
        this.coeffForce = coeffForce;
        this.coeffAgilite = coeffAgilite;
        this.coeffEndurance = coeffEndurance;
        this.lesEpreuves = new ArrayList<>();
    }

    /**
     * Retourne le nom du sport de la classe
     * @return le nom du sport
     */
    public String getNomSport() {
        return nomSport;
    }

    /**
     * Retourne la liste des Epreuves de la classe
     * @return la liste des épreuves
     */
    public List<Epreuve> getLesEpreuves() {
        return lesEpreuves;
    }

    /**
     * Ajoute une epreuve à la classe
     * @param epreuve l'Epreuve à ajouter
     */
    public void ajouteEpreuve(Epreuve epreuve) {
        this.lesEpreuves.add(epreuve);
    }

    /**
     * Set le nom du sport
     * @param nomSport le sport implémenté
     */
    public void setNomSport(String nomSport) {
        this.nomSport = nomSport;
    }

    /**
     * Retourne le coefficient en force de la classe
     * @return le coefficient en force
     */
    public double getCoeffForce() {
        return coeffForce;
    }

    /**
     * Set le coeff de force
     * @param coeffForce le coefficient en force de la classe
     */
    public void setCoeffForce(double coeffForce) {
        this.coeffForce = coeffForce;
    }

    /**
     * Retourne le coefficient en agilité de la classe
     * @return le coefficient en agilité
     */
    public double getCoeffAgilite() {
        return coeffAgilite;
    }

    /**
     * Set le coeff d'agilite
     * @param coeffAgilite le coefficient en agilite de la classe
     */
    public void setCoeffAgilite(double coeffAgilite) {
        this.coeffAgilite = coeffAgilite;
    }

    /**
     * Retourne le coefficient en endurance de la classe
     * @return le coefficient en endurance
     */
    public double getCoeffEndurance() {
        return coeffEndurance;
    }

    /**
     * Set le coeff d'endurance
     * @param coeffEndurance le coefficient en endurance de la classe
     */
    public void setCoeffEndurance(double coeffEndurance) {
        this.coeffEndurance = coeffEndurance;
    }

    /**
     * Retourne le score pour un athlete
     * @param athlete l'athlete pour lequel on calcule son score
     * @return le score calculé
     */
    public double calculerScore(Athlete athlete) {
        return this.coeffForce*athlete.getForce() + this.coeffAgilite*athlete.getAgilite() + this.coeffEndurance*athlete.getEndurance();
    }

    @Override
    public String toString() {
        return this.nomSport;
    }
}