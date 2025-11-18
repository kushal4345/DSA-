package DP;

public class LongestRouteInGrid {

    static int maxLen = -1;

    static void dfs(int i, int j, int m, int n,
                    int[][] arr, boolean[][] visited,
                    int len, int di, int dj) {

        // Out of bounds or blocked or visited
        if (i < 0 || j < 0 || i >= m || j >= n || arr[i][j] == 0 || visited[i][j])
            return;

        // Destination reached
        if (i == di && j == dj) {
            maxLen = Math.max(maxLen, len );
            return;
        }

        visited[i][j] = true;

        dfs(i - 1, j, m, n, arr, visited, len + 1, di, dj); // up
        dfs(i + 1, j, m, n, arr, visited, len + 1, di, dj); // down
        dfs(i, j + 1, m, n, arr, visited, len + 1, di, dj); // right
        dfs(i, j - 1, m, n, arr, visited, len + 1, di, dj); // left

        visited[i][j] = false; // backtrack
    }

    public static void main(String[] args) {

        int[][] arr = {
                {1, 1, 1, 0},
                {0, 1, 1, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 1}
        };


        int rows = arr.length;
        int cols = arr[0].length;

        boolean[][] visited = new boolean[rows][cols];

        // destination = (5,7)
        dfs(0, 0, rows, cols, arr, visited, 0, 3, 2);

        System.out.println("Longest Route Length = " + maxLen);
    }
}
