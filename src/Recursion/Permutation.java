package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

    // Function to generate all permutations of the array
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, result);
        return result;
    }

    // Backtracking function
    private static void backtrack(int[] nums, int start, List<List<Integer>> result) {
        if (start == nums.length) {
            // Found a permutation, add it to result
            List<Integer> permutation = new ArrayList<>();
            for (int num : nums) {
                permutation.add(num);
            }
            result.add(permutation);
            return;
        }

        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);           // Swap current index with start
            backtrack(nums, start + 1, result); // Recurse for next index
            swap(nums, start, i);           // Backtrack (undo swap)
        }
    }

    // Helper function to swap two elements in the array
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Main function to test the code
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> permutations = permute(nums);

        System.out.println("All permutations:");
        for (List<Integer> perm : permutations) {
            System.out.println(perm);
        }
    }
}
