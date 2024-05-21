public class VolleyBall extends Sport{
    public VolleyBall() {
        super();
        this.nomSport = "Volley-Ball";
    }
    
    @Override
    public double calculerScore(Athlete athlete) {
        return 1.5*athlete.getForce() + athlete.getAgilite() + 1.5*athlete.getEndurance();
    }   
}
