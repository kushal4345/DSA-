package Greedy;
import java.util.*;
public class CandyStore {
    public static ArrayList<Integer> minMaxCandy(int[] prices, int k) {
        Arrays.sort(prices);
        ArrayList<Integer> list = new ArrayList<>();
        int i =0,j=prices.length-1;
        int min = 0,max = 0;
        int s = j;
        int l = i;
        while(i<=j){
            int pick = prices[i];
            min+=pick;
            j = j-k;
            i++;
        }
        while(l<=s){
            int pick1 = prices[s];
            max+=pick1;
            l = l+k-1;
            s--;

        }
        list.add(min);
        list.add(max);
        return list;

    }
    public static void main(String[] args) {
       int prices[] = {3, 2, 1, 4}, k = 2;
        System.out.println(minMaxCandy(prices,k));
    }
}
