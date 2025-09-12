package Array;

public class MissingNumber {
    public static void main(String[] args) {
        int arr [] =  {7,1,3,6,2};
        int sum = 0,max =0;
        for(int i =0;i<3;i++){
            sum = sum+arr[i];
        }
        int j = 0;
        for(int i =3;i<arr.length;i++){
            max = Math.max(max,sum);
            sum = sum - arr[j];
            j++;
            sum = sum + arr[i];

    }
        System.out.println(max);
}}
