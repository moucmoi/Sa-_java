package src.Controleur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import src.Modele.*;
import src.Vue.*;
import javafx.scene.control.TextField;



public class ControleurAdminCreer implements EventHandler<ActionEvent> {

    private VueAppliJO vueJO;
    private OutilsRequete outilsRequete;

    public ControleurAdminCreer(VueAppliJO vueJO, OutilsRequete outilsRequete) {
        this.vueJO = vueJO;
        this.outilsRequete = outilsRequete;

    }

    public void handle(ActionEvent actionEvent) {
        TextField num = (TextField) this.vueJO.getPageConnexion().lookup("#num");
        String numAthlete = num.getText();
        TextField nom = (TextField) this.vueJO.getPageConnexion().lookup("#nom");
        String nomAthlete = nom.getText();
        TextField prenom = (TextField) this.vueJO.getPageConnexion().lookup("#prenom");
        String prenomAthlete = prenom.getText();
        TextField genre = (TextField) this.vueJO.getPageConnexion().lookup("#genre");
        String genreAthlete = genre.getText();
        TextField force = (TextField) this.vueJO.getPageConnexion().lookup("#force");
        String forceAthlete = force.getText();
        TextField agilite = (TextField) this.vueJO.getPageConnexion().lookup("#agilite");
        String agiliteAthlete = agilite.getText();
        TextField endurance = (TextField) this.vueJO.getPageConnexion().lookup("#endurance");
        String enduranceAthlete = endurance.getText();
        TextField nume = (TextField) this.vueJO.getPageConnexion().lookup("#numequipe");
        String numEquipe = nume.getText();
        TextField or = (TextField) this.vueJO.getPageConnexion().lookup("#or");
        String MedailleOr = or.getText();
        TextField argent = (TextField) this.vueJO.getPageConnexion().lookup("#argent");
        String MedailleArgent = argent.getText();
        TextField bronze = (TextField) this.vueJO.getPageConnexion().lookup("#bronze");
        String MedailleBronze = bronze.getText();

        this.vueJO.popAthleteInserer();
    }
}