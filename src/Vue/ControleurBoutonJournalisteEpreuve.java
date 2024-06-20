import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;

import java.sql.SQLException;
import java.util.*;

public class ControleurBoutonJournalisteEpreuve implements EventHandler<ActionEvent> {

    private VueAppliJO vueJO;
    private JO modele;
    private List<Epreuve> liste;


    public ControleurBoutonJournalisteEpreuve(VueAppliJO vueJO,JO modele){
        this.vueJO = vueJO;
        this.modele=modele;
        try{
            this.liste=modele.getOutilsRequete().listerEpreuve();
        }
        catch (SQLException e){}
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
    
    public List<Epreuve> getListe() {
        return liste;
    }
}