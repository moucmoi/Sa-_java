 
import java.util.List;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class VueAppliJO extends Application {

    private Scene mainScene;
    
    private Scene Accueil;
    private BorderPane rootAccueil;

    private Scene pageConnexion;
    private BorderPane rootConnexion;

    private Scene pageInscription;
    private BorderPane rootInscription; 

    private Scene pageAccueilAdmin;
    private BorderPane rootAAdmin;

    private Scene pageAdmin;
    private BorderPane rootAdmin;
    
    private Scene pageJournaliste;
    private BorderPane rootJournaliste;

    private Scene pageJAthlete;
    private BorderPane rootJAthlete;
    
    private Scene pageJEpreuve;
    private BorderPane rootJEpreuve;

    private Scene pageJIAthlete;
    private BorderPane rootJIAthlete;
    
    private Scene pageJIEpreuve;
    private BorderPane rootJIEpreuve;
    
    private Scene pageJIPays;
    private BorderPane rootJIPays;

    private Scene pageJISport;
    private BorderPane rootJISport;

    private Scene pageJPays;
    private BorderPane rootJPays;

    private Scene pageJSport;
    private BorderPane rootJSport;

    private Scene pageOrganisateur;
    private BorderPane rootOrganisateur;

    private Scene pageOrganisateurAcceuil;
    private BorderPane rootOrganisateurAcceuil;

    private Stage stageVue;
    private BorderPane root;
    private FXMLLoader loader;
    private String role=null;
    private JO modele;

    
    
    @Override
    public void init(){
    }

    public Alert popUpDeconnexion(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Vous allez vous déconnecter \n Etes-vous sûr de vous déconnecter ?", ButtonType.YES, ButtonType.NO);
        alert.setTitle("Attention");
        return alert;
    }
  
    public void pageAccueil() {
        this.stageVue.setScene(mainScene);
    }

    public void pageConnexion() {
        this.stageVue.setScene(pageConnexion);
    }

    public void pageInscription() {
        this.stageVue.setScene(pageInscription);
    }

    public void pageJournaliste() {
        this.stageVue.setScene(pageJournaliste);
    }

    public void pageJournalisteIAthlete() {
        this.stageVue.setScene(pageJIAthlete);
    }

    public void pageJournalisteISport() {
        this.stageVue.setScene(pageJISport);
    }

    public void pageJournalisteIEpreuve() {
        this.stageVue.setScene(pageJAthlete);
    }

    @Override
    public void start(Stage stage) throws Exception{
        this.stageVue = stage;
        ControleurBoutonAccueil crtlBA = new ControleurBoutonAccueil(this);
        ControleurConnexion crtlCo = new ControleurConnexion(this);
        ControleurDeconnexion crtlDeco = new ControleurDeconnexion(this);
        ControleurBoutonJournaliste crtlBJ = new ControleurBoutonJournaliste(this);
        ControleurRetour crtlRetour = new ControleurRetour(this);
        ControleurInscription crtlIn = new ControleurInscription(this);
        ControleurOrganisateur crtlOrga = new ControleurOrganisateur(this);
        ControleurHome crtlHome = new ControleurHome(this);
        ControleurBoutonJournalisteAccueil crtlJAccueil = new ControleurBoutonJournalisteAccueil(this);
        ControleurBoutonJournalisteIAthlete crtlJIAthlete = new ControleurBoutonJournalisteIAthlete(this);
        ControleurBoutonJournalisteISport crtlJISport = new ControleurBoutonJournalisteISport(this);
        ControleurBoutonJournalisteIEpreuve crtlJIEpreuve = new ControleurBoutonJournalisteIEpreuve(this);

        this.loader = new FXMLLoader(this.getClass().getResource("SAEjavaAccueil.fxml"));
        this.rootAccueil = loader.load();
        this.mainScene = new Scene(rootAccueil); 

        Button bPageC = (Button) mainScene.lookup("#page_connexion");
        Button bPageI = (Button) mainScene.lookup("#page_inscription");
        bPageC.setOnAction(crtlBA);
        bPageI.setOnAction(crtlBA);

        this.loader = new FXMLLoader(this.getClass().getResource("page_connexion.fxml"));
        this.rootConnexion = loader.load();
        this.pageConnexion = new Scene(rootConnexion);

        Button bRetourC = (Button) pageConnexion.lookup("#retour");
        Button bConnexion = (Button) pageConnexion.lookup("#connexion");

        bRetourC.setOnAction(crtlRetour);
        bConnexion.setOnAction(crtlCo);

        this.loader = new FXMLLoader(this.getClass().getResource("page_inscription.fxml"));
        this.rootInscription = loader.load();
        this.pageInscription = new Scene(rootInscription);

        Button bRetourI = (Button) pageInscription.lookup("#retour");
        Button bInscription = (Button) pageInscription.lookup("#inscription");

        bRetourI.setOnAction(crtlRetour);
        bInscription.setOnAction(crtlIn);

        this.loader = new FXMLLoader(this.getClass().getResource("SAEjavaAdministrateur.fxml"));
        this.rootAdmin = loader.load();
        this.pageAdmin = new Scene(rootAdmin);

        this.loader = new FXMLLoader(this.getClass().getResource("SAEjavaJournaliste.fxml"));
        this.rootJournaliste = loader.load();
        this.pageJournaliste = new Scene(rootJournaliste);

        Button bDecoJ = (Button) pageJournaliste.lookup("#deconnexion");
        Button bJournaliste = (Button) pageJournaliste.lookup("#home");
        Button bJIAthlete = (Button) pageJournaliste.lookup("#athlete");
        Button bJISport = (Button) pageJournaliste.lookup("#sport");
        Button bJIEpreuve = (Button) pageJournaliste.lookup("#epreuve");

        bDecoJ.setOnAction(crtlDeco);
        bJournaliste.setOnAction(crtlJAccueil);
        bJIAthlete.setOnAction(crtlJIAthlete);
        bJISport.setOnAction(crtlJISport);
        bJIEpreuve.setOnAction(crtlJIEpreuve);

        this.loader = new FXMLLoader(this.getClass().getResource("SAEjavaJournalisteAthlete.fxml"));
        this.rootJAthlete = loader.load();
        this.pageJAthlete = new Scene(rootJAthlete);

        this.loader = new FXMLLoader(this.getClass().getResource("SAEjavaJournalisteInfoAthlete.fxml"));
        this.rootJIAthlete = loader.load();
        this.pageJIAthlete = new Scene(rootJIAthlete);

        this.loader = new FXMLLoader(this.getClass().getResource("SAEjavaJournalisteEpreuve.fxml"));
        this.rootJEpreuve = loader.load();
        this.pageJEpreuve = new Scene(rootJEpreuve);

        this.loader = new FXMLLoader(this.getClass().getResource("SAEjavaJournalisteInfoEpreuve.fxml"));
        this.rootJIEpreuve = loader.load();
        this.pageJIEpreuve = new Scene(rootJIEpreuve);

        this.loader = new FXMLLoader(this.getClass().getResource("SAEjavaJournalistePays.fxml"));
        this.rootJPays = loader.load();
        this.pageJPays = new Scene(rootJPays);

        this.loader = new FXMLLoader(this.getClass().getResource("SAEjavaJournalisteInfoPays.fxml"));
        this.rootJIPays = loader.load();
        this.pageJIPays = new Scene(rootJIPays);

        this.loader = new FXMLLoader(this.getClass().getResource("SAEjavaJournalisteSport.fxml"));
        this.rootJSport = loader.load();
        this.pageJSport = new Scene(rootJSport);

        this.loader = new FXMLLoader(this.getClass().getResource("SAEjavaJournalisteInfoSport.fxml"));
        this.rootJISport = loader.load();
        this.pageJISport = new Scene(rootJISport);

        this.loader = new FXMLLoader(this.getClass().getResource("SAEjavaOrganisateur.fxml"));
        this.rootOrganisateur = loader.load();
        this.pageOrganisateur = new Scene(rootOrganisateur);

        this.loader = new FXMLLoader(this.getClass().getResource("SAEjavaOrganisateurAccueil.fxml"));
        this.rootOrganisateurAcceuil = loader.load();
        this.pageOrganisateurAcceuil = new Scene(rootOrganisateurAcceuil);


        this.stageVue.setScene(mainScene);
        this.stageVue.setTitle("- Jeux IUT'Olympiques -");
        this.stageVue.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}