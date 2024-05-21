import java.util.List;
import java.util.ArrayList;

public class Equipe {
    private String nomEquipe;
    private List<Athlete> lesAthletes;

    public Equipe(String nomEquipe){
        this.nomEquipe = nomEquipe;
        this.lesAthletes = new ArrayList<>();
    }

    public void ajouteAthlete(Athlete athlete) {
        this.lesAthletes.add(athlete);
    }

    public String getNom() {
        return this.nomEquipe;
    }

    public List<Athlete> getLesAthletes() {
        return this.lesAthletes;
    }

    public int getNbAthletes() {
        return this.lesAthletes.size();
    }

    public double CalculerScoreEquipe() {
        for (Athlete athlete : this.lesAthletes) {
            
        }
    }

    @Override
    public String toString(){
        return "Equipe :" + this.nomEquipe + "/n" + "Athletes :" + this.lesAthletes;
    }
}
