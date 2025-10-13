package Array;

public class RemoveDuplicate {
    public static void main(String args[]){
        int nums[] = {1,1,2};

        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
// print the new nums
    }

}
