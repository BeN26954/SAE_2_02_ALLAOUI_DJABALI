import java.util.ArrayList;
import java.util.List;

public class Dijkstra {
    public Valeurs resoudre(Graphe g, String depart) {
        Valeurs v = new Valeurs();
        List<String> Q = new ArrayList<>();

        for (String noeud : g.getNoeuds()) {
            v.setValeur(noeud, Double.MAX_VALUE);
            Q.add(noeud);
        }
        v.setValeur(depart, 0.0);

        while (!Q.isEmpty()) {
            String u = null;
            double minValeur = Double.MAX_VALUE;
            for (String noeud : Q) {
                if (v.getValeur(noeud) <= minValeur) {
                    minValeur = v.getValeur(noeud);
                    u = noeud;
                }
            }

            if (u == null || minValeur == Double.MAX_VALUE) {
                break;
            }

            Q.remove(u);

            for (Arc arc : g.getAdjacence(u)) {
                String n = arc.getDestination();

                if (Q.contains(n)) {
                    double d = v.getValeur(u) + arc.getPoids();
                    if (d < v.getValeur(n)) {
                        v.setValeur(n, d);
                        v.setParent(n, u);
                    }
                }
            }
        }

        return v;
    }
}