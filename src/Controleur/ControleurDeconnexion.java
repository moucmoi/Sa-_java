package src.Controleur;

import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ButtonType;
import src.Modele.*;
import src.Vue.*;

public class ControleurDeconnexion implements EventHandler<ActionEvent> {

    private VueAppliJO vueJO;

    public ControleurDeconnexion(VueAppliJO vueJO) {
        this.vueJO = vueJO;

    }

    public void handle(ActionEvent actionEvent) {
        Optional<ButtonType> reponse = this.vueJO.popUpDeconnexion().showAndWait();
        if (reponse.isPresent() && reponse.get().equals(ButtonType.YES)){
            this.vueJO.pageAccueil();
        }
    }
}