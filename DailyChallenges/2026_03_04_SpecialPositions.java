package DailyChallenges;

/**
 * Problem: Special Positions in a Binary Matrix
 * Date: 04-03-2026
 * Difficulty: Easy
 * Pattern: Matrix Traversal / Counting
 *
 * Problem Link:
 * https://leetcode.com/problems/special-positions-in-a-binary-matrix/
 *
 * Description:
 * Given an m x n binary matrix mat, return the number of special positions.
 *
 * A position (i, j) is special if:
 * - mat[i][j] == 1
 * - All other elements in row i are 0
 * - All other elements in column j are 0
 *
 * Constraints:
 * - 1 <= m, n <= 100
 * - mat[i][j] is either 0 or 1
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(m + n)
 */
public class _2026_03_04_SpecialPositions {

    /**
     * Solution:
     * 1. Count number of 1s in each row.
     * 2. Count number of 1s in each column.
     * 3. A cell is special if:
     *      - mat[i][j] == 1
     *      - rowCount[i] == 1
     *      - colCount[j] == 1
     */
    public int numSpecial(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;

        int[] rowCount = new int[m];
        int[] colCount = new int[n];

        // First pass: count 1s in rows and columns
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }

        int count = 0;

        // Second pass: check special positions
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1 && rowCount[i] == 1 && colCount[j] == 1) {
                    count++;
                }
            }
        }

        return count;
    }

    /**
     * Example main to test the solution
     */
    public static void main(String[] args) {
        _2026_03_04_SpecialPositions solution = new _2026_03_04_SpecialPositions();

        int[][] mat1 = {
                {1, 0, 0},
                {0, 0, 1},
                {1, 0, 0}
        };

        int[][] mat2 = {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };

        System.out.println("Output 1: " + solution.numSpecial(mat1)); // Expected: 1
        System.out.println("Output 2: " + solution.numSpecial(mat2)); // Expected: 3
    }
}
