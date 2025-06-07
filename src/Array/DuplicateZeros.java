package Array;

public class DuplicateZeros {
        public static void modified(int arr[],int j){
            for(int i =j+1;i<arr.length;i++){
                arr[i] = arr[i-1];

            }
        }
        public static void main (String args[]) {
           int[] arr = {1,0,2,3,0,4,5,0};
            for(int i =0;i<arr.length;i++){
                if(arr[i]==0){
                    i++;
                    modified(arr,i);

                }
            }
            for(int num :arr){

            System.out.println(num);}
        }
    }

