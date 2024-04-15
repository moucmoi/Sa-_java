import java.util.ArrayList;
import java.util.List;
public abstract class Sport{
    private String nomSport;
    private List<Athlete> lesAthletes;
    private List<Epreuve> lesEpreuves;
  
    public Sport(String nomSport) {
        this.nomSport = nomSport;
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

    public abstract int calculerScore(Athlete athlete);
}