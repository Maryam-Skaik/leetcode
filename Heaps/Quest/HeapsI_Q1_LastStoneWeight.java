package Heaps.Quest;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Collections;

/**
 * Problem: Last Stone Weight (Easy)
 * LeetCode: https://leetcode.com/problems/last-stone-weight/
 *
 * Source:
 * - data-structures-and-algorithms-quest
 * - Arrays I / Heaps I
 *
 * ---------------------------------------------------
 * Solution 1: Array + Sorting (Logical Size Technique)
 * Pattern: Array / In-place Simulation
 * Time Complexity: O(n^2 log n)
 * Space Complexity: O(1)
 *
 * Solution 2: Heap (Max-Heap / Priority Queue)
 * Pattern: Heap / Greedy
 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 * ---------------------------------------------------
 */

public class HeapsI_Q1_LastStoneWeight {

    /**
     * Solution 1: Array-based approach
     * Uses sorting and logical size (capacity)
     */
    public static int lastStoneWeight_Array(int[] stones) {
        if (stones.length == 1) return stones[0];

        Arrays.sort(stones);
        int capacity = stones.length - 1;

        while (capacity > 0) {
            int destroyed = stones[capacity] - stones[capacity - 1];

            stones[capacity - 1] = destroyed;
            capacity--;

            if (destroyed == 0) capacity--;

            Arrays.sort(stones, 0, capacity + 1);
        }

        return stones[0];
    }

    /**
     * Solution 2: Heap-based approach
     * Uses a Max-Heap to always extract the heaviest stones
     */
    public static int lastStoneWeight_Heap(int[] stones) {
        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Collections.reverseOrder());

        for (int stone : stones) {
            maxHeap.add(stone);
        }

        while (maxHeap.size() > 1) {
            int y = maxHeap.poll(); // heaviest
            int x = maxHeap.poll(); // second heaviest

            if (y != x) {
                maxHeap.add(y - x);
            }
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }

    // Test both solutions
    public static void main(String[] args) {
        int[] stones1 = {2, 7, 4, 1, 8, 1};
        int[] stones2 = {1};

        System.out.println("Array Solution:");
        System.out.println(lastStoneWeight_Array(stones1.clone())); // 1
        System.out.println(lastStoneWeight_Array(stones2.clone())); // 1

        System.out.println("\nHeap Solution:");
        System.out.println(lastStoneWeight_Heap(stones1)); // 1
        System.out.println(lastStoneWeight_Heap(stones2)); // 1
    }
}
