import java.util.ArrayList;
import java.util.List;

public class GrapheListe implements Graphe {
    private List<String> noeuds;
    private List<Arcs> adjacence;

    public GrapheListe() {
        this.noeuds = new ArrayList<>();
        this.adjacence = new ArrayList<>();
    }

    public List<String> getNoeuds() {
        return this.noeuds;
    }

    public List<Arc> getAdjacence(String noeud) {
        int index = this.noeuds.indexOf(noeud);
        if (index != -1) {
            return this.adjacence.get(index).getArcs();
        }
        return new ArrayList<>();
    }

    public void ajouterArc(String depart, String destination, double cout) {
        int indexDepart = this.noeuds.indexOf(depart);
        if (indexDepart == -1) {
            this.noeuds.add(depart);
            this.adjacence.add(new Arcs());
            indexDepart = this.noeuds.size() - 1;
        }

        int indexDest = this.noeuds.indexOf(destination);
        if (indexDest == -1) {
            this.noeuds.add(destination);
            this.adjacence.add(new Arcs());
        }
        this.adjacence.get(indexDepart).ajouterArc(new Arc(destination, cout));
    }

}
