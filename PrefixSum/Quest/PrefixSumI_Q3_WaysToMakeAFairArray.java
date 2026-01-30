package PrefixSum.Quest;

import java.util.*;

/**
 * Problem: Ways to Make a Fair Array (Medium)
 * LeetCode: https://leetcode.com/problems/ways-to-make-a-fair-array/
 *
 * Source:
 * - data-structures-and-algorithms-quest
 * - Prefix Sum II
 *
 * Pattern:
 * - Prefix Sum
 * - Left and Right Sum Calculation
 *
 * Idea:
 * We are asked to remove an element from the array such that the sum of elements at even indices equals the sum of elements at odd indices in the resulting array.
 * We can solve this by calculating the total even and odd sums of the array, and then for each index, calculate the left and right sums dynamically.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class PrefixSumI_Q3_WaysToMakeAFairArray {

    public static int waysToMakeFair(int[] nums) {
        int n = nums.length;
        
        // Calculate total evenSum and oddSum for the whole array
        int totalEvenSum = 0, totalOddSum = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                totalEvenSum += nums[i];
            } else {
                totalOddSum += nums[i];
            }
        }

        // Variables to track the left side sums
        int leftEvenSum = 0, leftOddSum = 0;
        int count = 0;

        // Iterate through each element and calculate the sums after removal
        for (int i = 0; i < n; i++) {
            // Calculate right side sums by subtracting the left sums
            int rightEvenSum = totalEvenSum - leftEvenSum;
            int rightOddSum = totalOddSum - leftOddSum;

            // Adjust the right sums based on whether we remove an even or odd indexed element
            if (i % 2 == 0) {
                rightEvenSum -= nums[i];  // If i is even, subtract from the right even sum
            } else {
                rightOddSum -= nums[i];   // If i is odd, subtract from the right odd sum
            }

            // Now check if the sums are equal after removing index i
            if (leftEvenSum + rightOddSum == leftOddSum + rightEvenSum) {
                count++;
            }

            // Update the left side sums for the next iteration
            if (i % 2 == 0) {
                leftEvenSum += nums[i];
            } else {
                leftOddSum += nums[i];
            }
        }

        return count;
    }

    // Test the solution
    public static void main(String[] args) {
        // Test cases for Ways to Make a Fair Array
        int[] nums1 = {2, 1, 6, 4};
        System.out.println(waysToMakeFair(nums1)); // Output: 1

        int[] nums2 = {1, 1, 1};
        System.out.println(waysToMakeFair(nums2)); // Output: 3

        int[] nums3 = {1, 2, 3};
        System.out.println(waysToMakeFair(nums3)); // Output: 0
    }
}
