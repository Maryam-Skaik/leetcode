package DailyChallenges;

import java.util.*;

/**
 * Problem: Plus One
 * Date: 01-01-2026
 * Difficulty: Easy
 * Pattern: Array Traversal / Carry Handling
 *
 * Problem Link:
 * https://leetcode.com/problems/plus-one/
 *
 * Time Complexity:
 * O(n)
 *
 * Space Complexity:
 * O(n) in the worst case (when all digits are 9)
 */

public class _2026_01_01_PlusOne {

    /**
     * Optimized solution
     * Time Complexity: O(n)
     * Space Complexity: O(n) (only when a new array is needed)
     */
    public static int[] plusOne(int[] digits) {
        int n = digits.length;

        // Traverse from least significant digit
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        // If all digits were 9
        int[] newDigits = new int[n + 1];
        newDigits[0] = 1;
        return newDigits;
    }

    // Test examples
    public static void main(String[] args) {
        int[] ex1 = {1, 2, 3};
        int[] ex2 = {4, 3, 2, 1};
        int[] ex3 = {9};

        System.out.println(Arrays.toString(plusOne(ex1))); // [1, 2, 4]
        System.out.println(Arrays.toString(plusOne(ex2))); // [4, 3, 2, 2]
        System.out.println(Arrays.toString(plusOne(ex3))); // [1, 0]
    }
}
