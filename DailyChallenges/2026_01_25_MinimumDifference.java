package DailyChallenges;

/**
 * Problem: Minimum Difference Between Highest and Lowest of K Scores
 * Date: 25-01-2026
 * Difficulty: Easy
 * Pattern: Sorting / Sliding Window
 *
 * Problem Link:
 * https://leetcode.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/
 *
 * Time Complexity:
 * O(n log n) where n = number of elements in the array, due to sorting.
 *
 * Space Complexity:
 * O(1) (ignoring the space used by the input array)
 */

import java.util.Arrays;

public class _2026_01_25_MinimumDifference {

    /**
     * Solution:
     * - If k = 1, the difference is always 0.
     * - Sort the array to bring numbers closer in order.
     * - Use a sliding window of size k.
     * - For each window, calculate the difference between the last and first elements.
     * - Track the minimum difference across all windows.
     */
    public int minimumDifference(int[] nums, int k) {
        if (k == 1) return 0;  // Single element difference is 0
        
        Arrays.sort(nums);  // Sort the array
        int min = Integer.MAX_VALUE;

        for (int i = 0; i <= nums.length - k; i++) {
            int diff = nums[i + k - 1] - nums[i];  // Max - Min in this window
            if (diff < min) min = diff;
        }

        return min;
    }

    // Test examples
    public static void main(String[] args) {
        _2026_01_25_MinimumDifference solution = new _2026_01_25_MinimumDifference();

        // Example 1: nums = [90], k = 1 → output = 0
        int[] ex1 = {90};
        System.out.println("Example 1 Output: " + solution.minimumDifference(ex1, 1)); // 0

        // Example 2: nums = [9, 4, 1, 7], k = 2 → output = 2
        int[] ex2 = {9, 4, 1, 7};
        System.out.println("Example 2 Output: " + solution.minimumDifference(ex2, 2)); // 2

        // Custom Example: nums = [87063,61094,44530,21297,95857,93551,9918], k = 6 → output = 74560
        int[] ex3 = {87063, 61094, 44530, 21297, 95857, 93551, 9918};
        System.out.println("Custom Example Output: " + solution.minimumDifference(ex3, 6)); // 74560
    }
}
