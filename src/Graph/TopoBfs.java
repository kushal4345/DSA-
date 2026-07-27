package Graph;
import java.util.*;

public class TopoBfs {

    private static void bfs(ArrayList<ArrayList<Integer>> adj,
                            int deg[],
                            Stack<Integer> st) {

        Queue<Integer> q = new LinkedList<>();

        // Add all nodes having indegree 0
        for(int i = 0; i < deg.length; i++){
            if(deg[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){

            int val = q.remove();
            st.push(val);

            for(int a : adj.get(val)){

                deg[a]--;

                if(deg[a] == 0){
                    q.add(a);
                }
            }
        }
    }

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        int E = sc.nextInt();

        int edges[][] = new int[E][2];

        for(int i = 0; i < E; i++){
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
        }

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < E; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
        }

        int deg[] = new int[V];

        // Calculate indegree
        for(int i = 0; i < E; i++){
            int v = edges[i][1];
            deg[v]++;
        }

        Stack<Integer> st = new Stack<>();

        bfs(adj, deg, st);

        while(!st.isEmpty()){
            System.out.print(st.pop() + " ");
        }

        sc.close();
    }
}