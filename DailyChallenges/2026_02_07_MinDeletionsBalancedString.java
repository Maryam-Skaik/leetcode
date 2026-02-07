package DailyChallenges;

/**
 * Problem: Minimum Deletions to Make String Balanced
 * Date: 07-02-2026
 * Difficulty: Medium
 * Pattern: Stack / Greedy
 *
 * Problem Link:
 * https://leetcode.com/problems/minimum-deletions-to-make-string-balanced/
 *
 * Description:
 * You are given a string s consisting only of characters 'a' and 'b'.
 * You can delete any number of characters to make s balanced.
 * s is balanced if there is no pair of indices (i,j) such that i < j and s[i] = 'b' and s[j]= 'a'.
 * Return the minimum number of deletions needed to make s balanced.
 *
 * Time Complexity: O(n) — single pass through the string
 * Space Complexity: O(n) — due to the stack, can be optimized to O(1)
 */
public class _2026_02_07_MinDeletionsBalancedString {

    /**
     * Solution:
     * - Use a stack to track 'b' characters encountered.
     * - For each 'a' after a 'b', delete one 'b' to remove the inversion.
     * - Increment deletion count each time a conflict is resolved.
     * - Return total deletions at the end.
     */
    public int minimumDeletions(String s) {
        Stack<Character> stack = new Stack<>();
        int deletion = 0;

        for (char c : s.toCharArray()) {
            if (c == 'b') {
                stack.push(c);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                    deletion++;
                }
            }
        }

        return deletion;
    }

    // Test examples
    public static void main(String[] args) {
        _2026_02_07_MinDeletionsBalancedString solution =
                new _2026_02_07_MinDeletionsBalancedString();

        String ex1 = "aababbab";
        System.out.println(solution.minimumDeletions(ex1)); // 2

        String ex2 = "bbaaaaabb";
        System.out.println(solution.minimumDeletions(ex2)); // 2

        String ex3 = "aaaa";
        System.out.println(solution.minimumDeletions(ex3)); // 0

        String ex4 = "bbbb";
        System.out.println(solution.minimumDeletions(ex4)); // 0

        String ex5 = "ba";
        System.out.println(solution.minimumDeletions(ex5)); // 1
    }
}
