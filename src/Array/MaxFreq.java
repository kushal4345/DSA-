package Array;
import java.util.*;
public class MaxFreq {
    public static void main(String[] args) {
        int count =0,max=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int nums[] = {1,2,2,3,1,4};

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for(int num : map.keySet()){
            int freq = map.get(num);
            if(freq>=max){
                max = freq;
                count++;
            }

        }
        System.out.println(count*max);
    }
}
