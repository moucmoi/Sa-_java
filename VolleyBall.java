public class VolleyBall extends Sport{
    public VolleyBall(String nomSport) {
        super(nomSport);
    } 
    
    @Override
    public double calculerScore(Athlete athlete) {
        return 1.5*athlete.getForce() + athlete.getAgilite() + 1.5*athlete.getEndurance();
    }   
}
