package DailyChallenges;

import java.util.*;

/**
 * Problem: Sum of Four Divisors
 * Date: 04-01-2026
 * Difficulty: Medium
 * Pattern: Math / Divisors Counting
 *
 * Problem Link:
 * https://leetcode.com/problems/sum-of-four-divisors/
 *
 * Time Complexity:
 * O(n * sqrt(max(nums))) where n = nums.length
 *
 * Space Complexity:
 * O(1)
 */

public class _2026_01_04_FourDivisors {

    /**
     * Solution:
     * For each number, check all divisors up to sqrt(n)
     * Count divisors and sum them.
     * If a number has exactly 4 divisors, add its sum to the total.
     */
    public static int sumFourDivisors(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += sumIfFourDivisors(num);
        }
        return sum;
    }

    /**
     * Helper method:
     * Returns the sum of divisors if the number has exactly 4 divisors
     * Otherwise, returns 0
     */
    private static int sumIfFourDivisors(int n) {
        int sum = 1 + n;
        int count = 2; // 1 and n

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                if (i * i == n) {
                    sum += i;
                    count++;
                } else {
                    sum += i + n / i;
                    count += 2;
                }
            }
            if (count > 4) return 0; // early exit
        }

        return (count == 4) ? sum : 0;
    }

    // Test examples
    public static void main(String[] args) {
        int[] ex1 = {21, 4, 7};
        int[] ex2 = {21, 21};
        int[] ex3 = {1, 2, 3, 4, 5};

        System.out.println("Example 1 Output: " + sumFourDivisors(ex1)); // 32
        System.out.println("Example 2 Output: " + sumFourDivisors(ex2)); // 64
        System.out.println("Example 3 Output: " + sumFourDivisors(ex3)); // 0
    }
}
