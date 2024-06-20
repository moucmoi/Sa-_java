
import java.sql.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControleurConnexion implements EventHandler<ActionEvent> {

    private VueAppliJO vueJO;
    private OutilsRequete outilsRequete;

     public ControleurConnexion(VueAppliJO vueJO, OutilsRequete outilsRequete) throws SQLException, ClassNotFoundException{
        this.vueJO = vueJO;
        this.outilsRequete = outilsRequete;
    }

    public void handle(ActionEvent actionEvent) {
        String nomUtilisateur = this.vueJO.pageConnexion.lookup("#textfield").getAccessibleText();
        String mdp = this.vueJO.pageConnexion.lookup("#passwordfield").getAccessibleText();
        try {
         int retour = outilsRequete.verifConnexion(nomUtilisateur, mdp);
         if (retour == 0) {
             this.vueJO.pageJournalisteIPays();
         }
         else if (retour == 1) {
             this.vueJO.pageOrganisateurAcceuil();
         }
         else if (retour == 2) {
             this.vueJO.pageAccueilAdmin();
         }
         else {
             this.vueJO.popUpUtilisateurOuMdpIncorrect();
         }
        
        }
        catch (SQLException e) {
        }
    }
}