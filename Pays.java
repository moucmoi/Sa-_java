import java.util.List;
import java.util.ArrayList;

public class Pays {
    private String nomPays;
    private String codePays;
    private int nbMedailleOr;
    private int nbMedailleArgent;
    private int nbMedailleBronze;
    private List<Athlete> lesAthletes;
    
    public Pays(String nomPays, String codePays) {
        this.nomPays = nomPays;
        this.codePays = codePays;
        this.lesAthletes = new ArrayList<>();
    }

    public String getNomPays() {
        return nomPays;
    }

    public String getCodePays() {
        return codePays;
    }

    public int getNbMedaille() {
        return this.nbMedailleOr + this.nbMedailleArgent + this.nbMedailleBronze;
    }

    public int getNbMedailleOr() {
        return nbMedailleOr;
    }

    public int getNbMedailleArgent() {
        return nbMedailleArgent;
    }

    public int getNbMedailleBronze() {
        return nbMedailleBronze;
    }

    public void ajouteAthlete(Athlete newAthlete) {
        this.lesAthletes.add(newAthlete);
    }

    public List<Athlete> getLesAthletes() {
        return this.lesAthletes;
    }

    @Override
    public String toString() {
        return this.nomPays + " " + this.codePays;
    }
}
