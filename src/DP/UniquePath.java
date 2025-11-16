package DP;
import java.util.*;
public class UniquePath {
    public static int helper(int i ,int j , int m , int n , int arr[][]){
        if(i==m-1&&j==n-1) return 1;
        if(i>=m||j>=n) return 0;
        if(arr[i][j]!=-1) return arr[i][j];

        int bottom = helper( i+1 , j , m ,  n ,  arr);
        int right = helper( i , j+1 , m ,  n ,  arr);

        return arr[i][j] =  bottom+right;
    }

    public static void main(String[] args) {
       int m = 3, n = 7;
        int[][] dp = new int[m][n];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        System.out.println(helper(0, 0, m, n, dp));
    }

}
