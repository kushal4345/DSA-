package Graph;

import java.util.*;

public class BFS {

    static class Edge {
        int src;
        int dest;
        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    static void createGraph(ArrayList<Edge>[] graph, int v) {
        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));
        graph[1].add(new Edge(1, 4));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 3));
        graph[4].add(new Edge(4, 2));

    }

    static void bfs(int start, boolean[] visited, ArrayList<Edge>[] graph) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while(! q.isEmpty()){
            int curr  = q.remove();
            if(visited[curr]==false){
                System.out.println(curr);
                visited[curr] = true;
                for(int i =0;i<graph[curr].size();i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    public static void main(String[] args) {

        int v = 5;
        ArrayList<Edge>[] graph = new ArrayList[v];

        createGraph(graph, v);

        System.out.println("Graph:");
        for (int i = 0; i < v; i++) {
            System.out.print(i + " -> ");
            for (Edge e : graph[i]) {
                System.out.print("(" + e.src + " -> " + e.dest + ") ");
            }
            System.out.println();
        }

        boolean visited[] = new boolean[v];
        System.out.println("\nBFS Traversal:");
        for(int i = 0;i<v;i++){
            if(!visited[i])bfs(i, visited, graph);
        }
    }
}
