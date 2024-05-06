public class Athletisme extends Sport{
    
    public Athletisme(String nomSport) {
        super(nomSport);
    }
    
    @Override
    public double calculerScore(Athlete athlete) {
        return 0.5*athlete.getForce() + athlete.getAgilite() + 2*athlete.getEndurance();
    }
}
