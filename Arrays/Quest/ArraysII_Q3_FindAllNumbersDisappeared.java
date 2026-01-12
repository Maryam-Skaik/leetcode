package Arrays.Quest;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

/**
 * Problem: Find All Numbers Disappeared in an Array (Easy)
 * LeetCode: https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 *
 * Source:
 * - data-structures-and-algorithms-quest
 * - Arrays II
 *
 * Pattern: Array / Sorting / Two Pointers
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(1) extra (excluding output list)
 */

public class ArraysII_Q3_FindAllNumbersDisappeared {

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        Arrays.sort(nums);

        List<Integer> list = new ArrayList<>();
        int index = 0;

        for (int i = 1; i <= nums.length; i++) {
            // Skip duplicates and smaller values
            while (index < nums.length && nums[index] < i) {
                index++;
            }

            // If i is missing
            if (index >= nums.length || nums[index] != i) {
                list.add(i);
            }
        }

        return list;
    }

    // Test the solution
    public static void main(String[] args) {
        int[] nums1 = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDisappearedNumbers(nums1)); // [5, 6]

        int[] nums2 = {1, 1};
        System.out.println(findDisappearedNumbers(nums2)); // [2]
    }
}
