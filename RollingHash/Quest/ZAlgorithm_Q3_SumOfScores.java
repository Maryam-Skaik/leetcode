package ZAlgorithm.Quest;

/**
 * Problem: Sum of Scores of Built Strings (Hard)
 * LeetCode: https://leetcode.com/problems/sum-of-scores-of-built-strings/
 *
 * Source:
 * - data-structures-and-algorithms-quest
 * - Z-Algorithm
 *
 * Pattern: String / Z-Algorithm
 *
 * Idea:
 * Use Z-Algorithm to compute the length of the longest common prefix 
 * between s and each suffix of s in O(n) time.
 * Sum all Z-values (including full string length for Z[0]).
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

public class ZAlgorithm_Q3_SumOfScores {

    public static long sumScores(String s) {
        int n = s.length();
        int[] Z = new int[n];
        char[] arr = s.toCharArray();

        int l = 0, r = 0;
        for (int i = 1; i < n; i++) {
            if (i <= r) {
                Z[i] = Math.min(r - i + 1, Z[i - l]);
            }
            while (i + Z[i] < n && arr[Z[i]] == arr[i + Z[i]]) {
                Z[i]++;
            }
            if (i + Z[i] - 1 > r) {
                l = i;
                r = i + Z[i] - 1;
            }
        }

        // Z[0] is the full string itself
        long sum = n;
        for (int i = 1; i < n; i++) {
            sum += Z[i];
        }

        return sum;
    }

    // Test the solution
    public static void main(String[] args) {
        System.out.println(sumScores("babab"));      // 9
        System.out.println(sumScores("azbazbzaz"));  // 14
        System.out.println(sumScores("aaaa"));       // 10 (4 + 3 + 2 + 1)
        System.out.println(sumScores("abc"));        // 3 (1 + 0 + 2)
    }
}
