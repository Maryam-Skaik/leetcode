package DP.Easy;

/**
 * Problem: 1137. N-th Tribonacci Number (Easy)
 * LeetCode: https://leetcode.com/problems/n-th-tribonacci-number/
 * Pattern: Dynamic Programming (1D DP / Tribonacci)
 *
 * Definition:
 * T0 = 0
 * T1 = 1
 * T2 = 1
 * Tn = Tn - 1 + Tn - 2 + Tn - 3, for n >= 3
 *
 * DP State:
 * dp[i] = Tribonacci number at index i
 *
 * Base Cases:
 * dp[0] = 0
 * dp[1] = 1
 * dp[2] = 1
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

public class _1137_NthTribonacciNumber {

    public static int tribonacci(int n) {
        if (n == 0 || n == 1) return n;
        if (n == 2) return 1;

        int[] table = new int[n + 1];

        table[0] = 0;
        table[1] = 1;
        table[2] = 1;

        for (int i = 3; i <= n; i++) {
            table[i] = table[i - 1] + table[i - 2] + table[i - 3];
        }

        return table[n];
    }

    // Test the solution
    public static void main(String[] args) {
        System.out.println(tribonacci(4));  // 4
        System.out.println(tribonacci(25)); // 1389537
    }
}
