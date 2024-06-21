package src.Modele;
import java.util.Comparator;

public class ComparerEquipeMedaille implements Comparator<Equipe> {

    @Override
    public int compare(Equipe e1, Equipe e2) {
        return (e1.getBronze()+e1.getArgent()+e1.getOr())-(e2.getBronze()+e2.getArgent()+e2.getOr());
    }
}