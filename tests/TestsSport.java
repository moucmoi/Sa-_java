import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

public class TestsSport {
    private static Sport natation;
    private static Sport handball;
    private static Sport volleyBall;
    private static Sport escrime;
    private static Sport athletisme;
    private static Athlete a1;
    private static Athlete a2; 
    private static Pays france;
    private static Equipe e1;
    
    @BeforeAll // initialisation faite en premier lieu
    static void init() { 
        natation=new Sport("Natation",1,0.5,2.5);
        handball=new Sport("HandBall",1,1.5,1.5);
        volleyBall=new Sport("VolleyBall",1.5,1,1.5);
        escrime=new Sport("Escrime",0.5,2.5,1);
        athletisme=new Sport("Athletisme",0.5,1,2.5);
        france=new Pays("France","FRA");

        e1=new Equipe("Equipe1",france);

        a1 = new Athlete("Testeur", "Test", "H", 10, 10, 20, e1);
        a2 = new Athlete("Testeur2", "Test2", "F", 20, 10, 10, e1);
    }

    @Test
    public void testNom() {
        Assertions.assertEquals(natation.getNomSport(), "Natation");
        Assertions.assertEquals(handball.getNomSport(), "Handball");
        Assertions.assertEquals(volleyBall.getNomSport(), "VolleyBall");
        Assertions.assertEquals(escrime.getNomSport(), "Escrime");
        Assertions.assertEquals(athletisme.getNomSport(), "Athletisme");
    }

    @Test
    public void testCoeff() {
        Assertions.assertEquals(natation.getCoeffForce(), 1);
        Assertions.assertEquals(handball.getCoeffForce(), 1);
        Assertions.assertEquals(volleyBall.getCoeffForce(), 1.5);
        Assertions.assertEquals(escrime.getCoeffForce(), 0.5);
        Assertions.assertEquals(athletisme.getCoeffForce(), 0.5);

        Assertions.assertEquals(natation.getCoeffAgilite(), 0.5);
        Assertions.assertEquals(handball.getCoeffAgilite(), 1.5);
        Assertions.assertEquals(volleyBall.getCoeffAgilite(), 1);
        Assertions.assertEquals(escrime.getCoeffAgilite(), 2.5);
        Assertions.assertEquals(athletisme.getCoeffAgilite(), 1);

        Assertions.assertEquals(natation.getCoeffEndurance(), 2.5);
        Assertions.assertEquals(handball.getCoeffEndurance(), 1.5);
        Assertions.assertEquals(volleyBall.getCoeffEndurance(), 1.5);
        Assertions.assertEquals(escrime.getCoeffEndurance(), 1);
        Assertions.assertEquals(athletisme.getCoeffEndurance(), 2.5);
    }

    @Test
    public void testCalculerScore() {
        Assertions.assertEquals(natation.calculerScore(a1), 65);
        Assertions.assertEquals(handball.calculerScore(a1), 55);
        Assertions.assertEquals(volleyBall.calculerScore(a1), 55);
        Assertions.assertEquals(escrime.calculerScore(a1), 50);
        Assertions.assertEquals(athletisme.calculerScore(a1), 65);

        Assertions.assertEquals(natation.calculerScore(a2), 50);
        Assertions.assertEquals(handball.calculerScore(a2), 50);
        Assertions.assertEquals(volleyBall.calculerScore(a2), 55);
        Assertions.assertEquals(escrime.calculerScore(a2), 45);
        Assertions.assertEquals(athletisme.calculerScore(a2), 45);
        
    }

}
