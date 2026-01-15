package StackQueue.Quest;

import java.util.Queue;
import java.util.LinkedList;

/**
 * Problem: Time Needed to Buy Tickets (Easy)
 * LeetCode: https://leetcode.com/problems/time-needed-to-buy-tickets/
 *
 * Source:
 * - data-structures-and-algorithms-quest
 * - Queue I
 *
 * Pattern: Queue Simulation
 *
 * Time Complexity: O(n * max(tickets[i]))
 * Space Complexity: O(n)
 */

public class QueueI_Q2_TimeNeededToBuyTickets {

    public static int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer> queue = new LinkedList<>();

        // enqueue all people by index
        for (int i = 0; i < tickets.length; i++) {
            queue.offer(i);
        }

        int counter = 0;

        while (true) {
            int person = queue.poll();
            tickets[person]--;
            counter++;

            // if person k just finished, stop
            if (person == k && tickets[person] == 0) {
                return counter;
            }

            // if this person still needs tickets, rejoin queue
            if (tickets[person] > 0) {
                queue.offer(person);
            }
        }
    }

    // Test the solution
    public static void main(String[] args) {
        int[] tickets1 = {2, 3, 2};
        int k1 = 2;
        System.out.println(timeRequiredToBuy(tickets1, k1));
        // Output: 6

        int[] tickets2 = {5, 1, 1, 1};
        int k2 = 0;
        System.out.println(timeRequiredToBuy(tickets2, k2));
        // Output: 8
    }
}
