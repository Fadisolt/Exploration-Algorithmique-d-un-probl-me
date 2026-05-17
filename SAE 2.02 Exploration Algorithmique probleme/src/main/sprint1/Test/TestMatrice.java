package main.sprint1.Test;

import main.sprint1.MatriceGraphe;
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
        assertFalse(m.existeArete("AppliChenille", "AppliChenille"), "Le doublon ne doit pas créer d'arête");
    }
}
