package Arrays.Easy; // You can adjust package name if using Strings folder

import java.util.Arrays;

/**
 * Problem: Longest Common Prefix (Easy)
 * LeetCode: https://leetcode.com/problems/longest-common-prefix/
 * Pattern: Sorting / Compare first & last
 * Time Complexity: O(n log n + m) -> sorting + comparison (n = # of strings, m = length of first string)
 * Space Complexity: O(1) or O(n) depending on sorting implementation
 */

public class _014_LongestCommonPrefix_Sorting {

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        Arrays.sort(strs); // Sorts strings lexicographically
        StringBuilder result = new StringBuilder();

        String first = strs[0];
        String last = strs[strs.length - 1];

        for (int i = 0; i < first.length(); i++) {
            if (i >= last.length() || first.charAt(i) != last.charAt(i)) break;
            result.append(first.charAt(i));
        }

        return result.toString();
    }

    // Test the solution
    public static void main(String[] args) {
        String[] strs1 = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs1)); // Output: "fl"

        String[] strs2 = {"dog","racecar","car"};
        System.out.println(longestCommonPrefix(strs2)); // Output: ""

        String[] strs3 = {"a"};
        System.out.println(longestCommonPrefix(strs3)); // Output: "a"
    }
}
