import java.util.List;
import java.util.ArrayList;


public class Epreuve {
    private String nomEpreuve;
    private boolean homme;
    private boolean individuel;
    private Sport sport;
    private List<Equipe> lesParticipants;


    public Epreuve(String nomEpreuve, boolean homme, boolean individuel, Sport sport){
        this.nomEpreuve = nomEpreuve;
        this.homme = homme;
        this.individuel = individuel;
        this.sport = sport;
        this.lesParticipants=new ArrayList<>();
    }

    public List<Equipe> getlesParticipants(){
        return this.lesParticipants;
    }

    public void ajouteEquipe(Equipe newEquipe){
        this.lesParticipants.add(newEquipe);
    }
    public String getNom(){
        return this.nomEpreuve;
    }

    public boolean getHomme(){
        return this.homme;
    }

    public boolean getIndividuel(){
        return this.individuel;
    }

    public Sport getSport(){
        return this.sport;
    } 

    public double calculerScore(Equipe Equipe){
        double res;
    }

    @Override

    public String toString(){
        return "Epreuve :" + this.nomEpreuve + '\n' + "homme :" + this.homme + "\n" + "individuel" + this.individuel + "\n" + "sport :" + this.sport;
    }
}
