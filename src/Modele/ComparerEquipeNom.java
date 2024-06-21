package src.Modele;
import java.util.Comparator;

public class ComparerEquipeNom implements Comparator<Equipe> {

    @Override
    public int compare(Equipe e1, Equipe e2) {
        return e1.getNom().compareTo(e2.getNom());
    }
}