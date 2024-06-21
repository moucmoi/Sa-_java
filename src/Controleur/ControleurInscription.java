package src.Controleur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.sql.*;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import src.Modele.*;
import src.Vue.*;

public class ControleurInscription implements EventHandler<ActionEvent> {

    private VueAppliJO vueJO;
    private OutilsRequete outilsRequete;

    public ControleurInscription(VueAppliJO vueJO, OutilsRequete outilsRequete) {
        this.vueJO = vueJO;
        this.outilsRequete = outilsRequete;
    }

    public void handle(ActionEvent actionEvent) {
        TextField textUtilisateur = (TextField) this.vueJO.getPageConnexion().lookup("#textfield");
        PasswordField passwordfieldUtilisateur1 = (PasswordField) this.vueJO.getPageConnexion().lookup("#passwordfield1");
        PasswordField passwordfieldUtilisateur2 = (PasswordField) this.vueJO.getPageConnexion().lookup("#passwordfield2");
        String nomUtilisateur = textUtilisateur.getText() ;
        String mdp1 = passwordfieldUtilisateur1.getText();
        String mdp2 = passwordfieldUtilisateur2.getText();
        try{
            if(mdp1.equals(mdp2)){
            boolean retour = this.outilsRequete.inscription(nomUtilisateur, mdp1);
            if (retour) {
                this.vueJO.pageConnexion();
            }
            else {
                this.vueJO.popUpInscriptionIncorrect();
            }   
        }
        }
        catch(SQLException e){
            
        }
        
    }
}