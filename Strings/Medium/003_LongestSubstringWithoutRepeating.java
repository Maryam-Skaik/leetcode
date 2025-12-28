package Strings.Medium;

import java.util.HashSet;

/**
 * Problem: Longest Substring Without Repeating Characters (Medium)
 * LeetCode: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * Pattern: Sliding Window / HashSet
 * Time Complexity: O(n)
 * Space Complexity: O(min(n, charset)) - HashSet stores unique characters
 */

public class _003_LongestSubstringWithoutRepeating {

    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int maxLength = 0, left = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            // Remove characters from the left until the duplicate is gone
            while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(c);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    // Test the solution
    public static void main(String[] args) {
        String s1 = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s1)); // 3

        String s2 = "bbbbb";
        System.out.println(lengthOfLongestSubstring(s2)); // 1

        String s3 = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s3)); // 3

        String s4 = "";
        System.out.println(lengthOfLongestSubstring(s4)); // 0

        String s5 = "au";
        System.out.println(lengthOfLongestSubstring(s5)); // 2
    }
}
