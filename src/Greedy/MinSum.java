package Greedy;

import java.util.Arrays;

public class MinSum {
    public static long minSum(int arr[], int n) {
        Arrays.sort(arr);
        String p = "";
        String q = "";

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                p = p + arr[i];
            } else {
                q = q + arr[i];
            }
        }


        if (p.equals("")) p = "0";
        if (q.equals("")) q = "0";

        // Convert strings to long
        long num1 = Long.parseLong(p);
        long num2 = Long.parseLong(q);


        return num1 + num2;
    }


    public static void main(String[] args) {
        int arr[] = {6, 8, 4, 5, 2, 3};
        int n = arr.length;
        System.out.println(minSum(arr, n));
    }
}
