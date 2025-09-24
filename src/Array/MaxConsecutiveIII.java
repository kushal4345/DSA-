package Array;

public class MaxConsecutiveIII {
    public static void main(String[] args) {
        int [] nums = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k = 3;
        int j =0;
        int max = 0;
        int z =0;
        for(int i =0;i<nums.length;i++){
            if(nums[i]==0){
                z++;

            }
            if(z>k){
                j = i;
                z = 0;
            }
            max = Math.max(max,i-j+1);
        }
        System.out.println(max);
    }
}
