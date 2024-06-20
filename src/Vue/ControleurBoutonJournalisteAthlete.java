import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;

import java.sql.SQLException;
import java.util.*;

public class ControleurBoutonJournalisteAthlete implements EventHandler<ActionEvent> {

    private VueAppliJO vueJO;
    private JO modele;
    private List<Athlete> liste;


    public ControleurBoutonJournalisteAthlete(VueAppliJO vueJO,JO modele) throws SQLException{
        this.vueJO = vueJO;
        this.modele=modele;
        this.liste=modele.getOutilsRequete().listerAthletes();
    }

    public void handle(ActionEvent actionEvent) {
        MenuItem menuItem=(MenuItem) actionEvent.getSource();
        String textBouton = menuItem.getText();
        if (textBouton.equals("croissant")){
            Collections.sort(liste);
        }
        else if(textBouton.equals("decroissant")){
            Collections.sort(liste);
            Collections.reverse(liste);
        }
    }
    
    public List<Athlete> getListe() {
        return liste;
    }
}