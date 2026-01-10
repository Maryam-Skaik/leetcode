package Arrays.Quest;

/**
 * Problem: Concatenation of Array (Easy)
 * LeetCode: https://leetcode.com/problems/concatenation-of-array/
 *
 * Source:
 * - data-structures-and-algorithms-quest
 * - Arrays I
 *
 * Pattern: Array / Iteration
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

public class ArraysI_Q1_ConcatenationOfArray {

    public static int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2 * n];

        for (int i = 0; i < n; i++) {
            ans[i] = nums[i];
            ans[i + n] = nums[i];
        }

        return ans;
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
