import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControleurConnexion implements EventHandler<ActionEvent> {

    private VueAppliJO vueJO;

    public ControleurConnexion(VueAppliJO vueJO) {
        this.vueJO = vueJO;
    }

    public void handle(ActionEvent actionEvent) {
        this.vueJO.pageJournaliste();
    }
}