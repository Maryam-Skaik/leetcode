package Sorting.Easy;

/**
 * Problem: Merge Sorted Array (Easy)
 * LeetCode: https://leetcode.com/problems/merge-sorted-array/
 * Pattern: Forward Merge + Shifting
 * Time Complexity: O((m + n)^2)
 * Space Complexity: O(1)
 */

public class _088_MergeSortedArray_Shift {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int j = 0;

        for (int i = 0; i < m && j < n; ) {
            if (nums1[i] > nums2[j]) {
                shiftRight(nums1, i);
                nums1[i] = nums2[j];
                j++;
                m++;
            }
            i++;
        }

        while (j < n) {
            nums1[m++] = nums2[j++];
        }
    }

    private static void shiftRight(int[] arr, int index) {
        for (int i = arr.length - 1; i > index; i--) {
            arr[i] = arr[i - 1];
        }
    }

    // Test the solution
    public static void main(String[] args) {

        int[] nums1a = {1, 2, 3, 0, 0, 0};
        int[] nums2a = {2, 5, 6};
        merge(nums1a, 3, nums2a, 3);
        System.out.println(Arrays.toString(nums1a)); // [1, 2, 2, 3, 5, 6]

        int[] nums1b = {1};
        int[] nums2b = {};
        merge(nums1b, 1, nums2b, 0);
        System.out.println(Arrays.toString(nums1b)); // [1]

        int[] nums1c = {0};
        int[] nums2c = {1};
        merge(nums1c, 0, nums2c, 1);
        System.out.println(Arrays.toString(nums1c)); // [1]
    }
}
