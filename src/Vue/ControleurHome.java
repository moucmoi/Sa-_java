import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControleurHome implements EventHandler<ActionEvent> {

    private VueAppliJO vueJO;

    public ControleurHome(VueAppliJO vueJO) {
        this.vueJO = vueJO;
    }

    public void handle(ActionEvent actionEvent) {
        // recuperer le role en fonction de la page
        // if role == admin:
        // this.vueJO.homeAdmin
        // elif role == organisateur:
        // this.vueJO.homeOrganisateur
        // elif role == Journaliste:
        // this.vueJO.homeJournaliste
    }
}