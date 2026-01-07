package StackQueue.Medium;

import java.util.Queue;
import java.util.LinkedList;

/**
 * Problem: Find the Winner of the Circular Game (Medium)
 * LeetCode: https://leetcode.com/problems/find-the-winner-of-the-circular-game/
 * Topic: Queue, Simulation, Recursion, Josephus Problem
 *
 * Idea:
 * - There are two main approaches:
 *
 * 1) Queue Simulation:
 *    - Use a queue to represent friends in a circle.
 *    - Rotate the first k-1 friends to the back of the queue.
 *    - Remove the kth friend.
 *    - Repeat until only one friend remains.
 *
 *    Time Complexity: O(n*k)
 *    Space Complexity: O(n)
 *
 * 2) Recursion (Josephus Problem):
 *    - Use the Josephus formula recursively:
 *        f(1) = 0
 *        f(n) = (f(n-1) + k) % n
 *    - Add 1 at the end because friends are numbered from 1.
 *
 *    Time Complexity: O(n)
 *    Space Complexity: O(n) due to recursion stack
 */

public class _1823_FindTheWinner {

    /**
     * Solution 1: Queue simulation
     */
    public int findTheWinnerQueue(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();

        // Add all friends to the queue
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        // Eliminate friends until one remains
        while (queue.size() > 1) {
            for (int i = 0; i < k - 1; i++) {
                queue.add(queue.poll()); // Move first k-1 friends to the back
            }
            queue.poll(); // Remove the kth friend
        }

        return queue.poll();
    }

    /**
     * Solution 2: Recursion (Josephus problem)
     */
    public int findTheWinnerRecursive(int n, int k) {
        return 1 + josephus(n, k);
    }

    private int josephus(int n, int k) {
        if (n == 1) return 0; // base case: last remaining friend
        return (josephus(n - 1, k) + k) % n;
    }

    /**
     * Test cases
     */
    public static void main(String[] args) {
        _1823_FindTheWinner solution = new _1823_FindTheWinner();

        int n1 = 5, k1 = 2;
        System.out.println("Queue simulation winner: " + solution.findTheWinnerQueue(n1, k1));
        System.out.println("Recursive winner: " + solution.findTheWinnerRecursive(n1, k1));
        // Expected: 3

        int n2 = 6, k2 = 5;
        System.out.println("Queue simulation winner: " + solution.findTheWinnerQueue(n2, k2));
        System.out.println("Recursive winner: " + solution.findTheWinnerRecursive(n2, k2));
        // Expected: 1
    }
}
