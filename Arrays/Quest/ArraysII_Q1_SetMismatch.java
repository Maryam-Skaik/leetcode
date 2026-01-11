package Arrays.Quest;

/**
 * Problem: Set Mismatch (Easy)
 * LeetCode: https://leetcode.com/problems/set-mismatch/
 *
 * Source:
 * - data-structures-and-algorithms-quest
 * - Arrays II
 *
 * Pattern: Array / Iteration / Hashing
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

public class ArraysII_Q1_SetMismatch {

    public static int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] result = new int[2];
        boolean[] seen = new boolean[n + 1];

        // Find the duplicate number
        for (int num : nums) {
            if (seen[num]) {
                result[0] = num; // duplicate
            }
            seen[num] = true;
        }

        // Find the missing number
        for (int i = 1; i <= n; i++) {
            if (!seen[i]) {
                result[1] = i;
                break;
            }
        }

        return result;
    }

    // Test the solution
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 4};
        printArray(findErrorNums(nums1)); // [2, 3]

        int[] nums2 = {1, 1};
        printArray(findErrorNums(nums2)); // [1, 2]
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
