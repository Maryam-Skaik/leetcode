package StackQueue.Quest;

import java.util.Stack;
import java.util.Arrays;

/**
 * Problem: Final Prices With a Special Discount in a Shop (Easy)
 * LeetCode: https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/
 *
 * Source:
 * - data-structures-and-algorithms-quest
 * - Stack I / Monotonic Stack
 *
 * Pattern: Monotonic Stack
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Description:
 * You are given an integer array prices where prices[i] is the price of the ith item.
 * If you buy the ith item, you receive a discount equal to prices[j] where j is the first index
 * after i such that prices[j] <= prices[i]. If no such index exists, no discount is applied.
 * Return the final prices array after discounts.
 */

public class StackII_Q1_FinalPricesMonotonic {

    /**
     * Monotonic Stack solution
     */
    public static int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>(); // store indices

        for (int i = 0; i < n; i++) {
            // Apply discount for previous items where current price is less or equal
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                int idx = stack.pop();
                result[idx] = prices[idx] - prices[i];
            }
            stack.push(i);
        }

        // Remaining items with no discount
        while (!stack.isEmpty()) {
            int idx = stack.pop();
            result[idx] = prices[idx];
        }

        return result;
    }

    // Test the solution
    public static void main(String[] args) {
        int[] prices1 = {8, 4, 6, 2, 3};
        int[] prices2 = {1, 2, 3, 4, 5};
        int[] prices3 = {10, 1, 1, 6};

        System.out.println("Test Case 1: " + Arrays.toString(finalPrices(prices1))); // [4, 2, 4, 2, 3]
        System.out.println("Test Case 2: " + Arrays.toString(finalPrices(prices2))); // [1, 2, 3, 4, 5]
        System.out.println("Test Case 3: " + Arrays.toString(finalPrices(prices3))); // [9, 0, 1, 6]
    }
}
