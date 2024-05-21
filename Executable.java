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
        Epreuve EscrimeFleuretH=new Epreuve("Escrime fleuret",true, false, Escrime);
        Epreuve EscrimeEpeeH=new Epreuve("Escrime fleuret",true, false, Escrime);
        
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
