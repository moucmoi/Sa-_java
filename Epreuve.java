import java.util.List;
import java.util.ArrayList;

public class Epreuve {
    private String nomEpreuve;
    private boolean homme;
    private boolean individuel;
    private Sport sport;

    public Epreuve(String nomEpreuve, boolean homme, boolean individuel, Sport sport){
        this.nomEpreuve = nomEpreuve;
        this.homme = homme;
        this.individuel = individuel;
        this.sport = sport;
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

    @Override

    public String toString(){
        return "Epreuve :" + this.nomEpreuve + '\n' + "homme :" + this.homme + "\n" + "individuel" + this.individuel + "\n" + "sport :" + this.sport;
    }
}
