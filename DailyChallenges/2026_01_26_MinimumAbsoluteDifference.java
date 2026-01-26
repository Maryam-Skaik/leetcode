package DailyChallenges;

/**
 * Problem: Minimum Absolute Difference
 * Date: 26-01-2026
 * Difficulty: Easy
 * Pattern: Sorting
 *
 * Problem Link:
 * https://leetcode.com/problems/minimum-absolute-difference/
 *
 * Time Complexity:
 * O(n log n), where n = arr.length, due to sorting.
 *
 * Space Complexity:
 * O(n), for storing the resulting list of pairs.
 */

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class _2026_01_26_MinimumAbsoluteDifference {

    /**
     * Solution:
     * - Sort the array.
     * - First pass: find the minimum difference between adjacent elements.
     * - Second pass: collect all adjacent pairs with this minimum difference.
     * - Sorted order guarantees pairs are returned in ascending order.
     */
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            if ((arr[i + 1] - arr[i]) < min)
                min = arr[i + 1] - arr[i];
        }

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i++) {
            if ((arr[i + 1] - arr[i]) == min) {
                List<Integer> l = new ArrayList<>();
                l.add(arr[i]);
                l.add(arr[i + 1]);
                list.add(l);
            }
        }

        return list;
    }

    // Test examples
    public static void main(String[] args) {
        _2026_01_26_MinimumAbsoluteDifference solution =
                new _2026_01_26_MinimumAbsoluteDifference();

        int[] ex1 = {4, 2, 1, 3};
        System.out.println(solution.minimumAbsDifference(ex1));
        // [[1, 2], [2, 3], [3, 4]]

        int[] ex2 = {1, 3, 6, 10, 15};
        System.out.println(solution.minimumAbsDifference(ex2));
        // [[1, 3]]

        int[] ex3 = {3, 8, -10, 23, 19, -4, -14, 27};
        System.out.println(solution.minimumAbsDifference(ex3));
        // [[-14, -10], [19, 23], [23, 27]]
    }
}
