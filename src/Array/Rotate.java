package Array;


 public class Rotate {
     static void reverse(int[] nums, int i, int j) {
         int l = i;
         int h = j;
         while (i <= j) {
             int temp = nums[i];
             nums[i] = nums[j];
             nums[j] = temp;
             i++;
             j--;
         }
     }
    public static void main(String[] args) {
        int k = 3;
        int nums[] = {1,2,3,4,5,6,7};
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);

    }
}
