<h1 align="center">🧠 DSA Mastery Vault</h1>

<p align="center">
  <img src="https://img.shields.io/badge/DSA-Level-Up-blue?style=for-the-badge" />
  <img src="https://img.shields.io/github/last-commit/your-username/dsa-vault?style=for-the-badge&color=brightgreen" />
  <img src="https://img.shields.io/github/languages/top/your-username/dsa-vault?style=for-the-badge&color=purple" />
</p>

---

<h3 align="center">📘 Your One-Stop Repository for Crushing DSA Problems</h3>

<p align="center">Master Data Structures & Algorithms from the ground up. Track your progress, revisit important concepts, and become interview-ready.</p>

---

## 🧩 Table of Contents
- [🚀 About](#-about)
- [📂 Structure](#-folder-structure)
- [🛠️ Topics Covered](#️-topics-covered)
- [📈 Progress Tracker](#-progress-tracker)
- [📚 Resources](#-resources)
- [🤝 Contribute](#-contribute)
- [📄 License](#-license)

---

## 🚀 About

Welcome to **DSA Mastery Vault**, a curated collection of hand-picked problems and concepts from:
- 💼 **FAANG Interviews**
- 📚 **Competitive Programming**
- 🎯 **Coding Platforms (LeetCode, GFG, Codeforces)**

> My goal is to build a solid DSA foundation and help others prepare smarter, not harder.

---

## 📂 Folder Structure
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Main
{
// Below arrays detail all eight possible movements from a cell
// (top, right, bottom, left, and four diagonal moves)
public static int[] row = { -1, -1, -1, 0, 1, 0, 1, 1 };
public static int[] col = { -1, 1, 0, -1, -1, 1, 0, 1 };

    // Function to check if it is safe to go to cell (x, y) from the current cell.
    // The function returns false if (x, y) is not valid matrix coordinates
    // or cell (x, y) is already processed.
    public static boolean isSafe(int x, int y, boolean[][] processed) {
        return (x >= 0 && x < processed.length) && (y >= 0 && y < processed[0].length)
                && !processed[x][y];
    }
 
    // A recursive function to generate all possible words in a boggle
    public static void searchBoggle(char[][] board, Set<String> words,
                                    Set<String> result, boolean[][] processed,
                                    int i, int j, String path)
    {
        // mark the current node as processed
        processed[i][j] = true;
 
        // update the path with the current character and insert it into the set
        path += board[i][j];
 
        // check whether the path is present in the input set
        if (words.contains(path)) {
            result.add(path);
        }
 
        // check for all eight possible movements from the current cell
        for (int k = 0; k < row.length; k++)
        {
            // skip if a cell is invalid, or it is already processed
            if (isSafe(i + row[k], j + col[k], processed)) {
                searchBoggle(board, words, result, processed, i + row[k],
                        j + col[k], path);
            }
        }
 
        // backtrack: mark the current node as unprocessed
        processed[i][j] = false;
    }
 
    // Function to search for a given set of words in a boggle
    public static Set<String> searchBoggle(char[][] board, Set<String> words)
    {
        // construct a set to store valid words constructed from the boggle
        Set<String> result = new HashSet<>();
 
        // base case
        if (board.length == 0) {
            return result;
        }
 
        // `M × N` board
        int M = board.length;
        int N = board[0].length;
 
        // construct a boolean matrix to store whether a cell is processed or not
        boolean[][] processed = new boolean[M][N];
 
        // generate all possible words in a boggle
        for (int i = 0; i < M; i++)
        {
            for (int j = 0; j < N; j++) {
                // consider each character as a starting point and run DFS
                searchBoggle(board, words, result, processed, i, j, "");
            }
        }
 
        return result;
    }
 
    public static void main(String[] args)
    {
        char[][] board = {
                {'M', 'S', 'E'},
                {'R', 'A', 'T'},
                {'L', 'O', 'N'}
        };
        Set<String> words = Stream.of("STAR", "NOTE", "SAND", "STONE")
                                .collect(Collectors.toSet());
 
        Set<String> validWords = searchBoggle(board, words);
        System.out.println(validWords);
    }
}

class Main
{
// Find all binary strings that can be formed from a given wildcard pattern
private static void printAllCombinations(char[] pattern, int i)
{
// base case
if (pattern == null || pattern.length == 0) {
return;
}

        // base case
        if (i == pattern.length)
        {
            System.out.println(pattern);
            return;
        }
 
        // if the current character is '?'
        if (pattern[i] == '?')
        {
            for (char ch = '0'; ch <= '1'; ch++)
            {
                // replace '?' with 0 and 1
                pattern[i] = ch;
 
                // recur for the remaining pattern
                printAllCombinations(pattern, i + 1);
 
                // backtrack
                pattern[i] = '?';
            }
        }
        else {
            // if the current character is 0 or 1, ignore it and
            // recur for the remaining pattern
            printAllCombinations(pattern, i + 1);
        }
    }
 
    public static void main(String[] args)
    {
        char[] pattern = "1?11?00?1?".toCharArray();
        printAllCombinations(pattern, 0);
    }
}

#include <iostream>
#include <algorithm>
using namespace std;

// Find the minimum number formed by doing at-most `k` swap operations upon
// digits of the string
void findMin(string s, int k, string &min_so_far)
{
// compare the current number with a minimum number so far
if (min_so_far.compare(s) > 0) {
min_so_far = s;
}

    // base case: no swaps left
    if (k < 1) {
        return;
    }
 
    int n = s.length();
 
    // do for each digit in the input string
    for (int i = 0; i < n - 1; i++)
    {
        // compare the current digit with the remaining digits
        for (int j = i + 1; j < n; j++)
        {
            // if the digit at i'th index is more than the digit at j'th index
            if (s[i] > s[j])
            {
                // swap `s[i]` and `s[j]`
                swap(s[i], s[j]);
 
                // recur for remaining `k-1` swap
                findMin(s, k - 1, min_so_far);
 
                // backtrack: restore the string
                swap(s[i], s[j]);
            }
        }
    }
}

// Wrapper over findMin() function
string findMinimum(string s, int k)
{
string min = s;

    findMin(s, k, min);
    return min;
}

int main()
{
// input string and number
string s = "934651";
int k = 2;

    string min = findMinimum(s, k);
 
    cout << "The minimum number formed by doing at-most " << k
         << " swaps is " << min;
 
    return 0;
}

import java.util.Arrays;

class Main
{
// Function to print all distinct triplets in the array with a sum
// less than or equal to a given number
public static void printAllTriplets(int[] nums, int sum)
{
// sort the array in ascending order
Arrays.sort(nums);

        // check if triplet is formed by `nums[i]` and a pair from
        // subarray `nums[i+1…n)`
        for (int i = 0; i <= nums.length - 3; i++)
        {
            // maintain two indexes pointing to endpoints of the
            // subarray `nums[i+1…n)`
            int low = i + 1, high = nums.length - 1;
 
            // loop if `low` is less than `high`
            while (low < high)
            {
                // decrement `high` if the total is more than the remaining sum
                if (nums[i] + nums[low] + nums[high] > sum) {
                    high--;
                }
                else {
                    // if the total is less than or equal to the remaining sum,
                    // print all triplets
                    for (int x = low + 1; x <= high; x++)
                    {
                        System.out.println("(" + nums[i] + ", " + nums[low] + ", "
                                        + nums[x] + ")");
                    }
 
                    low++;        // increment low
                }
            }
        }
    }
 
    public static void main(String[] args)
    {
        int[] nums = { 2, 7, 4, 9, 5, 1, 3 };
        int sum = 10;
 
        printAllTriplets(nums, sum);
    }
}

class Main
{
// Check if it is possible to go to position (x, y) from
// the current position. The function returns false if the cell
// is invalid, has a value 0, or it is already visited.
private static boolean isSafe(int[][] mat, boolean[][] visited, int x, int y) {
return (x >= 0 && x < mat.length && y >= 0 && y < mat[0].length) &&
mat[x][y] == 1 && !visited[x][y];
}

    // Find the longest possible route in a matrix `mat` from the source cell
    // (i, j) to destination cell (x, y).
    // `max_dist` —> keep track of the length of the longest path from source to
    // destination.
    // `dist` —> length of the path from the source cell to the current cell (i, j).
    public static int findLongestPath(int[][] mat, boolean[][] visited, int i, int j,
                                      int x, int y, int max_dist, int dist)
    {
        // if the destination is not possible from the current cell
        if (mat[i][j] == 0) {
            return 0;
        }
 
        // if the destination is found, update `max_dist`
        if (i == x && j == y) {
            return Integer.max(dist, max_dist);
        }
 
        // set (i, j) cell as visited
        visited[i][j] = true;
 
        // go to the bottom cell
        if (isSafe(mat, visited, i + 1, j))
        {
            max_dist = findLongestPath(mat, visited, i + 1, j, x, y,
                    max_dist, dist + 1);
        }
 
        // go to the right cell
        if (isSafe(mat, visited, i, j + 1))
        {
            max_dist = findLongestPath(mat, visited, i, j + 1, x, y,
                    max_dist, dist + 1);
        }
 
        // go to the top cell
        if (isSafe(mat, visited, i - 1, j))
        {
            max_dist = findLongestPath(mat, visited, i - 1, j, x, y,
                    max_dist, dist + 1);
        }
 
        // go to the left cell
        if (isSafe(mat, visited, i, j - 1))
        {
            max_dist = findLongestPath(mat, visited, i, j - 1, x, y,
                    max_dist, dist + 1);
        }
 
        // backtrack: remove (i, j) from the visited matrix
        visited[i][j] = false;
 
        return max_dist;
    }
 
    // Wrapper over findLongestPath() function
    public static int findLongestPathLength(int[][] mat, int i, int j, int x, int y)
    {
        // base case: invalid input
        if (mat == null || mat.length == 0 || mat[i][j] == 0 || mat[x][y] == 0) {
            return -1;
        }
 
        // `M × N` matrix
        int M = mat.length;
        int N = mat[0].length;
 
        // construct an `M × N` matrix to keep track of visited cells
        boolean[][] visited= new boolean[M][N];
 
        // (i, j) are the source cell, and (x, y) are the destination
        // cell coordinates
        return findLongestPath(mat, visited, i, j, x, y, 0, 0);
    }
 
    public static void main(String[] args)
    {
        // input matrix
        int mat[][] =
                {
                        { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                        { 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
                        { 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
                        { 0, 0, 0, 0, 1, 0, 0, 1, 0, 0 },
                        { 1, 0, 0, 0, 1, 1, 1, 1, 1, 1 },
                        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 0 },
                        { 1, 0, 0, 0, 1, 0, 0, 1, 0, 1 },
                        { 1, 0, 1, 1, 1, 1, 0, 0, 1, 1 },
                        { 1, 1, 0, 0, 1, 0, 0, 0, 0, 1 },
                        { 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 }
                };
 
        // (0, 0) are the source cell, and (5, 7) are the destination
        // cell coordinates
        int max_dist = findLongestPathLength(mat, 0, 0, 5, 7);
        System.out.println("The maximum length path is " + max_dist);
    }
}
class Main
{
// Check if cell (x, y) is valid or not
private static boolean isValidCell(int x, int y, int N) {
return !(x < 0 || y < 0 || x >= N || y >= N);
}

    private static int countPaths(int[][] maze, int i, int j, int x, int y,
                                  boolean visited[][])
    {
        // if destination (x, y) is found, return 1
        if (i == x && j == y) {
            return 1;
        }
 
        // stores number of unique paths from source to destination
        int count = 0;
 
        // mark the current cell as visited
        visited[i][j] = true;
 
        // `N × N` matrix
        int N = maze.length;
 
        // if the current cell is a valid and open cell
        if (isValidCell(i, j, N) && maze[i][j] == 1)
        {
            // go down (i, j) ——> (i + 1, j)
            if (i + 1 < N && !visited[i + 1][j]) {
                count += countPaths(maze, i + 1, j, x, y, visited);
            }
 
            // go up (i, j) ——> (i - 1, j)
            if (i - 1 >= 0 && !visited[i - 1][j]) {
                count += countPaths(maze, i - 1, j, x, y, visited);
            }
 
            // go right (i, j) ——> (i, j + 1)
            if (j + 1 < N && !visited[i][j + 1]) {
                count += countPaths(maze, i, j + 1, x, y, visited);
            }
 
            // go left (i, j) ——> (i, j - 1)
            if (j - 1 >= 0 && !visited[i][j - 1]) {
                count += countPaths(maze, i, j - 1, x, y, visited);
            }
        }
 
        // backtrack from the current cell and remove it from the current path
        visited[i][j] = false;
 
        return count;
    }
 
    public static int findCount(int[][] maze, int i, int j, int x, int y)
    {
        // base case: invalid input
        if (maze == null || maze.length == 0 || maze[i][j] == 0 || maze[x][y] == 0) {
            return 0;
        }
 
        // `N × N` matrix
        int N = maze.length;
 
        // 2D matrix to keep track of cells involved in the current path
        boolean[][] visited = new boolean[N][N];
 
        // start from source cell (i, j)
        return countPaths(maze, i, j, x, y, visited);
    }
 
    public static void main(String[] args)
    {
        int[][] maze =
        {
            { 1, 1, 1, 1 },
            { 1, 1, 0, 1 },
            { 0, 1, 0, 1 },
            { 1, 1, 1, 1 }
        };
 
        // source cell (0, 0), destination cell (3, 3)
        int count = findCount(maze, 0, 0, 3, 3);
 
        System.out.println("The total number of unique paths are " + count);
    }
}

// subset sum
class Solution {
List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsetSum(int[] arr, int sum) {
        backtrack(arr, 0, sum, new ArrayList<>());
        return ans;
    }

    void backtrack(int[] arr, int idx, int target, List<Integer> temp) {
        if (target == 0) {            // valid subset found
            ans.add(new ArrayList<>(temp));
            return;
        }
        if (idx == arr.length) return;

        // Take current element
        if (arr[idx] <= target) {
            temp.add(arr[idx]);
            backtrack(arr, idx + 1, target - arr[idx], temp);
            temp.remove(temp.size() - 1); // backtrack
        }

        // Not take current element
        backtrack(arr, idx + 1, target, temp);
    }
}

coin change //

class Solution {
public int countWays(int[] coins, int N) {
Integer[][] dp = new Integer[coins.length][N + 1];
return solve(coins, 0, N, dp);
}

    int solve(int[] coins, int i, int sum, Integer[][] dp) {
        if (sum == 0) return 1;
        if (i == coins.length) return 0;

        if (dp[i][sum] != null) return dp[i][sum];

        int take = 0;
        if (coins[i] <= sum)
            take = solve(coins, i, sum - coins[i], dp);  // stay at same i

        int notTake = solve(coins, i + 1, sum, dp);

        return dp[i][sum] = take + notTake;
    }
}

cutting rod 

public class Solution {
public int cutRod(int[] price, int n) {
return helper(price, n);
}

    private int helper(int[] price, int n) {
            if (n == 0) return 0;

            int max = Integer.MIN_VALUE;

            // try every cut of length i
            for (int i = 1; i <= n; i++) {
                int val = price[i - 1] + helper(price, n - i);
                max = Math.max(max, val);
            }
            return max;
    }
}
class Solution {

    // Main function to solve the board
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {

                if (board[r][c] == '.') {   // empty cell
                    
                    for (char num = '1'; num <= '9'; num++) {

                        if (isSafe(board, r, c, num)) {
                            board[r][c] = num;

                            if (solve(board)) return true; // recurse

                            board[r][c] = '.'; // backtrack
                        }
                    }

                    return false; // no valid number found
                }
            }
        }
        return true; // solved
    }

    private boolean isSafe(char[][] board, int row, int col, char num) {

        // check row and column
        for (int x = 0; x < 9; x++) {
            if (board[row][x] == num) return false;
            if (board[x][col] == num) return false;
        }

        // check 3×3 sub-box
        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;

        for (int r = sr; r < sr + 3; r++) {
            for (int c = sc; c < sc + 3; c++) {
                if (board[r][c] == num) return false;
            }
        }

        return true;
    }
}
class Solution {
public boolean wordBreak(String s, List<String> wordDict) {

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {

                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
class Solution {
public boolean wordBreak(String s, List<String> wordDict) {
boolean[] dp = new boolean[s.length() + 1];
dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
class Solution {
public int optimalBST(int keys[], int freq[], int n) {

        int[][] dp = new int[n][n];
        int[] prefix = new int[n];

        prefix[0] = freq[0];
        for(int i=1;i<n;i++)
            prefix[i] = prefix[i-1] + freq[i];

        for(int i=0;i<n;i++)
            dp[i][i] = freq[i];

        for(int len=2; len<=n; len++) {
            for(int i=0; i<=n-len; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;

                int sum = prefix[j] - (i>0 ? prefix[i-1] : 0);

                for(int r=i; r<=j; r++) {
                    int left = (r > i) ? dp[i][r-1] : 0;
                    int right = (r < j) ? dp[r+1][j] : 0;

                    dp[i][j] = Math.min(dp[i][j], left + right + sum);
                }
            }
        }

        return dp[0][n-1];
    }
}
import java.util.*;

public class HamiltonianPaths {

    private int V; // Number of vertices
    private List<Integer>[] adj; // Adjacency list

    public HamiltonianPaths(int V) {
        this.V = V;
        adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    // Add undirected edge
    public void addEdge(int u, int v) {
        adj[u].add(v);
        adj[v].add(u);
    }

    // Utility function to print all Hamiltonian paths
    private void hamiltonianUtil(int u, boolean[] visited, List<Integer> path) {
        visited[u] = true;
        path.add(u);

        if (path.size() == V) {
            System.out.println(path);
        } else {
            for (int v : adj[u]) {
                if (!visited[v]) {
                    hamiltonianUtil(v, visited, path);
                }
            }
        }

        // Backtracking
        visited[u] = false;
        path.remove(path.size() - 1);
    }

    // Function to print all Hamiltonian paths in the graph
    public void printHamiltonianPaths() {
        for (int i = 0; i < V; i++) {
            boolean[] visited = new boolean[V];
            List<Integer> path = new ArrayList<>();
            hamiltonianUtil(i, visited, path);
        }
    }

    public static void main(String[] args) {
        HamiltonianPaths g = new HamiltonianPaths(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);

        System.out.println("All Hamiltonian paths in the graph:");
        g.printHamiltonianPaths();
    }
}
{
private static void swap(char[] digits, int i, int j)
{
char digit = digits[i];
digits[i] = digits[j];
digits[j] = digit;
}

    // Find the minimum number formed by doing at-most `k` swap operations upon
    // digits of the string
    public static String findMin(char[] digits, int k, String min_so_far)
    {
        // compare the current number with a minimum number so far
        String curr = new String(digits);
        if (curr.compareTo(min_so_far) < 0) {
            min_so_far = curr;
        }
 
        // base case: no swaps left
        if (k < 1) {
            return min_so_far;
        }
 
        // do for each digit in the input string
        for (int i = 0; i < digits.length - 1; i++)
        {
            // compare the current digit with the remaining digits
            for (int j = i + 1; j < digits.length; j++)
            {
                // if the digit at i'th index is more than the digit
                // at j'th index
                if (digits[i] > digits[j])
                {
                    // swap `digits[i]` with `digits[j]`
                    swap(digits, i, j);
 
                    // recur for remaining `k-1` swap
                    min_so_far = findMin(digits, k - 1, min_so_far);
 
                    // backtrack: restore the array
                    swap(digits, i, j);
                }
            }
        }
        return min_so_far;
    }
 
    // Wrapper over findMin() function
    public static String findMinimum(String s, int k)
    {
        // base case
        if (s == null || s.length() == 0) {
            return s;
        }
 
        // convert digits of a given integer to a char array to
        // facilitate operations on them
        char[] digits = s.toCharArray();
        return findMin(digits, k, s);
    }
 
    public static void main(String[] args)
    {
        // input number
        String s = "934651";
        int k = 2;
 
        String min = findMinimum(s, k);
 
        System.out.println("The minimum number formed by doing at-most "
                + k + " swaps is " + min);
    }
}

// DFS based approach
class Graph {
int V;
LinkedList<Integer>[] adj;

    Graph(int v) { V = v; adj = new LinkedList[v]; for(int i=0;i<v;i++) adj[i]=new LinkedList<>();}
    
    void addEdge(int u,int v){ adj[u].add(v); adj[v].add(u);}
    
    void DFSUtil(int v, boolean[] visited){
        visited[v]=true;
        for(int n: adj[v]) if(!visited[n]) DFSUtil(n, visited);
    }
    
    int connectedComponents(){
        boolean[] visited = new boolean[V];
        int count=0;
        for(int i=0;i<V;i++)
            if(!visited[i]) { DFSUtil(i, visited); count++; }
        return count;
    }
}

// Directed Graph using DFS
class CycleDetect {
boolean dfs(int v, boolean[] visited, boolean[] recStack, LinkedList<Integer>[] adj){
visited[v]=true;
recStack[v]=true;
for(int n: adj[v])
if(!visited[n] && dfs(n, visited, recStack, adj)) return true;
else if(recStack[n]) return true;
recStack[v]=false;
return false;
}

    boolean isCyclic(int V, LinkedList<Integer>[] adj){
        boolean[] visited=new boolean[V], recStack=new boolean[V];
        for(int i=0;i<V;i++) if(!visited[i] && dfs(i, visited, recStack, adj)) return true;
        return false;
    }
}
class Solution {
public int numIslands(char[][] grid) {
int count=0;
int m=grid.length, n=grid[0].length;
boolean[][] visited=new boolean[m][n];
for(int i=0;i<m;i++)
for(int j=0;j<n;j++)
if(grid[i][j]=='1' && !visited[i][j]){
dfs(grid, i, j, visited); count++;
}
return count;
}

    void dfs(char[][] g, int i,int j, boolean[][] v){
        if(i<0||j<0||i>=g.length||j>=g[0].length||g[i][j]=='0'||v[i][j]) return;
        v[i][j]=true;
        dfs(g,i+1,j,v); dfs(g,i-1,j,v); dfs(g,i,j+1,v); dfs(g,i,j-1,v);
    }
}
// Prim's Algorithm
class PrimMST {
int V;
int[][] graph;
PrimMST(int[][] g){ V=g.length; graph=g;}
void primMST(){
boolean[] mstSet=new boolean[V];
int[] key=new int[V]; Arrays.fill(key,Integer.MAX_VALUE); key[0]=0;
int[] parent=new int[V]; parent[0]=-1;
for(int count=0;count<V-1;count++){
int u=-1, min=Integer.MAX_VALUE;
for(int v=0;v<V;v++) if(!mstSet[v] && key[v]<min){ min=key[v]; u=v;}
mstSet[u]=true;
for(int v=0;v<V;v++) if(graph[u][v]!=0 && !mstSet[v] && graph[u][v]<key[v]){ key[v]=graph[u][v]; parent[v]=u;}
}
}
}
// Kruskal's Algorithm
class Kruskal {
class Edge implements Comparable<Edge>{ int u,v,w; public int compareTo(Edge e){ return w-e.w;}}
int[] parent; int[] rank;
int find(int u){ if(parent[u]!=u) parent[u]=find(parent[u]); return parent[u];}
void union(int u,int v){ int pu=find(u), pv=find(v); if(rank[pu]<rank[pv]) parent[pu]=pv; else if(rank[pu]>rank[pv]) parent[pv]=pu; else{ parent[pv]=pu; rank[pu]++;}}
}


class Dijkstra {
int V; int[][] graph;
Dijkstra(int[][] g){ V=g.length; graph=g;}
void shortestPath(int src){
int[] dist=new int[V]; Arrays.fill(dist,Integer.MAX_VALUE); dist[src]=0;
boolean[] sptSet=new boolean[V];
for(int count=0;count<V-1;count++){
int u=-1,min=Integer.MAX_VALUE;
for(int i=0;i<V;i++) if(!sptSet[i] && dist[i]<min){ min=dist[i]; u=i;}
sptSet[u]=true;
for(int v=0;v<V;v++) if(!sptSet[v] && graph[u][v]!=0 && dist[u]+graph[u][v]<dist[v]) dist[v]=dist[u]+graph[u][v];
}
}
}



class BellmanFord {
int V,E; class Edge{ int u,v,w;}
void shortestPath(Edge[] edges,int V,int src){
int[] dist=new int[V]; Arrays.fill(dist,Integer.MAX_VALUE); dist[src]=0;
for(int i=1;i<V;i++) for(Edge e: edges) if(dist[e.u]!=Integer.MAX_VALUE && dist[e.u]+e.w<dist[e.v]) dist[e.v]=dist[e.u]+e.w;
}
}

class TrieNode{
TrieNode[] children=new TrieNode[26]; boolean isEnd=false;
}
class Trie {
TrieNode root=new TrieNode();
void insert(String s){
TrieNode node=root;
for(char c: s.toCharArray()){
int i=c-'a';
if(node.children[i]==null) node.children[i]=new TrieNode();
node=node.children[i];
}
node.isEnd=true;
}
boolean search(String s){
TrieNode node=root;
for(char c: s.toCharArray()){
if(node.children[c-'a']==null) return false;
node=node.children[c-'a'];
}
return node.isEnd;
}
}

class PathExist {
boolean hasPath(int[][] graph, int src, int dest, boolean[] visited) {
if(src == dest) return true;
visited[src] = true;
for(int i = 0; i < graph[src].length; i++) {
if(graph[src][i] == 1 && !visited[i] && hasPath(graph, i, dest, visited))
return true;
}
return false;
}
}
class AllPaths {
void printAllPaths(int[][] graph, int src, int dest) {
List<Integer> path = new ArrayList<>();
boolean[] visited = new boolean[graph.length];
dfs(graph, src, dest, visited, path);
}

    void dfs(int[][] g, int node, int dest, boolean[] visited, List<Integer> path) {
        visited[node] = true;
        path.add(node);
        if(node == dest) {
            System.out.println(path);
        } else {
            for(int i = 0; i < g[node].length; i++) {
                if(g[node][i] == 1 && !visited[i]) dfs(g, i, dest, visited, path);
            }
        }
        path.remove(path.size()-1);
        visited[node] = false;
    }
}
class NumberOfIslands {
int numIslands(char[][] grid) {
int count = 0, m = grid.length, n = grid[0].length;
for(int i=0;i<m;i++){
for(int j=0;j<n;j++){
if(grid[i][j]=='1'){
dfs(grid, i, j);
count++;
}
}
}
return count;
}

    void dfs(char[][] grid, int i, int j){
        if(i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]=='0') return;
        grid[i][j] = '0';
        dfs(grid, i+1,j); dfs(grid,i-1,j); dfs(grid,i,j+1); dfs(grid,i,j-1);
    }
}

class NumberOfProvinces {
int findCircleNum(int[][] isConnected) {
int n = isConnected.length;
boolean[] visited = new boolean[n];
int count = 0;
for(int i=0;i<n;i++){
if(!visited[i]){
dfs(isConnected, visited, i);
count++;
}
}
return count;
}

    void dfs(int[][] g, boolean[] visited, int i){
        visited[i] = true;
        for(int j=0;j<g.length;j++){
            if(g[i][j]==1 && !visited[j]) dfs(g, visited, j);
        }
    }
}
class FloodFill {
int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
int oldColor = image[sr][sc];
if(oldColor != newColor) dfs(image, sr, sc, oldColor, newColor);
return image;
}

    void dfs(int[][] img, int r, int c, int oldColor, int newColor){
        if(r<0||c<0||r>=img.length||c>=img[0].length||img[r][c]!=oldColor) return;
        img[r][c] = newColor;
        dfs(img,r+1,c,oldColor,newColor);
        dfs(img,r-1,c,oldColor,newColor);
        dfs(img,r,c+1,oldColor,newColor);
        dfs(img,r,c-1,oldColor,newColor);
    }
}
class ClosedIslands {
public int closedIsland(int[][] grid) {
int m = grid.length, n = grid[0].length;
for(int i=0;i<m;i++){
dfs(grid,i,0); dfs(grid,i,n-1);
}
for(int j=0;j<n;j++){
dfs(grid,0,j); dfs(grid,m-1,j);
}
int count = 0;
for(int i=1;i<m-1;i++){
for(int j=1;j<n-1;j++){
if(grid[i][j]==0){
dfs(grid,i,j);
count++;
}
}
}
return count;
}

    void dfs(int[][] g, int i, int j){
        if(i<0||j<0||i>=g.length||j>=g[0].length||g[i][j]==1) return;
        g[i][j]=1;
        dfs(g,i+1,j); dfs(g,i-1,j); dfs(g,i,j+1); dfs(g,i,j-1);
    }
}
class TrieNode {
TrieNode[] children = new TrieNode[26];
boolean isEnd = false;
}

class TrieDelete {
TrieNode root = new TrieNode();

    void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null) node.children[idx] = new TrieNode();
            node = node.children[idx];
        }
        node.isEnd = true;
    }

    boolean delete(String word) {
        return delete(root, word, 0);
    }

    private boolean delete(TrieNode node, String word, int depth) {
        if (node == null) return false;

        if (depth == word.length()) {
            if (!node.isEnd) return false;
            node.isEnd = false;
            return isEmpty(node);
        }

        int idx = word.charAt(depth) - 'a';
        if (delete(node.children[idx], word, depth + 1)) {
            node.children[idx] = null;
            return !node.isEnd && isEmpty(node);
        }
        return false;
    }

    private boolean isEmpty(TrieNode node) {
        for (TrieNode child : node.children)
            if (child != null) return false;
        return true;
    }
}
class TrieCount {
TrieNode root = new TrieNode();

    void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null) node.children[idx] = new TrieNode();
            node = node.children[idx];
        }
        node.isEnd = true;
    }

    int countWords() {
        return countWords(root);
    }

    private int countWords(TrieNode node) {
        if (node == null) return 0;
        int count = node.isEnd ? 1 : 0;
        for (TrieNode child : node.children) count += countWords(child);
        return count;
    }
}
class WordBreakTrie {
TrieNode root = new TrieNode();

    void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null) node.children[idx] = new TrieNode();
            node = node.children[idx];
        }
        node.isEnd = true;
    }

    boolean wordBreak(String s) {
        Boolean[] dp = new Boolean[s.length()];
        return dfs(s, 0, dp);
    }

    private boolean dfs(String s, int start, Boolean[] dp) {
        if (start == s.length()) return true;
        if (dp[start] != null) return dp[start];

        TrieNode node = root;
        for (int i = start; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if (node.children[idx] == null) break;
            node = node.children[idx];
            if (node.isEnd && dfs(s, i + 1, dp)) return dp[start] = true;
        }
        return dp[start] = false;
    }
}
class HouseRobber {
// Tabulation
public int rob(int[] nums) {
if(nums.length==0) return 0;
if(nums.length==1) return nums[0];
int n=nums.length;
int[] dp = new int[n];
dp[0] = nums[0];
dp[1] = Math.max(nums[0], nums[1]);
for(int i=2;i<n;i++){
dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
}
return dp[n-1];
}
}
class HouseRobber2 {
public int rob(int[] nums) {
if(nums.length==1) return nums[0];
return Math.max(robLinear(nums,0,nums.length-2), robLinear(nums,1,nums.length-1));
}

    private int robLinear(int[] nums, int start, int end){
        int prev=0, curr=0;
        for(int i=start;i<=end;i++){
            int temp = Math.max(curr, prev+nums[i]);
            prev = curr;
            curr = temp;
        }
        return curr;
    }
}
class Goldmine {
public int getMaxGold(int[][] grid) {
int m = grid.length, n = grid[0].length;
int[][] dp = new int[m][n];
for(int col=n-1;col>=0;col--){
for(int row=0;row<m;row++){
int right = col==n-1 ? 0 : dp[row][col+1];
int rightUp = (row==0 || col==n-1) ? 0 : dp[row-1][col+1];
int rightDown = (row==m-1 || col==n-1) ? 0 : dp[row+1][col+1];
dp[row][col] = grid[row][col] + Math.max(right, Math.max(rightUp,rightDown));
}
}
int maxGold = 0;
for(int i=0;i<m;i++) maxGold = Math.max(maxGold, dp[i][0]);
return maxGold;
}
}
class MaxGoldPath {
public int getMaximumGold(int[][] grid) {
int max = 0;
int m = grid.length, n = grid[0].length;
for(int i=0;i<m;i++){
for(int j=0;j<n;j++){
if(grid[i][j] != 0)
max = Math.max(max, dfs(grid, i, j));
}
}
return max;
}

    private int dfs(int[][] g, int r, int c){
        if(r<0 || c<0 || r>=g.length || c>=g[0].length || g[r][c]==0) return 0;
        int val = g[r][c];
        g[r][c] = 0; // mark visited
        int max = val + Math.max(Math.max(dfs(g,r+1,c),dfs(g,r-1,c)), Math.max(dfs(g,r,c+1), dfs(g,r,c-1)));
        g[r][c] = val; // backtrack
        return max;
    }
}
class SegmentTreeSum {
int[] tree;
int n;

    SegmentTreeSum(int[] arr) {
        n = arr.length;
        tree = new int[4 * n];
        build(arr, 0, n - 1, 0);
    }

    void build(int[] arr, int start, int end, int idx) {
        if (start == end) {
            tree[idx] = arr[start];
            return;
        }
        int mid = (start + end) / 2;
        build(arr, start, mid, 2 * idx + 1);
        build(arr, mid + 1, end, 2 * idx + 2);
        tree[idx] = tree[2 * idx + 1] + tree[2 * idx + 2];
    }

    int query(int qs, int qe) {
        return queryUtil(0, n - 1, qs, qe, 0);
    }

    int queryUtil(int ss, int se, int qs, int qe, int idx) {
        if (qs > se || qe < ss) return 0;  // No overlap
        if (qs <= ss && qe >= se) return tree[idx]; // Total overlap
        int mid = (ss + se) / 2;
        return queryUtil(ss, mid, qs, qe, 2 * idx + 1) + queryUtil(mid + 1, se, qs, qe, 2 * idx + 2);
    }

    void update(int pos, int val) {
        updateUtil(0, n - 1, pos, val, 0);
    }

    void updateUtil(int ss, int se, int pos, int val, int idx) {
        if (ss == se) {
            tree[idx] = val;
            return;
        }
        int mid = (ss + se) / 2;
        if (pos <= mid) updateUtil(ss, mid, pos, val, 2 * idx + 1);
        else updateUtil(mid + 1, se, pos, val, 2 * idx + 2);
        tree[idx] = tree[2 * idx + 1] + tree[2 * idx + 2];
    }
}
class Solution {
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
ListNode dummy = new ListNode(0);
ListNode curr = dummy;
int carry = 0;

        while(l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if(l1 != null) { sum += l1.val; l1 = l1.next; }
            if(l2 != null) { sum += l2.val; l2 = l2.next; }

            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
        }
        return dummy.next;
    }
}
class Solution {
public ListNode rotateRight(ListNode head, int k) {
if(head == null || head.next == null) return head;

        ListNode temp = head;
        int len = 1;

        while(temp.next != null) {
            temp = temp.next;
            len++;
        }

        temp.next = head; // make circular

        k = k % len;
        int steps = len - k;

        while(steps-- > 0) temp = temp.next;

        ListNode newHead = temp.next;
        temp.next = null;

        return newHead;
    }
}
class Solution {
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
ListNode dummy = new ListNode(0);
ListNode curr = dummy;
int carry = 0;

        while(l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if(l1 != null) { sum += l1.val; l1 = l1.next; }
            if(l2 != null) { sum += l2.val; l2 = l2.next; }

            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
        }
        return dummy.next;
    }
}

