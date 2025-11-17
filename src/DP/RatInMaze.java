package DP;
import java.util.*;
public class RatInMaze {
    public static boolean isescape(int i , int j , int target[],
                            HashMap<Integer,HashSet<Integer>> map,
                            HashSet<String> vis){

        String key = i + "," + j;
        if(vis.contains(key)) return false;
        vis.add(key);

        if(i < 0 || j < 0) return false;
        if(target[0] == i && target[1] == j) return true;

        if(map.containsKey(i) && map.get(i).contains(j)) return false;

        return isescape(i+1, j, target, map, vis)
                || isescape(i-1, j, target, map, vis)
                || isescape(i, j+1, target, map, vis)
                || isescape(i, j-1, target, map, vis);
    }
    public static void main(String[] args) {
       int[][]  blocked = {{0,1},{1,0}};
        int [] source = {0,0};
        int [] target = {0,2};
        if(blocked.length == 0) System.out.println(false);

        HashMap<Integer,HashSet<Integer>> map = new HashMap<>();

        for(int k = 0; k < blocked.length; k++){
            int x = blocked[k][0];
            int y = blocked[k][1];
            map.putIfAbsent(x, new HashSet<>());
            map.get(x).add(y);
        }

        HashSet<String> vis = new HashSet<>();

        System.out.println(isescape(source[0], source[1], target, map, vis));
    }
}
