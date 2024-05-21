public class Handball extends Sport {

    public Handball() {
        super();
        this.nomSport = "Handball";
    }

    @Override
    public double calculerScore(Athlete athlete) {
        return athlete.getForce() + 1.5*athlete.getAgilite() + 1.5*athlete.getEndurance();
    }
}
