import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class Equipe implements Comparable<Equipe>{
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

    public void ajouteAthlete(Athlete athlete) {
        this.lesAthletes.add(athlete);
    }

    public List<Epreuve> getLesEpreuves() {
        return lesEpreuves;
    }

    public List<Athlete> getLesAthletes() {
        return lesAthletes;
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

    public String getNom(){
        return this.nomEquipe;
    }

    public int getNbAthletes() {
        return this.lesAthletes.size();
    }

    public double calculerScore(){
        double res=0;
        for(Epreuve epreuve:this.lesEpreuves){
                res+=epreuve.calculerScore(this);
        }
        return res;
    }

    @Override
    public int compareTo(Equipe e){
        return (int)this.calculerScore()-(int)e.calculerScore();
    }

    @Override
    public String toString(){
        return "Equipe : " + this.nomEquipe + "/n" + " Athletes : " + this.lesAthletes;
    }
}