public class Evaluation {
    public static void main(String[] args) {
        String depart = "NYGAR1";
        String arrivee = "NYPCL1";

        System.out.println("Chargement du réseau...");
        Graphe g = LireReseau.lire("stan.nodes.txt", "stan.edges.txt");

        long startBF = System.nanoTime();
        BellmanFord bf = new BellmanFord();
        bf.resoudre(g, depart).calculerChemin(arrivee);
        long timeBF = System.nanoTime() - startBF;

        long startD = System.nanoTime();
        Dijkstra dijkstra = new Dijkstra();
        dijkstra.resoudre(g, depart).calculerChemin(arrivee);
        long timeD = System.nanoTime() - startD;

        System.out.println("Trajet : " + depart + " -> " + arrivee);
        System.out.println("Temps Bellman-Ford : " + timeBF + " ns");
        System.out.println("Temps Dijkstra     : " + timeD + " ns");
    }
}