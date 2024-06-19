import java.util.Comparator;

public class ComparerEquipeMedailleBronze implements Comparator<Equipe> {

    @Override
    public int compare(Equipe e1, Equipe e2) {
        return e1.getBronze()-e2.getBronze();
    }
}