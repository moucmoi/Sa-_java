import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControleurBoutonAccueil implements EventHandler<ActionEvent> {
  
    private VueAppliJO vueJO;

    public ControleurBoutonAccueil(VueAppliJO vueJO) {
        this.vueJO = vueJO;
    }

    public void handle(ActionEvent actionEvent) {

        if (actionEvent.getSource().getText().contains()) {
            this.vueJO.pageConnexion();
        }
        if (actionEvent.getSource().getText().contains()) {
            this.vueJO.pageInscription();
        }
    }
}