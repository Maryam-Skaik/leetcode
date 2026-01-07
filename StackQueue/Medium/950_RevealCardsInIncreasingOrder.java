package StackQueue.Medium;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

/**
 * Problem: Reveal Cards in Increasing Order (Medium)
 * LeetCode: https://leetcode.com/problems/reveal-cards-in-increasing-order/
 * Topic: Queue, Simulation, Sorting
 *
 * Idea:
 * - The goal is to construct an initial deck order such that
 *   revealing cards using the given rules results in increasing order.
 *
 * - Instead of simulating card values, we simulate the reveal process
 *   on indices (positions).
 *
 * Steps:
 * 1. Sort the deck (this is the desired reveal order).
 * 2. Use a queue to simulate positions [0, 1, 2, ..., n-1].
 * 3. For each card in sorted order:
 *    - Take the front index from the queue and place the card there.
 *    - Move the next index to the back (simulating "move top to bottom").
 *
 * Time Complexity: O(n log n)
 *   - Sorting dominates.
 *
 * Space Complexity: O(n)
 *   - Queue + result array.
 */

public class _950_RevealCardsInIncreasingOrder {

    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;

        // Queue to store indices (positions)
        Queue<Integer> q = new LinkedList<>();

        // Sort deck to get desired reveal order
        Arrays.sort(deck);

        int[] result = new int[n];

        // Initialize queue with indices
        for (int i = 0; i < n; i++) {
            q.add(i);
        }

        // Place sorted values into positions based on reveal simulation
        for (int i = 0; i < n; i++) {
            result[q.poll()] = deck[i];

            // Simulate: move next top card to bottom
            if (!q.isEmpty()) {
                q.add(q.poll());
            }
        }

        return result;
    }

    // Test cases
    public static void main(String[] args) {
        _950_RevealCardsInIncreasingOrder solution =
                new _950_RevealCardsInIncreasingOrder();

        int[] deck1 = {17, 13, 11, 2, 3, 5, 7};
        System.out.println(Arrays.toString(
                solution.deckRevealedIncreasing(deck1)
        ));
        // Expected: [2, 13, 3, 11, 5, 17, 7]

        int[] deck2 = {1, 1000};
        System.out.println(Arrays.toString(
                solution.deckRevealedIncreasing(deck2)
        ));
        // Expected: [1, 1000]
    }
}
