package PrefixSum.Quest;

/**
 * Problem: Prefix SumI (Easy)
 * LeetCode: https://leetcode.com/problems/find-the-prefix-and-suffix-array/
 *
 * Source:
 * - data-structures-and-algorithms-quest
 * - PrefixSum I
 *
 * Pattern: Array / Prefix Sum
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

public class PrefixSumI_Q1_FindtheHighestAltitude {

    public static int[] prefixSum(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];

        prefix[0] = nums[0];  // The first element is the same as the input array

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i]; // Add current value to the sum of previous values
        }

        return prefix;
    }

    // Test the solution
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4};
        printArray(prefixSum(nums1)); // [1, 3, 6, 10]

        int[] nums2 = {1, -1, 1, 1};
        printArray(prefixSum(nums2)); // [1, 0, 1, 2]
    }

    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}
