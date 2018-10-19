import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.HashMap;

public class GraphMatrix {

    protected HashMap<Character, Integer> _map;

    protected char[] vertex;

    protected double[][] edges;

    static final double INFINITE = Double.MAX_VALUE;

    public GraphMatrix (char[] vertex, ArrayList<Edge> list) {
        this(vertex, list, false);
    }
    public GraphMatrix (char[] vertex, ArrayList<Edge> list, boolean direction) {

        this.edges = new double[vertex.length][vertex.length];

        this.vertex = Arrays.copyOf(vertex, vertex.length);

        for (int i = 0; i < this.edges.length; i++) {
            for (int j = 0; j < this.edges[i].length; j++) {
                this.edges[i][j] = i == j ? 0 : INFINITE;
            }
        }

        HashMap<Character, Integer> map = this.getPositionMap();

        Iterator iter = list.iterator();

        while (iter.hasNext()) {

            Edge edge = (Edge)iter.next();

            this.edges[(Integer)map.get(edge.from)][(Integer)map.get(edge.to)] = edge.weight;

            if (direction == false) this.edges[(Integer)map.get(edge.to)][(Integer)map.get(edge.from)] = edge.weight;
        }
        
    }


    public HashMap<Character, Integer> getPositionMap () {
        int index = 0;
        char[] vertex = this.vertex;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        for (char item: vertex) {
            map.put((char)item, index++);
        }

        return this._map = map;
    }

    public double[][] getEdges () {
        return this.edges;
    }

    public char[] getVertex () {
        return this.vertex; 
    }

    public void prim (int start) {
       int index = 0;
       char[] V = this.vertex;
       int[] vNew = new int[V.length];
       double[][] edges = this.edges;
       double[] weights = new double[V.length];

       for (int i = 0, length = V.length; i < length; i++) {
            weights[i] = edges[start][i];
       }

       vNew[index++] = start;

       for (int i = 1, length = V.length; i < length; i++) {

           int from = 0;
           double min = INFINITE;
           for (int j = 0; j < length; j++) {
                if (weights[j] != 0 && weights[j] < min) {
                    min = weights[j];
                    from = j;         
                } 
           }

           vNew[index++] = from;
           weights[from] = 0;

           for (int k = 0; k < length; k++) {
                if (weights[k] != 0 && weights[k] > edges[from][k]) {
                    weights[k] = edges[from][k];
                }
           }
            
       }

       for (int v = 0; v < V.length; v++) {
            System.out.print(vNew[v] + " ");
       }

    }

    public void prim (char start) {
        this.prim((Integer)this._map.get(start));
    }

    public static GraphMatrix getGraphMatrix () {

        ArrayList<Edge> list = new ArrayList<Edge>(20);

        char[] vertex = new char[]{ 'A', 'B', 'C', 'D', 'E', 'F', 'G' };

        list.add(new Edge('A', 'B', 12.0));
        list.add(new Edge('A', 'F', 16.0));
        list.add(new Edge('A', 'G', 14.0));

        list.add(new Edge('B', 'A', 12.0));
        list.add(new Edge('B', 'F', 7.0));
        list.add(new Edge('B', 'C', 10.0));

        list.add(new Edge('C', 'F', 6.0));
        list.add(new Edge('C', 'E', 5.0));
        list.add(new Edge('C', 'D', 3.0));

        list.add(new Edge('D', 'C', 3.0));
        list.add(new Edge('D', 'E', 4.0));

        list.add(new Edge('E', 'F', 2.0));
        list.add(new Edge('E', 'C', 5.0));
        list.add(new Edge('E', 'D', 4.0));

        list.add(new Edge('F', 'B', 7.0));
        list.add(new Edge('F', 'C', 6.0));
        list.add(new Edge('F', 'E', 2.0));
        list.add(new Edge('F', 'G', 9.0));

        list.add(new Edge('G', 'A', 14.0));
        list.add(new Edge('G', 'F', 9.0));
        list.add(new Edge('G', 'E', 8.0));

        return new GraphMatrix(vertex, list);

    }
    
    public static void main (String args[]) {
        GraphMatrix graphMatrix = getGraphMatrix(); 

        char[] vertex = graphMatrix.getVertex();
        double[][] edges = graphMatrix.getEdges();

        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges[i].length; j++) {
                System.out.print(" " + edges[i][j]); 
            }
            System.out.println("");
        }
        System.out.println("");
        graphMatrix.prim('B');
    }
}
