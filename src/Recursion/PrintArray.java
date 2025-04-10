package Recursion;

public class PrintArray {
    public static void printArray(int arr[],int i){
        if(i==arr.length){  //base condition
            return;
        }

        printArray(arr,i+1); // calling itself
        System.out.print(arr[i] + " ");  // print the array
    }
    public static void main(String args[]){
        int arr[] = {1,2,6,9,8,5};
        printArray(arr,0);
    }
}
