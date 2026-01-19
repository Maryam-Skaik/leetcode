package Strings.Quest;

/**
 * Problem: Rotate String (Easy)
 * LeetCode: https://leetcode.com/problems/rotate-string/
 *
 * Source:
 * - data-structures-and-algorithms-quest
 * - Strings II
 *
 * Pattern: String manipulation / Rotation check
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

public class StringsII_Q2_RotateString {

    public static boolean rotateString(String s, String goal) {
        // Lengths must be equal to be rotations
        if (s.length() != goal.length()) return false;

        // Concatenate string with itself
        String str = s + s;

        // If goal is a substring of doubled string, it's a rotation
        return str.contains(goal);
    }

    // Test the solution
    public static void main(String[] args) {
        System.out.println(rotateString("abcde", "cdeab")); // true
        System.out.println(rotateString("abcde", "abced")); // false
        System.out.println(rotateString("a", "a"));         // true
        System.out.println(rotateString("ab", "ba"));       // true
        System.out.println(rotateString("abc", "cab"));     // true
    }
}
