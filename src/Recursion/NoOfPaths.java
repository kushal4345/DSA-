package Recursion;
import java.util.*;

class NoOfPaths {

    // Helper function for DFS + Backtracking
    private static void dfs(int[][] grid, int i, int j,
                            ArrayList<Integer> path,
                            ArrayList<ArrayList<Integer>> result,
                            int m, int n) {

        // Add current cell to path
        path.add(grid[i][j]);


        if (i == m - 1 && j == n - 1) {
            result.add(new ArrayList<>(path)); // store copy of path
            path.remove(path.size() - 1); // backtrack
            return;
        }

        // Move Right
        if (j + 1 < n) {
            dfs(grid, i, j + 1, path, result, m, n);
        }

        // Move Down
        if (i + 1 < m) {
            dfs(grid, i + 1, j, path, result, m, n);
        }


        path.remove(path.size() - 1);
    }

    // Main function that returns all paths
    public static ArrayList<ArrayList<Integer>> findAllPossiblePaths(int n, int m, int[][] grid) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        dfs(grid, 0, 0, new ArrayList<>(), result, n, m);
        return result;
    }

    // Testing
    public static void main(String[] args) {
        int[][] grid = {
                {1, 2, 3},
                {4, 5, 6}
        };

        ArrayList<ArrayList<Integer>> paths = findAllPossiblePaths(2, 3, grid);

        // Print all paths
        for (ArrayList<Integer> path : paths) {
            System.out.println(path);
        }
    }
}
