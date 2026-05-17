package Main.impl;

import Main.modele.IGraphe;
import Main.modele.AbstractIGrapheTest;

public class GrapheTest extends AbstractIGrapheTest {

    @Override
    protected IGraphe creerGrapheVide() {
        return new Graphe();
    }
}