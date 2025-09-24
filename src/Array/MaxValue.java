package Array;

import java.util.HashMap;

public class MaxValue {
    public static void main(String[] args) {
        int nums2[] =  {5,4,3,2,1};
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i =0;i<nums2.length;i++){
            map.put(nums2[i],i);
        }
        System.out.println(map);
    }
}
