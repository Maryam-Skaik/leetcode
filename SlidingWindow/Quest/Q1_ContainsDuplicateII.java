package SlidingWindow.Quest;

import java.util.HashSet;

/**
 * Problem: Contains Duplicate II (Easy)
 * LeetCode: https://leetcode.com/problems/contains-duplicate-ii/
 *
 * Source:
 * - data-structures-and-algorithms-quest
 * - Sliding Window
 *
 * Pattern:
 * - Sliding Window + HashSet
 *
 * Idea:
 * 1. Use a sliding window of size at most k.
 * 2. Maintain a HashSet to store elements inside the current window.
 * 3. For each element:
 *    - If it already exists in the set → duplicate found within distance k.
 *    - Add the element to the set.
 *    - If window size exceeds k, remove the element that is k positions behind.
 * 4. Continue until a duplicate is found or array ends.
 *
 * Time Complexity: O(n)
 *   - Each element is added and removed at most once.
 *
 * Space Complexity: O(min(n, k))
 *   - HashSet stores at most k elements.
 */
public class Q1_ContainsDuplicateII {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> window = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {

            // Duplicate found within window
            if (window.contains(nums[i])) {
                return true;
            }

            window.add(nums[i]);

            // Maintain window size <= k
            if (window.size() > k) {
                window.remove(nums[i - k]);
            }
        }

        return false;
    }

    // Test the solution
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 1};
        System.out.println(containsNearbyDuplicate(nums1, 3)); // true

        int[] nums2 = {1, 0, 1, 1};
        System.out.println(containsNearbyDuplicate(nums2, 1)); // true

        int[] nums3 = {1, 2, 3, 1, 2, 3};
        System.out.println(containsNearbyDuplicate(nums3, 2)); // false
    }
}
