package Sorting.Quest;

import java.util.Arrays;

/**
 * Problem: Kth Largest Element in an Array
 * Difficulty: Medium
 *
 * LeetCode:
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 *
 * Source:
 * - data-structures-and-algorithms-quest
 * - Sorting II
 *
 * Pattern:
 * - Sorting
 *
 * Idea:
 * 1. Sort the array in ascending order.
 * 2. The kth largest element will be at index (n - k).
 * 3. Return nums[nums.length - k].
 *
 * Note:
 * - This solution uses sorting.
 * - The problem also asks for a solution without sorting
 *   (e.g., Heap or Quickselect), but this version focuses on Sorting II.
 *
 * Time Complexity:
 * O(n log n), due to sorting the array.
 *
 * Space Complexity:
 * O(1), ignoring the input array modification.
 */
public class SortingII_Q1_KthLargestElementInArray {

    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    // Test the solution
    public static void main(String[] args) {

        int[] ex1 = {3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest(ex1, 2));
        // Output: 5

        int[] ex2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(findKthLargest(ex2, 4));
        // Output: 4
    }
}
