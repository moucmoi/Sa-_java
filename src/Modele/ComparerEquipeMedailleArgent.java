import java.util.Comparator;

public class ComparerEquipeMedailleArgent implements Comparator<Equipe> {

    @Override
    public int compare(Equipe e1, Equipe e2) {
        return e1.getArgent()-e2.getArgent();
    }
}