package src.Controleur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import src.Modele.*;
import src.Vue.*;



public class ControleurAdmin implements EventHandler<ActionEvent> {

    private VueAppliJO vueJO;

    public ControleurAdmin(VueAppliJO vueJO) {
        this.vueJO = vueJO;
    }

    public void handle(ActionEvent actionEvent) {
        this.vueJO.pageAccueilAdmin();
    }
}