import java.sql.*;


public class Executable{
    public static void main(String[] args) {
        
        Pays France=new Pays("France","FRA");
        Pays EtatsUnis=new Pays("USA","USA");
        Pays Chine=new Pays("Chine","CHN");
        Pays Japon=new Pays("Japon","JPN");
        Pays Kenya=new Pays("Kenya","KEN");
        Pays Maroc=new Pays("Maroc","MAR");
        Pays Allemagne=new Pays("Allemagne","DEU");
        Pays Australie=new Pays("Australie","AUS");
        Pays Bresil=new Pays("Brésil","BRA");
        Pays Turquie=new Pays("Turquie","TUR");


        Natation Natation=new Natation();
        Handball Handball=new Handball();
        VolleyBall VolleyBall=new VolleyBall();
        Escrime Escrime=new Escrime();
        Athletisme Athletisme=new Athletisme();

        Epreuve CentMetresH=new Epreuve("Natation 100 brasse", true, true, Natation);
        Epreuve RelaisLibreH=new Epreuve("Natation relais libre",true,false,Natation);
        Epreuve HandballH=new Epreuve("Handball", true, false,Handball);
        Epreuve  VolleyBallH=new Epreuve("Volley-Ball",true,false,VolleyBall);
        Epreuve EscrimeFleuretH=new Epreuve("Escrime fleuret",true, true, Escrime);
        Epreuve EscrimeEpeeH=new Epreuve("Escrime fleuret",true, true, Escrime);
        Epreuve CentMetreHaiesH=new Epreuve("Athlétisme 110 haies", true, true, Athletisme);
        Epreuve QuatreCentMetresRelaiH=new Epreuve("Athlétisme 110 haies", true, false, Athletisme);
        
        Epreuve CentMetresF=new Epreuve("Natation 100 brasse", false, true, Natation);
        Epreuve RelaisLibreF=new Epreuve("Natation relais libre",false,false,Natation);
        Epreuve HandballF=new Epreuve("Handball", false, false,Handball);
        Epreuve  VolleyBallF=new Epreuve("Volley-Ball",false,false,VolleyBall);
        Epreuve EscrimeFleuretF=new Epreuve("Escrime fleuret",false, true, Escrime);
        Epreuve EscrimeEpeeF=new Epreuve("Escrime fleuret",false, true, Escrime);
        Epreuve CentMetreHaiesF=new Epreuve("Athlétisme 110 haies", false, true, Athletisme);
        Epreuve QuatreCentMetresRelaiF=new Epreuve("Athlétisme 110 haies", false, false, Athletisme);

        Equipe e1=new Equipe("Clebs");
        Equipe e2=new Equipe("Furies")
        
        Athlete a1=new Athlete("Fonteny", "Noa", true, 100, 100, 100,France,e1);
        Athlete a2=new Athlete("Chesneau", "Marin", false, 0, 0, 0, France, e1);
        Athlete a3=new Athlete("Grandchamp", "Loris", true, 10, 10000, 50, France, e1);
        Athlete a4=new Athlete("Yayaoui", "Mohamed-Amine", true, 10, 10, 10, Maroc, e2);


    }
   
   
   
    /* public static void main(String[] args) throws SQLException{
        Connection c;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mysql://servinfo-maria:3306/mabd","monlog","monpass");
        }
        catch (SQLException ex){
            System.out.println("Msg:"+ex.getMessage()+
            ex.getErrorCode());
        }
    } */
}
