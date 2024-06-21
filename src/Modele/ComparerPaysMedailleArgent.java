package src.Modele;
import java.util.Comparator;

public class ComparerPaysMedailleArgent implements Comparator<Pays> {

    @Override
    public int compare(Pays e1, Pays e2) {
        return e1.getNbMedailleArgent()-e2.getNbMedailleArgent();
    }
}