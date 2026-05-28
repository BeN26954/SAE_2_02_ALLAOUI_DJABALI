import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LireReseau {
    public static Graphe lire(String fichier_stations, String fichier_connexions) {
        GrapheListe g = new GrapheListe();

        try (BufferedReader br = new BufferedReader(new FileReader(fichier_connexions))) {
            String ligne;

            while ((ligne = br.readLine()) != null) {
                String[] parties = ligne.split(";");

                if (parties.length >= 3) {
                    String depart = parties[0];
                    String arrivee = parties[1];
                    double distance = Double.parseDouble(parties[2]);

                    g.ajouterArc(depart, arrivee, distance);
                    g.ajouterArc(arrivee, depart, distance);
                }
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }

        return g;
    }
}