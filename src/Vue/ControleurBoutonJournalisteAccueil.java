import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ButtonType;

public class ControleurBoutonJournalisteAccueil implements EventHandler<ActionEvent> {

    private VueAppliJO vueJO;

    public ControleurBoutonJournalisteAccueil(VueAppliJO vueJO) {
        this.vueJO = vueJO;

    }

    public void handle(ActionEvent actionEvent) {
        this.vueJO.pageJournalisteIPays();
    }
}
