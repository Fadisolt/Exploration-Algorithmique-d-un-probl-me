package main.outils;

import main.modele.AbstractAlgorithmesGrapheTest;
import main.impl.Graphe;
import main.modele.IGraphe;

public class AlgorithmesGrapheTest extends AbstractAlgorithmesGrapheTest {
    @Override
    protected IGraphe creerGrapheVide() {

        return new Graphe();
    }
}