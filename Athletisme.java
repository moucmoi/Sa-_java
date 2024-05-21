public class Athletisme extends Sport{
    
    public Athletisme() {
        super();
        this.nomSport = "Athlétisme";
    }
    
    @Override
    public double calculerScore(Athlete athlete) {
        return 0.5*athlete.getForce() + athlete.getAgilite() + 2*athlete.getEndurance();
    }
}
