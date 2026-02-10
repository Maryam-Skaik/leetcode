package DailyChallenges;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem: Longest Balanced Subarray I
 * Date: 10-02-2026
 * Difficulty: Medium
 * Pattern: Brute Force / HashSet
 *
 * Problem Link:
 * https://leetcode.com/problems/longest-balanced-subarray-i/
 *
 * Description:
 * Given an integer array nums, a subarray is called balanced if the number
 * of distinct even numbers in the subarray is equal to the number of distinct odd numbers.
 *
 * Return the length of the longest balanced subarray.
 *
 * Constraints:
 * - 1 <= nums.length <= 1500
 * - 1 <= nums[i] <= 10^5
 *
 * Time Complexity: O(n^2) — iterate all subarrays, add numbers to sets
 * Space Complexity: O(n) — sets to store distinct numbers
 */
public class _2026_02_10_LongestBalancedSubarray {

    /**
     * Solution:
     * 1. Iterate all possible subarrays.
     * 2. Keep track of distinct even and odd numbers using HashSets.
     * 3. Update max length when sets have equal size.
     */
    public int longestBalanced(int[] nums) {
        int maxLen = 0;

        for (int start = 0; start < nums.length; start++) {
            Set<Integer> evens = new HashSet<>();
            Set<Integer> odds = new HashSet<>();

            for (int end = start; end < nums.length; end++) {
                if (nums[end] % 2 == 0) evens.add(nums[end]);
                else odds.add(nums[end]);

                if (evens.size() == odds.size()) {
                    maxLen = Math.max(maxLen, end - start + 1);
                }
            }
        }

        return maxLen;
    }

    /**
     * Example main to test the solution
     */
    public static void main(String[] args) {
        _2026_02_10_LongestBalancedSubarray solution = new _2026_02_10_LongestBalancedSubarray();
        int[] nums1 = {2, 5, 4, 3};
        int[] nums2 = {3, 2, 2, 5, 4};
        int[] nums3 = {1, 2, 3, 2};

        System.out.println(solution.longestBalanced(nums1)); // 4
        System.out.println(solution.longestBalanced(nums2)); // 5
        System.out.println(solution.longestBalanced(nums3)); // 3
    }
}
