package Array;

public class pivotIndex {
    public static int pivotIndex(int[] nums) {
        int leftsum =0;
        int rightsum =0;
        int left =0;
        int right = nums.length-1;
        while(left<right){
            leftsum = leftsum+nums[left];
            rightsum = rightsum+nums[right];
            if(leftsum==rightsum){
                break;
            }
            else if(leftsum<rightsum){
                left++;

            }
            else if(leftsum>rightsum){
                right--;
            }
            else{
                return -1;
            }
        }
        return left+1;}
public static void main(String args[]){
    int arr[] = {1,7,3,6,5,6};
          int res =  pivotIndex(arr);
    System.out.println(res);
        }
    }
