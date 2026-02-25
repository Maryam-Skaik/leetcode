package DailyChallenges;

import java.util.Arrays;

/**
 * Problem: Sort Integers by The Number of 1 Bits
 * Date: 25-02-2026
 * Difficulty: Easy
 * Pattern: Sorting / Bit Manipulation
 *
 * Problem Link:
 * https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/
 *
 * Description:
 * Given an integer array arr, sort the integers in ascending order by 
 * the number of 1's in their binary representation. 
 * If two numbers have the same number of 1's, sort them by value.
 *
 * Constraints:
 * - 1 <= arr.length <= 500
 * - 0 <= arr[i] <= 10^4
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(n) (for boxing int[] to Integer[])
 */
public class _2026_02_25_SortByBits {

    /**
     * Solution:
     * 1. Convert int[] to Integer[] to use custom comparator.
     * 2. Sort using bit count as primary key, value as secondary key.
     * 3. Convert back to int[] and return.
     */
    public int[] sortByBits(int[] arr) {
        // Box int[] to Integer[] for custom sorting
        Integer[] boxed = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        // Sort by number of 1s in binary, then by value
        Arrays.sort(boxed, (a, b) -> {
            int countA = Integer.bitCount(a);
            int countB = Integer.bitCount(b);
            if (countA != countB) return countA - countB;
            return a - b; // tie-breaker
        });

        // Convert back to int[]
        for (int i = 0; i < arr.length; i++) arr[i] = boxed[i];
        return arr;
    }

    /**
     * Example main to test the solution
     */
    public static void main(String[] args) {
        _2026_02_25_SortByBits solution = new _2026_02_25_SortByBits();

        int[] arr1 = {0, 1, 2, 3, 4, 5, 6, 7, 8}; 
        int[] arr2 = {1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1};

        System.out.println("Input: " + Arrays.toString(arr1));
        System.out.println("Output: " + Arrays.toString(solution.sortByBits(arr1)));

        System.out.println("Input: " + Arrays.toString(arr2));
        System.out.println("Output: " + Arrays.toString(solution.sortByBits(arr2)));
    }
}
