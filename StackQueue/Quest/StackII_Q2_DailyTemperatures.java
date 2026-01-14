package StackQueue.Quest;

import java.util.Stack;
import java.util.Arrays;

/**
 * Problem: Daily Temperatures (Medium)
 * LeetCode: https://leetcode.com/problems/daily-temperatures/
 *
 * Source:
 * - data-structures-and-algorithms-quest
 * - Stack II / Monotonic Stack
 *
 * Pattern: Monotonic Stack (Next Greater Element to the Right)
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Description:
 * Given an array of daily temperatures, return an array where each element
 * represents how many days you must wait to get a warmer temperature.
 * If no future day has a warmer temperature, the value is 0.
 */

public class StackII_Q2_DailyTemperatures {

    /**
     * Monotonic Stack solution
     */
    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>(); // store indices

        for (int i = 0; i < n; i++) {
            // resolve previous colder days
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                result[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }

        // remaining indices already have 0
        return result;
    }

    // Test the solution
    public static void main(String[] args) {
        int[] t1 = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] t2 = {30, 40, 50, 60};
        int[] t3 = {30, 60, 90};

        System.out.println("Test Case 1: " + Arrays.toString(dailyTemperatures(t1)));
        // Expected: [1, 1, 4, 2, 1, 1, 0, 0]

        System.out.println("Test Case 2: " + Arrays.toString(dailyTemperatures(t2)));
        // Expected: [1, 1, 1, 0]

        System.out.println("Test Case 3: " + Arrays.toString(dailyTemperatures(t3)));
        // Expected: [1, 1, 0]
    }
}
