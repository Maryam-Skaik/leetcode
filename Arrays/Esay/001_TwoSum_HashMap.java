package Arrays.Easy;

import java.util.HashMap;
import java.util.Arrays;

/**
 * Problem: Two Sum (Easy)
 * LeetCode: https://leetcode.com/problems/two-sum/
 * Pattern: HashMap / Complement
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

public class _001_TwoSum_HashMap {

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    // Test the solution
    public static void main(String[] args) {
        int[] nums1 = {2,7,11,15};
        int target1 = 9;
        System.out.println(Arrays.toString(twoSum(nums1, target1))); // [0,1]

        int[] nums2 = {3,2,4};
        int target2 = 6;
        System.out.println(Arrays.toString(twoSum(nums2, target2))); // [1,2]

        int[] nums3 = {3,3};
        int target3 = 6;
        System.out.println(Arrays.toString(twoSum(nums3, target3))); // [0,1]
    }
}
