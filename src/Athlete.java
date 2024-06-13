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

    /**
     * Constructeur demandant un nom un prenom, le sexe, la force, l'agilité et l'endurance
     * @param nom le nom de l'athlète
     * @param prenom le prenom de l'athlète
     * @param sexe le sexe de l'athlète
     * @param force la force de l'athlète
     * @param agilite l'agilité de l'athlète
     * @param endurance l'endurance de l'athlète
     */
    public Athlete(String nom, String prenom, String sexe, int force, int agilite, int endurance) {
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.force = force;
        this.agilite = agilite;
        this.endurance = endurance;
        this.equipes=new ArrayList<>();
    }

    /**
     * Méthode qui change le nom de l'athlete
     * @param nom le nom que l'on set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Méthode qui change le prenom
     * @param prenom le prenom que l'on set
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * Méthode qui change le sexe
     * @param sexe le sexe que l'on set
     */
    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    /**
     * Méthode qui change le force
     * @param force le force que l'on set
     */
    public void setForce(int force) {
        this.force = force;
    }

    /**
     * Méthode qui change l'agilité
     * @param agilite l'agilité que l'on set
     */
    public void setAgilite(int agilite) {
        this.agilite = agilite;
    }

    /**
     * Méthode qui change l'endurance
     * @param endurance l'endurance que l'on set
     */
    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    /**
     * Méthode pour obtenir les équipes dans lesquels sont l'athlète
     * @return la liste des équipes
     */
    public List<Equipe> getEquipes(){
        return this.equipes;
    }

    /**
     * Méthode qui ajoute une équipe à l'athlète
     * @param newEquipe
     */
    public void ajouteEquipe(Equipe newEquipe){
        this.equipes.add(newEquipe);
    }

    /**
     * Getter du nom
     * @return le nom de l'athlète
     */
    public String getNom() {
        return nom;
    }

    /**
     * Getter du prénom
     * @return le prénom de l'athlète
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Getter du sexe
     * @return le sexe de l'athlète
     */
    public String getSexe() {
        return sexe;
    }

    /**
     * Getter de la force
     * @return la force de l'athlète
     */
    public int getForce() {
        return force;
    }

    /**
     * Getter de l'agilité
     * @return l'agilité de l'athlète
     */
    public int getAgilite() {
        return agilite;
    }

    /**
     * Getter de l'endurance
     * @return l'endurance de l'athlète
     */
    public int getEndurance() {
        return endurance;
    }

    /**
     * Fonction qui calcule le score d'un athlete
     * @return le score de l'athlète
     */
    public double participer() {
        double res=0;
        for(Equipe equipe:this.equipes){
            res+=equipe.calculerScore();
        }
        return res;
    }

    /**
     * comparateur naturel d'Athlete
     * @param p un autre Athlete
     */
    @Override
    public int compareTo(Athlete a){
        return (int)this.participer()-(int)a.participer();
    }

    /**
     * toString d'Athlete
     * @return le string
     */
    @Override
    public String toString() {
        return this.nom + " " + this.prenom;
    }
}
