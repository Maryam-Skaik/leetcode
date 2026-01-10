package Arrays.Quest;

/**
 * Problem: Shuffle the Array (Easy)
 * LeetCode: https://leetcode.com/problems/shuffle-the-array/
 *
 * Source:
 * - data-structures-and-algorithms-quest
 * - Arrays I
 *
 * Pattern: Array / Two Pointers
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

public class ArraysI_Q2_ShuffleTheArray {

    public static int[] shuffle(int[] nums, int n) {
        int[] result = new int[nums.length];
        int i = 0, j = n, k = 0;

        while (k < nums.length) {
            result[k++] = nums[i++];
            result[k++] = nums[j++];
        }

        return result;
    }

    // Test the solution
    public static void main(String[] args) {
        int[] nums1 = {2, 5, 1, 3, 4, 7};
        printArray(shuffle(nums1, 3)); // [2, 3, 5, 4, 1, 7]

        int[] nums2 = {1, 2, 3, 4, 4, 3, 2, 1};
        printArray(shuffle(nums2, 4)); // [1, 4, 2, 3, 3, 2, 4, 1]

        int[] nums3 = {1, 1, 2, 2};
        printArray(shuffle(nums3, 2)); // [1, 2, 1, 2]
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
