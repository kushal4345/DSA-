package Recursion;

import java.util.*;

public class Allindices {

    // Recursive function that returns a list of indices where target is found
    public static List<Integer> findIndices(int[] arr, int i, int target) {
        // Base case: if end of array is reached
        if (i == arr.length) {
            return new ArrayList<>();
        }

        // Recursive call
        List<Integer> result = findIndices(arr, i + 1, target);

        // If current element matches target, add index at the beginning
        if (arr[i] == target) {
            result.add(0, i); // Add to the front to maintain order
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 4};
        int target = 2;

        List<Integer> indices = findIndices(arr, 0, target);
        System.out.println("Indices of " + target + ": " + indices);
    }
}

