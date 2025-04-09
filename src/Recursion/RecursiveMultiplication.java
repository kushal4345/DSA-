package Recursion;

public class RecursiveMultiplication {
    public static int multiply(int n ,int sum){
        if(n<=0){
            return 0;
        }

         sum  = sum + multiply(n-1,sum);
         return sum;
    }
    public static void main(String []args){
        int n = 3;
        int m = 5;
        System.out.println(multiply(n , m));
    }
}
