package DP;
import java.util.*;
public class UniquePathObstacle {
    public static int helper(int i, int j, int m, int n, int arr[][], int obstacleGrid[][]){


        if(i >= m || j >= n) return 0;


        if(obstacleGrid[i][j] == 1) return 0;


        if(i == m-1 && j == n-1) return 1;

        // Memo check
        if(arr[i][j] != -1) return arr[i][j];

        // Move Down & Right
        int down = helper(i+1, j, m, n, arr, obstacleGrid);
        int right = helper(i, j+1, m, n, arr, obstacleGrid);

        return arr[i][j] = down + right;
    }

    public static void main(String[] args) {

        int[][] obstacleGrid = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];
        for(int[] row : dp) Arrays.fill(row, -1);

        System.out.println(helper(0, 0, m, n, dp, obstacleGrid));
    }
}

