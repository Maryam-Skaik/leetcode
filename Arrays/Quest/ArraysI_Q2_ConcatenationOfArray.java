package Arrays.Quest;

/**
 * Problem: Concatenation of Array (Easy)
 *
 * Quest:
 * - data-structures-and-algorithms-quest
 * - Arrays I — Question 2
 *
 * LeetCode:
 * https://leetcode.com/problems/concatenation-of-array/
 *
 * Note:
 * This problem is identical to Q1 (LeetCode 1929).
 * It is solved again here as part of the Quest sequence.
 *
 * Pattern: Array / Iteration
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

public class ArraysI_Q2_ConcatenationOfArray {

    public static int[] getConcatenation(int[] nums) {
        int[] arr = new int[nums.length * 2];

        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
            arr[nums.length + i] = nums[i];
        }

        return arr;
    }

    // Test the solution
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 1};
        printArray(getConcatenation(nums1)); // [1, 2, 1, 1, 2, 1]

        int[] nums2 = {1, 3, 2, 1};
        printArray(getConcatenation(nums2)); // [1, 3, 2, 1, 1, 3, 2, 1]
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
