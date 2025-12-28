package DailyChallenges;

import java.util.*;

/**
 * Problem: Count Negative Numbers in a Sorted Matrix
 * Date: 28-12-2025
 * Difficulty: Easy
 * Pattern: Matrix Traversal / Two Pointers
 *
 * Problem Link:
 * https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/
 *
 * Constraints:
 * 1 <= m, n <= 100
 * -100 <= grid[i][j] <= 100
 *
 * Follow-up:
 * Can you find an O(m + n) solution?
 *
 * Time Complexity:
 * - Brute Force: O(m * n)
 * - Optimized: O(m + n)
 *
 * Space Complexity:
 * O(1)
 */

public class _2025_12_28_CountNegativeNumbers {

    /**
     * Time Complexity: O(m * n)
     */
    public static int countNegativesBrute(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] < 0) count++;
            }
        }
        return count;
    }

    /**
     * Optimized solution (Follow-up)
     * Time Complexity: O(m + n)
     *
     * Start from bottom-left corner:
     * - If current value is negative → all elements to the right are negative
     * - If current value is non-negative → move right
     */
    public static int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int row = m - 1;
        int col = 0;
        int count = 0;

        while (row >= 0 && col < n) {
            if (grid[row][col] < 0) {
                count += (n - col);
                row--;
            } else {
                col++;
            }
        }

        return count;
    }

    // Test examples
    public static void main(String[] args) {
        int[][] grid1 = {
                {4, 3, 2, -1},
                {3, 2, 1, -1},
                {1, 1, -1, -2},
                {-1, -1, -2, -3}
        };

        int[][] grid2 = {
                {3, 2},
                {1, 0}
        };

        System.out.println(countNegativesBrute(grid1)); // 8
        System.out.println(countNegatives(grid1));      // 8

        System.out.println(countNegativesBrute(grid2)); // 0
        System.out.println(countNegatives(grid2));      // 0
    }
}
