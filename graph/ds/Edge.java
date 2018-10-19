public class Edge {
    public double weight;
    public char from;
    public char to;

    public Edge(char from, char to, double weight) {
        this.to = to;
        this.from = from;
        this.weight = weight;
    }
}
