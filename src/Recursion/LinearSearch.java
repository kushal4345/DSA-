package Recursion;

public class LinearSearch {
    public static boolean Search(int arr[],int i,int target){
       if(i==arr.length) { // base Condition
           return false;
       }
       if(arr[i]==target){
           return true;
       }
       return Search(arr,i+1,target);
    }
    public static void main(String args[]){
        int arr[] = {1, 3, 5, 7};
        int target = 14;
      boolean find =  Search(arr,0,target);
      if(find){
          System.out.println("Yeah Got it !! "+ find);
      }
      else{
          System.out.println("Unable to find!! "+ find);
      }

    }
}
