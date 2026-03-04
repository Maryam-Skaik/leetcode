package DailyChallenges;

/**
 * Problem: Find Kth Bit in Nth Binary String
 * Date: 03-03-2026
 * Difficulty: Medium
 * Pattern: Recursion / Divide & Conquer / Binary Construction
 *
 * Special Note:
 * 03-03-2026 — A beautifully symmetric date ✨
 * Perfect match for this problem, which is built entirely on symmetry.
 *
 * Problem Link:
 * https://leetcode.com/problems/find-kth-bit-in-nth-binary-string/
 *
 * Description:
 * The binary string Sn is defined recursively:
 *
 * S1 = "0"
 * Si = Si-1 + "1" + reverse(invert(Si-1))   for i > 1
 *
 * Return the kth bit in Sn.
 *
 * Constraints:
 * - 1 <= n <= 20
 * - 1 <= k <= 2^n - 1
 *
 * Key Observations:
 * - Length of Sn = (2^n) - 1
 * - The middle element is always '1'
 * - The second half is a mirrored and inverted version of the first half
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n) (recursion stack)
 */
public class _2026_03_03_FindKthBit {

    /**
     * Solution Idea:
     *
     * 1. Base case:
     *      If n == 1 → return '0'
     *
     * 2. Compute total length:
     *      length = (2^n) - 1
     *
     * 3. Find middle index:
     *      mid = length / 2 + 1
     *
     * 4. Cases:
     *      - If k == mid → return '1'
     *      - If k < mid → same as S(n-1) at position k
     *      - If k > mid → mirror index in first half,
     *                     then invert the result
     */
    public char findKthBit(int n, int k) {

        // Base case
        if (n == 1) return '0';

        int length = (1 << n) - 1;
        int mid = (length / 2) + 1;

        if (k == mid) {
            return '1';
        }
        else if (k < mid) {
            return findKthBit(n - 1, k);
        }
        else {
            int mirroredIndex = length - k + 1;
            char bit = findKthBit(n - 1, mirroredIndex);

            // Invert the mirrored result
            return (bit == '0') ? '1' : '0';
        }
    }

    /**
     * Example main to test the solution
     */
    public static void main(String[] args) {

        _2026_03_03_FindKthBit solution = new _2026_03_03_FindKthBit();

        System.out.println("n=3, k=1 → " + solution.findKthBit(3, 1));  // Expected: 0
        System.out.println("n=4, k=11 → " + solution.findKthBit(4, 11)); // Expected: 1
    }
}
