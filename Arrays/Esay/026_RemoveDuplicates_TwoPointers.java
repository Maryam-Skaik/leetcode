package Arrays.Easy;

/**
 * Problem: Remove Duplicates from Sorted Array (Easy)
 * LeetCode: https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * Pattern: Two Pointers / In-place
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

import java.util.Arrays;

public class _026_RemoveDuplicates_TwoPointers {

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    // Test the solution
    public static void main(String[] args) {
        int[] nums1 = {1,1,2};
        int k1 = removeDuplicates(nums1);
        System.out.println("k = " + k1 + ", nums = " + Arrays.toString(Arrays.copyOf(nums1, k1))); // [1,2]

        int[] nums2 = {0,0,1,1,1,2,2,3,3,4};
        int k2 = removeDuplicates(nums2);
        System.out.println("k = " + k2 + ", nums = " + Arrays.toString(Arrays.copyOf(nums2, k2))); // [0,1,2,3,4]
    }
}
