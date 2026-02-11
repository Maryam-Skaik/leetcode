package SlidingWindow.Quest;

/**
 * Problem: Longest Repeating Character Replacement (Medium)
 * LeetCode: https://leetcode.com/problems/longest-repeating-character-replacement/
 *
 * Source:
 * - data-structures-and-algorithms-quest
 * - Sliding Window
 *
 * Pattern:
 * - Sliding Window + Frequency Counting
 *
 * Idea:
 * 1. Maintain a sliding window [left, right].
 * 2. Track character frequencies in the window using count[26].
 * 3. Track maxFreq = highest frequency character in current window.
 * 4. If (window_size - maxFreq) > k:
 *        shrink the window from the left.
 * 5. Keep updating the maximum valid window length.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)  (fixed array of size 26)
 */
public class Q3_LongestRepeatingCharacterReplacement {

    public static int characterReplacement(String s, int k) {

        int[] count = new int[26];
        int left = 0;
        int maxFreq = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            // Update frequency of current character
            int index = s.charAt(right) - 'A';
            count[index]++;

            // Update max frequency in current window
            maxFreq = Math.max(maxFreq, count[index]);

            // If more than k replacements needed, shrink window
            while ((right - left + 1) - maxFreq > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }

            // Update maximum length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    // Test the solution
    public static void main(String[] args) {

        String s1 = "ABAB";
        System.out.println(characterReplacement(s1, 2)); // 4

        String s2 = "AABABBA";
        System.out.println(characterReplacement(s2, 1)); // 4
    }
}
