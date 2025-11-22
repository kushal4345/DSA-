package Graph;

import java.util.*;

public class Implimentation {

    // Edge class
    static class Edge {
        int src;
        int dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    // Create graph function
    static void createGraph(ArrayList<Edge>[] graph, int v) {

        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }

        // Now add edges
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 4));
        graph[2].add(new Edge(2, 3));
        graph[4].add(new Edge(4, 2));
    }

    public static void main(String[] args) {
        int v = 5;
        ArrayList<Edge>[] graph = new ArrayList[v];

        createGraph(graph, v);

        // Print graph
        for (int i = 0; i < v; i++) {
            System.out.print(i + " -> ");
            for (Edge e : graph[i]) {
                System.out.print("(" + e.src + " -> " + e.dest + ") ");
            }
            System.out.println();
        }
    }
}
