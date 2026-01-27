package Math.Easy;

import java.util.Arrays;

/**
 * Problem: Minimum Operations to Make Array Sum Divisible by K (Easy)
 * LeetCode: https://leetcode.com/problems/minimum-operations-to-make-array-sum-divisible-by-k/
 * Pattern: Array / Modular Arithmetic
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class _3512_MinOperationsDivisibleByK {

    public static int minOperations(int[] nums, int k) {
        int sum = 0;
        
        // Compute the sum of the array
        for (int num : nums) {
            sum += num;
        }
        
        // Minimum operations needed is sum % k
        return sum % k;
    }

    // Test the solution
    public static void main(String[] args) {
        int[] nums1 = {3, 9, 7};
        int k1 = 5;
        System.out.println(minOperations(nums1, k1)); // 4

        int[] nums2 = {4, 1, 3};
        int k2 = 4;
        System.out.println(minOperations(nums2, k2)); // 0

        int[] nums3 = {3, 2};
        int k3 = 6;
        System.out.println(minOperations(nums3, k3)); // 5
    }
}
