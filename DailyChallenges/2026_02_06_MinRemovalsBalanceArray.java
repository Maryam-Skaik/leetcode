package DailyChallenges;

import java.util.Arrays;

/**
 * Problem: Minimum Removals to Balance Array
 * Date: 06-02-2026
 * Difficulty: Medium
 * Pattern: Two Pointers + Sliding Window
 *
 * Problem Link:
 * https://leetcode.com/problems/minimum-removals-to-balance-array/
 *
 * Time Complexity:
 * O(n log n), due to sorting the array.
 *
 * Space Complexity:
 * O(1), ignoring input sorting.
 */
public class _2026_02_06_MinRemovalsBalanceArray {

    /**
     * Solution:
     * - Sort the array to simplify min/max checks.
     * - Use two pointers (left, right) to represent a valid window:
     *   - nums[right] is the maximum in the window.
     *   - nums[left] is the minimum in the window.
     * - Expand right for each element.
     * - If nums[right] > nums[left] * k → window invalid → move left forward.
     * - Track the largest valid window size.
     * - Minimum removals = total elements - largest window.
     * - Cast to long during multiplication to avoid integer overflow.
     */
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0;
        int maxWindow = 0;

        for (int right = 0; right < n; right++) {
            while ((long) nums[right] > (long) nums[left] * k) {
                left++;
            }
            maxWindow = Math.max(maxWindow, right - left + 1);
        }

        return n - maxWindow;
    }

    // Test examples
    public static void main(String[] args) {
        _2026_02_06_MinRemovalsBalanceArray solution =
                new _2026_02_06_MinRemovalsBalanceArray();

        int[] ex1 = {2, 1, 5};
        System.out.println(solution.minRemoval(ex1, 2)); // 1

        int[] ex2 = {1, 6, 2, 9};
        System.out.println(solution.minRemoval(ex2, 3)); // 2

        int[] ex3 = {4, 6};
        System.out.println(solution.minRemoval(ex3, 2)); // 0

    }
}
