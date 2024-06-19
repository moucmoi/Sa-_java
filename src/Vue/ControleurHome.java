import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControleurHome implements EventHandler<ActionEvent> {

    private VueAppliJO vueJO;

    public ControleurHome(VueAppliJO vueJO) {
        this.vueJO = vueJO;
    }

    public void handle(ActionEvent actionEvent) {
        if (this.vueJO.getRole() == "Organisateur") {
            this.vueJO.pageOrganisateur();
        }
        else if (this.vueJO.getRole() == "Journaliste") {

        }
        else if (this.vueJO.getRole() == "Administrateur") {

        }
    }
}