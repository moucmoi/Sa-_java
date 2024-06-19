import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

import java.sql.*;
import java.sql.*;

public class OutilsRequete {
    ConnexionMySQL laConnexion;
    Statement st;
    Statement st2;
    Statement st3;


    /**
     * Constructeur d'OutilsRequete
     * @param connexionMySQL la classe pour se connecter sur le serveur
     * @throws ClassNotFoundException
     */
    public OutilsRequete(ConnexionMySQL connexionMySQL) throws ClassNotFoundException {
        this.laConnexion = connexionMySQL;
    }

    /**
     * Liste les médailles d'un pays dans l'ordre [or, argent, bronze]
     * @param pays le pays pour lequel on regarde ses médailles
     * @return La liste des médailles en Integer sous forme [or, argent, bronze]
     * @throws SQLException exception SQL
     */
    public List<Integer> listerMedaillesPays(Pays pays) throws SQLException {
        List<Integer> listeRetour = new ArrayList<>();
        this.st = this.laConnexion.createStatement();
        ResultSet rs = null;
        String requete = "SELECT nb_medaille_or, nb_medaille_argent, nb_medaille_argent FROM PAYS WHERE code_pays =" + pays.getCodePays() + ";";
        rs = st.executeQuery(requete);
        listeRetour.add(rs.getInt("nb_medaille_or"));
        listeRetour.add(rs.getInt("nb_medaille_argent"));
        listeRetour.add(rs.getInt("nb_medaille_bronze"));
        rs.close();

        return listeRetour;
    }

    /**
     * Liste les Pays de la base de données
     * @return La liste des pays de la base de données
     * @throws SQLException exception SQL
     */
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

    /**
     * Liste les épreuves pour une équipe précise
     * @param numEquipe le numéro de l'équipe (unique)
     * @return la liste des épreuves de l'équipe
     * @throws SQLException exception SQL
     */
    public List<Epreuve> listerEpreuvePourEquipe(int numEquipe) throws SQLException {
        List<Epreuve> listeRetour = new ArrayList<>();
        this.st2 = this.laConnexion.createStatement();
        ResultSet rs = null;
            String requete = "SELECT * FROM EPREUVE NATURAL JOIN EQUIPE WHERE num_equipe = " + numEquipe + ";";
            rs = st2.executeQuery(requete);
            while (rs.next()){
				listeRetour.add(new Epreuve(rs.getString("nom_epreuve"),rs.getBoolean("homme"),rs.getBoolean("individuel"),new Sport(rs.getString("nom_sport"),rs.getFloat("coeff_force"),rs.getFloat("coeff_agilite"),rs.getFloat("coeff_endurance"))));
			}
			rs.close();
        return listeRetour;
    }

    /**
     * Liste les athlètes pour une équipe précise
     * @param nomSport le numéro de l'équipe (unique)
     * @return la liste des athlètes de l'équipe
     * @throws SQLException exception SQL
     */
    public List<Athlete> listerAthletePourEquipe(int numEquipe) throws SQLException {
        List<Athlete> listeRetour = new ArrayList<>();
        this.st3 = this.laConnexion.createStatement();
        ResultSet rs = null;
            String requete = "SELECT * FROM ATHLETE NATURAL JOIN EQUIPE WHERE num_equipe = " + numEquipe + ";";
            rs = st3.executeQuery(requete);
            while (rs.next()){
				listeRetour.add(new Athlete(rs.getInt("num_athlete"), rs.getString("nom_athlete"),rs.getString("prenom_athlete"), rs.getString("sexe"),  rs.getInt("force"), rs.getInt("agilite"), rs.getInt("endurance"),obtenirEquipe(rs.getInt("num_equipe")), rs.getInt("medaille_or"), rs.getInt("medaille_argent"), rs.getInt("medaille_bronze")));
			}
			rs.close();
        return listeRetour;
    }

    /**
     * Liste les Equipe de la base de données
     * @return La liste des équipes de la base de données
     * @throws SQLException exception SQL
     */

