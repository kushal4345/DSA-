package Recursion;

import java.util.*;

public class CombinationSum {
    static void comb(int index, int arr[],  int target, List<List<Integer>> result, List<Integer> current) {
        if (target==0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (target < 0) return;
        for (int i = index; i < arr.length; i++) {
            current.add(arr[i]);
            comb(i, arr,  target - arr[i], result, current);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        int index = 0;
        ArrayList<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> current = new ArrayList<>();
        int k = 7;
        int arr[] = {2,3,6,7};

        comb(index, arr,  k, result, current);
        System.out.println(result);
    }
}
