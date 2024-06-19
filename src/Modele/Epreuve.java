import java.util.ArrayList;
import java.util.List;
/**
 * Classe Epreuve
 */
public class Epreuve {
    private String nomEpreuve;
    private boolean homme;
    private boolean individuel;
    private Sport sport;


    /**
     * Constructeur demandant un nom un prenom, le sexe, la force, l'agilité et l'endurence 
     * @param nomEpreuve le nom de l'épreuve
     * @param homme un boolean indiquant si l'épreuve est masculine ou féminine, true si masculine, false si féminine
     * @param individuel un boolean indiquant si l'épreuve est individuelle ou non, true si individuelle, false si à plusieurs
     * @param sport le sport qui contient l'épreuve
     */

    public Epreuve(String nomEpreuve, boolean homme, boolean individuel, Sport sport){ 
        this.nomEpreuve = nomEpreuve;
        this.homme = homme;
        this.individuel = individuel;
        this.sport = sport;

    }

    /**
     * change le nom de l'epreuve
     * @param nomEpreuve le nom de l'epreuve 
     */
    public void setNomEpreuve(String nomEpreuve){
        this.nomEpreuve = nomEpreuve;
    }

    /**
     * change le sexe de l'epreuve
     * @param homme boolean indiquant si l'épreuve est homme ou femme 
     */
    public void setHomme(boolean homme) {
        this.homme = homme;
    }

    /**
     * change l'individualité de l'epreuve
     * @param individuel boolean indiquant si l'épreuve est individuelle ou non
     */
    public void setIndividuel(boolean individuel) {
        this.individuel = individuel;
    }

    /**
     * change le sport de l'epreuve
     * @param sport le sport de l'epreuve 
     */
    public void setSport(Sport sport) {
        this.sport = sport;
    }

    /**
     * donne le nom de l'epreuve
     * @return le nom de l'epreuve
     */
    public String getNom(){
        return this.nomEpreuve;
    }

    /**
     * donne le sexe de l'epreuve
     * @return true si l'épreuve est homme, false si elle est femme
     */
    public boolean getHomme(){
        return this.homme;
    }

    /**
     * donne l'individualité de l'epreuve
     * @return l'individualité de l'epreuve
     */
    public boolean getIndividuel(){ 
        return this.individuel;
    }

    /**
     * donne le sport de l'epreuve
     * @return le sport de l'epreuve
     */
    public Sport getSport(){
        return this.sport;
    } 

    /**
     * calcul le sport de l'epreuve
     * @param equipe une équipe
     * @return le score total de l'epreuve
     */
    public double calculerScore(Equipe equipe){
        double res=0;
        for(Athlete athlete:equipe.getLesAthletes()){
            res+=sport.calculerScore(athlete);
        }
        return res;
    }

    public int idMax(List<Double> liste){
        Double max=null;
        int id=0;
        for(int i=0; i<liste.size();i++){
            if(max.equals(null)||liste.get(i)>max){
                max=liste.get(i);
                id=i;
            }
        }
        return id;
    }

    public List<Equipe> simulerEpreuve(List<Equipe> liste){
        List<Equipe> rep=new ArrayList<>();
        List<Double> listeScore=new ArrayList<>();
        for(Equipe e:liste){
            Double score=0.0;
            for(Athlete a:e.getLesAthletes()){
                score+=a.participer(this);
            }
            listeScore.add(score);
        }
        for(int i=0;i<listeScore.size();i++){
            int meilleur=idMax(listeScore);
            rep.add(liste.get(meilleur));
            liste.remove(meilleur);
            listeScore.remove(meilleur);
        }
        return rep;
    }

    /**
     * donne une représentaion de l'epreuve
     * @return une représentation de l'epreuve
     */
    @Override
    public String toString(){
        return "Epreuve : " + this.nomEpreuve + '\n' + " homme : " + this.homme + "\n" + " individuel : " + this.individuel + "\n" + " sport : " + this.sport;
    }

    


}
