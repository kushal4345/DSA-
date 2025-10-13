package Array;
import java.sql.SQLOutput;
import java.util.*;
public class CoundElementWithMax {
    public static void main(String args[]){
        int nums[] =  {1 , 2 ,2 ,3 , 5 , 6 , 6};
        int count =0,max=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i =0;i<nums.length;i++){  // COUNTING THE FREQ AND MAX FREQ
            if(map.containsKey(nums[i])){
                map.put(nums[i] , map.get(nums[i])+1);
            }
            else{
                map.put(nums[i],1);
            }
            max = Math.max(map.get(nums[i]),max);
        }
        for(int num: map.keySet()){ // COUNTING THE MAX FREQ ELEMENT
            if(max==map.get(num)){
                count++;
            }
        }

        System.out.println(count*max);
    }
}
