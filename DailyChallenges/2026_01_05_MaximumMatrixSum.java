package DailyChallenges;

/**
 * Problem: Maximum Matrix Sum
 * Date: 05-01-2026
 * Difficulty: Medium
 * Pattern: Greedy / Math
 *
 * Problem Link:
 * https://leetcode.com/problems/maximum-matrix-sum/
 *
 * Time Complexity:
 * O(n²) where n = matrix size
 *
 * Space Complexity:
 * O(1)
 */

public class _2026_01_05_MaximumMatrixSum {

    /**
     * Solution:
     * - Flipping two adjacent cells changes the sign of both, so only the parity
     *   of negative numbers matters.
     * - Maximize sum by taking absolute values of all elements.
     * - If the count of negative numbers is odd, one element must remain negative.
     *   Choose the smallest absolute value to minimize loss.
     */
    public static long maxMatrixSum(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        int negativeCount = 0;
        long sum = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int val = matrix[i][j];
                if (val < 0) negativeCount++;

                int abs = Math.abs(val);
                min = Math.min(min, abs);
                sum += abs;
            }
        }

        if (negativeCount % 2 != 0) {
            sum -= 2L * min;
        }

        return sum;
    }

    // Test examples
    public static void main(String[] args) {
        int[][] ex1 = {{1, -1}, {-1, 1}};
        int[][] ex2 = {{1, 2, 3}, {-1, -2, -3}, {1, 2, 3}};

        System.out.println("Example 1 Output: " + maxMatrixSum(ex1)); // 4
        System.out.println("Example 2 Output: " + maxMatrixSum(ex2)); // 16
    }
}
