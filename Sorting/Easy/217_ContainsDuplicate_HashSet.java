package Sorting.Easy;

import java.util.HashSet;

/**
 * Problem: Contains Duplicate (Easy)
 * LeetCode: https://leetcode.com/problems/contains-duplicate/
 * Pattern: HashSet
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

public class _217_ContainsDuplicate_HashSet {

    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }

    // Test the solution
    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3, 1};
        System.out.println(containsDuplicate(nums1)); // true

        int[] nums2 = {1, 2, 3, 4};
        System.out.println(containsDuplicate(nums2)); // false

        int[] nums3 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println(containsDuplicate(nums3)); // true
    }
}
