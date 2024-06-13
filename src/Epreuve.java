public class Epreuve {
    private String nomEpreuve;
    private boolean homme;
    private boolean individuel;
    private Sport sport;


    public Epreuve(String nomEpreuve, boolean homme, boolean individuel, Sport sport){
        /**Constructeur demandant un nom un prenom, le sexe, la force, l'agilité et l'endurence */
        this.nomEpreuve = nomEpreuve;
        this.homme = homme;
        this.individuel = individuel;
        this.sport = sport;
    }


    public void setNomEpreuve(String nomEpreuve){
        /**
         * change le nom de l'epreuve
         * @param le nom de l'epreuve 
         */
        this.nomEpreuve = nomEpreuve;
    }

    public void setHomme(boolean homme) {
        /**
         * change le sexe de l'epreuve
         * @param le sexe de l'epreuve 
         */
        this.homme = homme;
    }

    public void setIndividuel(boolean individuel) {
        /**
         * change le l'individualité de l'epreuve
         * @param le individualité de l'epreuve 
         */
        this.individuel = individuel;
    }

    public void setSport(Sport sport) {
        /**
         * change le sport de l'epreuve
         * @param le sport de l'epreuve 
         */
        this.sport = sport;
    }

    public String getNom(){
        /**
         * donne le nom de l'epreuve
         * @return le nom de l'epreuve
         */
        return this.nomEpreuve;
    }

    public boolean getHomme(){
        /**
         * donne le sexe de l'epreuve
         * @return le sexe de l'epreuve
         */
        return this.homme;
    }

    public boolean getIndividuel(){
        /**
         * donne le l'individualité de l'epreuve
         * @return le individualité de l'epreuve
         */
        return this.individuel;
    }

    public Sport getSport(){
        /**
         * donne le sport de l'epreuve
         * @return le sport de l'epreuve
         */
        return this.sport;
    } 

    public double calculerScore(Equipe equipe){
        /**
         * calcul le sport de l'epreuve
         * @param une équipe
         * @return le score total de l'epreuve
         */
        double res=0;
        for(Athlete athlete:equipe.getLesAthletes()){
            res+=sport.calculerScore(athlete);
        }
        return res;
    }

    @Override
    public String toString(){
        /**
         * donne une représentaion de l'epreuve
         * @return une représentaion de l'epreuve
         */
        return "Epreuve : " + this.nomEpreuve + '\n' + " homme : " + this.homme + "\n" + " individuel : " + this.individuel + "\n" + " sport : " + this.sport;
    }
}
