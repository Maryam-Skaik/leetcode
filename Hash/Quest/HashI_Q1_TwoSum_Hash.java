package Hash.Quest;

import java.util.HashMap;

/**
 * Problem: Two Sum (Easy)
 * LeetCode: https://leetcode.com/problems/two-sum/
 *
 * Source:
 * - data-structures-and-algorithms-quest
 * - Hash I
 *
 * Pattern: Hashing (HashMap) + Single Pass
 *
 * Idea:
 * - While iterating, store each number with its index in a HashMap.
 * - For each number nums[i], check if (target - nums[i]) already exists.
 * - If yes, return the stored index and current index.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

public class HashI_Q1_TwoSum_Hash {

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            map.put(nums[i], i);
        }

        // According to the problem, one valid answer always exists
        return new int[]{};
    }

    // Test the solution
    public static void main(String[] args) {
        int[] nums1 = {2, 7, 11, 15};
        printArray(twoSum(nums1, 9)); // [0, 1]

        int[] nums2 = {3, 2, 4};
        printArray(twoSum(nums2, 6)); // [1, 2]

        int[] nums3 = {3, 3};
        printArray(twoSum(nums3, 6)); // [0, 1]
    }

    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}
