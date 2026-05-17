package main.impl;

import main.modele.IGraphe;
import main.modele.AbstractIGrapheTest;

public class GrapheTest extends AbstractIGrapheTest {

    @Override
    protected IGraphe creerGrapheVide() {
        return new Graphe();
    }
}