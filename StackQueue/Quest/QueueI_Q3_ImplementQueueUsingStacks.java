package StackQueue.Quest;

import java.util.Stack;

/**
 * Problem: Implement Queue using Stacks (Easy)
 * LeetCode: https://leetcode.com/problems/implement-queue-using-stacks/
 *
 * Source:
 * - data-structures-and-algorithms-quest
 * - Queue I
 *
 * Pattern: Stack Simulation (Two Stacks)
 *
 * Time Complexity:
 * - push: O(1)
 * - pop: O(n)
 * - peek: O(n)
 * - empty: O(1)
 *
 * Space Complexity: O(n)
 *
 * Description:
 * Implement a FIFO queue using only two stacks.
 * Only standard stack operations are allowed.
 */

public class QueueI_Q3_ImplementQueueUsingStacks {

    private Stack<Integer> s1; // main stack
    private Stack<Integer> s2; // helper stack

    public QueueI_Q3_ImplementQueueUsingStacks() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        s1.push(x);
    }

    /**
     * Removes the element from the front of the queue and returns it.
     */
    public int pop() {
        int size = s1.size() - 1;

        // move all except the bottom element to s2
        for (int i = 0; i < size; i++) {
            s2.push(s1.pop());
        }

        int result = s1.pop(); // front element

        // restore elements back to s1
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }

        return result;
    }

    /**
     * Get the front element.
     */
    public int peek() {
        int size = s1.size() - 1;

        // move all except the bottom element to s2
        for (int i = 0; i < size; i++) {
            s2.push(s1.pop());
        }

        int result = s1.peek(); // front element

        // restore elements back to s1
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }

        return result;
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return s1.isEmpty();
    }

    // Test the solution
    public static void main(String[] args) {
        QueueI_Q3_ImplementQueueUsingStacks myQueue =
                new QueueI_Q3_ImplementQueueUsingStacks();

        myQueue.push(1);
        myQueue.push(2);

        System.out.println(myQueue.peek());
        // Expected: 1

        System.out.println(myQueue.pop());
        // Expected: 1

        System.out.println(myQueue.empty());
        // Expected: false
    }
}
