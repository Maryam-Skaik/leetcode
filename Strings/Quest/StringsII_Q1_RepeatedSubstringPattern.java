package Strings.Quest;

/**
 * Problem: Repeated Substring Pattern (Easy)
 * LeetCode: https://leetcode.com/problems/repeated-substring-pattern/
 *
 * Source:
 * - data-structures-and-algorithms-quest
 * - Strings II
 *
 * Pattern: String manipulation / Repeated pattern detection
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

public class StringsII_Q1_RepeatedSubstringPattern {

    public static boolean repeatedSubstringPattern(String s) {
        // Double the string
        String check = s + s;

        // Remove first and last characters
        String str = check.substring(1, check.length() - 1);

        // Check if original string exists in the modified string
        return str.contains(s);
    }

    // Test the solution
    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("abab"));          // true
        System.out.println(repeatedSubstringPattern("aba"));           // false
        System.out.println(repeatedSubstringPattern("abcabcabcabc"));  // true
        System.out.println(repeatedSubstringPattern("a"));             // false
        System.out.println(repeatedSubstringPattern("zzzz"));          // true
    }
}
