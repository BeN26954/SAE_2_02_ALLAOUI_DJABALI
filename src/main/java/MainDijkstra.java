import java.util.List;

public class MainDijkstra {
    public static void main(String[] args) {
        GrapheListe g = new GrapheListe();
        g.ajouterArc("A", "B", 12);
        g.ajouterArc("A", "D", 87);
        g.ajouterArc("B", "E", 11);
        g.ajouterArc("C", "A", 19);
        g.ajouterArc("D", "B", 23);
        g.ajouterArc("D", "C", 10);
        g.ajouterArc("E", "D", 43);

        System.out.println("Lancement de Dijkstra depuis le noeud A...");
        Dijkstra dijkstra = new Dijkstra();
        Valeurs resultats = dijkstra.resoudre(g, "A");

        List<String> cheminVersC = resultats.calculerChemin("C");
        System.out.println("Le plus court chemin pour aller à C est : " + cheminVersC);
        System.out.println("Le coût total est de : " + resultats.getValeur("C"));
    }
}