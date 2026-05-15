package Main.Sprint1.Test;

import Main.Sprint1.ListeGraphe;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class TestListe {

    ListeGraphe liste = new ListeGraphe();

    @Test
    public void testAjoutSommetArete() {
        liste.ajouterSommet("AppliChenille");
        liste.ajouterSommet("AppliChenille");
        liste.ajouterSommet("Chenille");

        liste.ajouterArete("AppliChenille", "Create", "Chenille");

        assertTrue(liste.existeArete("AppliChenille", "Chenille"));
        assertEquals("Create", liste.getEtiquette("AppliChenille", "Chenille"));
        assertTrue(liste.existeArete("AppliChenille", "AppliChenille"),"Le sommet a un doublon");
    }
}
