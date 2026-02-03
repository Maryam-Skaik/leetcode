package BinarySearch.Quest;

/**
 * Problem: Sum of Square Numbers (Medium)
 * LeetCode: https://leetcode.com/problems/sum-of-square-numbers/
 *
 * Source:
 * - data-structures-and-algorithms-quest
 * - Binary Search
 *
 * Pattern:
 * - Binary Search to check for perfect squares
 *
 * Idea:
 * 1. Iterate a from 0 to sqrt(c).
 * 2. For each a, calculate target = c - a^2.
 * 3. Use binary search to check if target is a perfect square (i.e., b^2 = target exists).
 * 4. If such b exists, return true.
 * 5. If loop finishes without finding, return false.
 *
 * Time Complexity: O(sqrt(c) * log(c)) due to binary search
 * Space Complexity: O(1)
 */
public class Q3_SumOfSquareNumbers {

    public static boolean judgeSquareSum(int c) {
        // iterate a from 0 to sqrt(c)
        for (long a = 0; a * a <= c; a++) {
            long target = c - a * a;  // this is b^2
            if (isPerfectSquare(target)) {
                return true;
            }
        }
        return false;
    }

    // binary search to check if n is a perfect square
    private static boolean isPerfectSquare(long n) {
        long left = 0, right = n;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long square = mid * mid;
            if (square == n) {
                return true;
            } else if (square < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    // Test the solution
    public static void main(String[] args) {
        System.out.println(judgeSquareSum(5));  // Output: true
        System.out.println(judgeSquareSum(3));  // Output: false
        System.out.println(judgeSquareSum(25)); // Output: true (3^2 + 4^2 = 25)
        System.out.println(judgeSquareSum(2));  // Output: true (1^2 + 1^2 = 2)
        System.out.println(judgeSquareSum(1));  // Output: true (0^2 + 1^2 = 1)
    }
}
