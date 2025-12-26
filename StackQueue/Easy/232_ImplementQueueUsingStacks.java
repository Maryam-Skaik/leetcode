package Queue.Easy;

import java.util.Stack;

/**
 * Problem: Implement Queue using Stacks (Easy)
 * LeetCode: https://leetcode.com/problems/implement-queue-using-stacks/
 * Topic: Queue, Stack
 *
 * Idea:
 * - Use two stacks to simulate FIFO behavior
 * - Push elements into s1
 * - Pop/Peek elements by reversing order using s2
 *
 * Time Complexity:
 * - push(): O(1)
 * - pop(): O(n)
 * - peek(): O(n)
 * - empty(): O(1)
 *
 * Space Complexity: O(n)
 */

public class _232_ImplementQueueUsingStacks {

    static class MyQueue {
        Stack<Integer> s1;
        Stack<Integer> s2;

        public MyQueue() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        /** Push element x to the back of queue */
        public void push(int x) {
            s1.push(x);
        }

        /** Removes the element from in front of queue and returns it */
        public int pop() {
            int size = s1.size() - 1;

            // Move first n-1 elements to s2
            for (int i = 0; i < size; i++) {
                s2.push(s1.pop());
            }

            // Last element is the front of the queue
            int result = s1.pop();

            // Restore elements back to s1
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }

            return result;
        }

        /** Get the front element */
        public int peek() {
            int size = s1.size() - 1;

            // Move first n-1 elements to s2
            for (int i = 0; i < size; i++) {
                s2.push(s1.pop());
            }

            // Peek the front element without removing it
            int result = s1.peek();

            // Restore elements back to s1
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }

            return result;
        }

        /** Returns whether the queue is empty */
        public boolean empty() {
            return s1.isEmpty();
        }
    }

    // Test cases
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());  // 1
        System.out.println(queue.pop());   // 1
        System.out.println(queue.empty()); // false
    }
}
