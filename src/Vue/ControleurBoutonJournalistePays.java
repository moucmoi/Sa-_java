import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;

import java.sql.SQLException;
import java.util.*;

public class ControleurBoutonJournalistePays implements EventHandler<ActionEvent> {

    private VueAppliJO vueJO;
    private JO modele;
    private List<Pays> liste;


    public ControleurBoutonJournalistePays(VueAppliJO vueJO,JO modele){
        this.vueJO = vueJO;
        this.modele=modele;
        try{
            this.liste=modele.getOutilsRequete().listerPays();
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
    
    public List<Pays> getListe() {
        return liste;
    }
}