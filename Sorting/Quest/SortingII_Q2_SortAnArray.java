package Sorting.Quest;

/**
 * Problem: Sort an Array
 * Difficulty: Medium
 *
 * LeetCode:
 * https://leetcode.com/problems/sort-an-array/
 *
 * Source:
 * - data-structures-and-algorithms-quest
 * - Sorting II
 *
 * Pattern:
 * - Divide and Conquer
 * - Merge Sort
 *
 * Idea:
 * 1. Use Merge Sort to achieve O(n log n) time complexity.
 * 2. Recursively divide the array into two halves.
 * 3. Sort each half independently.
 * 4. Merge the two sorted halves into one sorted array.
 * 5. Avoid using any built-in sorting functions as required.
 *
 * Notes:
 * - Merge Sort is a stable sorting algorithm.
 * - It guarantees O(n log n) time complexity in all cases.
 * - Uses additional space for temporary arrays during merging.
 *
 * Time Complexity:
 * O(n log n)
 *
 * Space Complexity:
 * O(n), due to temporary arrays used in merge step.
 */
public class SortingII_Q2_SortAnArray {

    public static int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    // Merge Sort recursive function
    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            // Sort left and right halves
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            // Merge sorted halves
            merge(arr, left, mid, right);
        }
    }

    // Merge two sorted subarrays
    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data into temporary arrays
        for (int i = 0; i < n1; i++) L[i] = arr[left + i];
        for (int j = 0; j < n2; j++) R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;

        // Merge temporary arrays back into arr
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        // Copy remaining elements
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    // Test the solution
    public static void main(String[] args) {

        int[] ex1 = {5, 2, 3, 1};
        sortArray(ex1);
        // Output: [1, 2, 3, 5]
        for (int x : ex1) System.out.print(x + " ");
        System.out.println();

        int[] ex2 = {5, 1, 1, 2, 0, 0};
        sortArray(ex2);
        // Output: [0, 0, 1, 1, 2, 5]
        for (int x : ex2) System.out.print(x + " ");
    }
}
