import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.sql.*;

public class OutilsRequete {
    ConnexionMySQL laConnexion;
    Statement st;
    Statement st2;

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
            String requete = "SELECT * FROM PAYS ;";
            rs = st.executeQuery(requete);
            while (rs.next()){
                Pays paysEnCours = new Pays(rs.getString("nom_pays"), rs.getString("code_pays"),rs.getInt("nb_medaille_or"),rs.getInt("nb_medaille_argent"),rs.getInt("nb_medaille_bronze"));
                List<Equipe> lesEquipesEnCours = listerEquipePourPays(rs.getString("code_pays"));
                for (Equipe equipe : lesEquipesEnCours) {
                    paysEnCours.ajouteEquipe(equipe);
                }
				listeRetour.add(paysEnCours);
			}
			rs.close();
        return listeRetour;
    }

    public List<Equipe> listerEquipe() throws SQLException {
        List<Equipe> listeRetour = new ArrayList<>();
        this.st = this.laConnexion.createStatement();
        ResultSet rs = null;
            String requete = "SELECT * FROM EQUIPE ;";
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
        String requete = "SELECT * FROM PAYS WHERE code_pays = " + codePays + ";";
        rs = st.executeQuery(requete);
        return new Pays(rs.getString("code_pays"), rs.getString("nom_pays"), rs.getInt("nb_medaille_or"), rs.getInt("nb_medaille_argent"), rs.getInt("nb_medaille_bronze"));
    }

    public List<Equipe> listerEquipePourPays(String codePays) throws SQLException {
        List<Equipe> listeRetour = new ArrayList<>();
        this.st2 = this.laConnexion.createStatement();
        ResultSet rs = null;
            String requete = "SELECT * FROM EQUIPE WHERE code_pays = " + codePays + ";";
            rs = st2.executeQuery(requete);
            while (rs.next()){
				listeRetour.add(new Equipe(rs.getInt("num_equipe"), rs.getString("nom_equipe"),obtenirPays(rs.getString("code_pays"))));
			}
			rs.close();
        return listeRetour;
    }

    public List<Athlete> listerAthletes() throws SQLException {
        List<Athlete> listeRetour = new ArrayList<>();
        this.st = this.laConnexion.createStatement();
        ResultSet rs = null;
        String requete = "SELECT * FROM ATHLETE ;";
        rs = st.executeQuery(requete);
        while (rs.next()){
            listeRetour.add(new Athlete(rs.getInt("num_athlete"), rs.getString("nom_athlete"),rs.getString("prenom_athlete"), rs.getString("sexe"),  rs.getInt("force"), rs.getInt("agilite"), rs.getInt("endurance"),obtenirEquipe(rs.getInt("num_equipe"))));
        }
        rs.close();
        return listeRetour;
    }

    public Equipe obtenirEquipe(int numEquipe) throws SQLException {
        this.st = this.laConnexion.createStatement();
        ResultSet rs = null;
        String requete = "SELECT * FROM EQUIPE WHERE num_equipe = " + numEquipe + ";";
        rs = st.executeQuery(requete);
        return new Equipe(rs.getInt("code_equipe"), rs.getString("nom_equipe"), obtenirPays(rs.getString("code_pays")));
    }


    public List<Epreuve> listerEpreuve() throws SQLException {
        List<Epreuve> liste=new ArrayList<>();
        this.st = this.laConnexion.createStatement();
        ResultSet rs = null;
        String requete="SELECT * FROM EPREUVE";
        rs=st.executeQuery(requete);
        while(rs.next()){
            liste.add(new Epreuve(rs.getString("nom_epreuve"),rs.getBoolean("homme"),rs.getBoolean("individuel"),new Sport(rs.get("nom_sport"))));
        }
    }

}

