package RollingHash.Quest;

/**
 * Problem: Longest Happy Prefix (Hard)
 * LeetCode: https://leetcode.com/problems/longest-happy-prefix/
 *
 * Source:
 * - data-structures-and-algorithms-quest
 * - Rolling Hash II
 *
 * Pattern: String / Rolling Hash
 *
 * Idea:
 * A happy prefix is a prefix that is also a suffix (excluding the whole string).
 * Use polynomial rolling hash:
 * - Build prefix hash from left → right.
 * - Build suffix hash from right → left.
 * - When both hashes match at position i,
 *   we found a prefix of length (i + 1) that equals a suffix.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class RollingHash_Q2_LongestHappyPrefix {

    public static String longestPrefix(String s) {
        long base = 131;
        long mod = 1_000_000_007;

        long prefixHash = 0;
        long suffixHash = 0;
        long power = 1;

        int n = s.length();
        int maxLen = 0;

        for (int i = 0; i < n - 1; i++) {
            int leftVal = s.charAt(i);
            int rightVal = s.charAt(n - 1 - i);

            // Build prefix hash
            prefixHash = (prefixHash * base + leftVal) % mod;

            // Build suffix hash
            suffixHash = (suffixHash + rightVal * power) % mod;

            if (prefixHash == suffixHash) {
                maxLen = i + 1;
            }

            power = (power * base) % mod;
        }

        return s.substring(0, maxLen);
    }

    // Test the solution
    public static void main(String[] args) {
        System.out.println(longestPrefix("level"));   // l
        System.out.println(longestPrefix("ababab"));  // abab
        System.out.println(longestPrefix("aaaaa"));   // aaaa
        System.out.println(longestPrefix("abc"));     // ""
    }
}
