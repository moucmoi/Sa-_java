package src.Modele;
import java.util.Comparator;

public class ComparerAthleteMedaille implements Comparator<Athlete> {

    @Override
    public int compare(Athlete a1, Athlete a2) {
        return (a1.getBronze()+a1.getArgent()+a1.getOr())-(a2.getBronze()+a2.getArgent()+a2.getOr());
    }
}