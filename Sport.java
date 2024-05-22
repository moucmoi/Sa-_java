import java.util.ArrayList;
import java.util.List;
public class Sport{
    private String nomSport;
    private List<Epreuve> lesEpreuves;
    private double coeffForce;
    private double coeffAgilite;
    private double coeffEndurance;
  

    public Sport(String nomSport, double coeffForce, double coeffAgilite, double coeffEndurance) {
        this.nomSport = nomSport;
        this.coeffForce = coeffForce;
        this.coeffAgilite = coeffAgilite;
        this.coeffEndurance = coeffEndurance;
        this.lesEpreuves = new ArrayList<>();
    }

    public String getNomSport() {
        return nomSport;
    }

    public List<Epreuve> getLesEpreuves() {
        return lesEpreuves;
    }

    public void ajouteEpreuve(Epreuve epreuve) {
        this.lesEpreuves.add(epreuve);
    }

    public double calculerScore(Athlete athlete) {
        return this.coeffForce*athlete.getForce() + this.coeffAgilite*athlete.getAgilite() + this.coeffEndurance*athlete.getEndurance();
    }
}