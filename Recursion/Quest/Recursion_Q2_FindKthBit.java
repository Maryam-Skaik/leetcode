package Recursion.Quest;

/**
 * Problem: Find Kth Bit in Nth Binary String (Medium)
 * LeetCode: https://leetcode.com/problems/find-kth-bit-in-nth-binary-string/
 *
 * Source:
 * - data-structures-and-algorithms-quest
 * - Recursion II
 *
 * Pattern: Recursion / Divide and Conquer / Bit Manipulation
 *
 * Idea:
 * - The binary string Sn is defined recursively:
 *   S1 = "0"
 *   Si = Si-1 + "1" + reverse(invert(Si-1)) for i > 1
 * - To find the kth bit without building the entire string:
 *   1. Calculate the length of Sn.
 *   2. Identify the middle index (the "1" in the middle).
 *   3. If k is in the first half, recurse on Si-1.
 *   4. If k is the middle, return '1'.
 *   5. If k is in the second half, map k to mirrored index in Si-1, recurse, and invert the bit.
 *
 * Time Complexity: O(n) — recursion depth is n
 * Space Complexity: O(n) — recursion stack
 */

public class Recursion_Q2_FindKthBit {

    /**
     * Recursive solution to find the kth bit in nth binary string
     */
    public char findKthBit(int n, int k) {
        if (n == 1) return '0';

        int length = (1 << n) - 1;       // Length of Sn
        int mid = (length / 2) + 1;      // Middle index of Sn

        if (k == mid) {
            return '1';                  // Middle bit is always '1'
        } else if (k < mid) {
            return findKthBit(n - 1, k); // First half: recurse on previous string
        } else {
            int mirroredIndex = length - k + 1;       // Map to mirrored index in first half
            char bit = findKthBit(n - 1, mirroredIndex);
            return (bit == '0') ? '1' : '0';         // Invert the bit for second half
        }
    }

    // Test examples
    public static void main(String[] args) {
        Recursion_Q2_FindKthBit solution = new Recursion_Q2_FindKthBit();

        int n1 = 3, k1 = 1;
        int n2 = 4, k2 = 11;

        System.out.println(solution.findKthBit(n1, k1)); // "0"
        System.out.println(solution.findKthBit(n2, k2)); // "1"
    }
}
