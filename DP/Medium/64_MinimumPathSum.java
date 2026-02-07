package DP.Medium;

/**
 * Problem: 64. Minimum Path Sum (Medium)
 * LeetCode: https://leetcode.com/problems/minimum-path-sum/
 * Pattern: Dynamic Programming (2D Grid DP)
 *
 * Idea:
 * You start at the top-left cell and want to reach the bottom-right cell.
 * At each cell, you can only move:
 * 1) Right
 * 2) Down
 *
 * The cost of a path is the sum of all grid values along that path.
 * We want the minimum possible sum.
 *
 * DP State:
 * dp[i][j] = minimum path sum to reach cell (i, j)
 *
 * Transition:
 * dp[i][j] = grid[i - 1][j - 1] + min(dp[i - 1][j], dp[i][j - 1])
 *
 * Base Cases:
 * dp[1][0] = 0
 * dp[0][1] = 0
 * (Used to simplify boundary handling)
 *
 * Answer:
 * dp[m][n]
 *
 * Time Complexity: O(m × n)
 * Space Complexity: O(m × n)
 */

public class _64_MinimumPathSum {

    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] table = new int[m + 1][n + 1];

        // Initialize with large values
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                table[i][j] = Integer.MAX_VALUE;
            }
        }

        // Base case before starting cell
        table[1][0] = 0;
        table[0][1] = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                table[i][j] = grid[i - 1][j - 1]
                        + Math.min(table[i - 1][j], table[i][j - 1]);
            }
        }

        return table[m][n];
    }

    // Test the solution
    public static void main(String[] args) {
        int[][] grid1 = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(minPathSum(grid1)); // 7

        int[][] grid2 = {
                {1, 2, 3},
                {4, 5, 6}
        };
        System.out.println(minPathSum(grid2)); // 12
    }
}
