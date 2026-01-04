package Math.Easy;

import java.util.Arrays;

/**
 * Problem: Plus One (Easy)
 * LeetCode: https://leetcode.com/problems/plus-one/
 * Pattern: Array / Carry Handling
 * Time Complexity: O(n)
 * Space Complexity: O(1) or O(n) if new array is created
 */

public class _066_PlusOne {

    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        
        // Start from the last digit
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i] += 1;
                return digits; // no carry, done
            }
            digits[i] = 0; // carry over
        }
        
        // If all digits were 9, create a new array with 1 at the front
        int[] newDigits = new int[n + 1];
        newDigits[0] = 1;
        return newDigits;
    }

    // Test the solution
    public static void main(String[] args) {
        int[] digits1 = {1, 2, 3};
        System.out.println(Arrays.toString(plusOne(digits1))); // [1,2,4]

        int[] digits2 = {4, 3, 2, 1};
        System.out.println(Arrays.toString(plusOne(digits2))); // [4,3,2,2]

        int[] digits3 = {9};
        System.out.println(Arrays.toString(plusOne(digits3))); // [1,0]

        int[] digits4 = {9, 9, 9};
        System.out.println(Arrays.toString(plusOne(digits4))); // [1,0,0,0]
    }
}
