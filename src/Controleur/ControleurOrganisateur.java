package src.Controleur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import src.Modele.*;
import src.Vue.*;

public class ControleurOrganisateur implements EventHandler<ActionEvent> {

    private VueAppliJO vueJO;

    public ControleurOrganisateur(VueAppliJO vueJO) {
        this.vueJO = vueJO;
    }

    public void handle(ActionEvent actionEvent) {
        this.vueJO.pageOrganisateurAccueil();
    }
}

/*
        Button boutonclique = (Button) actionEvent.getSource();
        String textBouton = boutonclique.getText();
        if (textBouton.contains("Connexion")) {
            this.vueJO.pageConnexion();
        }
        if (textBouton.contains("Inscription")) {
            this.vueJO.pageInscription();
        }
*/
