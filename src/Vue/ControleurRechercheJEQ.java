import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.sql.SQLException;
import java.util.*;

public class ControleurRechercheJEQ implements EventHandler<ActionEvent>{
    private VueAppliJO vueJO;
    private JO modele;
    private List<String> equipes;


    public ControleurRechercheJEQ(VueAppliJO vueJO,JO modele) {
        this.vueJO = vueJO;
        this.modele=modele;
    }

    public void handle(ActionEvent actionEvent){
        try{
            TextArea textArea=(TextArea)vueJO.getPageJEquipe().lookup("#textarea");
            String mot=textArea.getText();
            List<String> liste=modele.getOutilsRequete().barreRechercheEquipe(mot);
            for(String s:liste){
                equipes.add(s);
            }
        }
        catch(SQLException e){
            e.getLocalizedMessage();
        }
    }
    public List<String> getEquipes() {
        return equipes;
    }
}
