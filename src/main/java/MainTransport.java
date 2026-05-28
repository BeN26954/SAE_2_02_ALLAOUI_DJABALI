import java.util.List;

public class MainTransport {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Erreur: MainTransport <STATION_DEPART> <STATION_ARRIVEE>");
            System.exit(1);
        }

        String depart = args[0];
        String arrivee = args[1];

        String fichier_stations = "stan.nodes.txt";
        String fichier_connexions = "stan.edges.txt";

        Graphe g = LireReseau.lire(fichier_stations, fichier_connexions);

        long startTime = System.nanoTime(); // On démarre le chrono

        Dijkstra dijkstra = new Dijkstra();
        Valeurs resultats = dijkstra.resoudre(g, depart);
        List<String> chemin = resultats.calculerChemin(arrivee);

        long endTime = System.nanoTime();

        System.err.println("Temps execution Dijkstra : " + (endTime - startTime) + " ns");

        String sortiePython = String.join(";", chemin);
        System.out.println(sortiePython);
    }
}