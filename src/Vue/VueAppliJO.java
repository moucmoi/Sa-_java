import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class VueAppliJO extends Application {


    public Alert popUpDeconnexion(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Vous allez vous déconneter \n Etes-vous sûr de vous déconnecter ?", ButtonType.YES, ButtonType.NO);
        alert.setTitle("Attention");
        return alert;
    }

    public void start(Stage stage) {
    }
}

