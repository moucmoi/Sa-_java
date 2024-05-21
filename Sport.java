import java.util.ArrayList;
import java.util.List;
public abstract class Sport{
    protected String nomSport;
    protected List<Athlete> lesAthletes;
    protected List<Epreuve> lesEpreuves;
  
    public Sport() {
        this.lesAthletes = new ArrayList<>();
        this.lesEpreuves = new ArrayList<>();
    }

    public String getNomSport() {
        return nomSport;
    }

    public List<Athlete> getLesAthletes() {
        return lesAthletes;
    }

    public List<Epreuve> getLesEpreuves() {
        return lesEpreuves;
    }

    public void ajouteAthlete(Athlete athlete) {
        this.lesAthletes.add(athlete);
    }

    public void ajouteEpreuve(Epreuve epreuve) {
        this.lesEpreuves.add(epreuve);
    }

    public abstract double calculerScore(Athlete athlete);
}