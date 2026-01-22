package Hash.Quest;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Problem: First Missing Positive (Hard)
 * LeetCode: https://leetcode.com/problems/first-missing-positive/
 *
 * Source:
 * - data-structures-and-algorithms-quest
 * - Hash I
 *
 * Idea:
 * 1) Sorting Approach:
 *    - Sort the array.
 *    - Track the smallest positive number n expected.
 *    - Return the first gap.
 *    - Time Complexity: O(n log n)
 *    - Space Complexity: O(1)
 *
 * 2) Hashing Approach:
 *    - Store all positive numbers in a HashSet.
 *    - Check from 1 to n+1 which number is missing.
 *    - Time Complexity: O(n)
 *    - Space Complexity: O(n)
 */

public class HashI_Q3_FirstMissingPositive {

    // ---------------- Sorting Approach ----------------
    public static int firstMissingPositive_Sort(int[] nums) {
        Arrays.sort(nums);
        int n = 1;
        for (int num : nums) {
            if (num == n) n++;
            else if (num > n) return n;
        }
        return n;
    }

    // ---------------- Hashing Approach ----------------
    public static int firstMissingPositive_Hash(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num > 0) set.add(num);
        }
        for (int i = 1; i <= nums.length + 1; i++) {
            if (!set.contains(i)) return i;
        }
        return 1; // unreachable
    }

    // ---------------- Test ----------------
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 0};
        int[] nums2 = {3, 4, -1, 1};
        int[] nums3 = {7, 8, 9, 11, 12};

        System.out.println("=== Sorting Approach ===");
        System.out.println(firstMissingPositive_Sort(nums1)); // 3
        System.out.println(firstMissingPositive_Sort(nums2)); // 2
        System.out.println(firstMissingPositive_Sort(nums3)); // 1

        System.out.println("=== Hashing Approach ===");
        System.out.println(firstMissingPositive_Hash(nums1)); // 3
        System.out.println(firstMissingPositive_Hash(nums2)); // 2
        System.out.println(firstMissingPositive_Hash(nums3)); // 1
    }
}
