package RollingHash.Quest;

/**
 * Problem: Shortest Palindrome (Hard)
 * LeetCode: https://leetcode.com/problems/shortest-palindrome/
 *
 * Source:
 * - data-structures-and-algorithms-quest
 * - Rolling Hash I
 *
 * Pattern: String / Rolling Hash
 *
 * Idea:
 * Use polynomial rolling hash to find the longest palindromic prefix.
 * If forwardHash == reverseHash at index i,
 * then substring(0, i) is a palindrome.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class RollingHash_Q1_ShortestPalindrome {

    public static String shortestPalindrome(String s) {
        if (s == null || s.length() <= 1) return s;

        long base = 131;
        long mod = 1_000_000_007;

        long forwardHash = 0;
        long reverseHash = 0;
        long power = 1;

        int longestPrefixLen = 0;

        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i);

            // Hash from left → right
            forwardHash = (forwardHash * base + val) % mod;

            // Hash as if building reversed string
            reverseHash = (reverseHash + val * power) % mod;

            if (forwardHash == reverseHash) {
                longestPrefixLen = i + 1;
            }

            power = (power * base) % mod;
        }

        // Remaining suffix that is NOT part of palindrome prefix
        String suffix = s.substring(longestPrefixLen);

        // Reverse suffix and add in front
        StringBuilder sb = new StringBuilder(suffix);
        return sb.reverse().toString() + s;
    }

    // Test the solution
    public static void main(String[] args) {
        System.out.println(shortestPalindrome("aacecaaa")); // aaacecaaa
        System.out.println(shortestPalindrome("abcd"));     // dcbabcd
        System.out.println(shortestPalindrome("aba"));      // aba
        System.out.println(shortestPalindrome("a"));        // a
    }
}
