package Sorting.Quest;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/**
 * Problem: Minimum Absolute Difference (Easy)
 * LeetCode: https://leetcode.com/problems/minimum-absolute-difference/
 *
 * Source:
 * - data-structures-and-algorithms-quest
 * - Sorting
 *
 * Pattern:
 * - Sorting
 * - Pair Comparison
 *
 * Idea:
 * 1. Sort the array first to bring the elements with the minimum absolute difference next to each other.
 * 2. Calculate the minimum absolute difference between consecutive elements.
 * 3. Traverse the array and collect pairs with the minimum absolute difference.
 * 
 * Time Complexity: O(n log n) due to sorting
 * Space Complexity: O(n) due to the additional list to store pairs
 */
public class SortingQ1_MinimumAbsoluteDifference {

    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);  // Sort the array to ensure the smallest difference is between consecutive elements

        int min = Integer.MAX_VALUE;

        // Step 1: Find the minimum absolute difference between consecutive elements
        for (int i = 0; i < arr.length - 1; i++) {
            min = Math.min(min, arr[i + 1] - arr[i]);
        }

        // Step 2: Collect all pairs with the minimum absolute difference
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] == min) {
                List<Integer> pair = new ArrayList<>();
                pair.add(arr[i]);
                pair.add(arr[i + 1]);
                result.add(pair);
            }
        }

        return result;
    }

    // Test the solution
    public static void main(String[] args) {
        // Test cases for Minimum Absolute Difference
        int[] arr1 = {4, 2, 1, 3};
        System.out.println(minimumAbsDifference(arr1));  // Output: [[1, 2], [2, 3], [3, 4]]

        int[] arr2 = {1, 3, 6, 10, 15};
        System.out.println(minimumAbsDifference(arr2));  // Output: [[1, 3]]

        int[] arr3 = {3, 8, -10, 23, 19, -4, -14, 27};
        System.out.println(minimumAbsDifference(arr3));  // Output: [[-14, -10], [19, 23], [23, 27]]
    }
}
