package Array;

public class RunningSum {
    public static void main(String args[]){
        int nums[] = {1 , 2 , 3 , 4 ,5};
        int arr[] = new int [nums.length];
        int sum =0;
        for(int i = 0;i<nums.length;i++){
            sum = sum + nums[i];
            arr[i] = sum;
        }

    }
}
