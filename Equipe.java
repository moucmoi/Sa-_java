import java.util.List;
import java.util.ArrayList;

public class Equipe {
    private String nomEquipe;
    private List<Athlete> athletes;

    public Equipe(String nomEquipe){
        this.nomEquipe = nomEquipe;
        this.athletes = new ArrayList<>();
    }

    public void ajouteAthlete(Athlete athlete){
        this.athletes.add(athlete);
    }

    public String getNom(){
        return this.nomEquipe;
    }

    public List<Athlete> getLesAthletes(){
        return this.athletes
    }

    @Override

    public String toString(){
        return "Equipe :" + this.nomEquipe + "/n" + "Athletes :" + this.athletes;
    }
}
