package Strings.Quest;

/**
 * Problem: Repeated String Match (Medium)
 * LeetCode: https://leetcode.com/problems/repeated-string-match/
 *
 * Source:
 * - data-structures-and-algorithms-quest
 * - Strings II
 *
 * Pattern: String manipulation / Repetition check / Substring search
 *
 * Time Complexity: O(n * m) in worst case, where n = a.length(), m = b.length()
 * Space Complexity: O(n * k), where k is the number of repetitions
 */

public class StringsII_Q3_RepeatedStringMatch {

    public static int repeatedStringMatch(String a, String b) {
        int counter = 1;
        StringBuilder repeat = new StringBuilder(a);

        // Repeat a until the repeated string length >= b.length
        while (repeat.length() < b.length()) {
            repeat.append(a);
            counter++;
        }

        // Check if b is now a substring
        if (repeat.toString().contains(b)) return counter;

        // Sometimes one more repetition is needed for overlapping parts
        if (repeat.append(a).toString().contains(b)) return counter + 1;

        // If still not found, impossible
        return -1;
    }

    // Test the solution
    public static void main(String[] args) {
        System.out.println(repeatedStringMatch("abcd", "cdabcdab")); // 3
        System.out.println(repeatedStringMatch("a", "aa"));          // 2
        System.out.println(repeatedStringMatch("abc", "wxyz"));      // -1
        System.out.println(repeatedStringMatch("xyz", "xyzxyz"));    // 2
        System.out.println(repeatedStringMatch("ab", "bababa"));     // 3
    }
}
