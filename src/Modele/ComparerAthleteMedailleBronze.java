package src.Modele;
import java.util.Comparator;

public class ComparerAthleteMedailleBronze implements Comparator<Athlete> {

    @Override
    public int compare(Athlete a1, Athlete a2) {
        return a1.getBronze()-a2.getBronze();
    }
}