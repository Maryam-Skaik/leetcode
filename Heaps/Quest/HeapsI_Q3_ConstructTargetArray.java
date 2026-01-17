package Heaps.Quest;

import java.util.PriorityQueue;

/**
 * Problem: Construct Target Array With Multiple Sums (Hard)
 * LeetCode: https://leetcode.com/problems/construct-target-array-with-multiple-sums/
 *
 * Source:
 * - data-structures-and-algorithms-quest
 * - Heaps / Priority Queue
 *
 * ---------------------------------------------------
 * Solution: Max-Heap + Reverse Construction
 * Idea:
 * - Always work with the largest element in target.
 * - Reverse engineer how it could be formed: max element comes from sum of others + previous value.
 * - Use modulus to jump to previous value to avoid repeated subtraction.
 * 
 * Time Complexity: O(n log n * log(maxValue))
 * Space Complexity: O(n)
 * ---------------------------------------------------
 */

public class HeapsI_Q3_ConstructTargetArray {

    /**
     * Solution: Max-Heap + Modulus Trick (Optimal)
     */
    public static boolean isPossible(int[] target) {
        PriorityQueue<Long> pq = new PriorityQueue<>((a, b) -> Long.compare(b, a));
        long totalSum = 0;

        for (int num : target) {
            pq.offer((long) num);
            totalSum += num;
        }

        while (true) {
            long max = pq.poll();
            long sumRest = totalSum - max;

            // If max is 1 or the rest sum is 1, all can become 1 → done
            if (max == 1 || sumRest == 1) return true;

            // Impossible cases
            if (sumRest == 0 || max <= sumRest) return false;

            long prev = max % sumRest;

            // If prev is 0 or unchanged → impossible
            if (prev == 0) return false;

            pq.offer(prev);
            totalSum = sumRest + prev;
        }
    }

    // Test cases
    public static void main(String[] args) {
        int[] target1 = {9, 3, 5};
        int[] target2 = {1, 1, 1, 2};
        int[] target3 = {8, 5};
        int[] target4 = {1, 1000000000}; // Large numbers
        int[] target5 = {1, 1, 1, 1, 1}; // All ones

        System.out.println("Test Case 1: " + isPossible(target1)); // true
        System.out.println("Test Case 2: " + isPossible(target2)); // false
        System.out.println("Test Case 3: " + isPossible(target3)); // true
        System.out.println("Test Case 4: " + isPossible(target4)); // true
        System.out.println("Test Case 5: " + isPossible(target5)); // true
    }
}
