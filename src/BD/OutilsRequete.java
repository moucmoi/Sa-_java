import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class OutilsRequete {
    ConnexionMySQL laConnexion;
    Statement st;

    public OutilsRequete(ConnexionMySQL connexionMySQL) throws ClassNotFoundException {
        this.laConnexion = connexionMySQL;
    }

    List<Integer> listerMedaillesPays(Pays pays) throws SQLException {
        List<Integer> listeRetour = new ArrayList<>();
        this.st = this.laConnexion.createStatement();
        ResultSet rs = null;
            String requete = "SELECT nb_medaille_or, nb_medaille_argent, nb_medaille_argent FROM PAYS WHERE code_pays =" + pays.getCodePays();
            rs = st.executeQuery(requete);
        listeRetour.add(rs.getInt("nb_medaille_or"));
        listeRetour.add(rs.getInt("nb_medaille_argent"));
        listeRetour.add(rs.getInt("nb_medaille_bronze"));

        return listeRetour;
    }
}
