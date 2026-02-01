package DailyChallenges;

import java.util.Arrays;

/**
 * Problem: Divide an Array Into Subarrays With Minimum Cost I
 * Date: 01-02-2026
 * Difficulty: Easy
 * Pattern: Greedy + Sorting
 *
 * Problem Link:
 * https://leetcode.com/problems/divide-an-array-into-subarrays-with-minimum-cost-i/
 *
 * Time Complexity:
 * O(n log n), due to sorting the array.
 *
 * Space Complexity:
 * O(1), ignoring the input array modification.
 */

public class _2026_02_01_DivideArrayIntoSubarraysWithMinimumCostI {

    /**
     * Solution:
     * - The cost of each subarray is its first element.
     * - We must create exactly 3 contiguous subarrays.
     * - To minimize the total cost:
     *   1. The first subarray must start at index 0 → cost = nums[0].
     *   2. The other two subarrays should start with the smallest possible values
     *      from the remaining elements.
     * - We temporarily set nums[0] = 0, sort the array,
     *   and add the two smallest remaining values.
     */
    public int minimumCost(int[] nums) {
        int result = nums[0]; // cost of first subarray

        nums[0] = 0;          // exclude first element from sorting impact
        Arrays.sort(nums);   // sort remaining elements

        result += nums[1] + nums[2]; // pick two smallest costs

        return result;
    }

    // Test examples
    public static void main(String[] args) {
        _2026_02_01_DivideArrayIntoSubarraysWithMinimumCostI solution =
                new _2026_02_01_DivideArrayIntoSubarraysWithMinimumCostI();

        int[] ex1 = {1, 2, 3, 12};
        System.out.println(solution.minimumCost(ex1));
        // 6

        int[] ex2 = {5, 4, 3};
        System.out.println(solution.minimumCost(ex2));
        // 12

        int[] ex3 = {10, 3, 1, 1};
        System.out.println(solution.minimumCost(ex3));
        // 12
    }
}
