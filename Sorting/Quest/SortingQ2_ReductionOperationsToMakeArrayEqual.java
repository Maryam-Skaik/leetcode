package Sorting.Quest;

import java.util.Arrays;

/**
 * Problem: Reduction Operations to Make the Array Elements Equal (Medium)
 * LeetCode: https://leetcode.com/problems/reduction-operations-to-make-the-array-elements-equal/
 *
 * Source:
 * - data-structures-and-algorithms-quest
 * - Sorting
 *
 * Pattern:
 * - Sorting
 * - Counting steps between distinct values
 *
 * Idea:
 * 1. Sort the array in non-decreasing order.
 * 2. Each time we encounter a new larger value compared to the previous one,
 *    it means all elements from this position onward require one additional operation.
 * 3. Accumulate the number of operations needed based on how many "levels"
 *    an element is above the minimum value.
 *
 * Time Complexity: O(n log n)
 * - Sorting the array dominates the complexity.
 *
 * Space Complexity: O(1)
 * - Only constant extra space is used.
 */
public class SortingQ2_ReductionOperationsToMakeArrayEqual {

    public static int reductionOperations(int[] nums) {
        Arrays.sort(nums); // Step 1: Sort the array

        int totalOperations = 0;
        int operationsPerElement = 0;

        // Step 2: Traverse the array and count operations
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                operationsPerElement++;
            }
            totalOperations += operationsPerElement;
        }

        return totalOperations;
    }

    // Test the solution
    public static void main(String[] args) {
        int[] nums1 = {5, 1, 3};
        System.out.println(reductionOperations(nums1)); // Output: 3

        int[] nums2 = {1, 1, 1};
        System.out.println(reductionOperations(nums2)); // Output: 0

        int[] nums3 = {1, 1, 2, 2, 3};
        System.out.println(reductionOperations(nums3)); // Output: 4
    }
}
