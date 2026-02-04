package BinarySearch.Quest;

/**
 * Problem: Search in Rotated Sorted Array (Medium)
 * LeetCode: https://leetcode.com/problems/search-in-rotated-sorted-array/
 *
 * Source:
 * - data-structures-and-algorithms-quest
 * - Binary Search
 *
 * Pattern:
 * - Modified Binary Search on Rotated Array
 *
 * Idea:
 * 1. Use binary search with two pointers (l, r).
 * 2. At each step, compute mid.
 * 3. If nums[mid] == target, return mid.
 * 4. Determine which half is sorted:
 *    - If nums[l] <= nums[mid], left half is sorted.
 *    - Otherwise, right half is sorted.
 * 5. Check whether the target lies within the sorted half.
 * 6. Narrow the search space accordingly.
 * 7. If target is not found, return -1.
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */
public class Q4_SearchInRotatedSortedArray {

    public static int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // LEFT half is sorted
            if (nums[l] <= nums[mid]) {
                if (nums[l] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            // RIGHT half is sorted
            else {
                if (nums[mid] < target && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }

        return -1;
    }

    // Test the solution
    public static void main(String[] args) {
        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 0)); // Output: 4
        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 3)); // Output: -1
        System.out.println(search(new int[]{1}, 0));             // Output: -1
        System.out.println(search(new int[]{1}, 1));             // Output: 0
        System.out.println(search(new int[]{3,1}, 1));           // Output: 1
    }
}
