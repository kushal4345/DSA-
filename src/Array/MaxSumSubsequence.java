package Array;
import java.util.*;
public class MaxSumSubsequence {
        public static void main(String[] args) {
            int nums[] = {-1,-2,3,4};
            int k =3;
                Arrays.sort(nums);
                int arr [] = new int [k];
                int j =0;
                int max =0;
                int sum =0;
                int m = nums.length-1;
                for(int i = nums.length-1;i>=0;i--){

                    if(k>0&&nums[i]>0){
                        sum =sum+ nums[i];
                        arr[j] = nums[i];
                        j++;
                        k--;
                        m--;


                    }
                    else{
                        break;
                    }

                }

                if(k>0){
                    for(int i =m;i>=0;i--){

                        if(k>0){
                            arr[j] = nums[i];
                            k--;
                        }
                        else{
                            break;
                        }


                    }
                }

            System.out.println(arr[0]);
            System.out.println(arr[1]);
            System.out.println(arr[2]);


}}
