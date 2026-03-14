package DailyChallenges;

/**
 * Problem: The k-th Lexicographical Happy String of Length n
 * Date: 14-03-2026
 * Difficulty: Medium
 * Pattern: Backtracking / Recursion
 *
 * Problem Link:
 * https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/
 *
 * Key Idea:
 * 1. A happy string uses only characters ['a','b','c'] and no two adjacent characters are equal.
 * 2. Generate all possible strings using backtracking.
 * 3. Build the string character by character while ensuring the next character
 *    is different from the previous one.
 * 4. Because we try characters in order ('a' → 'b' → 'c'), the generated strings
 *    naturally follow lexicographical order.
 * 5. Maintain a counter of valid strings generated.
 * 6. When the counter reaches k, store that string as the result.
 * 7. Stop recursion early once the result is found.
 *
 * Example:
 * n = 3, k = 9
 *
 * Happy strings in order:
 * ["aba","abc","aca","acb","bab","bac","bca","bcb","cab","cac","cba","cbc"]
 *
 * The 9th string → "cab"
 *
 * Time Complexity:
 * - O(3 * 2^(n-1))
 *   First character has 3 choices, each next position has 2 choices
 *   due to the adjacency restriction.
 *
 * Space Complexity:
 * - O(n) recursion depth for the current string.
 *
 */
public class _2026_03_14_KthHappyString {

    private int count = 0;      // number of valid happy strings generated
    private String result = ""; // stores the k-th happy string

    /**
     * Returns the k-th lexicographical happy string of length n
     */
    public String getHappyString(int n, int k) {
        backtrack("", n, k);
        return result;
    }

    /**
     * Backtracking function to generate happy strings
     */
    private void backtrack(String current, int n, int k) {

        // If the string length reaches n, we formed a valid happy string
        if (current.length() == n) {
            count++;

            if (count == k) {
                result = current;
            }
            return;
        }

        // Try characters in lexicographical order
        for (char c = 'a'; c <= 'c'; c++) {

            // Ensure no two adjacent characters are equal
            if (current.isEmpty() || current.charAt(current.length() - 1) != c) {

                backtrack(current + c, n, k);

                // Stop recursion once the result is found
                if (!result.isEmpty()) return;
            }
        }
    }

    /**
     * Example main to test the solution
     */
    public static void main(String[] args) {

        _2026_03_14_KthHappyString solution =
                new _2026_03_14_KthHappyString();

        int n1 = 1, k1 = 3; // Output: "c"
        int n2 = 1, k2 = 4; // Output: ""
        int n3 = 3, k3 = 9; // Output: "cab"

        System.out.println("Result: " + solution.getHappyString(n1, k1));
        System.out.println("Result: " + solution.getHappyString(n2, k2));
        System.out.println("Result: " + solution.getHappyString(n3, k3));
    }
}
