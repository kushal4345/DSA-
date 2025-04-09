package Recursion;

public class SumOfDigits {
    public static int sumofdigit(int n){
        if(n<=9){
            return n;

        }
        int sum = n%10 + sumofdigit(n/10);
           return sum;
    }
    public static void main(String[]args){
        int n = 259;
        System.out.println(sumofdigit(n));
    }
}
