package DP.Easy;

/**
 * Problem: 509. Fibonacci Number (Easy)
 * LeetCode: https://leetcode.com/problems/fibonacci-number/
 * Pattern: Dynamic Programming (1D DP / Fibonacci)
 *
 * Definition:
 * F(0) = 0
 * F(1) = 1
 * F(n) = F(n - 1) + F(n - 2), for n > 1
 *
 * DP State:
 * dp[i] = Fibonacci number at index i
 *
 * Base Cases:
 * dp[0] = 0
 * dp[1] = 1
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

public class _509_FibonacciNumber {

    public static int fib(int n) {
        if (n == 0 || n == 1) return n;

        int[] table = new int[n + 1];

        table[0] = 0;
        table[1] = 1;

        for (int i = 2; i <= n; i++) {
            table[i] = table[i - 1] + table[i - 2];
        }

        return table[n];
    }

    // Test the solution
    public static void main(String[] args) {
        System.out.println(fib(2)); // 1
        System.out.println(fib(3)); // 2
        System.out.println(fib(4)); // 3
        System.out.println(fib(10)); // 55
    }
}
