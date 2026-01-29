package Arrays.Easy;

/**
 * Problem: Transform Array by Parity (Easy)
 * LeetCode: https://leetcode.com/problems/transform-array-by-parity/
 * Pattern: Array / Counting
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

public class _3467_TransformArrayByParity {

    public static int[] transformArray(int[] nums) {
        int oddcounter = 0;

        // Count odd numbers
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 != 0) oddcounter ++;
        }

        int[] result = new int[nums.length];

        // Starting index where 1s should begin
        int n = nums.length - oddcounter;

        // Fill odd positions with 1
        for (int i = n; i < nums.length; i++) {
            result[i] = 1;
        }

        return result;
    }

    // Test the solution
    public static void main(String[] args) {
        int[] nums1 = {4, 3, 2, 1};
        print(transformArray(nums1)); // [0, 0, 1, 1]

        int[] nums2 = {1, 5, 1, 4, 2};
        print(transformArray(nums2)); // [0, 0, 1, 1, 1]
    }

    // Helper method to print array
    private static void print(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}
