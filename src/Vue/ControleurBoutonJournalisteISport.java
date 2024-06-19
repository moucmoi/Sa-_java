import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ButtonType;

public class ControleurBoutonJournalisteISport implements EventHandler<ActionEvent> {

    private VueAppliJO vueJO;

    public ControleurBoutonJournalisteISport(VueAppliJO vueJO) {
        this.vueJO = vueJO;

    }

    public void handle(ActionEvent actionEvent) {
        this.vueJO.pageJournalisteISport();
    }
}