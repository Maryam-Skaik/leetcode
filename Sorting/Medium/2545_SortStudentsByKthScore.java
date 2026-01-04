package Sorting.Medium;

/**
 * Problem: Sort the Students by Their Kth Score (Medium)
 * LeetCode: https://leetcode.com/problems/sort-the-students-by-their-kth-score/
 * Pattern: Sorting / Nested Loops
 * Time Complexity: O(m^2 * n) using nested-loop row sort
 * Space Complexity: O(1)
 */

public class _2545_SortStudentsByKthScore {

    /**
     * Sorts the students (rows) by their kth exam score in descending order.
     * Uses nested-loop (bubble sort style) to keep it simple and in-place.
     */
    public static int[][] sortTheStudents(int[][] score, int k) {
        for (int i = 0; i < score.length; i++) {
            for (int j = i + 1; j < score.length; j++) {
                if (score[j][k] > score[i][k]) {
                    // Swap entire rows
                    int[] temp = score[i];
                    score[i] = score[j];
                    score[j] = temp;
                }
            }
        }
        return score;
    }

    // Helper method to print 2D array
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    // Test the solution
    public static void main(String[] args) {
        int[][] score1 = {
            {10, 6, 9, 1},
            {7, 5, 11, 2},
            {4, 8, 3, 15}
        };
        int k1 = 2;

        int[][] score2 = {
            {3, 4},
            {5, 6}
        };
        int k2 = 0;

        System.out.println("Example 1 Output:");
        printMatrix(sortTheStudents(score1, k1)); // [[7,5,11,2],[10,6,9,1],[4,8,3,15]]

        System.out.println("\nExample 2 Output:");
        printMatrix(sortTheStudents(score2, k2)); // [[5,6],[3,4]]
    }
}
