package Main.Sprint1.Test;

import Main.Sprint1.MatriceGraphe;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestMatrice{

    MatriceGraphe m = new MatriceGraphe();

    @Test
    public void testAjoutSommetArete() {
        m.ajouterSommet("AppliChenille");
        m.ajouterSommet("AppliChenille");
        m.ajouterSommet("Chenille");

        m.ajouterArete("AppliChenille", "Create", "Chenille");

        assertTrue(m.existeArete("AppliChenille", "Chenille"));
        assertEquals("Create", m.getEtiquette("AppliChenille", "Chenille"));
        assertTrue(m.existeArete("AppliChenille", "AppliChenille"),"Le sommet a un doublon");
    }
}
