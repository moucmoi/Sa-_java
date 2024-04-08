import java.util.ArrayList;
import java.util.List;
public abstract class Sport{
    protected String nomSport;
    public List<Athlete> lesAthletes;
    public List<Epreuve> lesEpreuves;


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

}

