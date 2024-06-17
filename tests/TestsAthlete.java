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

        e1=new Equipe(1, "Equipe1",france);
        e2=new Equipe(2, "Equipe2",chine);

        a1 = new Athlete(1, "Testeur", "Test", "H", 50, 10, 20,e1);
        a2 = new Athlete(2, "Testeur2", "Test2", "F", 20, 10, 30,e2);
        a3 = new Athlete(3, "Testeur3", "Test3", "H", 5, 5, 75,e2);
        a4 = new Athlete(4, "Testeur4", "Test4", "F", 60, 30, 5,e1);

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

    }
        @Test
        public void TestParticiper() {
            Assertions.assertEquals(a1.participer(handballH), 95);
            Assertions.assertEquals(a2.participer(handballH), 80);
            Assertions.assertEquals(a3.participer(handballH), 125);
            Assertions.assertEquals(a4.participer(handballH), 112.5);

            Assertions.assertEquals(a1.participer(volleyBallH), 115);
            Assertions.assertEquals(a2.participer(volleyBallH), 85);
            Assertions.assertEquals(a3.participer(volleyBallH), 125);
            Assertions.assertEquals(a4.participer(volleyBallH), 127.5);

        }

        @Test
        public void TestToString() {
            Assertions.assertEquals(a1.toString(), "Testeur Test");
            Assertions.assertEquals(a2.toString(), "Testeur2 Test2");
            Assertions.assertEquals(a3.toString(), "Testeur3 Test3");
            Assertions.assertEquals(a4.toString(), "Testeur4 Test4");
        }
}
