package BinarySearch.Quest;

/**
 * Problem: Peak Index in a Mountain Array (Medium)
 * LeetCode: https://leetcode.com/problems/peak-index-in-a-mountain-array/
 *
 * Source:
 * - data-structures-and-algorithms-quest
 * - Binary Search
 *
 * Pattern:
 * - Binary Search
 *
 * Idea:
 * 1. Use binary search to find the peak element.
 * 2. If the middle element is smaller than its next element, the peak lies on the right.
 * 3. Otherwise, the peak lies on the left or is the mid element itself.
 * 4. Repeat until left and right converge to the peak index.
 * 
 * Time Complexity: O(log n) due to binary search
 * Space Complexity: O(1)
 */
public class Q1_PeakIndexInMountainArray {

    public static int peakIndexInMountainArray(int[] arr) {
        int l = 0, r = arr.length - 1;
        
        while (l < r) {
            int mid = l + (r - l) / 2;
            
            if (arr[mid] < arr[mid + 1]) {
                l = mid + 1; // peak is on the right
            } else {
                r = mid;     // peak is at mid or on the left
            }
        }
        
        // l == r is the peak index
        return l;
    }

    // Test the solution
    public static void main(String[] args) {
        int[] arr1 = {0, 1, 0};
        System.out.println(peakIndexInMountainArray(arr1));  // Output: 1

        int[] arr2 = {0, 2, 1, 0};
        System.out.println(peakIndexInMountainArray(arr2));  // Output: 1

        int[] arr3 = {0, 10, 5, 2};
        System.out.println(peakIndexInMountainArray(arr3));  // Output: 1
    }
}
