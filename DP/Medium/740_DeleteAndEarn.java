package DP.Medium;

/**
 * Problem: 740. Delete and Earn (Medium)
 * LeetCode: https://leetcode.com/problems/delete-and-earn/
 * Pattern: Dynamic Programming (House Robber Variant)
 *
 * Idea:
 * If you take a number x, you must delete x - 1 and x + 1.
 * This transforms the problem into a House Robber problem
 * where indices represent values instead of house positions.
 *
 * Step 1:
 * Convert nums[] into a sum[] array where:
 * sum[i] = total points gained by taking all occurrences of i
 *
 * Step 2:
 * Apply House Robber DP on sum[]
 *
 * DP State:
 * dp[i] = maximum points we can earn considering values from 0..i
 *
 * Transition:
 * dp[i] = max(dp[i - 1], sum[i] + dp[i - 2])
 *
 * Base Cases:
 * dp[0] = 0
 * dp[1] = sum[1]
 *
 * Time Complexity: O(n + maxValue)
 * Space Complexity: O(maxValue)
 */

public class _740_DeleteAndEarn {

    public static int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        // sum[i] = total points earned by taking all i's
        int[] sum = new int[max + 1];
        for (int num : nums) {
            sum[num] += num;
        }

        int[] table = new int[max + 1];

        table[0] = 0;
        table[1] = sum[1];

        for (int i = 2; i <= max; i++) {
            table[i] = Math.max(table[i - 1], sum[i] + table[i - 2]);
        }

        return table[max];
    }

    // Test the solution
    public static void main(String[] args) {
        int[] nums1 = {3, 4, 2};
        System.out.println(deleteAndEarn(nums1)); // 6

        int[] nums2 = {2, 2, 3, 3, 3, 4};
        System.out.println(deleteAndEarn(nums2)); // 9
    }
}
