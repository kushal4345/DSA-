package Recursion;

public class ReverseArray {

    // Helper method to swap two elements in the array
    public static void swap(int[] arr, int m, int n) {
        int temp = arr[m];
        arr[m] = arr[n];
        arr[n] = temp;
    }

    // Recursive function to reverse the array
    public static int[] reverse(int[] arr, int i, int j) {
        if (i >= j) {
            return arr;
        }

        swap(arr, i, j);                // Swap elements at i and j
        return reverse(arr, i + 1, j - 1);  // Recursive call inward
    }

    public static void main(String[] args) {
        int[] arr = {6, 2, 8, 6, 8, 7, 6, 8};
        int i = 0;
        int j = arr.length - 1;

        reverse(arr, i, j);  // Reverse the array recursively

        // Print the reversed array
        for (int k = 0; k < arr.length; k++) {
            System.out.print(arr[k] + " ");
        }
    }
}
