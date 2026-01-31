package Sorting.Quest;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/**
 * Problem: Merge Intervals (Medium)
 * LeetCode: https://leetcode.com/problems/merge-intervals/
 *
 * Source:
 * - data-structures-and-algorithms-quest
 * - Sorting
 *
 * Pattern:
 * - Sorting
 * - Interval Merging (Greedy)
 *
 * Idea:
 * 1. Sort all intervals by their start value.
 * 2. Initialize the first interval as the current interval.
 * 3. Traverse the remaining intervals:
 *    - If the next interval overlaps with the current one
 *      (next.start <= current.end), merge them by updating the end.
 *    - Otherwise, store the current interval and move to the next one.
 * 4. Add the last processed interval to the result.
 *
 * Time Complexity: O(n log n)
 * - Sorting the intervals dominates the complexity.
 *
 * Space Complexity: O(n)
 * - Additional space is used to store the merged intervals.
 */
public class SortingQ3_MergeIntervals {

    public static int[][] merge(int[][] intervals) {
        // Step 1: Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> merged = new ArrayList<>();

        // Step 2: Initialize with the first interval
        int[] current = intervals[0];

        // Step 3: Traverse and merge overlapping intervals
        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];

            if (next[0] <= current[1]) {
                // Overlapping intervals → merge
                current[1] = Math.max(current[1], next[1]);
            } else {
                // No overlap → save current and move forward
                merged.add(current);
                current = next;
            }
        }

        // Step 4: Add the last interval
        merged.add(current);

        return merged.toArray(new int[merged.size()][]);
    }

    // Test the solution
    public static void main(String[] args) {
        int[][] ex1 = {{1,3},{2,6},{8,10},{15,18}};
        System.out.println(Arrays.deepToString(merge(ex1)));
        // [[1, 6], [8, 10], [15, 18]]

        int[][] ex2 = {{1,4},{4,5}};
        System.out.println(Arrays.deepToString(merge(ex2)));
        // [[1, 5]]

        int[][] ex3 = {{4,7},{1,4}};
        System.out.println(Arrays.deepToString(merge(ex3)));
        // [[1, 7]]
    }
}
