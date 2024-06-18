import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ControleurBoutonAccueil implements EventHandler<ActionEvent> {
  
    private VueAppliJO vueJO;

    public ControleurBoutonAccueil(VueAppliJO vueJO) {
        this.vueJO = vueJO;
    }

    public void handle(ActionEvent actionEvent) {
        Button boutonclique = (Button) actionEvent.getSource();
        String textBouton = boutonclique.getText();
        if (textBouton.contains("Connexion")) {
            this.vueJO.pageConnexion();
        }
        if (textBouton.contains("Inscription")) {
            this.vueJO.pageInscription();
        }
    }
}