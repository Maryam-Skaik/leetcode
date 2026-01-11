package Arrays.Quest;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Problem: How Many Numbers Are Smaller Than the Current Number (Easy)
 * LeetCode: https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
 *
 * Source:
 * - data-structures-and-algorithms-quest
 * - Arrays II
 *
 * Pattern: Array / Sorting / HashMap
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 */

public class ArraysII_Q2_SmallerNumbersThanCurrent {

    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        HashMap<Integer, Integer> map = new HashMap<>();
        // Map each number to the count of numbers smaller than it
        for (int i = 0; i < sorted.length; i++) {
            map.putIfAbsent(sorted[i], i);
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = map.get(nums[i]);
        }

        return result;
    }

    // Test the solution
    public static void main(String[] args) {
        int[] nums1 = {8, 1, 2, 2, 3};
        printArray(smallerNumbersThanCurrent(nums1)); // [4, 0, 1, 1, 3]

        int[] nums2 = {6, 5, 4, 8};
        printArray(smallerNumbersThanCurrent(nums2)); // [2, 1, 0, 3]

        int[] nums3 = {7, 7, 7, 7};
        printArray(smallerNumbersThanCurrent(nums3)); // [0, 0, 0, 0]
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
