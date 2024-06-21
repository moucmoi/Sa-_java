package src.Modele;
import java.util.Comparator;

public class ComparerPaysMedaille implements Comparator<Pays> {

    @Override
    public int compare(Pays e1, Pays e2) {
        return e1.getNbMedaille()-e2.getNbMedaille();
    }
}