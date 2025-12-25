package Arrays.Medium;

import java.util.*;

/**
 * Problem: 3Sum (Medium)
 * LeetCode: https://leetcode.com/problems/3sum/
 * Pattern: Two Pointers
 * Time Complexity: O(n^2)
 * Space Complexity: O(1) extra space (ignoring output list)
 */

public class _015_ThreeSum_TwoPointers {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sort array for two-pointer approach
        
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // Skip duplicates
            
            int left = i + 1;
            int right = nums.length - 1;
            int target = -nums[i];
            
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    while (left < right && nums[left] == nums[left + 1]) left++; // Skip duplicates
                    while (left < right && nums[right] == nums[right - 1]) right--; // Skip duplicates
                    
                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        
        return result;
    }

    // Test the solution
    public static void main(String[] args) {
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        System.out.println("Triplets: " + threeSum(nums1)); // [[-1, -1, 2], [-1, 0, 1]]

        int[] nums2 = {0, 1, 1};
        System.out.println("Triplets: " + threeSum(nums2)); // []

        int[] nums3 = {0, 0, 0};
        System.out.println("Triplets: " + threeSum(nums3)); // [[0, 0, 0]]
    }
}
