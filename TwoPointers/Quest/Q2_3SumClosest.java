package TwoPointers.Quest;

import java.util.Arrays;

/**
 * Problem: 3Sum Closest (Medium)
 * LeetCode: https://leetcode.com/problems/3sum-closest/
 *
 * Source:
 * - data-structures-and-algorithms-quest
 * - Two Pointers / 3Sum
 *
 * Pattern: Two Pointers after Sorting
 *
 * Time Complexity: O(n^2) — one loop for fixing first element + two pointers for the rest
 * Space Complexity: O(1) — sorting in place, no extra space required
 *
 * Description:
 * Given an integer array nums and an integer target, find three integers in nums
 * such that their sum is closest to target. Return the sum of the three integers.
 * You may assume each input has exactly one solution.
 */
public class Q2_3SumClosest {

    /**
     * Solution:
     * 1. Sort the array.
     * 2. Loop through each number as the first element of the triplet.
     * 3. Use two pointers (left and right) to find the remaining two numbers.
     * 4. Update closestSum whenever a closer sum is found.
     * 5. Move pointers based on comparison with target:
     *    - sum < target → increase sum → move left++
     *    - sum > target → decrease sum → move right--
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int closestSum = nums[0] + nums[1] + nums[2]; // initialize with first triplet sum

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];

                // Update closestSum if currentSum is closer to target
                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum;
                }

                if (currentSum < target) {
                    left++; // need a larger sum
                } else if (currentSum > target) {
                    right--; // need a smaller sum
                } else {
                    // exact match
                    return target;
                }
            }
        }

        return closestSum;
    }

    // Test examples
    public static void main(String[] args) {
        Q2_3SumClosest solution = new Q2_3SumClosest();

        int[] ex1 = {-1, 2, 1, -4};
        System.out.println(solution.threeSumClosest(ex1, 1)); // 2

        int[] ex2 = {0, 0, 0};
        System.out.println(solution.threeSumClosest(ex2, 1)); // 0

        int[] ex3 = {1, 1, 1, 0};
        System.out.println(solution.threeSumClosest(ex3, -100)); // 2

        int[] ex4 = {1, 2, 4, 8, 16};
        System.out.println(solution.threeSumClosest(ex4, 18)); // 17
    }
}
