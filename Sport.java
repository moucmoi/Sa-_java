public class Sport{
    private String nomSport;
    private double coeffForce;
    private double coeffAgilite;
    private double coeffEndurance;
  

    public String getNomSport() {
        return nomSport;
    }

    public void setNomSport(String nomSport) {
        this.nomSport = nomSport;
    }

    public double getCoeffForce() {
        return coeffForce;
    }

    public void setCoeffForce(double coeffForce) {
        this.coeffForce = coeffForce;
    }

    public double getCoeffAgilite() {
        return coeffAgilite;
    }

    public void setCoeffAgilite(double coeffAgilite) {
        this.coeffAgilite = coeffAgilite;
    }

    public double getCoeffEndurance() {
        return coeffEndurance;
    }

    public void setCoeffEndurance(double coeffEndurance) {
        this.coeffEndurance = coeffEndurance;
    }

    public Sport(String nomSport, double coeffForce, double coeffAgilite, double coeffEndurance){
        this.nomSport = nomSport;
        this.coeffForce = coeffForce;
        this.coeffAgilite = coeffAgilite;
        this.coeffEndurance = coeffEndurance;
    }

    public double calculerScore(Athlete athlete) {
        return this.coeffForce*athlete.getForce() + this.coeffAgilite*athlete.getAgilite() + this.coeffEndurance*athlete.getEndurance();
    }
}