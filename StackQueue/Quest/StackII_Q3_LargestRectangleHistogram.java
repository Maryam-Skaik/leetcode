package StackQueue.Quest;

import java.util.Stack;

/**
 * Problem: Largest Rectangle in Histogram (Hard)
 * LeetCode: https://leetcode.com/problems/largest-rectangle-in-histogram/
 *
 * Source:
 * - data-structures-and-algorithms-quest
 * - Stack II / Monotonic Stack
 *
 * Pattern: Monotonic Stack (Previous Smaller + Next Smaller)
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Description:
 * Given an array of integers heights representing a histogram,
 * where the width of each bar is 1, return the area of the
 * largest rectangle that can be formed inside the histogram.
 */

public class StackII_Q3_LargestRectangleHistogram {

    /**
     * Monotonic Increasing Stack solution
     */
    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>(); // store indices
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i < n; i++) {
            // process bars that are taller than current
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int idx = stack.pop();
                int height = heights[idx];

                int width;
                if (stack.isEmpty()) {
                    width = i; // extends to the beginning
                } else {
                    width = i - stack.peek() - 1;
                }

                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }

        // process remaining bars in stack
        while (!stack.isEmpty()) {
            int idx = stack.pop();
            int height = heights[idx];

            int width;
            if (stack.isEmpty()) {
                width = n;
            } else {
                width = n - stack.peek() - 1;
            }

            maxArea = Math.max(maxArea, height * width);
        }

        return maxArea;
    }

    // Test the solution
    public static void main(String[] args) {
        int[] h1 = {2, 1, 5, 6, 2, 3};
        int[] h2 = {2, 4};
        int[] h3 = {2, 1, 2};

        System.out.println("Test Case 1: " + largestRectangleArea(h1));
        // Expected: 10

        System.out.println("Test Case 2: " + largestRectangleArea(h2));
        // Expected: 4

        System.out.println("Test Case 3: " + largestRectangleArea(h3));
        // Expected: 3
    }
}
