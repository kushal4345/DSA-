package Graph;
import java.util.*;
public class courseSchedule2 {
    private static void dfs(int node , ArrayList<ArrayList<Integer>> adj,boolean visited[],Stack<Integer>st){
        visited[node] = true;
        for(int val : adj.get(node)){
            if(!visited[val]){
                dfs(val,adj,visited,st);
            }
        }
        st.add(node);
    }
    private static boolean isCycle(int node, ArrayList<ArrayList<Integer>> adj,
                               boolean visited[], boolean rec[]) {

        visited[node] = true;
        rec[node] = true;

        for (int val : adj.get(node)) {
            if (!visited[val]) {
                if (isCycle(val, adj, visited, rec)) {
                    return true;
                }
            } else if (rec[val]) {
                return true;
            }
        }

        rec[node] = false;
        return false;
    }

    public static void main(String[] args) {
        // find cycle
      int prerequisites[][] = {{1,0},{2,0},{3,1},{3,2}};
      int numCourses = 4;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            adj.get(v).add(u);
        }

        boolean visited[] = new boolean[numCourses];
        boolean rec[] = new boolean[numCourses];
          boolean ans = true;
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (isCycle(i, adj, visited, rec)) {
                    ans = false;
                }
            }
        }
        // apply topo sort
        if(ans){
            for(int i =0;i<numCourses;i++){
                visited[i]= false;
            }
            Stack<Integer> st = new Stack<>();
            for(int i =0;i<numCourses;i++){
                if(!visited[i]){
                    dfs(i,adj,visited,st);
                }
            }
            while(!st.isEmpty()){
System.out.print(st.pop() + " ");
            }
        }
    }
}
