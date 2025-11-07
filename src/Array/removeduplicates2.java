package Array;
import java.util.*;
public class removeduplicates2 {
    public static int removeDuplicates(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();

        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int num : nums){
            if(map.containsKey(num)){
                map.put(num ,map.get(num)+1);

            }
            else{
                map.put(num,1);
            }
        }
        int arr[] = new int [nums.length];
        int i =0;
        for(int num : map.keySet()){
            if(map.get(num)>=2){
                int n = 0;
                while(n<2) {
                    nums[i] = num;
                    i++;
                    n++;
                }
            }
            if(map.get(num)==1){
                nums[i] = num;
                i++;
            }

        }
        return i;
    }

    public static void main(String[] args) {
        int arr [] = { 1,1,1,2,2,2,3,5};
        removeDuplicates(arr);
    }
}
