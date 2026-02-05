package DP.Easy;

/**
 * Problem: 746. Min Cost Climbing Stairs (Easy)
 * LeetCode: https://leetcode.com/problems/min-cost-climbing-stairs/
 * Pattern: Dynamic Programming (1D DP / Cost Minimization)
 *
 * Idea:
 * Each step has a cost. When you step on it, you pay its cost.
 * You can start from step 0 or step 1.
 *
 * DP State:
 * dp[i] = minimum cost to reach step i
 *
 * Transition:
 * dp[i] = cost[i] + min(dp[i - 1], dp[i - 2])
 *
 * Base Cases:
 * dp[0] = cost[0]
 * dp[1] = cost[1]
 *
 * Final Answer:
 * The "top" is beyond the last index, so we can reach it from
 * either the last or second-last step without extra cost.
 *
 * answer = min(dp[n - 1], dp[n - 2])
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

public class _746_MinCostClimbingStairs {

    public static int minCostClimbingStairs(int[] cost) {
        int[] table = new int[cost.length];

        table[0] = cost[0];
        table[1] = cost[1];

        for (int i = 2; i < cost.length; i++) {
            table[i] = cost[i] + Math.min(table[i - 1], table[i - 2]);
        }

        return Math.min(table[cost.length - 1], table[cost.length - 2]);
    }

    // Test the solution
    public static void main(String[] args) {
        int[] cost1 = {10, 15, 20};
        System.out.println(minCostClimbingStairs(cost1)); // 15

        int[] cost2 = {1,100,1,1,1,100,1,1,100,1};
        System.out.println(minCostClimbingStairs(cost2)); // 6
    }
}
