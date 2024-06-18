import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControleurRetour implements EventHandler<ActionEvent> {

    private VueAppliJO vueJO;

    public ControleurRetour(VueAppliJO vueJO) {
        this.vueJO = vueJO;
    }

    public void handle(ActionEvent actionEvent) {
        this.vueJO.pageAccueil();
    }
}