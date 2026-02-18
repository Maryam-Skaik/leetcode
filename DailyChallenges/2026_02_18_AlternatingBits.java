package DailyChallenges;

/**
 * Problem: Binary Number with Alternating Bits
 * Date: 18-02-2026
 * Difficulty: Easy
 * Pattern: Bit Manipulation
 *
 * Special Note:
 * Today (18-02-2026) is the first day of Ramadan 🌙
 *
 * Problem Link:
 * https://leetcode.com/problems/binary-number-with-alternating-bits/
 *
 * Description:
 * Given a positive integer n, check whether it has alternating bits.
 * Two adjacent bits must always have different values.
 *
 * Constraints:
 * - 1 <= n <= 2^31 - 1
 *
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */
public class _2026_02_18_AlternatingBits {

    /**
     * Solution (Bit Manipulation Trick):
     * 1. Shift n right by 1.
     * 2. XOR original number with shifted number.
     * 3. If bits were alternating, result becomes all 1s.
     * 4. Check if result is of form 111... using:
     *      x & (x + 1) == 0
     */
    public boolean hasAlternatingBits(int n) {
        int x = n ^ (n >> 1);
        return (x & (x + 1)) == 0;
    }

    /**
     * Example main to test the solution
     */
    public static void main(String[] args) {
        _2026_02_18_AlternatingBits solution = new _2026_02_18_AlternatingBits();

        int n1 = 5;   // 101 -> true
        int n2 = 7;   // 111 -> false
        int n3 = 11;  // 1011 -> false

        System.out.println("n = " + n1 + " -> " + solution.hasAlternatingBits(n1));
        System.out.println("n = " + n2 + " -> " + solution.hasAlternatingBits(n2));
        System.out.println("n = " + n3 + " -> " + solution.hasAlternatingBits(n3));
    }
}
