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

    public void setNomEpreuve(String nomEpreuve) {
        this.nomEpreuve = nomEpreuve;
    }

    public void setHomme(boolean homme) {
        this.homme = homme;
    }

    public void setIndividuel(boolean individuel) {
        this.individuel = individuel;
    }

    public void setSport(Sport sport) {
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

    public double calculerScore(Equipe equipe){
        double res=0;
        for(Athlete athlete:equipe.getLesAthletes()){
            res+=sport.calculerScore(athlete);
        }
        return res;
    }

    @Override
    public String toString(){
        return "Epreuve :" + this.nomEpreuve + '\n' + "homme :" + this.homme + "\n" + "individuel" + this.individuel + "\n" + "sport :" + this.sport;
    }
}
