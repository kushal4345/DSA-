package Graph;
import java.util.*;
public class NetworkDelay {
    public int networkDelayTime(int[][] times, int n, int k) {

        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        int weight[] = new int[n + 1];

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();


        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < times.length; i++){
            int node = times[i][0];
            int des = times[i][1];
            int cost = times[i][2];

            adj.get(node).add(new int[]{des, cost});
        }

        Arrays.fill(weight, Integer.MAX_VALUE);

        weight[k] = 0;
        pq.add(new int[]{k, 0});

        while(!pq.isEmpty()){
            int edge[] = pq.remove();

            int currCost = edge[1];
            int node = edge[0];

            for(int v[] : adj.get(node)){
                int total = currCost + v[1];

                if(total < weight[v[0]]){
                    weight[v[0]] = total;
                    pq.add(new int[]{v[0], total});
                }
            }
        }

        int time = 0;

        for(int i = 1; i < weight.length; i++){
            if(weight[i] == Integer.MAX_VALUE)
                return -1;

            time = Math.max(time, weight[i]);
        }

        return time;
    }

    public static void main(String[] args) {
        // take the input and pass it to the network delay function
    }
}
