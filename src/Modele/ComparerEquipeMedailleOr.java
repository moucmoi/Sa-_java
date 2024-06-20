import java.util.Comparator;

public class ComparerEquipeMedailleOr implements Comparator<Equipe> {

    @Override
    public int compare(Equipe e1, Equipe e2) {
        return e1.getOr()-e2.getOr();
    }
}