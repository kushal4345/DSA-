package Array;

public class Search_IN_RotatedArray {
    static int search(int arr[],int index,int target){
        int start = index;
        int end = arr.length-1;
        while(start<=end){
            int mid  = (start+end)/2;
            if(arr[mid]==target){
                return mid;
            }
            else if(arr[mid]<target){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return -1;
    }
    static int search1(int arr[],int index,int target){
        int start = 0;
        int end = index;
        while(start<=end){
            int mid  = (start+end)/2;
            if(arr[mid]==target){
                return mid;
            }
            else if(arr[mid]<target){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return -1;
    }
public static void main(String[] args){
    int arr[] = {3,1};
    int start = 0;
    int end = arr.length-1;
    while(start<end){
        int mid = (start + end)/2;
          if(arr[mid]>arr[end]){
              start = mid+1;

          }
          else{
              end= mid;
          }

    }
  int index= start;
    int target = 3;
    System.out.println(search(arr,index,target));
    System.out.println(search1(arr,index-1,target));
}
}
