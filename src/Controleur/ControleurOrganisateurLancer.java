package src.Controleur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import src.Modele.*;
import src.Vue.*;

public class ControleurOrganisateurLancer implements EventHandler<ActionEvent> {

    private VueAppliJO vueJO;
    private JO modele;

    public ControleurOrganisateurLancer(VueAppliJO vueJO, JO modele) {
        this.vueJO = vueJO;
        this.modele = modele;
    }

    public void handle(ActionEvent actionEvent) {
        System.out.println(modele.getLancer());
        if(this.modele.getLancer()){
            this.vueJO.popUpDejaLancer().showAndWait();
        }
        else{
            this.modele.changerLancer();
            this.vueJO.popUpLancer().showAndWait();
            this.modele.simulationJO();
        }
        System.out.println(modele.getLancer());
    }
}
