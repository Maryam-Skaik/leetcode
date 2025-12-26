package Stack.Easy;

import java.util.Queue;
import java.util.LinkedList;

/**
 * Problem: Implement Stack using Queues (Easy)
 * LeetCode: https://leetcode.com/problems/implement-stack-using-queues/
 * Topic: Stack, Queue
 *
 * Idea:
 * - Use two queues to simulate LIFO behavior
 * - Push is O(1)
 * - Pop and Top are O(n)
 *
 * Time Complexity:
 * - push(): O(1)
 * - pop(): O(n)
 * - top(): O(n)
 * - empty(): O(1)
 *
 * Space Complexity: O(n)
 */

public class _225_ImplementStackUsingQueues {

    static class MyStack {
        Queue<Integer> q1;
        Queue<Integer> q2;

        public MyStack() {
            q1 = new LinkedList<>();
            q2 = new LinkedList<>();
        }

        /** Push element x onto stack */
        public void push(int x) {
            q1.offer(x);
        }

        /** Removes the element on top of the stack and returns it */
        public int pop() {
            int size = q1.size() - 1;

            // Move all elements except the last one
            for (int i = 0; i < size; i++) {
                q2.offer(q1.poll());
            }

            // Last element is the stack top
            int result = q1.poll();

            // Reset queues
            q1 = q2;
            q2 = new LinkedList<>();

            return result;
        }

        /** Get the top element */
        public int top() {
            int size = q1.size() - 1;

            // Move all elements except the last one
            for (int i = 0; i < size; i++) {
                q2.offer(q1.poll());
            }

            int result = q1.poll();
            q2.offer(result); // put it back

            // Reset queues
            q1 = q2;
            q2 = new LinkedList<>();

            return result;
        }

        /** Returns whether the stack is empty */
        public boolean empty() {
            return q1.isEmpty();
        }
    }

    // Test cases
    public static void main(String[] args) {
        MyStack stack = new MyStack();

        stack.push(1);
        stack.push(2);
        System.out.println(stack.top());   // 2
        System.out.println(stack.pop());   // 2
        System.out.println(stack.empty()); // false
    }
}
