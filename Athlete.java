import java.util.List;
import java.util.ArrayList;

public class Athlete {
    private String nom;
    private String prenom;
    private String sexe;
    private int force;
    private int agilite;
    private int endurance;
    private Pays pays;
    private Equipe equipe;
    public Sport sport;
    private List<Epreuve> epreuve;


    public Athlete(String nom, String prenom, String sexe, int force, int agilite, int endurance, Pays pays, Equipe equipe, Sport sport, List<Epreuve> epreuve) {
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.force = force;
        this.agilite = agilite;
        this.endurance = endurance;
        this.pays = pays;
        this.equipe = equipe;
        this.sport = sport;
        this.epreuve = epreuve;
    }
    public Pays getPays() {
        return pays;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public Sport getSport() {
        return sport;
    }

    public List<Epreuve> getEpreuve() {
        return epreuve;
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

    
}
