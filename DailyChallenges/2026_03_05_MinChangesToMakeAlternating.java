package DailyChallenges;

/**
 * Problem: Minimum Changes to Make Alternating Binary String
 * Date: 05-03-2026
 * Difficulty: Easy
 * Pattern: String Manipulation / Greedy
 *
 * Problem Link:
 * https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string/
 *
 * Description:
 * You are given a string s consisting only of the characters '0' and '1'. In one operation, you can change any '0' to '1' or vice versa.
 * The string is called alternating if no two adjacent characters are equal. For example, the string "010" is alternating, while the string "0100" is not.
 * Return the minimum number of operations needed to make s alternating.
 *
 * Constraints:
 * - 1 <= s.length <= 10^4
 * - s[i] is either '0' or '1'
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class _2026_03_05_MinChangesToMakeAlternating {

    /**
     * Solution:
     * 1. Generate two alternating patterns based on the length of the string:
     *    - Pattern 1: Starts with '0' (e.g., "010101...")
     *    - Pattern 2: Starts with '1' (e.g., "101010...")
     * 2. Count the mismatches for both patterns and return the minimum of the two counts.
     */
    public int minOperations(String s) {
        int len = s.length();

        // Create the two alternating patterns
        StringBuilder startwith0 = new StringBuilder();
        StringBuilder startwith1 = new StringBuilder();

        for (int i = 0; i < len; i++) {
            startwith0.append(i % 2);  // Alternates starting with '0'
            startwith1.append((i + 1) % 2);  // Alternates starting with '1'
        }

        int counter0 = 0, counter1 = 0;

        // Count mismatches for both patterns
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) != startwith0.charAt(i)) counter0++;
            if (s.charAt(i) != startwith1.charAt(i)) counter1++;
        }

        // Return the minimum of the two counters
        return Math.min(counter0, counter1);
    }

    /**
     * Example main to test the solution
     */
    public static void main(String[] args) {
        _2026_03_05_MinChangesToMakeAlternating solution = new _2026_03_05_MinChangesToMakeAlternating();

        // Test case 1: Expected output: 1 (change the last '0' to '1')
        String s1 = "0100";
        System.out.println("Output 1: " + solution.minOperations(s1));

        // Test case 2: Expected output: 0 (already alternating)
        String s2 = "10";
        System.out.println("Output 2: " + solution.minOperations(s2));

        // Test case 3: Expected output: 2 (change two '1's to '0's)
        String s3 = "1111";
        System.out.println("Output 3: " + solution.minOperations(s3));
    }
}
