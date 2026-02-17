package Recursion.Quest;

/**
 * Problem: Decode String (Medium)
 * LeetCode: https://leetcode.com/problems/decode-string/
 *
 * Source:
 * - data-structures-and-algorithms-quest
 * - Recursion III
 *
 * Pattern: Recursion / String Manipulation
 *
 * Idea:
 * Recursively decode a string with pattern k[encoded_string].
 * - Parse digits to get repeat count k
 * - Recursively decode the substring inside brackets
 * - Concatenate the repeated result
 *
 * Time Complexity: O(n) where n is the length of the decoded string
 * Space Complexity: O(n) due to recursion stack and output string
 */

public class Recursion_Q3_DecodeString {

    /**
     * Main recursive solution
     */
    public String decodeString(String s) {
        return decodeHelper(s, new int[]{0});
    }

    /**
     * Helper method using index pointer to handle recursion
     */
    private String decodeHelper(String s, int[] index) {
        StringBuilder result = new StringBuilder();

        while (index[0] < s.length()) {
            char c = s.charAt(index[0]);

            if (Character.isLetter(c)) {
                result.append(c);  // Add letters directly
                index[0]++;
            } else if (Character.isDigit(c)) {
                int k = 0;
                while (index[0] < s.length() && Character.isDigit(s.charAt(index[0]))) {
                    k = k * 10 + (s.charAt(index[0]) - '0');
                    index[0]++;
                }

                index[0]++; // Skip '['
                String decoded = decodeHelper(s, index); // Recurse inside brackets
                index[0]++; // Skip ']'

                for (int i = 0; i < k; i++) {
                    result.append(decoded); // Repeat decoded substring
                }
            } else if (c == ']') {
                break; // End of current recursion level
            }
        }

        return result.toString();
    }

    // Test examples
    public static void main(String[] args) {
        Recursion_Q3_DecodeString solution = new Recursion_Q3_DecodeString();

        String s1 = "3[a]2[bc]";
        String s2 = "3[a2[c]]";
        String s3 = "2[abc]3[cd]ef";

        System.out.println(solution.decodeString(s1)); // "aaabcbc"
        System.out.println(solution.decodeString(s2)); // "accaccacc"
        System.out.println(solution.decodeString(s3)); // "abcabccdcdcdef"
    }
}
