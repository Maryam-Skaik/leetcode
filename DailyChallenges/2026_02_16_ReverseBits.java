package DailyChallenges;

/**
 * Problem: Reverse Bits
 * Date: 16-02-2026
 * Difficulty: Easy
 * Pattern: Bit Manipulation
 *
 * Problem Link:
 * https://leetcode.com/problems/reverse-bits/
 *
 * Description:
 * Reverse bits of a given 32 bits signed integer.
 *
 * Given a 32-bit integer n, return the integer obtained
 * by reversing its binary representation.
 *
 * Constraints:
 * - 0 <= n <= 2^31 - 2
 * - n is even.
 *
 * Time Complexity: O(32) = O(1) — iterate through 32 bits
 * Space Complexity: O(1) — constant extra space
 */
public class _2026_02_16_ReverseBits {

    /**
     * Solution:
     * 1. Initialize result = 0.
     * 2. Repeat 32 times:
     *    - Shift result left by 1.
     *    - Extract last bit of n using (n & 1).
     *    - Add extracted bit to result.
     *    - Shift n right by 1.
     * 3. Return result.
     */
    public int reverseBits(int n) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            result <<= 1;          // Make space for next bit
            result |= (n & 1);     // Add last bit of n
            n >>= 1;               // Move to next bit
        }

        return result;
    }

    /**
     * Example main to test the solution
     */
    public static void main(String[] args) {
        _2026_02_16_ReverseBits solution = new _2026_02_16_ReverseBits();

        int n1 = 43261596;
        int n2 = 2147483644;

        System.out.println(solution.reverseBits(n1)); // 964176192
        System.out.println(solution.reverseBits(n2)); // 1073741822
    }
}
