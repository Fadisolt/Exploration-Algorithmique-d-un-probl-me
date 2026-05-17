package main.sprint1.Test;

import main.sprint1.ListeGraphe;
import org.junit.jupiter.api.Test;

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
        assertFalse(liste.existeArete("AppliChenille", "AppliChenille"), "Le doublon ne doit pas créer d'arête");
    }
}
