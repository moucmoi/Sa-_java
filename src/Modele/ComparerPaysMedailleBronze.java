package src.Modele;
import java.util.Comparator;

public class ComparerPaysMedailleBronze implements Comparator<Pays> {

    @Override
    public int compare(Pays e1, Pays e2) {
        return e1.getNbMedailleBronze()-e2.getNbMedailleBronze();
    }
}