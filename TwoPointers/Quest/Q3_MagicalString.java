package TwoPointers.Quest;

import java.util.Arrays;

/**
 * Problem: Magical String (Medium)
 * LeetCode: https://leetcode.com/problems/magical-string/
 *
 * Source:
 * - data-structures-and-algorithms-quest
 * - Two Pointers / Simulation
 *
 * Pattern: Two Pointers / Sequence Simulation
 *
 * Time Complexity: O(n) — we process each element once
 * Space Complexity: O(n) — store sequence up to n elements
 *
 * Description:
 * A magical string consists of only '1' and '2' and obeys this rule:
 * - Concatenating the sequence of lengths of consecutive 1s and 2s generates the string itself.
 * Example: s = "1221121221221121122..."
 * Given n, return the number of 1's in the first n numbers of the magical string.
 */
public class Q3_MagicalString {

    /**
     * Solution:
     * - Use an int array to simulate the magical string
     * - read pointer (i) reads the count of next numbers to append
     * - nextNum alternates between 1 and 2
     * - count 1's as we "generate" numbers
     */
    public int magicalString(int n) {
        if (n == 0) return 0;
        if (n <= 3) return 1; // "122" contains 1 one

        int[] s = new int[n];
        s[0] = 1;
        s[1] = 2;
        s[2] = 2;

        int countOnes = 1;  // first '1'
        int i = 2;          // read pointer
        int idx = 3;        // next write index
        int nextNum = 1;    // next number to append

        while (idx < n) {
            int times = s[i]; // how many times to append nextNum
            for (int j = 0; j < times && idx < n; j++) {
                s[idx++] = nextNum;
                if (nextNum == 1) countOnes++;
            }
            nextNum = 3 - nextNum; // alternate 1 -> 2, 2 -> 1
            i++;
        }

        return countOnes;
    }

    // Test examples
    public static void main(String[] args) {
        Q3_MagicalString solution = new Q3_MagicalString();

        int n1 = 6;
        System.out.println(solution.magicalString(n1)); // 3, "122112"

        int n2 = 1;
        System.out.println(solution.magicalString(n2)); // 1, "1"

        int n3 = 10;
        System.out.println(solution.magicalString(n3)); // 5, "1221121221"

        int n4 = 20;
        System.out.println(solution.magicalString(n4)); // 10
    }
}
