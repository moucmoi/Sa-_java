import java.beans.Statement;
import java.sql.SQLException;
import java.util.List;

public class OutilsRequete {
    private ConnexionMySQL laConnexion;
    private Statement st;

    public OutilsRequete() throws ClassNotFoundException {
        laConnexion = new ConnexionMySQL();
    }

    List<int> listerMedaillesPays(Pays pays) throws SQLException {
        this.st = this.laConnexion.createStatement();
        try {
            String requete = “SELECT nb_medaille_or, nb_medaille_argent, nb_medaille_argent FROM PAYS WHERE code_pays =” + pays.getCodePays() 
        st.executeUpdate(requete);
        }
            catch (Exception e) {
                throw new SQLException();
            }
}

}
