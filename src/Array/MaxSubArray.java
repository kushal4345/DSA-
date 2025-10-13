package Array;

public class MaxSubArray {
    public static void main(String[] args) {
        int nums[] = {-2,1,-3,4,-1,2,1,-5,4};
        int CurrentSum = 0,MaxSum =Integer.MIN_VALUE;
        for(int i = 0;i<nums.length;i++){
            CurrentSum +=nums[i];
            MaxSum =  Math.max(CurrentSum,MaxSum);
            if(CurrentSum<0){
                CurrentSum = 0;
            }
        }
        // print here
    }
}
