package Hashing;
import java.util.*;
public class ContigiousArray {
   static public int findMaxLength(int[] nums) {
       Map<Integer,Integer> map = new HashMap<>();
       int max =0;
       int sum =0;
       for(int i =0;i<nums.length;i++){
           if(nums[i]==0){
               sum++;
           }
           else{
               sum--;
           }
           if(map.containsKey(sum)){
               max = Math.max(max,i-(map.get(sum)));
           }
           else{
               map.put(sum,i);
           }
       }
       return max;
    }
    public static void main(String[] args) {
  int arr[] = {0,1,1,1,1,1,0,0,0};
  int result = findMaxLength(arr);
        System.out.println(result);
    }
}
