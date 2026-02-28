package Backtracking.Quest;

/**
 * Problem: The k-th Lexicographical String of All Happy Strings of Length n (Medium)
 * LeetCode: https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/
 *
 * Source:
 * - data-structures-and-algorithms-quest
 * - Backtracking
 *
 * Pattern:
 * - Backtracking
 *
 * Idea:
 * 1. Generate all happy strings of length n using backtracking.
 * 2. A happy string:
 *    - Contains only 'a', 'b', 'c'.
 *    - No two consecutive characters are the same.
 * 3. Build strings in lexicographical order by trying 'a', then 'b', then 'c'.
 * 4. Count generated strings.
 * 5. When count == k, store the result and stop early.
 *
 * Time Complexity: O(3 * 2^(n-1))
 *   - First character: 3 choices.
 *   - Each next character: at most 2 choices.
 *
 * Space Complexity: O(n)
 *   - Recursion depth up to n.
 */
public class Q3_KthHappyString {

    private static int count;
    private static String result;

    public static String getHappyString(int n, int k) {
        count = 0;
        result = "";
        backtrack("", n, k);
        return result;
    }

    private static void backtrack(String current, int n, int k) {

        if (current.length() == n) {
            count++;
            if (count == k) {
                result = current;
            }
            return;
        }

        for (char c = 'a'; c <= 'c'; c++) {

            if (current.isEmpty() ||
                current.charAt(current.length() - 1) != c) {

                backtrack(current + c, n, k);

                // Early stop if result found
                if (!result.isEmpty()) return;
            }
        }
    }

    // Main method for testing
    public static void main(String[] args) {

        int n1 = 1, k1 = 3;
        System.out.println("Input: n = " + n1 + ", k = " + k1);
        System.out.println("Output: " + getHappyString(n1, k1));
        System.out.println();

        int n2 = 1, k2 = 4;
        System.out.println("Input: n = " + n2 + ", k = " + k2);
        System.out.println("Output: " + getHappyString(n2, k2));
        System.out.println();

        int n3 = 3, k3 = 9;
        System.out.println("Input: n = " + n3 + ", k = " + k3);
        System.out.println("Output: " + getHappyString(n3, k3));
    }
}
