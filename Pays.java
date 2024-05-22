import java.util.List;
import java.util.ArrayList;

public class Pays {
    private String nomPays;
    private String codePays;
    private int nbMedailleOr;
    private int nbMedailleArgent;
    private int nbMedailleBronze;
    private List<Athlete> lesEquipes;
    
    public Pays(String nomPays, String codePays) {
        this.nomPays = nomPays;
        this.codePays = codePays;
        this.lesEquipes = new ArrayList<>();
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

    public void ajouteEquipe(Athlete newEquipe) {
        this.lesEquipes.add(newEquipe);
    }

    public List<Athlete> getLesEquipes() {
        return this.lesEquipes;
    }

    //faire calculer score

    @Override
    public String toString() {
        return "Nom: " + this.nomPays + " Code: " + this.codePays + "\n" + " Nombre de Médailles" + " Or: " + this.nbMedailleOr + " Argent: " + this.nbMedailleArgent + " Bronze " + this.nbMedailleBronze;
    }
}
