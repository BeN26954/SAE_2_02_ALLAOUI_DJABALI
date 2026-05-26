public class Arc {
    private String destination;
    private double poids;

    public Arc(String destination, double poids) {
        this.destination = destination;
        this.poids = poids;
    }

    public String getDestination() {
        return this.destination;
    }

    public double getPoids() {
        return this.poids;
    }
}
