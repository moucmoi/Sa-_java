import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

import java.sql.SQLException;
import java.util.*;

public class ControleurAllerPageInfoJ implements EventHandler<ActionEvent>{
    private VueAppliJO vueJO;
    private JO modele;

    public ControleurAllerPageInfoJ(VueAppliJO vueJO,JO modele) {
        this.vueJO = vueJO;
        this.modele=modele;
    }

    public void handle(ActionEvent actionEvent){
        try{
            Button bouton=(Button) actionEvent.getSource();
            String texte=bouton.getText(); 
            List<Pays> pays=modele.getOutilsRequete().listerPays();
            List<Athlete> athletes=modele.getOutilsRequete().listerAthletes();
            List<Epreuve> epreuves=modele.getOutilsRequete().listerEpreuve();
            List<Equipe> equipes=modele.getOutilsRequete().listerEquipe();
            for (Pays p:pays){
                if(p.getNomPays().contains(texte)){
                    vueJO.pageJournalistePays(p);
                }
            }
            for (Athlete a:athletes){
                if(a.getNom().contains(texte)){
                    vueJO.pageJournalisteAthlete(a);
                }
            }
            for (Epreuve e:epreuves){
                if(e.getNom().contains(texte)){
                    vueJO.pageJournalisteEpreuve(e);
                }
            }
            for (Equipe eq:equipes){
                if(eq.getNom().contains(texte)){
                    vueJO.pageJournalisteEquipe(eq);
                }
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}
