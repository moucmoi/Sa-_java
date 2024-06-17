import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ButtonType;

public class ControleurDeconnexion implements EventHandler<ActionEvent> {


    public ControleurDeconnexion() {
        // A implémenter
    }

    public void handle(ActionEvent actionEvent) {
        Optional<ButtonType> reponse = this.VueAppliJO.popUpDeconnexion().showAndWait();
    }
}