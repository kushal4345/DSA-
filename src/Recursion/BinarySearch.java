package Recursion;

public class BinarySearch {

    public static int Search(int arr[], int start, int end, int target) {
        if (start > end) {
            return -1;  // Base case: target not found
        }

        int mid = (start + end) / 2;

        if (arr[mid] == target) {
            return mid;  // Target found
        } else if (arr[mid] > target) {
            return Search(arr, start, mid - 1, target);  // Search left
        } else {
            return Search(arr, mid + 1, end, target);    // Search right
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 4, 6, 9, 11, 14};
        int target = 11;
        int start = 0;
        int end = arr.length - 1;

        int index = Search(arr, start, end, target);

        if (index != -1) {
            System.out.println("Target found at index: " + index);
        } else {
            System.out.println("Target not found in the array.");
        }
    }
}
