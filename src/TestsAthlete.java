import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

public class TestsAthlete {
    private static Pays france;
    private static Pays chine;
    private static Athlete a1;
    private static Athlete a2;
    private static Athlete a3;
    private static Athlete a4;
    private static Equipe e1;
    private static Equipe e2;
    private static Sport handball;
    private static Sport volleyBall;   
    private static Epreuve handballH;
    private static Epreuve volleyBallH;
    
    @BeforeAll // initialisation faite en premier lieu
    static void init() {
        france=new Pays("France","FRA");
        chine=new Pays("Chine","CHN");

        a1 = new Athlete("Testeur", "Test", "H", 50, 10, 20);
        a2 = new Athlete("Testeur2", "Test2", "F", 20, 10, 30);
        a3 = new Athlete("Testeur3", "Test3", "H", 5, 5, 75);
        a4 = new Athlete("Testeur4", "Test4", "F", 60, 30, 5);

        e1=new Equipe("Equipe1",france);
        e2=new Equipe("Equipe2",chine);

        e1.ajouteAthlete(a4);
        e1.ajouteAthlete(a1);
        e2.ajouteAthlete(a2);
        e2.ajouteAthlete(a3);

        france.ajouteEquipe(e1);
        chine.ajouteEquipe(e2);

        handball=new Sport("HandBall",1,1.5,1.5);
        volleyBall=new Sport("VolleyBall",1.5,1,1.5);

        handballH=new Epreuve("Handball", true, false,handball);
        volleyBallH=new Epreuve("Volley-Ball",true,false,volleyBall);

        e1.ajouteEpreuve(handballH);
        e1.ajouteEpreuve(volleyBallH);

        e2.ajouteEpreuve(handballH);
        e2.ajouteEpreuve(volleyBallH);

        @Test
        public void TestParticiper() {
            Assertions.assertEquals(a1.participer(), ((112.5+95)+(127.5+115)));
            Assertions.assertEquals(a4.participer(), ((112.5+95)+(127.5+115)));
            Assertions.assertEquals(a2.participer(), ((80+125)+(85+125)));
            Assertions.assertEquals(a3.participer(), ((80+125)+(85+125)));
        }

        @Test
        public void TestToString() {
            Assertions.assertEquals(a1.toString(), "Testeur Test");
            Assertions.assertEquals(a2.toString(), "Testeur2 Test2");
            Assertions.assertEquals(a3.toString(), "Testeur3 Test3");
            Assertions.assertEquals(a4.toString(), "Testeur4 Test4");
        }
    }
}
