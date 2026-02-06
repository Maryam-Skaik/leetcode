package DP.Medium;

/**
 * Problem: 62. Unique Paths (Medium)
 * LeetCode: https://leetcode.com/problems/unique-paths/
 * Pattern: Dynamic Programming (2D Grid DP)
 *
 * Idea:
 * A robot starts at the top-left corner and wants to reach the bottom-right corner.
 * It can only move:
 * 1) Down
 * 2) Right
 *
 * Each cell (i, j) can be reached from:
 * - the cell above it (i - 1, j)
 * - the cell to the left of it (i, j - 1)
 *
 * DP State:
 * dp[i][j] = number of unique paths to reach cell (i, j)
 *
 * Transition:
 * dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
 *
 * Base Case:
 * dp[1][1] = 1  (starting position)
 *
 * We use a (m + 1) x (n + 1) table to avoid boundary checks.
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 */

public class _62_UniquePaths {

    public static int uniquePaths(int m, int n) {
        int[][] table = new int[m + 1][n + 1];

        // Base case: starting point
        table[1][1] = 1;

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                int current = table[i][j];

                // Move down
                if (i + 1 <= m) table[i + 1][j] += current;

                // Move right
                if (j + 1 <= n) table[i][j + 1] += current;
            }
        }

        return table[m][n];
    }

    // Test the solution
    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7)); // 28
        System.out.println(uniquePaths(3, 2)); // 3
    }
}