    public List<Equipe> listerEquipe() throws SQLException {
        List<Equipe> listeRetour = new ArrayList<>();
        this.st = this.laConnexion.createStatement();
        ResultSet rs = null;
            String requete = "SELECT * FROM EQUIPE ;";
            rs = st.executeQuery(requete);
            while (rs.next()){

                Equipe equipeEnCours = new Equipe(rs.getInt("num_equipe"), rs.getString("nom_equipe"),obtenirPays(rs.getString("code_pays")));
                List<Epreuve> listeEpreuveEnCours = listerEpreuvePourEquipe(rs.getInt("num_equipe"));
                for (Epreuve epreuve : listeEpreuveEnCours) {
                    equipeEnCours.ajouteEpreuve(epreuve);
                }
                List<Athlete> listeAthletesEnCours= listerAthletePourEquipe(rs.getInt("num_equipe"));
                for (Athlete athlete : listeAthletesEnCours) {
                    equipeEnCours.ajouteAthlete(athlete);
                }
				listeRetour.add(equipeEnCours);
			}
			rs.close();
        return listeRetour;
    }

    /**
     * Permet d'obtenir un Pays précis grâce à son code (unique)
     * @param codePays le code du pays (unique)
     * @return le pays 
     * @throws SQLException exception SQL
     */

    public Pays obtenirPays(String codePays) throws SQLException {
        this.st = this.laConnexion.createStatement();
        ResultSet rs = null;
        String requete = "SELECT * FROM PAYS WHERE code_pays = " + codePays + ";";
        rs = st.executeQuery(requete);
        return new Pays(rs.getString("code_pays"), rs.getString("nom_pays"), rs.getInt("nb_medaille_or"), rs.getInt("nb_medaille_argent"), rs.getInt("nb_medaille_bronze"));
    }

    /**
     * Liste les équipes pour un pays précis
     * @param codePays le code du pays (unique)
     * @return la liste des équipes pour le pays
     * @throws SQLException exception SQL
     */

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


    /**
     * Liste les athlètes de la base de données
     * @return la liste des athlètes de la base des données
     * @throws SQLException exception SQL
     */
    public List<Athlete> listerAthletes() throws SQLException {
        List<Athlete> listeRetour = new ArrayList<>();
        this.st = this.laConnexion.createStatement();
        ResultSet rs = null;
        String requete = "SELECT * FROM ATHLETE ;";
        rs = st.executeQuery(requete);
        while (rs.next()){
            listeRetour.add(new Athlete(rs.getInt("num_athlete"), rs.getString("nom_athlete"),rs.getString("prenom_athlete"), rs.getString("sexe"),  rs.getInt("force"), rs.getInt("agilite"), rs.getInt("endurance"),obtenirEquipe(rs.getInt("num_equipe")), rs.getInt("medaille_or"), rs.getInt("medaille_argent"), rs.getInt("medaille_bronze")));
        }
        rs.close();
        return listeRetour;
    }

    /**
     * Permet d'obtenir une équipe précise grâce à numEquipe (unique)
     * @param numEquipe le numéro de l'équipe (unique)
     * @return l'équipe
     * @throws SQLException exception SQL
     */
    public Equipe obtenirEquipe(int numEquipe) throws SQLException {
        this.st = this.laConnexion.createStatement();
        ResultSet rs = null;
        String requete = "SELECT * FROM EQUIPE WHERE num_equipe = " + numEquipe + ";";
        rs = st.executeQuery(requete);
        return new Equipe(rs.getInt("code_equipe"), rs.getString("nom_equipe"), obtenirPays(rs.getString("code_pays")));
    }

    /**
     * Liste les épreuves de la base de données
     * @return la liste des épreuves de la base de données
     * @throws SQLException exception SQL
     */
    public List<Epreuve> listerEpreuve() throws SQLException {
        List<Epreuve> listeRetour = new ArrayList<>();
        this.st = this.laConnexion.createStatement();
        ResultSet rs = null;
        String requete="SELECT * FROM EPREUVE NATURAL JOIN SPORT;";
        rs=st.executeQuery(requete);
        while(rs.next()){
            listeRetour.add(new Epreuve(rs.getString("nom_epreuve"),rs.getBoolean("homme"),rs.getBoolean("individuel"),new Sport(rs.getString("nom_sport"),rs.getFloat("coeff_force"),rs.getFloat("coeff_agilite"),rs.getFloat("coeff_endurance"))));
        }
        rs.close();
        return listeRetour;
    }

