package Main.Sprint2;

import Main.Sprint2.IGraphe;
import Main.Sprint2.AbstractIGrapheTest;

public class GrapheTest extends AbstractIGrapheTest {

    @Override
    protected IGraphe creerGrapheVide() {
        return new Graphe();
    }
}