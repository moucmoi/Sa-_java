import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ButtonType;

public class ControleurDeconnexion implements EventHandler<ActionEvent> {

    private VueAppliJO vueJO;

    public ControleurDeconnexion() {
        // A implémenter
        this.vueJO = new VueAppliJO();
    }

    public void handle(ActionEvent actionEvent) {
        Optional<ButtonType> reponse = this.vueJO.popUpDeconnexion().showAndWait();
    }
}