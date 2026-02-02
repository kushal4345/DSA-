package Graph;
import java.util.*;
public class dfs {
    static class edge{
        int dest;
        int src;

        public edge(int dest,int src){
            this.dest = dest;
            this.src = src;
        }


    }

    static void dfs(ArrayList<edge>[] graph, boolean[] visited, int curr) {
        // 1. Visit the current node
        System.out.print(curr + " ");
        visited[curr] = true;

        // 2. Look at all neighbors
        for (int i = 0; i < graph[curr].size(); i++) {
            edge e = graph[curr].get(i);

            // 3. If the neighbor hasn't been visited, go there
            if (!visited[e.dest]) { // Check e.dest, not start!
                dfs(graph, visited, e.dest);
            }
        }
    }
    static void createGraph(ArrayList<edge> graph[]){
        for(int i = 0;i<4;i++){
            graph[i] = new ArrayList<edge>();
        }
        graph[0].add(new edge(0, 2));
        graph[0].add(new edge(0, 3));
        graph[1].add(new edge(1, 3));
        graph[1].add(new edge(1, 0));
        graph[2].add(new edge(2, 3));
        graph[3].add(new edge(3, 2));

    }
    public static void main(String args[]){
        int v = 4;
        ArrayList<edge> graph[] = new ArrayList[v];
        createGraph(graph);
        for (int i = 0; i < v; i++) {
            System.out.print(i + " -> ");
            for (edge e : graph[i]) {
                System.out.print("(" + e.src + " -> " + e.dest + ") ");
            }
            System.out.println();
        }
        boolean visited[] = new boolean[v];
        for(int i =0;i<v;i++){
            dfs(graph,visited,i);
        }

    }
}
