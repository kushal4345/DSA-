package Array;

public class equilibriumPoint {
    public static int point(int nums[]){
        int leftSum = 0;
        int rightSum ;
        int totalsum =0;
        //total sum
        for(int i =0;i<nums.length;i++){
            totalsum += nums[i];
        }
        // equilibrium point

        for(int i =0;i<nums.length;i++){
            rightSum = totalsum - nums[i]- leftSum; 
            if(rightSum==leftSum){  // return when both side will equal
                return nums[i];
            }
            leftSum+=nums[i];
        }
        return -1;
    }
    public static void main(String[]args){
    int arr[] = { 1,2,3};
    int equilibriumPoint = point(arr);
    System.out.println("the equilibrium point is " + equilibriumPoint);
}}
