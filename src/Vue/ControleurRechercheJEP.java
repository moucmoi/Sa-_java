import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.sql.SQLException;
import java.util.*;

public class ControleurRechercheJEP implements EventHandler<ActionEvent>{
    private VueAppliJO vueJO;
    private JO modele;
    private List<String> epreuves;


    public ControleurRechercheJEP(VueAppliJO vueJO,JO modele) {
        this.vueJO = vueJO;
        this.modele=modele;
    }

    public void handle(ActionEvent actionEvent){
        try{
            TextArea textArea=(TextArea)vueJO.getPageJEpreuve().lookup("#textarea");
            String mot=textArea.getText();
            List<String> liste=modele.getOutilsRequete().barreRechercheEpreuve(mot);
            for(String s:liste){
                epreuves.add(s);
            }
        }
        catch(SQLException e){
            e.getLocalizedMessage();
        }
    }
    public List<String> getEpreuves() {
        return epreuves;
    }
}
