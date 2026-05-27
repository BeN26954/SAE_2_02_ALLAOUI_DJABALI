public class BellmanFord {
    public Valeurs resoudre(Graphe g, String depart) {
        Valeurs v = new Valeurs();
        for (String noeud : g.getNoeuds()) {
            v.setValeur(noeud, Double.MAX_VALUE);
        }
        v.setValeur(depart, 0.0);
        boolean modifie = true;

        while (modifie) {
            modifie = false;
            for (String x : g.getNoeuds()) {
                double valeurX = v.getValeur(x);
                if (valeurX == Double.MAX_VALUE) {
                    continue;
                }
                for (Arc arc : g.getAdjacence(x)) {
                    String n = arc.getDestination();
                    double cout = arc.getPoids();
                    double nouvelleValeur = valeurX + cout;

                    if (nouvelleValeur < v.getValeur(n)) {
                        v.setValeur(n, nouvelleValeur);
                        v.setParent(n, x);
                        modifie = true;
                    }
                }
            }
        }
        return v;
    }
}