    /**
     * Liste les Sports de la base de données
     * @return la liste des sports de la base de données
     * @throws SQLException exception SQL
     */
    public List<Sport> listerSport() throws SQLException {
        List<Sport> listeRetour = new ArrayList<>();
        this.st = this.laConnexion.createStatement();
        ResultSet rs = null;
        String requete="SELECT * SPORT;";
        rs=st.executeQuery(requete);
        while(rs.next()){
            Sport sportEnCours = new Sport(rs.getString("nom_sport"),rs.getFloat("coeff_force"),rs.getFloat("coeff_agilite"),rs.getFloat("coeff_endurance"));
            List<Epreuve> lesEpreuvesEnCours = listerEpreuvePourSport(rs.getString("nom_sport"));
            for (Epreuve epreuve : lesEpreuvesEnCours) {
                sportEnCours.ajouteEpreuve(epreuve);
            }
            listeRetour.add(sportEnCours);
        }
        rs.close();
        return listeRetour;
    }

    /**
     * Liste les épreuves pour un sport précis
     * @param nomSport le nom du sport (unique)
     * @return la liste des épreuves du sport
     * @throws SQLException exception SQL
     */
    public List<Epreuve> listerEpreuvePourSport(String nomSport) throws SQLException {
        List<Epreuve> listeRetour = new ArrayList<>();
        this.st2 = this.laConnexion.createStatement();
        ResultSet rs = null;
            String requete = "SELECT * FROM EPREUVE NATURAL JOIN SPORT WHERE nom_sport = " + nomSport + ";";
            rs = st2.executeQuery(requete);
            while (rs.next()){
				listeRetour.add(new Epreuve(rs.getString("nom_epreuve"),rs.getBoolean("homme"),rs.getBoolean("individuel"),new Sport(rs.getString("nom_sport"),rs.getFloat("coeff_force"),rs.getFloat("coeff_agilite"),rs.getFloat("coeff_endurance"))));
			}
			rs.close();
        return listeRetour;
    }

    public void inscription(String nomUtilisateur, String motDePasse) throws SQLException {
        this.st = this.laConnexion.createStatement();
        ResultSet rs = null;
            String requete = "INSERT INTO UTILISATEUR VALUES(" ;
    }

    public List<Button> barreRechercheGeneral(String mot) throws SQLException{
        List<Button> res=new ArrayList<>();
        this.st = this.laConnexion.createStatement();
        ResultSet rsPays = null;
        ResultSet rsAthlete = null;
        ResultSet rsEquipe = null;
        ResultSet rsEpreuve = null;
        ResultSet rsSport = null;
        String requetePays="SELECT nom_pays FROM Pays where nom_pays like '%"+mot+"%'";
        rsPays=st.executeQuery(requetePays);
        String requeteAthlete="SELECT nom_athlete, prenom_athlete where nom_athlete like '%"+mot+"%'";
        rsAthlete=st.executeQuery(requeteAthlete);
        String requeteEquipe="SELECT nom_equipe FROM Pays where nom_equipe like '%"+mot+"%'";
        rsEquipe=st.executeQuery(requeteEquipe);
        String requeteEpreuve="SELECT nom_epreuve FROM Pays where nom_epreuve like '%"+mot+"%'";
        rsEpreuve=st.executeQuery(requeteEpreuve);
        String requeteSport="SELECT nom_sport FROM Pays where nom_sport like '%"+mot+"%'";
        rsSport=st.executeQuery(requeteSport);
        while(rsPays.next()){
            Button button=new Button(rsPays.getString("nom_pays"));
            res.add(button);
        }
        while(rsAthlete.next()){
            Button button=new Button(rsAthlete.getString("nom_athlete"));
            res.add(button);
        }
        while(rsEquipe.next()){
            Button button=new Button(rsPays.getString("nom_equipe"));
            res.add(button);
        }
        while(rsEpreuve.next()){
            Button button=new Button(rsEpreuve.getString("nom_epreuve"));
            res.add(button);
        }
        while(rsSport.next()){
            Button button=new Button(rsPays.getString("nom_sport"));
            res.add(button);
        }
        return res;
    }
}

