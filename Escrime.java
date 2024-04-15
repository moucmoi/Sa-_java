public class Escrime extends Sport{
    public Escrime(String nomSport) {
        super(nomSport);
    }
    
    @Override
    public int calculerScore(Athlete athlete) {
        return 0.5*athlete.getForce() + 2.5*athlete.getAgilite() + athlete.getEndurance();
    }
}
