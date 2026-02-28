package Backtracking.Quest;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: Restore IP Addresses (Medium)
 * LeetCode: https://leetcode.com/problems/restore-ip-addresses/
 *
 * Source:
 * - data-structures-and-algorithms-quest
 * - Backtracking
 *
 * Pattern:
 * - Backtracking
 *
 * Idea:
 * 1. Use backtracking to split the string into exactly 4 segments.
 * 2. At each step, try segment lengths from 1 to 3 digits.
 * 3. Validate each segment:
 *    - Must be between 0 and 255.
 *    - Cannot contain leading zeros (except "0").
 * 4. If 4 valid segments are formed and all characters are used,
 *    join them with dots and add to result.
 *
 * Time Complexity: O(1)
 *   - At most 3^4 possibilities (constant upper bound).
 *
 * Space Complexity: O(1)
 *   - Recursion depth is at most 4.
 */
public class Q2_RestoreIPAddresses {

    public static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(String s, int start,
                                  List<String> path,
                                  List<String> result) {

        // If 4 segments are formed
        if (path.size() == 4) {
            // Check if all characters are used
            if (start == s.length()) {
                result.add(String.join(".", path));
            }
            return;
        }

        // Try segments of length 1 to 3
        for (int len = 1; len <= 3; len++) {

            if (start + len > s.length()) break;

            String segment = s.substring(start, start + len);

            if (isValid(segment)) {
                path.add(segment);                           // choose
                backtrack(s, start + len, path, result);     // explore
                path.remove(path.size() - 1);                 // un-choose
            }
        }
    }

    private static boolean isValid(String segment) {

        // Leading zero check
        if (segment.length() > 1 && segment.startsWith("0"))
            return false;

        int value = Integer.parseInt(segment);

        return value >= 0 && value <= 255;
    }

    // Main method for testing
    public static void main(String[] args) {

        String s1 = "25525511135";
        System.out.println("Input: " + s1);
        System.out.println("Output: " + restoreIpAddresses(s1));
        System.out.println();

        String s2 = "0000";
        System.out.println("Input: " + s2);
        System.out.println("Output: " + restoreIpAddresses(s2));
        System.out.println();

        String s3 = "101023";
        System.out.println("Input: " + s3);
        System.out.println("Output: " + restoreIpAddresses(s3));
    }
}
