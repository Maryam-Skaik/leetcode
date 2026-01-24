package DailyChallenges;

/**
 * Problem: Minimize Maximum Pair Sum in Array
 * Date: 24-01-2026
 * Difficulty: Medium
 * Pattern: Sorting / Greedy
 *
 * Problem Link:
 * https://leetcode.com/problems/minimize-maximum-pair-sum-in-array/
 *
 * Time Complexity:
 * O(n log n) where n = number of elements in the array, due to sorting.
 *
 * Space Complexity:
 * O(1) (ignoring the space used by the input array)
 */

import java.util.Arrays;

public class _2026_01_24_MinPairSum {

    /**
     * Solution:
     * - Sort the array first to make pairing easier.
     * - Pair the smallest element with the largest, the second smallest with the second largest, and so on.
     * - Calculate the pair sums and return the maximum pair sum encountered.
     */
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);  // Sort the array
        int n = nums.length;
        int maxPairSum = 0;
        
        // Pair the smallest element with the largest element, the second smallest with the second largest, etc.
        for (int i = 0; i < n / 2; i++) {
            maxPairSum = Math.max(maxPairSum, nums[i] + nums[n - i - 1]);
        }
        
        return maxPairSum;  // Return the maximum pair sum
    }

    // Test examples
    public static void main(String[] args) {
        _2026_01_24_MinPairSum solution = new _2026_01_24_MinPairSum();

        // Example 1: nums = [3,5,2,3] → output = 7
        int[] ex1 = {3, 5, 2, 3};
        System.out.println("Example 1 Output: " + solution.minPairSum(ex1)); // 7

        // Example 2: nums = [3,5,4,2,4,6] → output = 8
        int[] ex2 = {3, 5, 4, 2, 4, 6};
        System.out.println("Example 2 Output: " + solution.minPairSum(ex2)); // 8
    }
}
