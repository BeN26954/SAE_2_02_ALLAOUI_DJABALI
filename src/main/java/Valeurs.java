import java.util.Map;
import java.util.TreeMap;

public class Valeurs {

    Map<String, Double> valeur;
    Map<String, String> parent;

    public Valeurs() {
        this.valeur = new TreeMap<>();
        this.parent = new TreeMap<>();
    }

    public void setValeur(String nom, double valeur) {
        this.valeur.put(nom, valeur);
    }

    public void setParent(String nom, String parent) {
        this.parent.put(nom, parent);
    }

    public String getParent(String nom) {
        return this.parent.get(nom);
    }

    public double getValeur(String nom) {
        return this.valeur.get(nom);
    }

    public String toString() {
        String res = "";
        for (String s : this.valeur.keySet()) {
            Double valeurNoeud = valeur.get(s);
            String noeudParent = parent.get(s);
            res += s + " ->  V:" + valeurNoeud + " p:" + noeudParent + "\n";
        }
        return res;
    }
}