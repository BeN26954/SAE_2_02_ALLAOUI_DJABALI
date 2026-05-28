import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

public class GrapheTest {

    @Test
    public void testConstructionGraphe() {
        GrapheListe g = new GrapheListe();
        g.ajouterArc("A", "B", 10);
        g.ajouterArc("B", "C", 20);

        List<String> noeuds = g.getNoeuds();
        assertTrue(noeuds.contains("A"), "Le graphe doit contenir le noeud A");
        assertTrue(noeuds.contains("B"), "Le graphe doit contenir le noeud B");
        assertTrue(noeuds.contains("C"), "Le graphe doit contenir le noeud C");

        List<Arc> arcsDeA = g.getAdjacence("A");
        assertEquals(1, arcsDeA.size(), "A doit avoir 1 arc sortant");
        assertEquals("B", arcsDeA.get(0).getDestination(), "L'arc de A doit aller vers B");
        assertEquals(10.0, arcsDeA.get(0).getPoids(), "Le poids doit être de 10");
    }

    @Test
    public void testBellmanFord() {
        GrapheListe g = new GrapheListe();
        g.ajouterArc("A", "B", 5);
        g.ajouterArc("B", "C", 10);
        g.ajouterArc("A", "C", 20); // Chemin direct plus long

        BellmanFord bf = new BellmanFord();
        Valeurs resultats = bf.resoudre(g, "A");

        assertEquals(15.0, resultats.getValeur("C"), "Le plus court chemin doit coûter 15 (5+10)");

        List<String> chemin = resultats.calculerChemin("C");
        assertEquals("[A, B, C]", chemin.toString(), "Le chemin doit passer par B");
    }

    @Test
    public void testDijkstra() {
        GrapheListe g = new GrapheListe();
        g.ajouterArc("A", "B", 5);
        g.ajouterArc("B", "C", 10);
        g.ajouterArc("A", "C", 20);

        Dijkstra dijkstra = new Dijkstra();
        Valeurs resultats = dijkstra.resoudre(g, "A");

        assertEquals(15.0, resultats.getValeur("C"), "Dijkstra doit trouver le coût de 15");

        List<String> chemin = resultats.calculerChemin("C");
        assertEquals("[A, B, C]", chemin.toString(), "Dijkstra doit trouver le chemin A -> B -> C");
    }
}