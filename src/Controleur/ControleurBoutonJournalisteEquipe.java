
package src.Controleur;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;

import java.sql.SQLException;
import java.util.*;
import src.Modele.*;
import src.Vue.*;

public class ControleurBoutonJournalisteEquipe implements EventHandler<ActionEvent> {

    private VueAppliJO vueJO;
    private JO modele;
    private List<Equipe> liste;


    public ControleurBoutonJournalisteEquipe(VueAppliJO vueJO,JO modele){
        this.vueJO = vueJO;
        this.modele=modele;
        try{
            this.liste=modele.getOutilsRequete().listerEquipe();
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
    
    public List<Equipe> getListe() {
        return liste;
    }
}