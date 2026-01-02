package DailyChallenges;

import java.util.*;

/**
 * Problem: N Repeated Element in Size 2N Array
 * Date: 02-01-2026
 * Difficulty: Easy
 * Pattern: Hashing / Set / Array Traversal
 *
 * Problem Link:
 * https://leetcode.com/problems/n-repeated-element-in-size-2n-array/
 *
 * Time Complexity:
 * HashMap solution: O(n)
 * HashSet solution: O(n)
 *
 * Space Complexity:
 * HashMap solution: O(n)
 * HashSet solution: O(n)
 */

public class _2026_01_02_RepeatedN {

    /**
     * Naive solution using HashMap
     * Counts occurrences of each number
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static int repeatedNTimesHashMap(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // Count occurrences
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Find the number that repeats n times
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                return entry.getKey();
            }
        }

        return -1; // Should never happen
    }

    /**
     * Optimized solution using HashSet
     * Finds the repeated element in a single pass
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static int repeatedNTimesHashSet(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (!set.add(num)) return num;
        }

        return nums[nums.length - 1]; // Fallback (guaranteed repeated element)
    }

    // Test examples
    public static void main(String[] args) {
        int[] ex1 = {1, 2, 3, 3};
        int[] ex2 = {2, 1, 2, 5, 3, 2};
        int[] ex3 = {5, 1, 5, 2, 5, 3, 5, 4};

        System.out.println("HashMap solution:");
        System.out.println(repeatedNTimesHashMap(ex1)); // 3
        System.out.println(repeatedNTimesHashMap(ex2)); // 2
        System.out.println(repeatedNTimesHashMap(ex3)); // 5

        System.out.println("\nHashSet solution:");
        System.out.println(repeatedNTimesHashSet(ex1)); // 3
        System.out.println(repeatedNTimesHashSet(ex2)); // 2
        System.out.println(repeatedNTimesHashSet(ex3)); // 5
    }
}
