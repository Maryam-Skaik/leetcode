package Heaps.Quest;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;

/**
 * Problem: Find K Pairs with Smallest Sums (Medium)
 * LeetCode: https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
 *
 * Source:
 * - data-structures-and-algorithms-quest
 * - Heaps / Priority Queue
 *
 * ---------------------------------------------------
 * Solution 1: Brute-force (All pairs + Sorting) [Inefficient for large inputs]
 * Pattern: Array / Sorting
 * Time Complexity: O(n * m * log(n*m))
 * Space Complexity: O(n * m)
 *
 * Solution 2: Heap-based approach (Optimal)
 * Pattern: Min-Heap / Priority Queue
 * Time Complexity: O(k log k)
 * Space Complexity: O(k)
 * ---------------------------------------------------
 */

public class HeapsI_Q2_KSmallestPairs {

    /**
     * Solution 1: Brute-force
     * Generate all pairs, sort by sum, return first k
     */
    public static List<List<Integer>> kSmallestPairs_BruteForce(int[] nums1, int[] nums2, int k) {
        List<int[]> allPairs = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                allPairs.add(new int[]{nums1[i], nums2[j]});
            }
        }

        allPairs.sort((a, b) -> (a[0] + a[1]) - (b[0] + b[1]));

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < Math.min(k, allPairs.size()); i++) {
            int[] pair = allPairs.get(i);
            result.add(Arrays.asList(pair[0], pair[1]));
        }

        return result;
    }

    /**
     * Solution 2: Heap-based (Optimal)
     * Min-Heap stores indices [i, j] and compares sums nums1[i] + nums2[j]
     */
    public static List<List<Integer>> kSmallestPairs_Heap(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) return result;

        PriorityQueue<int[]> heap = new PriorityQueue<>(
            (a, b) -> (nums1[a[0]] + nums2[a[1]]) - (nums1[b[0]] + nums2[b[1]])
        );

        // Initialize heap with first element of nums2 for first k elements of nums1
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            heap.offer(new int[]{i, 0});
        }

        while (k > 0 && !heap.isEmpty()) {
            int[] pair = heap.poll();
            int i = pair[0], j = pair[1];
            result.add(Arrays.asList(nums1[i], nums2[j]));
            k--;

            // Push next element in the row (same nums1[i]) if exists
            if (j + 1 < nums2.length) {
                heap.offer(new int[]{i, j + 1});
            }
        }

        return result;
    }

    // Test both solutions
    public static void main(String[] args) {
        int[] nums1a = {1, 7, 11};
        int[] nums2a = {2, 4, 6};
        int k1 = 3;

        int[] nums1b = {1, 1, 2};
        int[] nums2b = {1, 2, 3};
        int k2 = 2;

        System.out.println("Brute-force Solution:");
        System.out.println(kSmallestPairs_BruteForce(nums1a.clone(), nums2a.clone(), k1)); // [[1,2],[1,4],[1,6]]
        System.out.println(kSmallestPairs_BruteForce(nums1b.clone(), nums2b.clone(), k2)); // [[1,1],[1,1]]

        System.out.println("\nHeap-based Solution:");
        System.out.println(kSmallestPairs_Heap(nums1a, nums2a, k1)); // [[1,2],[1,4],[1,6]]
        System.out.println(kSmallestPairs_Heap(nums1b, nums2b, k2)); // [[1,1],[1,1]]
    }
}
