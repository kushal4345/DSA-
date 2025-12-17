package DP;

import java.util.Arrays;

public class MinPathSum {
   static  int dfs(int i, int j, int[][] grid,int dp[][]) {
        int n = grid.length;
        int m = grid[0].length;


        if (i >= n || j >= m) return Integer.MAX_VALUE;

        if (i == n - 1 && j == m - 1)
            return grid[i][j];

        if(dp[i][j]!=-1)return dp[i][j];
        int right = dfs(i, j + 1, grid,dp);
        int down = dfs(i + 1, j, grid,dp);

        return dp[i][j] = grid[i][j] + Math.min(right, down);
    }

    public static void main(String[] args) {
        int [][]grid = {{1,3,1},{1,5,1},{4,2,1}};
        int dp[][] =  new int[grid.length][grid[0].length];
        for(int arr[] : dp){
            Arrays.fill(arr,-1);
        }

        
        
        
    }

}
