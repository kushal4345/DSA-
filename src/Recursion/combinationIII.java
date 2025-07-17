package Recursion;
import java.util.ArrayList;
import java.util.List;

public class combinationIII {
    static void comSum(int arr[], List<Integer> current, List<List<Integer>> result, int index, int target, int k) {
        if (target == 0) {
            if (current.size() == k) {
                result.add(new ArrayList<>(current));
            }
            return;

        }

        if (target < 0 || current.size() > k) {
            return;
        }

        for (int i = index; i < arr.length; i++) {
            current.add(arr[i]);
            comSum(arr, current, result, i + 1, target - arr[i], k);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 7;
        int k = 3;
        comSum(arr, current, result, 0, target, k);
        System.out.println(result);
    }
}
