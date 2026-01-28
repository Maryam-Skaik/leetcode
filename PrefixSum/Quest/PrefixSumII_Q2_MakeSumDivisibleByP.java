package PrefixSum.Quest;

import java.util.HashMap;

/**
 * Problem: Make Sum Divisible by P (Medium)
 * LeetCode: https://leetcode.com/problems/make-sum-divisible-by-p/
 *
 * Source:
 * - data-structures-and-algorithms-quest
 * - Prefix Sum II
 *
 * Pattern:
 * - Prefix Sum
 * - Modulo Arithmetic
 * - HashMap
 *
 * Idea:
 * If totalSum % p = r, we need to remove the smallest subarray
 * whose sum % p == r.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class PrefixSumII_Q2_MakeSumDivisibleByP {

    public static int minSubarray(int[] nums, int p) {
        long totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int remainder = (int) (totalSum % p);
        if (remainder == 0) return 0;

        // prefixMod -> last index where it appeared
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // base case

        long prefixSum = 0;
        int minLen = nums.length;

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            int curMod = (int) (prefixSum % p);

            int needed = (curMod - remainder + p) % p;

            if (map.containsKey(needed)) {
                minLen = Math.min(minLen, i - map.get(needed));
            }

            // store latest index for current modulo
            map.put(curMod, i);
        }

        return minLen == nums.length ? -1 : minLen;
    }

    // Test the solution
    public static void main(String[] args) {
        int[] nums1 = {3, 1, 4, 2};
        System.out.println(minSubarray(nums1, 6)); // 1

        int[] nums2 = {6, 3, 5, 2};
        System.out.println(minSubarray(nums2, 9)); // 2

        int[] nums3 = {1, 2, 3};
        System.out.println(minSubarray(nums3, 3)); // 0
    }
}
