package DailyChallenges;

/**
 * Problem: Minimum Number of Flips to Make the Binary String Alternating
 * Date: 07-03-2026
 * Difficulty: Medium
 * Pattern: Sliding Window + String Rotation
 *
 * Problem Link:
 * https://leetcode.com/problems/minimum-number-of-flips-to-make-the-binary-string-alternating/
 *
 * Key Idea:
 * Because rotations are allowed, any rotation of the string is valid.
 *
 * Instead of generating all rotations explicitly (which would be expensive),
 * we duplicate the string:
 *
 * s + s
 *
 * Then we use a sliding window of size n to simulate every rotation.
 *
 * For each window we compare it against the two possible alternating patterns:
 *
 * Pattern A: 010101...
 * Pattern B: 101010...
 *
 * If mismatches with Pattern A = counter
 * then mismatches with Pattern B = n - counter
 *
 * We take the minimum flips among all windows.
 *
 * Time Complexity:
 * - O(n)
 *
 * Space Complexity:
 * - O(1)
 *
 */
public class _2026_03_07_MinimumFlipsBinaryAlternating {

    /**
     * Optimal Solution (Sliding Window)
     *
     * Idea:
     * 1. Duplicate the string to simulate rotations.
     * 2. Use a sliding window of size n.
     * 3. Count mismatches with pattern "010101..."
     * 4. The alternative pattern "101010..." will be (n - mismatches).
     * 5. Track the minimum flips across all windows.
     */
    public int minFlips(String s) {

        if (s.length() < 2) return 0;

        int n = s.length();

        // Duplicate the string to simulate rotations
        s += s;

        int answer = Integer.MAX_VALUE;
        int counter = 0;

        for (int i = 0; i < s.length(); i++) {

            // Compare with pattern: 010101...
            if (s.charAt(i) != ((i % 2) == 0 ? '0' : '1'))
                counter++;

            // Remove the character that leaves the window
            if (i >= n && s.charAt(i - n) != (((i - n) % 2) == 0 ? '0' : '1'))
                counter--;

            // When window size reaches n
            if (i >= n - 1)
                answer = Math.min(answer, Math.min(counter, n - counter));
        }

        return answer;
    }

    /**
     * Example main to test the solution
     */
    public static void main(String[] args) {

        _2026_03_07_MinimumFlipsBinaryAlternating solution =
                new _2026_03_07_MinimumFlipsBinaryAlternating();

        String s1 = "111000";
        String s2 = "010";
        String s3 = "1110";

        System.out.println("Minimum flips for s1: " + solution.minFlips(s1));
        System.out.println("Minimum flips for s2: " + solution.minFlips(s2));
        System.out.println("Minimum flips for s3: " + solution.minFlips(s3));
    }
}
