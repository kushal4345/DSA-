package Recursion;

public class ArraySum {
    public static int sumOfArray(int arr [] , int i){
        if(i == arr.length){
            return 0;
        }
        int sum = sumOfArray(arr ,i+1);
         return arr[i] + sum;
    }
    public static void main (String args[]){
        int arr[] = {4, 6 , 9 , 8};
        int i = 0;
       int result =  sumOfArray(arr,i);
       System.out.print(result);

    }
}
