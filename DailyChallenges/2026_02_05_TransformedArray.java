package DailyChallenges;

/**
 * Problem: Transformed Array
 * Date: 05-02-2026
 * Difficulty: Easy
 * Pattern: Circular Array + Modulo Arithmetic
 *
 * Problem Link:
 * https://leetcode.com/problems/transformed-array/
 *
 * Time Complexity:
 * O(n), where n is the length of the array.
 *
 * Space Complexity:
 * O(n), for the result array.
 */
public class _2026_02_05_TransformedArray {

    /**
     * Solution:
     * - The array is treated as circular.
     * - For each index i:
     *   - If nums[i] == 0 → result[i] = 0.
     *   - Otherwise:
     *     1. Compute steps = nums[i] % n to avoid extra full rotations.
     *     2. Move steps to the right (positive) or left (negative).
     *     3. Normalize the index using modulo to stay within bounds.
     *
     * - The expression (i + steps + n) % n ensures:
     *   - No negative indices.
     *   - Correct circular wrapping.
     */
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                result[i] = nums[i];
            } else {
                int steps = nums[i] % n;
                int newIndex = (i + steps + n) % n;
                result[i] = nums[newIndex];
            }
        }

        return result;
    }

    // Test examples
    public static void main(String[] args) {
        _2026_02_05_TransformedArray solution =
                new _2026_02_05_TransformedArray();

        int[] ex1 = {3, -2, 1, 1};
        System.out.println(java.util.Arrays.toString(
                solution.constructTransformedArray(ex1)));
        // [1, 1, 1, 3]

        int[] ex2 = {-1, 4, -1};
        System.out.println(java.util.Arrays.toString(
                solution.constructTransformedArray(ex2)));
        // [-1, -1, 4]
    }
}
