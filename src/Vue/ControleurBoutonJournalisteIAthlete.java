import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ButtonType;

public class ControleurBoutonJournalisteIAthlete implements EventHandler<ActionEvent> {

    private VueAppliJO vueJO;

    public ControleurBoutonJournalisteIAthlete(VueAppliJO vueJO) {
        this.vueJO = vueJO;

    }

    public void handle(ActionEvent actionEvent) {
        this.vueJO.pageJournalisteIAthlete();
    }
}