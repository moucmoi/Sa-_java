import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class VueAppliJO extends Application {

    private Scene mainScene;
    private Scene connexionScene;
    private BorderPane root;
    private FXMLLoader loader;
  
    public VueAppliJO() {

    }

    public Alert popUpDeconnexion(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Vous allez vous déconnecter \n Etes-vous sûr de vous déconnecter ?", ButtonType.YES, ButtonType.NO);
        alert.setTitle("Attention");
        return alert;
    }

    public void PageAccueil() {
        this.scene.setRoot();
    }

    @Override
    public void start(Stage stage) {
        /*loader = new FXMLLoader(this.getClass().getResource("PageAccueil.fxml"));
        root = loader.load();
        mainScene = new Scene(root);*/

        loader = new FXMLLoader(this.getClass().getResource("page_connexion.fxml"));
        root = loader.load();
        connexionScene = new Scene(root);

        Button bConnexion = (Button) mainScene.lookup("#connexion");
        Button bInscription = (Button) mainScene.lookup("#inscription");

        ControleurBoutonAccueil ctrlBA = new ControleurBoutonAccueil(this);
        bConnexion.setOnAction(ctrlBA);
        bInscription.setOnAction(ctrlBA);

        stage.setScene(connexionScene);
        stage.setTitle("...");
        stage.show();
    }
}

/*import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.fxml.FXMLLoader;

public class importBouton extends Application {
    Scene mainScene;
    BorderPane root;
    FXMLLoader loader;
  
    @Override
    public void init(){    
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        

    public static void main(String[] args) {
        launch(args);
}  
}*/



