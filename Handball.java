public class Handball extends Sport {

    public Handball(String nomSport) {
        super(nomSport);
    }

    @Override
    public int calculerScore(Athlete athlete) {
        return athlete.getForce() + 1.5*athlete.getAgilite() + 1.5*athlete.getEndurance();
    }
}
