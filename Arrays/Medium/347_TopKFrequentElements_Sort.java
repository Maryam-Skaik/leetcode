package Arrays.Medium;

import java.util.*;

/**
 * Problem: Top K Frequent Elements (Medium)
 * LeetCode: https://leetcode.com/problems/top-k-frequent-elements/
 * Pattern: HashMap + Sorting by Frequency
 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 */

public class _347_TopKFrequentElements_Sort {

    public static int[] topKFrequent(int[] nums, int k) {
        // 1. Count frequency using HashMap
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // 2. Convert map entries to list and sort by frequency descending
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(freq.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());

        // 3. Collect top k keys
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = list.get(i).getKey();
        }

        return result;
    }

    // Test the solution
    public static void main(String[] args) {
        int[] nums1 = {1, 1, 1, 2, 2, 3};
        System.out.println("Top 2 frequent: " + Arrays.toString(topKFrequent(nums1, 2))); // [1, 2]

        int[] nums2 = {1};
        System.out.println("Top 1 frequent: " + Arrays.toString(topKFrequent(nums2, 1))); // [1]

        int[] nums3 = {1, 2, 1, 2, 1, 2, 3, 1, 3, 2};
        System.out.println("Top 2 frequent: " + Arrays.toString(topKFrequent(nums3, 2))); // [1, 2]
    }
}
