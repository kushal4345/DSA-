package Graph;
import java.util.*;
public class DAGcycleDetection {
    private static boolean dfs(int node , ArrayList<ArrayList<Integer>>adj , boolean visited[], boolean rec[]){
        visited[node] = true;
        rec[node] = true;
        for(int val : adj.get(node)){
            if(!visited[val]){
                if(dfs(val,adj,visited,rec)){
                    return true;
                }
            }
            else if(rec[val]==true){
                return true;
            }
        }
        rec[node] = false;
        return false;
    }
    public static void main(String args[]){
        int edges[][] = {{1,2},{0,2},{2,3},{3,0}};
        int V = 4;
        ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
        for(int i =0;i<edges.length;i++){
        adj.add(new ArrayList<>());
        }

        for(int i =0;i<V;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
        }

        boolean visited[] = new boolean[V];
        boolean rec [] = new boolean[V];
        for(int i = 0;i<V;i++){
            if(!visited[i]){
                if(dfs(i,adj,visited,rec)){
                    System.out.print("Cycle");
                    break;
                }
            }
        }
    }

}
