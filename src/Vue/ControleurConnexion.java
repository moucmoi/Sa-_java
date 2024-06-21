import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
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
        TextField textUtilisateur = (TextField) this.vueJO.getPageConnexion().lookup("#textfield");
        PasswordField passwordfieldUtilisateur = (PasswordField) this.vueJO.getPageConnexion().lookup("#passwordfield");
        String nomUtilisateur = textUtilisateur.getText() ;
        String mdp = passwordfieldUtilisateur.getText();
        System.out.println(nomUtilisateur);
        System.out.println(mdp); 
        try {
         int retour = outilsRequete.verifConnexion(nomUtilisateur, mdp);
         System.out.println(retour);

         if (retour == 0) {
             this.vueJO.pageJournalisteIPays();
         }
         else if (retour == 1) {
<<<<<<< HEAD
            //this.vueJO.pageOrganisateurAcceuil();
=======
            this.vueJO.pageOrganisateurAcceuil();
>>>>>>> 8d6bcfbe5f4c2c218ed9f0507b7a3bb3b9a5fcb2
         }
         else if (retour == 2) {
             this.vueJO.pageAccueilAdmin();
         }
         else {
             this.vueJO.popUpUtilisateurOuMdpIncorrect();
         }
        
        }
        catch (SQLException e) {
<<<<<<< HEAD
            this.vueJO.popUpUtilisateurOuMdpIncorrect(); 
=======
            this.vueJO.popUpUtilisateurOuMdpIncorrect();
>>>>>>> 8d6bcfbe5f4c2c218ed9f0507b7a3bb3b9a5fcb2
        }
    }
}