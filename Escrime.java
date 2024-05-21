public class Escrime extends Sport{
    public Escrime() {
        super();
        this.nomSport = "Escrime";
    }
    
    @Override
    public double calculerScore(Athlete athlete) {
        return 0.5*athlete.getForce() + 2.5*athlete.getAgilite() + athlete.getEndurance();
    }
}
