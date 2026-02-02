package BinarySearch.Quest;

/**
 * Problem: Binary Search (Easy)
 * LeetCode: https://leetcode.com/problems/binary-search/
 *
 * Source:
 * - data-structures-and-algorithms-quest
 * - Binary Search
 *
 * Pattern:
 * - Binary Search
 *
 * Idea:
 * 1. Use binary search on a sorted array to find the target.
 * 2. Compare the middle element with the target:
 *    - If equal, return the mid index.
 *    - If middle element is less than target, search in the right half.
 *    - If middle element is greater than target, search in the left half.
 * 3. Repeat until left index exceeds right index.
 * 
 * Time Complexity: O(log n) due to binary search
 * Space Complexity: O(1)
 */
public class Q2_BinarySearch {

    public static int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] == target) {
                return mid; // Found the target
            } else if (nums[mid] < target) {
                l = mid + 1; // Search right half
            } else {
                r = mid - 1; // Search left half
            }
        }

        // Target not found
        return -1;
    }

    // Test the solution
    public static void main(String[] args) {
        int[] nums1 = {-1, 0, 3, 5, 9, 12};
        System.out.println(search(nums1, 9));  // Output: 4

        int[] nums2 = {-1, 0, 3, 5, 9, 12};
        System.out.println(search(nums2, 2));  // Output: -1

        int[] nums3 = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(search(nums3, 5));  // Output: 4
    }
}
