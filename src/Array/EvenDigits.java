package Array;

public class EvenDigits {

    public static int EvenDigit(int arr[]){
        int count =0;
        int evendigit = 0;
        for(int i =0;i<arr.length;i++){
            int n = arr[i];
            while(n!=0){
                n = n/10;
                count++;
            }
            if(count%2==0){
                evendigit++;
            }
        }
        return evendigit;
    }
    public static void main(String[]args) {
        int[] nums = {555,901,482,1771};
        int x = EvenDigit(nums);
        System.out.println(x);
    }
}






