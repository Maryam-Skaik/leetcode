package DP.Medium;

/**
 * Problem: 198. House Robber (Medium)
 * LeetCode: https://leetcode.com/problems/house-robber/
 * Pattern: Dynamic Programming (1D DP / Take or Skip)
 *
 * Idea:
 * You cannot rob two adjacent houses.
 * At each house, decide to either:
 * 1) Skip it → keep the previous maximum
 * 2) Rob it  → add current money to the best up to i - 2
 *
 * DP State:
 * dp[i] = maximum money that can be robbed from houses 0..i
 *
 * Transition:
 * dp[i] = max(dp[i - 1], nums[i] + dp[i - 2])
 *
 * Base Cases:
 * dp[0] = nums[0]
 * dp[1] = max(nums[0], nums[1])
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

public class _198_HouseRobber {

    public static int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        int[] table = new int[nums.length];

        table[0] = nums[0];
        table[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            table[i] = Math.max(table[i - 1], nums[i] + table[i - 2]);
        }

        return Math.max(table[nums.length - 1], table[nums.length - 2]);
    }

    // Test the solution
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 1};
        System.out.println(rob(nums1)); // 4

        int[] nums2 = {2, 7, 9, 3, 1};
        System.out.println(rob(nums2)); // 12
    }
}
