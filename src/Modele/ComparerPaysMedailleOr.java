package src.Modele;
import java.util.Comparator;

public class ComparerPaysMedailleOr implements Comparator<Pays> {

    @Override
    public int compare(Pays e1, Pays e2) {
        return e1.getNbMedailleOr()-e2.getNbMedailleOr();
    }
}