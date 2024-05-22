import java.util.List;
import java.util.ArrayList;

public class Equipe {
    private String nomEquipe;
    private Pays pays;
    private List<Epreuve> lesEpreuves;

    private List<Athlete> lesAthletes;

    public Equipe(String nomEquipe,Pays pays){
        this.nomEquipe = nomEquipe;
        this.pays=pays;
        this.lesAthletes = new ArrayList<>();
        this.lesEpreuves=new ArrayList<>();
    }

    public void ajouteAthlete(Athlete athlete){
        this.lesAthletes.add(athlete);
    }

    public void ajouteEpreuve(Epreuve epreuve){
        this.lesEpreuves.add(epreuve);
    }

    public Pays getPays() {
        return pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
    }

    public List<Epreuve> getLesEpreuves() {
        return lesEpreuves;
    }

    public String getNom(){
        return this.nomEquipe;
    }

    public List<Athlete> getLesAthletes(){
        return this.lesAthletes;
    }

    @Override
    public String toString(){
        return "Equipe :" + this.nomEquipe + "/n" + "Athletes :" + this.lesAthletes;
    }
}
