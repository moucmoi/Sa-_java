import java.util.List;
import java.util.ArrayList;

public class Pays {
    private String nomPays;
    private String codePays;
    private int nbMedailleOr;
    private int nbMedailleArgent;
    private int nbMedailleBronze;
    private List<Equipe> lesEquipes;
    
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

    public void ajouteEquipe(Equipe newEquipe) {
        this.lesEquipes.add(newEquipe);
    }

    public List<Equipe> getLesEquipes() {
        return this.lesEquipes;
    }
    public double calculerScore(){
        double res=0;
        for(Equipe equipe:this.lesEquipes){
            res+=equipe.calculerScore();
        }
        return res;
    }

    @Override
    public String toString() {
        return "Nom: " + this.nomPays +"\n"+ " Code: " + this.codePays + "\n" + " Nombre de Médailles" +"\n"+ " Or: " + this.nbMedailleOr +"\n"+ " Argent: " + this.nbMedailleArgent +"\n"+ " Bronze " + this.nbMedailleBronze;
    }
}
