package src.Controleur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.sql.SQLException;
import java.util.*;
import src.Modele.*;
import src.Vue.*;

public class ControleurRechercheJP implements EventHandler<ActionEvent>{
    private VueAppliJO vueJO;
    private JO modele;
    private List<String> pays;


    public ControleurRechercheJP(VueAppliJO vueJO,JO modele) {
        this.vueJO = vueJO;
        this.modele=modele;
        this.pays=new ArrayList<>();
    }

    public void handle(ActionEvent actionEvent){
        try{
            TextArea textArea=(TextArea)vueJO.getPageJPays().lookup("#textarea");
            String mot=textArea.getText();
            List<String> liste=modele.getOutilsRequete().barreRecherchePays(mot);
            for(String s:liste){
                pays.add(s);
            }
        }
        catch(SQLException e){
            e.getLocalizedMessage();
        }
    }
    public List<String> getPays() {
        return pays;
    }
}
