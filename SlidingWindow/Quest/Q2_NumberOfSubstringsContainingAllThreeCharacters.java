package SlidingWindow.Quest;

/**
 * Problem: Number of Substrings Containing All Three Characters (Medium)
 * LeetCode: https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/
 *
 * Source:
 * - data-structures-and-algorithms-quest
 * - Sliding Window
 *
 * Pattern:
 * - Sliding Window + Frequency Counting
 *
 * Idea:
 * 1. Use two pointers (left, right) to maintain a sliding window.
 * 2. Maintain a frequency array of size 3:
 *      counts[0] -> 'a'
 *      counts[1] -> 'b'
 *      counts[2] -> 'c'
 * 3. Expand the window by moving right and updating counts.
 * 4. When the window contains at least one 'a', 'b', and 'c':
 *      - All substrings starting at left and ending from right to n-1 are valid.
 *      - Add (n - right) to the result.
 *      - Shrink the window from the left.
 * 5. Continue until the end of the string.
 *
 * Time Complexity: O(n)
 *   - Each character is processed at most twice.
 *
 * Space Complexity: O(1)
 *   - Fixed-size frequency array (size 3).
 */
public class Q2_NumberOfSubstringsContainingAllThreeCharacters {

    public static int numberOfSubstrings(String s) {
        int n = s.length();

        int[] counts = new int[3]; // a, b, c
        int left = 0;
        int result = 0;

        for (int right = 0; right < n; right++) {

            // Expand window
            counts[s.charAt(right) - 'a']++;

            // While window contains at least one a, b, and c
            while (counts[0] > 0 && counts[1] > 0 && counts[2] > 0) {

                // Count all valid substrings starting at left
                result += (n - right);

                // Shrink window
                counts[s.charAt(left) - 'a']--;
                left++;
            }
        }

        return result;
    }

    // Test the solution
    public static void main(String[] args) {

        String s1 = "abcabc";
        System.out.println(numberOfSubstrings(s1)); // 10

        String s2 = "aaacb";
        System.out.println(numberOfSubstrings(s2)); // 3

        String s3 = "abc";
        System.out.println(numberOfSubstrings(s3)); // 1
    }
}
