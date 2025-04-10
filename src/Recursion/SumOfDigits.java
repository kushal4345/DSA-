package Recursion;
import java.util.*;

public class SumOfDigits {
    public static int sumofdigit(int n){
        if(n<=9){
            return n;
        }
        int sum = n%10 + sumofdigit(n/10);
           return sum;
    }
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(sumofdigit(n)); 

    }
}

