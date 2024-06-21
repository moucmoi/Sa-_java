package src.Modele;
import java.util.Comparator;

public class ComparerAthleteMedailleArgent implements Comparator<Athlete> {

    @Override
    public int compare(Athlete a1, Athlete a2) {
        return a1.getArgent()-a2.getArgent();
    }
}