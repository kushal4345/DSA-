package Greedy;
import java.util.*;
public class MinCoins {
    public static int findMin(int n) {
        // code here
        int currency [] =  { 10,5,2,1 };
        int remaining = n;
        int sum = 0;
        int i =0;
        while(remaining!=0){
            if(remaining<currency[i]) i++;

            int k = remaining/currency[i];
            remaining = remaining-k*currency[i];
            sum+=k;

        }
        return sum;
    }


public static void main(String[] args) {
    int n = 39;
    System.out.println(findMin(n));
}
}
