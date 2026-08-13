package Graph;
import java.util.*;
public class Dijkstra {
    public static void main(String[] args) {

        int n = 5;

        // adj.get(u) contains {v, edgeWeight}
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Example graph
        adj.get(0).add(new int[]{1, 10});
        adj.get(0).add(new int[]{2, 5});
        adj.get(1).add(new int[]{3, 1});
        adj.get(2).add(new int[]{1, 3});
        adj.get(2).add(new int[]{3, 9});
        adj.get(3).add(new int[]{4, 2});

        // distance array
        int[] weight = new int[n];
        Arrays.fill(weight, Integer.MAX_VALUE);

        // {node, cost}
        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        // Source = 0
        weight[0] = 0;
        pq.add(new int[]{0, 0});

        while (!pq.isEmpty()) {

            int[] node = pq.remove();

            int currNode = node[0];
            int cost = node[1];

            for (int[] edge : adj.get(currNode)) {

                int v = edge[0];
                int edgeWeight = edge[1];

                int totalCost = cost + edgeWeight;

                if (totalCost < weight[v]) {

                    weight[v] = totalCost;

                    pq.add(new int[]{v, totalCost});
                }
            }
        }

        System.out.println(Arrays.toString(weight));
    }
}
