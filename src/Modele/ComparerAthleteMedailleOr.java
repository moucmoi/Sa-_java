import java.util.Comparator;

public class ComparerAthleteMedailleOr implements Comparator<Athlete> {

    @Override
    public int compare(Athlete a1, Athlete a2) {
        return a1.getOr()-a2.getOr();
    }
}