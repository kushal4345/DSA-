package Recursion;
import java.util.*;

public class combinations {
    static void comb(int index, int arr[], int n, int k, List<List<Integer>> result, List<Integer> current) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = index; i < arr.length; i++) {
            current.add(arr[i]);
            comb(i + 1, arr, n, k, result, current);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        int index = 0;
        ArrayList<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> current = new ArrayList<>();
        int n = 4;
        int k = 2;
        int arr[] = new int[n];
        for (int i = 1; i <= n; i++) {
            arr[i - 1] = i;
        }
        comb(index, arr, n, k, result, current);
        System.out.println(result);
    }
}
