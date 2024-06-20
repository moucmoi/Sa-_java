import java.util.Comparator;

public class ComparerPaysNom implements Comparator<Pays> {

    @Override
    public int compare(Pays e1, Pays e2) {
        return e1.getNomPays().compareTo(e2.getNomPays());
    }
}