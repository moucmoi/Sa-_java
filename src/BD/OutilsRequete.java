import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class OutilsRequete {
    ConnexionMySQL laConnexion;
    Statement st;

    public OutilsRequete(ConnexionMySQL connexionMySQL) throws ClassNotFoundException {
        this.laConnexion = connexionMySQL;
    }

    public List<Integer> listerMedaillesPays(Pays pays) throws SQLException {
        List<Integer> listeRetour = new ArrayList<>();
        this.st = this.laConnexion.createStatement();
        ResultSet rs = null;
        String requete = "SELECT nb_medaille_or, nb_medaille_argent, nb_medaille_argent FROM PAYS WHERE code_pays =" + pays.getCodePays();
        rs = st.executeQuery(requete);
        listeRetour.add(rs.getInt("nb_medaille_or"));
        listeRetour.add(rs.getInt("nb_medaille_argent"));
        listeRetour.add(rs.getInt("nb_medaille_bronze"));
        rs.close();

        return listeRetour;
    }

    public List<Pays> listerPays() throws SQLException {
        List<Pays> listeRetour = new ArrayList<>();
        this.st = this.laConnexion.createStatement();
        ResultSet rs = null;
            String requete = "SELECT * FROM PAYS";
            rs = st.executeQuery(requete);
            while (rs.next()){
				listeRetour.add(new Pays(rs.getString("nom_pays"), rs.getString("code_pays"),rs.getInt("nb_medaille_or"),rs.getInt("nb_medaille_argent"),rs.getInt("nb_medaille_bronze")));
			}
			rs.close();
        return listeRetour;
    }

    public List<Equipe> listerEquipe() throws SQLException {
        List<Equipe> listeRetour = new ArrayList<>();
        this.st = this.laConnexion.createStatement();
        ResultSet rs = null;
            String requete = "SELECT * FROM EQUIPE";
            rs = st.executeQuery(requete);
            while (rs.next()){
				listeRetour.add(new Equipe(rs.getInt("num_equipe"), rs.getString("nom_equipe"),obtenirPays(rs.getString("code_pays"))));
			}
			rs.close();
        return listeRetour;
    }

    public Pays obtenirPays(String codePays) throws SQLException {
        this.st = this.laConnexion.createStatement();
        ResultSet rs = null;
        String requete = "SELECT * FROM PAYS WHERE code_pays = " + codePays;
        rs = st.executeQuery(requete);
        return new Pays(rs.getString("code_pays"), rs.getString("nom_pays"), rs.getInt("nb_medaille_or"), rs.getInt("nb_medaille_argent"), rs.getInt("nb_medaille_bronze"));
    }
}
