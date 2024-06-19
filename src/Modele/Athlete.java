import java.util.List;

/**
 * Classe Athlete
 */
public class Athlete implements Comparable<Athlete>{
    private int numAthlete;
    private String nom;
    private String prenom;
    private String sexe;
    private int force;
    private int agilite;
    private int endurance;
    private int nbOr;
    private int nbArgent;
    private int nbBronze;
    private Equipe equipe;

    /**
     * Constructeur demandant un nom un prenom, le sexe, la force, l'agilité et l'endurance
     * @param numAthlete le numéro de l'athlète
     * @param nom le nom de l'athlète
     * @param prenom le prenom de l'athlète
     * @param sexe le sexe de l'athlète
     * @param force la force de l'athlète
     * @param agilite l'agilité de l'athlète
     * @param endurance l'endurance de l'athlète
     * @param equipe l'équipe de l'athlète
     */
    public Athlete(int numAthlete, String nom, String prenom, String sexe, int force, int agilite, int endurance, Equipe equipe) {
        this.numAthlete = numAthlete;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.force = force;
        this.agilite = agilite;
        this.endurance = endurance;
        this.equipe= equipe;
        this.nbOr=0;
        this.nbArgent=0;
        this.nbBronze=0;

    }

    /**
     * Constructeur demandant un nom un prenom, le sexe, la force, l'agilité, l'endurance et les médailles
     * @param numAthlete le numéro de l'athlète
     * @param nom le nom de l'athlète
     * @param prenom le prenom de l'athlète
     * @param sexe le sexe de l'athlète
     * @param force la force de l'athlète
     * @param agilite l'agilité de l'athlète
     * @param endurance l'endurance de l'athlète
     * @param equipe l'équipe de l'athlète
     * @param nbOr le nombre de médailles d'or
     * @param nbArgent le nombre de médailles d'argent
     * @param nbBronze le nombre de médailles de bronze
     */
    public Athlete(int numAthlete, String nom, String prenom, String sexe, int force, int agilite, int endurance, Equipe equipe, int nbOr, int nbArgent, int nbBronze) {
        this.numAthlete = numAthlete;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.force = force;
        this.agilite = agilite;
        this.endurance = endurance;
        this.equipe= equipe;
        this.nbOr= nbOr;
        this.nbArgent= nbArgent;
        this.nbBronze= nbBronze;
    }
    
    /**
     * Méthode qui change le nom de l'athlete
     * @param nonumAthletem le numéro de l'athlète
     */
    public void setNumAthlete(int numAthlete) {
        this.numAthlete = numAthlete;
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
    public Equipe getEquipe(){
        return this.equipe;
    }

    /**
     * Getter du nom
     * @return le numéro de l'athlète
     */
    public int getNumAthlete() {
        return this.numAthlete;
    }

    /**
     * Getter du nom
     * @return le nom de l'athlète
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * Getter du prénom
     * @return le prénom de l'athlète
     */
    public String getPrenom() {
        return this.prenom;
    }

    /**
     * Getter du sexe
     * @return le sexe de l'athlète
     */
    public String getSexe() {
        return this.sexe;
    }

    /**
     * Getter de la force
     * @return la force de l'athlète
     */
    public int getForce() {
        return this.force;
    }

    /**
     * Getter de l'agilité
     * @return l'agilité de l'athlète
     */
    public int getAgilite() {
        return this.agilite;
    }

    /**
     * Getter de l'endurance
     * @return l'endurance de l'athlète
     */
    public int getEndurance() {
        return this.endurance;
    }

    /**
     * Retourne le nombre de médaille en or du pays
     * @return nombre de médaille en or du pays
     */
    public int getOr() {
        return this.nbOr;
    }

    /**
     * Retourne le nombre de médaille en argent du pays
     * @return nombre de médaille en argent du pays
     */
    public int getArgent() {
        return this.nbArgent;
    }

    /**
     * Retourne le nombre de médaille en bronze du pays
     * @return nombre de médaille en bronze du pays
     */
    public int getBronze() {
        return this.nbBronze;
    }

    /**
     * Fonction qui calcule le score d'un athlete
     * @param epreuve l'épreuve pour laquelle on calcule le score de l'athlète
     * @return le score de l'athlète
     */
    public double participer(Epreuve epreuve) {
        List<Epreuve> lesEpreuves = this.equipe.getLesEpreuves();
        if (lesEpreuves.contains(epreuve)) {
            Sport sport = epreuve.getSport();
            return sport.calculerScore(this);
        }
        return 0;
    }

    public void ajouterMedaille(String medaille){
        if (medaille.equals("Or")){
            this.nbOr++;
        }
        if(medaille.equals("Argent")){
            this.nbArgent++;
        }
        if(medaille.equals("Bronze")){
            this.nbBronze++;
        }
    }
    /**
     * comparateur naturel d'Athlete
     * @param a un autre Athlete
     * @return l'int pour la comparaison
     */
    @Override
    public int compareTo(Athlete a){
        return (int)(this.force+this.agilite+this.endurance)-(int)a.force+a.agilite+a.endurance;
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
