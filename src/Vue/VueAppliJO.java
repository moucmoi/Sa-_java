
import java.io.FileNotFoundException;
import java.sql.SQLException;
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

    public Scene pageConnexion;
    private BorderPane rootConnexion;

    private Scene pageInscription;
    private BorderPane rootInscription; 

    private Scene pageAccueilAdmin;
    private BorderPane rootAAdmin;

    private Scene pageAdmin;
    private BorderPane rootAdmin;

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

    private Scene pageJIEquipe;
    private BorderPane rootJIEquipe;


    private Scene pageJPays;
    private BorderPane rootJPays;

    private Scene pageJEquipe;
    private BorderPane rootJEquipe;

    private Scene pageOrganisateur;
    private BorderPane rootOrganisateur;

    private Scene pageOrganisateurAcceuil;
    private BorderPane rootOrganisateurAcceuil;

    private Stage stageVue;
    private BorderPane root;
    private FXMLLoader loader;
    private String role=null;
    private JO modele;

    private ControleurBoutonJournalisteAthlete crtlBJA;
    private ControleurBoutonJournalisteEquipe crtlBJEQ;
    private ControleurBoutonJournalisteEpreuve crtlBJEP;
    private ControleurBoutonJournalistePays crtlBJP;
    private ControleurBoutonAccueil crtlBA;
    private ControleurConnexion crtlCo;
    private ControleurDeconnexion crtlDeco;
    private ControleurRetour crtlRetour;
    private ControleurInscription crtlIn;
    private ControleurBoutonJournalisteIPays crtlJIPays;
    private ControleurBoutonJournalisteIAthlete crtlJIAthlete;
    private ControleurBoutonJournalisteIEquipe crtlJIEquipe;
    private ControleurBoutonJournalisteIEpreuve crtlJIEpreuve;
    private ControleurAllerPageInfoJ crtlAPIJ;
    private ControleurRechercheJA crtlRJA;
    private ControleurRechercheJP crtlRJP;
    private ControleurRechercheJEQ crtlRJEQ;
    private ControleurRechercheJEP crtlRJEP;


    public VueAppliJO() {
        super();
    }

    public void init() throws SQLException, ClassNotFoundException,FileNotFoundException{
        this.modele=new JO();
        this.crtlBJA=new ControleurBoutonJournalisteAthlete(this,modele);
        this.crtlBJEQ=new ControleurBoutonJournalisteEquipe(this, modele);
        this.crtlBJEP=new ControleurBoutonJournalisteEpreuve(this, modele);
        this.crtlBJP=new ControleurBoutonJournalistePays(this, modele);
        this.crtlBA=new ControleurBoutonAccueil(this);
        this.crtlCo=new ControleurConnexion(this);
        this.crtlDeco=new ControleurDeconnexion(this);
        this.crtlRetour=new ControleurRetour(this);
        this.crtlIn=new ControleurInscription(this);
        this.crtlJIPays=new ControleurBoutonJournalisteIPays(this);
        this.crtlJIAthlete= new ControleurBoutonJournalisteIAthlete(this);
        this.crtlJIEquipe=new ControleurBoutonJournalisteIEquipe(this);
        this.crtlJIEpreuve=new ControleurBoutonJournalisteIEpreuve(this);
        this.crtlAPIJ=new ControleurAllerPageInfoJ(this, modele);
        this.crtlRJA=new ControleurRechercheJA(this, modele);
        this.crtlRJP=new ControleurRechercheJP(this, modele);
        this.crtlRJEQ=new ControleurRechercheJEQ(this, modele);
        this.crtlRJEP=new ControleurRechercheJEP(this, modele);
    }

    @Override
    public void start(Stage stage) throws Exception{
        this.stageVue = stage;
        //new ControleurConnexion(this,this.modele.getOutilsRequete());

        this.loader = new FXMLLoader(this.getClass().getResource("SAEjavaAccueil.fxml"));
        this.rootAccueil = loader.load();
        this.mainScene = new Scene(rootAccueil); 
        this.modele.simulationJO();

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


        this.loader = new FXMLLoader(this.getClass().getResource("SAEjavaJournalisteAthlete.fxml"));
        this.rootJAthlete = loader.load();
        this.pageJAthlete = new Scene(rootJAthlete);

        Button bDecoJ7 = (Button) pageJAthlete.lookup("#deconnexion");
        Button bJournaliste7 = (Button) pageJAthlete.lookup("#home");
        Button bJIPays7 = (Button) pageJAthlete.lookup("#pays");
        Button bJIAthlete7 = (Button) pageJAthlete.lookup("#athlete");
        Button bJIEquipe7 = (Button) pageJAthlete.lookup("#equipe");
        Button bJIEpreuve7 = (Button) pageJAthlete.lookup("#epreuve");

        bDecoJ7.setOnAction(crtlDeco);
        bJournaliste7.setOnAction(crtlJIPays);
        bJIPays7.setOnAction(crtlJIPays);
        bJIAthlete7.setOnAction(crtlJIAthlete);
        bJIEquipe7.setOnAction(crtlJIEquipe);
        bJIEpreuve7.setOnAction(crtlJIEpreuve);

        this.loader = new FXMLLoader(this.getClass().getResource("SAEjavaJournalisteInfoAthlete.fxml"));
        this.rootJIAthlete = loader.load();
        this.pageJIAthlete = new Scene(rootJIAthlete);

        Button bDecoJ3 = (Button) pageJIAthlete.lookup("#deconnexion");
        Button bJournaliste3 = (Button) pageJIAthlete.lookup("#home");
        Button bJIPays3 = (Button) pageJIAthlete.lookup("#pays");
        Button bJIAthlete3 = (Button) pageJIAthlete.lookup("#athlete");
        Button bJIEquipe3 = (Button) pageJIAthlete.lookup("#equipe");
        Button bJIEpreuve3 = (Button) pageJIAthlete.lookup("#epreuve");

        bDecoJ3.setOnAction(crtlDeco);
        bJournaliste3.setOnAction(crtlJIPays);
        bJIPays3.setOnAction(crtlJIPays);
        bJIAthlete3.setOnAction(crtlJIAthlete);
        bJIEquipe3.setOnAction(crtlJIEquipe);
        bJIEpreuve3.setOnAction(crtlJIEpreuve);

        this.loader = new FXMLLoader(this.getClass().getResource("SAEjavaJournalisteEpreuve.fxml"));
        this.rootJEpreuve = loader.load();
        this.pageJEpreuve = new Scene(rootJEpreuve);

        Button bDecoJ5 = (Button) pageJEpreuve.lookup("#deconnexion");
        Button bJournaliste5 = (Button) pageJEpreuve.lookup("#home");
        Button bJIPays5 = (Button) pageJEpreuve.lookup("#pays");
        Button bJIAthlete5 = (Button) pageJEpreuve.lookup("#athlete");
        Button bJIEquipe5 = (Button) pageJEpreuve.lookup("#equipe");
        Button bJIEpreuve5 = (Button) pageJEpreuve.lookup("#epreuve");

        bDecoJ5.setOnAction(crtlDeco);
        bJournaliste5.setOnAction(crtlJIPays);
        bJIPays5.setOnAction(crtlJIPays);
        bJIAthlete5.setOnAction(crtlJIAthlete);
        bJIEquipe5.setOnAction(crtlJIEquipe);
        bJIEpreuve5.setOnAction(crtlJIEpreuve);

        this.loader = new FXMLLoader(this.getClass().getResource("SAEjavaJournalisteInfoEpreuve.fxml"));
        this.rootJIEpreuve = loader.load();
        this.pageJIEpreuve = new Scene(rootJIEpreuve);

        Button bDecoJ2 = (Button) pageJIEpreuve.lookup("#deconnexion");
        Button bJournaliste2 = (Button) pageJIEpreuve.lookup("#home");
        Button bJIPays2 = (Button) pageJIEpreuve.lookup("#pays");
        Button bJIAthlete2 = (Button) pageJIEpreuve.lookup("#athlete");
        Button bJIEquipe2 = (Button) pageJIEpreuve.lookup("#equipe");
        Button bJIEpreuve2 = (Button) pageJIEpreuve.lookup("#epreuve");

        bDecoJ2.setOnAction(crtlDeco);
        bJournaliste2.setOnAction(crtlJIPays);
        bJIPays2.setOnAction(crtlJIPays);
        bJIAthlete2.setOnAction(crtlJIAthlete);
        bJIEquipe2.setOnAction(crtlJIEquipe);
        bJIEpreuve2.setOnAction(crtlJIEpreuve);

        this.loader = new FXMLLoader(this.getClass().getResource("SAEjavaJournalistePays.fxml"));
        this.rootJPays = loader.load();
        this.pageJPays = new Scene(rootJPays);

        Button bDecoJ6 = (Button) pageJPays.lookup("#deconnexion");
        Button bJournaliste6 = (Button) pageJPays.lookup("#home");
        Button bJIPays6 = (Button) pageJPays.lookup("#pays");
        Button bJIAthlete6 = (Button) pageJPays.lookup("#athlete");
        Button bJIEquipe6 = (Button) pageJPays.lookup("#equipe");
        Button bJIEpreuve6 = (Button) pageJPays.lookup("#epreuve");

        bDecoJ6.setOnAction(crtlDeco);
        bJournaliste6.setOnAction(crtlJIPays);
        bJIPays6.setOnAction(crtlJIPays);
        bJIAthlete6.setOnAction(crtlJIAthlete);
        bJIEquipe6.setOnAction(crtlJIEquipe);
        bJIEpreuve6.setOnAction(crtlJIEpreuve);

        this.loader = new FXMLLoader(this.getClass().getResource("SAEjavaJournalisteInfoPays.fxml"));
        this.rootJIPays = loader.load();
        this.pageJIPays = new Scene(rootJIPays);

        Button bDecoJ = (Button) pageJIPays.lookup("#deconnexion");
        Button bJournaliste = (Button) pageJIPays.lookup("#home");
        Button bJIPays = (Button) pageJIPays.lookup("#pays");
        Button bJIAthlete = (Button) pageJIPays.lookup("#athlete");
        Button bJIEquipe = (Button) pageJIPays.lookup("#equipe");
        Button bJIEpreuve = (Button) pageJIPays.lookup("#epreuve");

        bDecoJ.setOnAction(crtlDeco);
        bJournaliste.setOnAction(crtlJIPays);
        bJIPays.setOnAction(crtlJIPays);
        bJIAthlete.setOnAction(crtlJIAthlete);
        bJIEquipe.setOnAction(crtlJIEquipe);
        bJIEpreuve.setOnAction(crtlJIEpreuve);

        this.loader = new FXMLLoader(this.getClass().getResource("SAEjavaJournalisteEquipe.fxml"));
        this.rootJEquipe = loader.load();
        this.pageJEquipe = new Scene(rootJEquipe);

        Button bDecoJ4 = (Button) pageJEquipe.lookup("#deconnexion");
        Button bJournaliste4 = (Button) pageJEquipe.lookup("#home");
        Button bJIPays4 = (Button) pageJEquipe.lookup("#pays");
        Button bJIAthlete4 = (Button) pageJEquipe.lookup("#athlete");
        Button bJIEquipe4 = (Button) pageJEquipe.lookup("#equipe");
        Button bJIEpreuve4 = (Button) pageJEquipe.lookup("#epreuve");

        bDecoJ4.setOnAction(crtlDeco);
        bJournaliste4.setOnAction(crtlJIPays);
        bJIPays4.setOnAction(crtlJIPays);
        bJIAthlete4.setOnAction(crtlJIAthlete);
        bJIEquipe4.setOnAction(crtlJIEquipe);
        bJIEpreuve4.setOnAction(crtlJIEpreuve);

        this.loader = new FXMLLoader(this.getClass().getResource("SAEjavaJournalisteInfoEquipe.fxml"));
        this.rootJIEquipe = loader.load();
        this.pageJIEquipe = new Scene(rootJIEquipe);

        Button bDecoJ1 = (Button) pageJIEquipe.lookup("#deconnexion");
        Button bJournaliste1 = (Button) pageJIEquipe.lookup("#home");
        Button bJIPays1 = (Button) pageJIEquipe.lookup("#pays");
        Button bJIAthlete1 = (Button) pageJIEquipe.lookup("#athlete");
        Button bJIEquipe1 = (Button) pageJIEquipe.lookup("#equipe");
        Button bJIEpreuve1 = (Button) pageJIEquipe.lookup("#epreuve");

        bDecoJ1.setOnAction(crtlDeco);
        bJournaliste1.setOnAction(crtlJIPays);
        bJIPays1.setOnAction(crtlJIPays);
        bJIAthlete1.setOnAction(crtlJIAthlete);
        bJIEquipe1.setOnAction(crtlJIEquipe);
        bJIEpreuve1.setOnAction(crtlJIEpreuve);

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

    public Alert popUpDeconnexion(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Vous allez vous déconnecter \n Etes-vous sûr de vous déconnecter ?", ButtonType.YES, ButtonType.NO);
        alert.setTitle("Attention");
        return alert;
    }

    public Alert popUpUtilisateurOuMdpIncorrect(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Nom d'utilisateur ou mot de passe incorrect", ButtonType.YES, ButtonType.NO);
        alert.setTitle("Erreur");
        return alert;
    }

    public Scene getPageJAthlete() {
        return pageJAthlete;
    }

    public Scene getPageJEquipe() {
        return pageJEquipe;
    }
    
    public Scene getPageJPays() {
        return pageJPays;
    }

    public Scene getPageJEpreuve() {
        return pageJEpreuve;
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

    public void pageJournalistePays(Pays p) throws SQLException{
        this.stageVue.setScene(pageJPays);
        List<Integer> listeMedaille =modele.getOutilsRequete().listerMedaillesPays(p);
        List<Athlete> listeAthletes=modele.getOutilsRequete().listerAthletePourUnSport(p.getNomPays());
        VBox vBoxM=(VBox)pageJPays.lookup("#vbox1");
        VBox vBoxA=(VBox)pageJPays.lookup("#vbox2");

        HBox hBoxM=new HBox();
        HBox hBoxM1=new HBox();
        HBox hBoxM2=new HBox();

        hBoxM.getChildren().add(new Label("Or"));
        hBoxM.getChildren().add(new Label(String.valueOf(listeMedaille.get(0))));
        
        hBoxM1.getChildren().add(new Label("Argent"));
        hBoxM1.getChildren().add(new Label(String.valueOf(listeMedaille.get(1))));
        
        hBoxM2.getChildren().add(new Label("Bronze"));
        hBoxM2.getChildren().add(new Label(String.valueOf(listeMedaille.get(2))));

        vBoxM.getChildren().add(hBoxM);
        vBoxM.getChildren().add(hBoxM1);
        vBoxM.getChildren().add(hBoxM2);

        for(Athlete a:listeAthletes){
            HBox hbox=new HBox();
            hbox.getChildren().add(new Label(a.getNom()));
            hbox.getChildren().add(new Label(a.getPrenom()));
            vBoxA.getChildren().add(hbox);
        }
    }

    public void pageJournalisteIPays() {
        this.stageVue.setScene(pageJIPays);
        if(crtlRJP.getPays().isEmpty()){
            List<Pays> liste=this.crtlBJP.getListe();
            VBox vBox=(VBox)pageJPays.lookup("#vbox");
            for(int i=0;i<liste.size();i++){
                HBox hbox=new HBox();
                hbox.getChildren().add(new Label(String.valueOf(i+1)));
                Button bouton=new Button(liste.get(i).getNomPays());
                bouton.setOnAction(this.crtlAPIJ);
                hbox.getChildren().add(bouton);
                vBox.getChildren().add(hbox);
            }
        }
        else{
            List<String> liste=this.crtlRJP.getPays();
            VBox vBox=(VBox)pageJPays.lookup("#vbox");
            for(String s:liste){
                Button bouton=new Button(s);
                bouton.setOnAction(crtlAPIJ);
                vBox.getChildren().add(bouton);
            }
        }
    }

    public void pageJournalisteAthlete(Athlete a) throws SQLException{
        this.stageVue.setScene(pageJAthlete);
        List<Integer> listeMedaille = modele.getOutilsRequete().listerMedaillesAthlete(a);
        VBox vBoxM=(VBox)pageJAthlete.lookup("#vbox1");
        HBox hBoxM=new HBox();
        HBox hBoxM1=new HBox();
        HBox hBoxM2=new HBox();

        hBoxM.getChildren().add(new Label("Or"));
        hBoxM.getChildren().add(new Label(String.valueOf(listeMedaille.get(0))));
        
        hBoxM1.getChildren().add(new Label("Argent"));
        hBoxM1.getChildren().add(new Label(String.valueOf(listeMedaille.get(1))));
        
        hBoxM2.getChildren().add(new Label("Bronze"));
        hBoxM2.getChildren().add(new Label(String.valueOf(listeMedaille.get(2))));

        vBoxM.getChildren().add(hBoxM);
        vBoxM.getChildren().add(hBoxM1);
        vBoxM.getChildren().add(hBoxM2);
    }

    public void pageJournalisteIAthlete() {
        this.stageVue.setScene(pageJIAthlete);
        if(crtlRJA.getAthletes().isEmpty()){
            List<Athlete> liste=this.crtlBJA.getListe();
            VBox vBox=(VBox)pageJAthlete.lookup("#vbox");
            for(int i=0;i<liste.size();i++){
                HBox hbox=new HBox();
                hbox.getChildren().add(new Label(String.valueOf(i+1)));
                Button bouton=new Button(liste.get(i).getNom());
                bouton.setOnAction(this.crtlAPIJ);
                hbox.getChildren().add(bouton);
                vBox.getChildren().add(hbox);
            }
        }
        else{
            List<String> liste=this.crtlRJA.getAthletes();
            VBox vBox=(VBox)pageJAthlete.lookup("#vbox");
            for(String s:liste){
                Button bouton=new Button(s);
                bouton.setOnAction(crtlAPIJ);
                vBox.getChildren().add(bouton);
            }
        }
    }

    public void pageJournalisteEquipe(Equipe e) throws SQLException{
        this.stageVue.setScene(pageJEquipe);
        List<Integer> listeMedaille =modele.getOutilsRequete().listerMedaillesEquipe(e);
        List<Athlete> listeAthletes=modele.getOutilsRequete().listerAthletePourEquipe(e.getNum());
        VBox vBoxA=(VBox)pageJEquipe.lookup("#vbox1");
        VBox vBoxM=(VBox)pageJEquipe.lookup("#vbox2");

        HBox hBoxM=new HBox();
        HBox hBoxM1=new HBox();
        HBox hBoxM2=new HBox();

        hBoxM.getChildren().add(new Label("Or"));
        hBoxM.getChildren().add(new Label(String.valueOf(listeMedaille.get(0))));
        
        hBoxM1.getChildren().add(new Label("Argent"));
        hBoxM1.getChildren().add(new Label(String.valueOf(listeMedaille.get(1))));
        
        hBoxM2.getChildren().add(new Label("Bronze"));
        hBoxM2.getChildren().add(new Label(String.valueOf(listeMedaille.get(2))));

        vBoxM.getChildren().add(hBoxM);
        vBoxM.getChildren().add(hBoxM1);
        vBoxM.getChildren().add(hBoxM2);

        for(Athlete a:listeAthletes){
            HBox hbox=new HBox();
            hbox.getChildren().add(new Label(a.getNom()));
            hbox.getChildren().add(new Label(a.getPrenom()));
            vBoxA.getChildren().add(hbox);
        }
    }

    public void pageJournalisteIEquipe() {
        this.stageVue.setScene(pageJIEquipe);
        if(crtlRJEQ.getEquipes().isEmpty()){
            List<Equipe> liste=this.crtlBJEQ.getListe();
            VBox vBox=(VBox)pageJEquipe.lookup("#vbox");
            for(int i=0;i<liste.size();i++){
                HBox hbox=new HBox();
                hbox.getChildren().add(new Label(String.valueOf(i+1)));
                Button bouton=new Button(liste.get(i).getNom());
                bouton.setOnAction(this.crtlAPIJ);
                hbox.getChildren().add(bouton);
                vBox.getChildren().add(hbox);
            }
        }
        else{
            List<String> liste=this.crtlRJEQ.getEquipes();
            VBox vBox=(VBox)pageJEquipe.lookup("#vbox");
            for(String s:liste){
                Button bouton=new Button(s);
                bouton.setOnAction(crtlAPIJ);
                vBox.getChildren().add(bouton);
            }
        }
    }

    public void pageJournalisteEpreuve(Epreuve e){
        this.stageVue.setScene(pageJEpreuve);
        VBox vBoxI=(VBox)pageJEpreuve.lookup("#vbox1");
        vBoxI.getChildren().add(new Label(e.getNom()));
        if(e.getHomme()){
            vBoxI.getChildren().add(new Label("Epreuve masculine"));
        }
        else{
            vBoxI.getChildren().add(new Label("Epreuve feminine"));
        }
        if(e.getIndividuel()){
            vBoxI.getChildren().add(new Label("Epreuve individuel"));
        }
        else{
            vBoxI.getChildren().add(new Label("Epreuve collective"));
        }
    }

    public void pageJournalisteIEpreuve() {
        this.stageVue.setScene(pageJIEpreuve);
        if(crtlRJEP.getEpreuves().isEmpty()){
            List<Epreuve> liste=this.crtlBJEP.getListe();
            VBox vBox=(VBox)pageJEpreuve.lookup("#vbox");
            for(int i=0;i<liste.size();i++){
                HBox hbox=new HBox();
                hbox.getChildren().add(new Label(String.valueOf(i+1)));
                Button bouton=new Button(liste.get(i).getNom());
                bouton.setOnAction(this.crtlAPIJ);
                hbox.getChildren().add(bouton);
                vBox.getChildren().add(hbox);
            }
        }
        else{
            List<String> liste=this.crtlRJEP.getEpreuves();
            VBox vBox=(VBox)pageJEpreuve.lookup("#vbox");
            for(String s:liste){
                Button bouton=new Button(s);
                bouton.setOnAction(crtlAPIJ);
                vBox.getChildren().add(bouton);
            }
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}