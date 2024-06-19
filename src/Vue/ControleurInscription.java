import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControleurInscription implements EventHandler<ActionEvent> {

    private VueAppliJO vueJO;

    public ControleurInscription(VueAppliJO vueJO) {
        this.vueJO = vueJO;
    }

    public void handle(ActionEvent actionEvent) {
        this.vueJO.pageConnexion();
    }
}