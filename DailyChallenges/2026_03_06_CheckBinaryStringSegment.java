package DailyChallenges;

import java.util.Arrays;
import java.util.Collections;

/**
 * Problem: Check if Binary String Has at Most One Segment of Ones
 * Date: 06-03-2026
 * Difficulty: Easy
 * Pattern: String Manipulation
 *
 * Problem Link:
 * https://leetcode.com/problems/check-if-binary-string-has-at-most-one-segment-of-ones/
 *
 * Description:
 * Given a binary string s without leading zeros, determine if the string
 * contains at most one contiguous segment of '1's.
 *
 * A valid case:
 * "111000" → only one segment of ones.
 *
 * An invalid case:
 * "1001" → two separate segments of ones.
 *
 * Return true if there is at most one segment of ones, otherwise return false.
 *
 * Constraints:
 * - 1 <= s.length <= 100
 * - s[i] is either '0' or '1'
 * - s[0] is '1'
 *
 * Time Complexity:
 * - Solution 1: O(n log n) (due to sorting)
 * - Solution 2: O(n)
 *
 * Space Complexity:
 * - Solution 1: O(n)
 * - Solution 2: O(1)
 *
 * Note:
 * 06-03-2026 → Another day of consistency in solving problems.
 * Small problems solved daily build strong problem-solving skills over time.
 */
public class _2026_03_06_CheckBinaryStringSegment {

    /**
     * Solution 1 (Sorting Approach)
     *
     * Idea:
     * If the string contains only one segment of '1's, sorting the characters
     * in descending order will produce the same string.
     *
     * Example:
     * "1100" -> sorted descending -> "1100" (valid)
     * "1001" -> sorted descending -> "1100" (not equal -> invalid)
     */
    public boolean checkOnesSegmentSort(String s) {

        Character[] charArray = new Character[s.length()];

        for (int i = 0; i < s.length(); i++) {
            charArray[i] = s.charAt(i);
        }

        Arrays.sort(charArray, Collections.reverseOrder());

        StringBuilder sortedString = new StringBuilder();
        for (Character c : charArray) {
            sortedString.append(c);
        }

        return s.equals(sortedString.toString());
    }

    /**
     * Solution 2 (Optimal Approach)
     *
     * Idea:
     * If we ever see "01", it means the segment of '1's ended
     * and then another '1' appeared later.
     *
     * That means there are multiple segments of ones.
     *
     * So if the string contains "01" followed by another '1',
     * the pattern "01" indicates separation.
     */
    public boolean checkOnesSegment(String s) {

        if (s.contains("01")) {
            return false;
        }

        return true;
    }

    /**
     * Example main to test the solutions
     */
    public static void main(String[] args) {

        _2026_03_06_CheckBinaryStringSegment solution =
                new _2026_03_06_CheckBinaryStringSegment();

        String s1 = "110";
        String s2 = "1001";

        System.out.println("Solution 1 (Sort) - s1: "
                + solution.checkOnesSegmentSort(s1));
        System.out.println("Solution 1 (Sort) - s2: "
                + solution.checkOnesSegmentSort(s2));

        System.out.println("Solution 2 (Optimal) - s1: "
                + solution.checkOnesSegment(s1));
        System.out.println("Solution 2 (Optimal) - s2: "
                + solution.checkOnesSegment(s2));
    }
}
