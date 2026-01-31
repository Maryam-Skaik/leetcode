package DailyChallenges;

/**
 * Problem: Find Smallest Letter Greater Than Target
 * Date: 31-01-2026
 * Difficulty: Easy
 * Pattern: Linear Scan / Sorted Array
 *
 * Problem Link:
 * https://leetcode.com/problems/find-smallest-letter-greater-than-target/
 *
 * Time Complexity:
 * O(n), where n = letters.length, since we scan the array once.
 *
 * Space Complexity:
 * O(1), constant extra space.
 */

public class _2026_01_31_FindSmallestLetterGreaterThanTarget {

    /**
     * Solution:
     * - The array is already sorted in non-decreasing order.
     * - Traverse the array and return the first character greater than target.
     * - If no such character exists, return the first character (wrap-around case).
     */
    public char nextGreatestLetter(char[] letters, char target) {
        for (char c : letters) {
            if (c > target) {
                return c;
            }
        }
        return letters[0];
    }

    // Test examples
    public static void main(String[] args) {
        _2026_01_31_FindSmallestLetterGreaterThanTarget solution =
                new _2026_01_31_FindSmallestLetterGreaterThanTarget();

        char[] ex1 = {'c', 'f', 'j'};
        System.out.println(solution.nextGreatestLetter(ex1, 'a'));
        // c

        char[] ex2 = {'c', 'f', 'j'};
        System.out.println(solution.nextGreatestLetter(ex2, 'c'));
        // f

        char[] ex3 = {'x', 'x', 'y', 'y'};
        System.out.println(solution.nextGreatestLetter(ex3, 'z'));
        // x
    }
}
