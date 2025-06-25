package Hashing;
import java.util.*;

public class Basic {
    public static void main(String[] args) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int [] nums = {1,1,1,2,2,3};

         for(int elem : nums){
             if(map.containsKey(elem)){
                 map.put(elem,map.get(elem)+1);
             }
             else{
                 map.put(elem,1);
             }
         }
        System.out.println(map);
    }
}
