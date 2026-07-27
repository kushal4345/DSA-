package Graph;

import java.util.*;

public class TopoDFS {

    private static void dfs(int node, ArrayList<ArrayList<Integer>> adj,
                            Stack<Integer> st, boolean visited[]) {

        visited[node] = true;

        for (int val : adj.get(node)) {
            if (!visited[val]) {
                dfs(val, adj, st, visited);
            }
        }

        // Push current node after visiting all its neighbours
        st.push(node);
    }

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        int E = sc.nextInt();

        int edges[][] = new int[E][2];

        for (int i = 0; i < E; i++) {
            for (int j = 0; j < 2; j++) {
                edges[i][j] = sc.nextInt();
            }
        }

        // Convert edge list to adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges
        for (int i = 0; i < E; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
        }

        // Topological Sort
        Stack<Integer> st = new Stack<>();
        boolean visited[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, adj, st, visited);
            }
        }

        while (!st.isEmpty()) {
            System.out.print(st.pop() + " ");
        }

        sc.close();
    }
}