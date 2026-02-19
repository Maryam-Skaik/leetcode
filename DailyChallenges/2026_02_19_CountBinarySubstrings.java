package DailyChallenges;

/**
 * Problem: Count Binary Substrings
 * Date: 19-02-2026
 * Difficulty: Easy
 * Pattern: Sliding Window / Consecutive Groups
 *
 * Special Note:
 * Today (19-02-2026) is the second day of Ramadan 🌙
 *
 * Problem Link:
 * https://leetcode.com/problems/count-binary-substrings/
 *
 * Description:
 * Given a binary string s, return the number of non-empty substrings 
 * that have the same number of 0's and 1's, and all the 0's and all the 1's 
 * in these substrings are grouped consecutively.
 *
 * Substrings that occur multiple times are counted the number of times they occur.
 *
 * Constraints:
 * - 1 <= s.length <= 10^5
 * - s[i] is either '0' or '1'
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class _2026_02_19_CountBinarySubstrings {

    /**
     * Solution (Group Counting / Sliding Window Idea):
     * 1. Count consecutive 0's or 1's and store in an array.
     * 2. For each adjacent pair, add min(count[i], count[i+1]) to result.
     */
    public int countBinarySubstrings(String s) {
        int n = s.length();
        int[] counts = new int[n];
        int index = 0;
        int i = 0;

        // Count consecutive characters
        while (i < n) {
            char c = s.charAt(i);
            int cnt = 0;
            while (i < n && s.charAt(i) == c) {
                i++;
                cnt++;
            }
            counts[index++] = cnt;
        }

        // Sum up min of adjacent groups
        int result = 0;
        for (int j = 1; j < index; j++) {
            result += Math.min(counts[j - 1], counts[j]);
        }

        return result;
    }

    /**
     * Example main to test the solution
     */
    public static void main(String[] args) {
        _2026_02_19_CountBinarySubstrings solution = new _2026_02_19_CountBinarySubstrings();

        String s1 = "00110011"; // Output: 6
        String s2 = "10101";    // Output: 4

        System.out.println("s = \"" + s1 + "\" -> " + solution.countBinarySubstrings(s1));
        System.out.println("s = \"" + s2 + "\" -> " + solution.countBinarySubstrings(s2));
    }
}
