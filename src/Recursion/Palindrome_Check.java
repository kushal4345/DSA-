package Recursion;

public class Palindrome_Check {

    // Recursive function to check if the array is a palindrome
    public static boolean isPalindrome(int[] arr, int i, int j) {
        if (i > j) {
            return true; // Base case: crossed pointers, it's a palindrome
        }
        if (arr[i] != arr[j]) {
            return false; // Mismatch found
        }
        return isPalindrome(arr, i + 1, j - 1); // Move inward
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 1}; // Change input here

        boolean check = isPalindrome(arr, 0, arr.length - 1);

        if (check) {
            System.out.println("✅ The given array is a palindrome");
        } else {
            System.out.println("❌ The given array is not a palindrome");
        }
    }
}
