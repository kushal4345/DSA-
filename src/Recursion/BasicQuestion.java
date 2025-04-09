package Recursion;

public class BasicQuestion {
    static int fact(int n) {  // Fixed method
        if(n<=1) return n;
        int res = n*fact(n-1) ;
        return res;                    // Example operation
    }

    public static void main(String[] args) {
        int result = fact(5);  // Call the method
        System.out.println("Result: " + result);  // Print output
    }
}