import java.util.List;
import java.util.ArrayList;

public class Athlete implements Comparable<Athlete>{
    private String nom;
    private String prenom;
    private String sexe;
    private int force;
    private int agilite;
    private int endurance;
    public List<Equipe> equipes;


    public Athlete(String nom, String prenom, String sexe, int force, int agilite, int endurance) {
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.force = force;
        this.agilite = agilite;
        this.endurance = endurance;
        this.equipes=new ArrayList<>();
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public void setAgilite(int agilite) {
        this.agilite = agilite;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    public List<Equipe> getEquipes(){
        return this.equipes;
    }

    public void ajouteEquipe(Equipe newEquipe){
        this.equipes.add(newEquipe);
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getSexe() {
        return sexe;
    }

    public int getForce() {
        return force;
    }

    public int getAgilite() {
        return agilite;
    }

    public int getEndurance() {
        return endurance;
    }

    public double participer() {
        double res=0;
        for(Equipe equipe:this.equipes){
            res+=equipe.calculerScore();
        }
        return res;
    }

    @Override
    public int compareTo(Athlete a){
        return (int)this.participer()-(int)a.participer();
    }

    @Override
    public String toString() {
        return this.nom +" "+ this.prenom;
    }


}
