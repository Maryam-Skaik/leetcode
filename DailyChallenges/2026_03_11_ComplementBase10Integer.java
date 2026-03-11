package DailyChallenges;

/**
 * Problem: Complement of Base 10 Integer
 * Date: 11-03-2026
 * Difficulty: Easy
 * Pattern: Bit Manipulation / String Conversion
 *
 * Problem Link:
 * https://leetcode.com/problems/complement-of-base-10-integer/
 *
 * Key Idea:
 * 1. Convert the number to binary string.
 * 2. Flip each bit: '0' → '1', '1' → '0'.
 * 3. Convert the flipped binary string back to decimal.
 *
 * Example:
 * n = 5 → binary "101" → complement "010" → decimal 2
 *
 * Time Complexity:
 * - O(log n) for binary conversion and flipping
 *
 * Space Complexity:
 * - O(log n) for storing the binary string
 *
 */
public class _2026_03_11_ComplementBase10Integer {

    /**
     * Solution using string manipulation
     */
    public int bitwiseComplement(int n) {
        if (n == 0) return 1; // edge case

        String binaryNumber = Integer.toBinaryString(n);
        StringBuilder result = new StringBuilder();

        for (char c : binaryNumber.toCharArray()) {
            result.append(c == '0' ? '1' : '0');
        }

        return Integer.parseInt(result.toString(), 2);
    }

    /**
     * Example main to test the solution
     */
    public static void main(String[] args) {
        _2026_03_11_ComplementBase10Integer solution =
                new _2026_03_11_ComplementBase10Integer();

        int n1 = 5;   // Output: 2
        int n2 = 7;   // Output: 0
        int n3 = 10;  // Output: 5
        int n4 = 0;   // Output: 1

        System.out.println("Complement of " + n1 + " is " + solution.bitwiseComplement(n1));
        System.out.println("Complement of " + n2 + " is " + solution.bitwiseComplement(n2));
        System.out.println("Complement of " + n3 + " is " + solution.bitwiseComplement(n3));
        System.out.println("Complement of " + n4 + " is " + solution.bitwiseComplement(n4));
    }
}
