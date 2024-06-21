package src.Controleur;

import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ButtonType;
import src.Modele.*;
import src.Vue.*;

public class ControleurBoutonJournalisteIEquipe implements EventHandler<ActionEvent> {

    private VueAppliJO vueJO;

    public ControleurBoutonJournalisteIEquipe(VueAppliJO vueJO) {
        this.vueJO = vueJO;

    }

    public void handle(ActionEvent actionEvent) {
        this.vueJO.pageJournalisteIEquipe();
    }
}