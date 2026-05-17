package Main.outils;

import Main.modele.AbstractAlgorithmesGrapheTest;
import Main.impl.Graphe;
import Main.modele.IGraphe;

public class AlgorithmesGrapheTest extends AbstractAlgorithmesGrapheTest {
    @Override
    protected IGraphe creerGrapheVide() {

        return new Graphe();
    }
}