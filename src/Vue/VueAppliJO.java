import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class VueAppliJO extends Application {

    public Alert popUpDeconnexion(){

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Vous allez vous déconnecter \n Etes-vous sûr de vous déconnecter ?", ButtonType.YES, ButtonType.NO);
        alert.setTitle("Attention");
        return alert;
    }

    public void PageAccueil() {
        this.scene.setRoot();
    }
  
    public void start(Stage stage) {
    }
}

