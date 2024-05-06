public class Natation extends Sport{
    public Natation(String nomSport) {
        super(nomSport);
    }
    
    @Override
    public int calculerScore(Athlete athlete) {
        return athlete.getForce() + 0.5*athlete.getAgilite() + 2.5*athlete.getEndurance();
    }
}
