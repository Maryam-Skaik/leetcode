package Arrays.Quest;

/**
 * Problem: Max Consecutive Ones (Easy)
 * LeetCode: https://leetcode.com/problems/max-consecutive-ones/
 *
 * Source:
 * - data-structures-and-algorithms-quest
 * - Arrays I
 *
 * Pattern: Array / Sliding Window
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class ArraysI_Q3_MaxConsecutiveOnes {

    public static int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int maxCount = 0;

        for (int num : nums) {
            if (num == 1) {
                count++;
                maxCount = Math.max(maxCount, count);
            } else {
                count = 0;
            }
        }

        return maxCount;
    }

    // Test the solution
    public static void main(String[] args) {
        int[] nums1 = {1, 1, 0, 1, 1, 1};
        System.out.println(findMaxConsecutiveOnes(nums1)); // 3

        int[] nums2 = {1, 0, 1, 1, 0, 1};
        System.out.println(findMaxConsecutiveOnes(nums2)); // 2
    }
}
