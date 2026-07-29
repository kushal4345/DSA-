package Graph;
import java.util.*;
public class SafeNode {
    private static boolean isCycle(int node, int[][] graph, boolean[] visited, boolean[] rec) {
        visited[node] = true;
        rec[node] = true;

        for (int nei : graph[node]) {
            if (!visited[nei]) {
                if (isCycle(nei, graph, visited, rec)) {
                    return true;
                }
            } else if (rec[nei]) {
                return true;
            }
        }

        rec[node] = false;
        return false;
    }
    public static void main(String[] args) {
        int graph[][] = {{1,2,3,4},{1,2},{3,4},{0,4},{}};
        boolean visited[] = new boolean[graph.length];
        boolean rec[] = new boolean[graph.length];
        boolean result [] = new boolean[graph.length];
        // adjacency lis
        for(int i =0;i<graph.length;i++){
                if(isCycle(i,graph ,visited,rec)){
                    result[i] = true;
                }
        }
        for(int i =0;i<result.length;i++){
//        System.out.println(visited[i] + " ");
        System.out.print(result[i] + " ");
        }
    }
}
