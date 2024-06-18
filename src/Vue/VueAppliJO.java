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
    private Scene Accueil;
    private Scene pageConnexion;
    private Scene pageInscription;
    private Scene pageAccueilAdmin;


    private BorderPane root;
    private FXMLLoader loader;
  
    public VueAppliJO() {
        super();
    }

    public Alert popUpDeconnexion(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Vous allez vous déconnecter \n Etes-vous sûr de vous déconnecter ?", ButtonType.YES, ButtonType.NO);
        alert.setTitle("Attention");
        return alert;
    }

    public void PageAccueil() {
        
    }

    @Override
    public void start(Stage stage) throws Exception{
        this.loader = new FXMLLoader(this.getClass().getResource("SAEjavaAccueil.fxml"));
        this.root = loader.load();
        this.mainScene = new Scene(root);

        Button bPageC = (Button) mainScene.lookup("#page_connexion");
        Button bPageI = (Button) mainScene.lookup("#page_inscription");

        /*ControleurBoutonAccueil crtlBA = new ControleurBoutonAccueil(this);
        bPageC.setOnAction(crtlBA);
        bPageI.setOnAction(crtlBA);*/


        this.loader = new FXMLLoader(this.getClass().getResource("page_connexion.fxml"));
        this.root = loader.load();
        this.pageConnexion = new Scene(root);

        Button bRetourC = (Button) mainScene.lookup("#retour");
        Button bConnexion = (Button) mainScene.lookup("#connexion");

        /*ControleurRetour crtlRetour = new ControleurRetour(this);
        bRetourC.setOnAction(crtlRetour);
        ControleurConnexion crtlCo = new ControleurConnexion(this);
        bConnexion.setOnAction(crtlCo);*/



        this.loader = new FXMLLoader(this.getClass().getResource("page_inscription.fxml"));
        this.root = loader.load();
        this.pageInscription = new Scene(root);

        Button bRetourI = (Button) mainScene.lookup("#retour");

        /*bRetourI.setOnAction(crtlRetour);*/


        this.loader = new FXMLLoader(this.getClass().getResource("SAEjavaAccueil.fxml"));
        this.root = loader.load();
        this.pageAccueilAdmin = new Scene(root);

        Button bRetourA = (Button) mainScene.lookup("#retour");
        /*bRetourA.setOnAction(crtlRetour);*/


        stage.setScene(mainScene);
        stage.setTitle("- Jeux IUT'Olympiques -");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}



