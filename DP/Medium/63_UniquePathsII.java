package DP.Medium;

/**
 * Problem: 63. Unique Paths II (Medium)
 * LeetCode: https://leetcode.com/problems/unique-paths-ii/
 * Pattern: Dynamic Programming (2D Grid DP with Obstacles)
 *
 * Idea:
 * A robot starts at the top-left corner and wants to reach the bottom-right corner.
 * It can only move:
 * 1) Down
 * 2) Right
 *
 * Obstacles are marked as 1 in the grid. The robot cannot step on obstacles.
 *
 * Each cell (i, j) can be reached from:
 * - the cell above it (i - 1, j)
 * - the cell to the left of it (i, j - 1)
 *
 * DP State:
 * dp[i][j] = number of unique paths to reach cell (i, j)
 *
 * Transition:
 * dp[i][j] = dp[i - 1][j] + dp[i][j - 1]   (if no obstacle at i,j)
 *
 * Base Case:
 * dp[1][1] = 1  if starting cell is free
 *
 * We use a (m + 1) x (n + 1) table to avoid boundary checks.
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 */

public class _63_UniquePathsII {

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] table = new int[m + 1][n + 1];

        // Base case: starting point (0,0)
        table[1][1] = (obstacleGrid[0][0] == 0) ? 1 : 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1) continue; // already initialized

                // If current cell is an obstacle, no paths lead here
                if (obstacleGrid[i - 1][j - 1] == 1) {
                    table[i][j] = 0;
                } else {
                    table[i][j] = table[i - 1][j] + table[i][j - 1];
                }
            }
        }

        return table[m][n];
    }

    // Test the solution
    public static void main(String[] args) {
        int[][] grid1 = {
            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 0}
        };
        System.out.println(uniquePathsWithObstacles(grid1)); // 2

        int[][] grid2 = {
            {0, 1},
            {0, 0}
        };
        System.out.println(uniquePathsWithObstacles(grid2)); // 1

        int[][] grid3 = {
            {1}
        };
        System.out.println(uniquePathsWithObstacles(grid3)); // 0
    }
}
