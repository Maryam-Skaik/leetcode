package DivideAndConquer.Quest;

import java.util.Arrays;

/**
 * Problem: Reverse Pairs
 * LeetCode: https://leetcode.com/problems/reverse-pairs/
 *
 * Source:
 * - data-structures-and-algorithms-quest
 * - Divide and Conquer I
 *
 * Pattern: Merge Sort + Divide and Conquer
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 *
 * Explanation:
 * - The problem asks for pairs (i, j) such that i < j and nums[i] > 2 * nums[j].
 * - Using brute force O(n^2) is too slow for large n.
 * - Merge Sort technique:
 *   1. Recursively divide the array into left and right halves.
 *   2. Count reverse pairs where left element > 2 * right element during merge.
 *   3. Merge the halves in sorted order to maintain correctness for future merges.
 * - Cast to long during multiplication to avoid integer overflow.
 */

public class Q3_ReversePairs {

    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int left, int right) {
        if (left >= right) return 0;

        int mid = left + (right - left) / 2;
        int count = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right);

        // Count reverse pairs across left and right halves
        int j = mid + 1;
        for (int i = left; i <= mid; i++) {
            while (j <= right && (long) nums[i] > 2L * nums[j]) {
                j++;
            }
            count += (j - mid - 1);
        }

        // Merge step to keep array sorted
        merge(nums, left, mid, right);
        return count;
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) L[i] = nums[left + i];
        for (int i = 0; i < n2; i++) R[i] = nums[mid + 1 + i];

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                nums[k++] = L[i++];
            } else {
                nums[k++] = R[j++];
            }
        }
        while (i < n1) nums[k++] = L[i++];
        while (j < n2) nums[k++] = R[j++];
    }

    // Test the solution
    public static void main(String[] args) {
        Q3_ReversePairs solution = new Q3_ReversePairs();

        int[] ex1 = {1, 3, 2, 3, 1};
        System.out.println("Reverse Pairs (ex1): " + solution.reversePairs(ex1)); // 2

        int[] ex2 = {2, 4, 3, 5, 1};
        System.out.println("Reverse Pairs (ex2): " + solution.reversePairs(ex2)); // 3

        int[] ex3 = {5, 4, 3, 2, 1};
        System.out.println("Reverse Pairs (ex3): " + solution.reversePairs(ex3)); // 4

        int[] ex4 = {2147483647, 2147483647, 0, 1};
        System.out.println("Reverse Pairs (ex4): " + solution.reversePairs(ex4)); // 4
    }
}
