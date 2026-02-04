package DP.Easy;

/**
 * Problem: 70. Climbing Stairs (Easy)
 * LeetCode: https://leetcode.com/problems/climbing-stairs/
 * Pattern: Dynamic Programming (1D DP / Fibonacci)
 *
 * Idea:
 * dp[i] = number of distinct ways to reach step i
 * dp[i] = dp[i - 1] + dp[i - 2]
 *
 * Base Cases:
 * dp[0] = 1  // one way to stay at the start
 * dp[1] = 1  // one way to reach step 1
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

public class _70_ClimbingStairs {

    public static int climbStairs(int n) {
        int[] dp = new int[n + 1];

        // Base cases
        dp[0] = 1;
        dp[1] = 1;

        // Build the solution bottom-up
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    // Test the solution
    public static void main(String[] args) {
        System.out.println(climbStairs(2)); // 2
        System.out.println(climbStairs(3)); // 3
        System.out.println(climbStairs(5)); // 8
    }
}
