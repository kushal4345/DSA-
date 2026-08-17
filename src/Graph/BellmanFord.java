package Graph;

import java.util.Arrays;

public class BellmanFord {
    public static void main(String args[]){
        // create edge list
        int n =4;
        int edge[][] = {{2,1,1},{2,3,1},{3,4,1}};

        int dist[]= new int[edge.length];
        Arrays.fill(dist,Integer.MAX_VALUE);
        for(int i =0;i<n-1;i++){
            //traverse through each node

            for(int ed[]:edge){
                int u = ed[0];
                int v= ed[1];
                int weight = ed[2];
                if(dist[u]!=Integer.MAX_VALUE&&dist[u]+weight<dist[v]){
                    dist[v] = dist[u]+weight;
                }
            }
        }
    }


}
