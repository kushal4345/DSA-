package Recursion;
import java.util.*;

public class Sum_positive {
   static int SumOfNumbers(int n){
       if(n<=1){
           return 1;
       }

       int sum = n + SumOfNumbers(n-1);
       System.out.println(n);
       return sum;
   }
    public static void main (String[]args){
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
        int sum = SumOfNumbers(n);
        System.out.println("The Sum of "+ n + " Postive number is " + sum);
    }
}
