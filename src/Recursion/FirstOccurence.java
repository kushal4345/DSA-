package Recursion;

public class FirstOccurence {

    public static int FirstIndex(int arr[] , int start,int end,int target){
        int mid = (start+end)/2;
        if(start>=end) {
            int index = mid;
            return index;
        }

        if(arr[mid]<target){
            start = mid+1;
        }
        else{
            end = mid-1;
        }
        return FirstIndex(arr,start,end,target);

    }
//    public static int LastIndex(int arr[],int start,int end,int target){
//        int mid = (start+end)/2;
//        if(start>=end){
//            int index = mid;
//            return mid;
//        }
//
//        if(arr[mid]>target){
//            start =
//        }
//    }

    public static void main(String args[]){
        int arr[] = {1,2,3,6,6,6};
        int Start = 0;
        int end = arr.length-1;
        int target = 6;
      int idx =   FirstIndex(arr,Start,end,target);
      System.out.println("First index is Found at "+ idx);
    }
}
