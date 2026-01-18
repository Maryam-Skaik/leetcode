package Strings.Quest;

/**
 * Problem: Detect Capital (Easy)
 * LeetCode: https://leetcode.com/problems/detect-capital/
 *
 * Source:
 * - data-structures-and-algorithms-quest
 * - Strings I
 *
 * Pattern: String manipulation / Case comparison
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

public class StringsI_Q1_DetectCapital {

    public static boolean detectCapitalUse(String word) {
        String upper = word.toUpperCase();
        String lower = word.toLowerCase();

        // First letter uppercase, rest lowercase
        String firstUpper = upper.charAt(0) + lower.substring(1);

        return word.equals(upper)
                || word.equals(lower)
                || word.equals(firstUpper);
    }

    // Test the solution
    public static void main(String[] args) {
        System.out.println(detectCapitalUse("USA"));     // true
        System.out.println(detectCapitalUse("leetcode"));// true
        System.out.println(detectCapitalUse("Google"));  // true
        System.out.println(detectCapitalUse("FlaG"));    // false
    }
}
