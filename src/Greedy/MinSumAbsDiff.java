package Greedy;

import java.util.Arrays;

public class MinSumAbsDiff {
   public static  long findMinSum(int[] A, int[] B, int N) {
        Arrays.sort(A);
        Arrays.sort(B);
        long sum = 0;
        for (int i = 0; i < N; i++) {
            int diff = Math.abs(A[i] - B[i]);
            sum += diff;
        }
        return sum;
    }


    public static void main(String[] args) {
        // Example input
        int[] A = {1, 3, 5, 9};
        int[] B = {2, 8, 6, 3};
        int N = A.length;

        long result = findMinSum(A, B, N);

        System.out.println("Minimum sum of absolute differences: " + result);
    }
}
