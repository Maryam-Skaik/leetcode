package StackQueue.Medium;

/**
 * Problem: Design Circular Queue (Medium)
 * LeetCode: https://leetcode.com/problems/design-circular-queue/
 * Topic: Queue, Array
 *
 * Idea:
 * - Use a fixed-size array
 * - Use modulo operator (%) to wrap front and rear pointers
 * - Maintain a size variable to check empty/full
 *
 * Time Complexity: O(1) for all operations
 * Space Complexity: O(k)
 */

public class _622_DesignCircularQueue {

    static class MyCircularQueue {
        int[] arr;
        int front, rear;
        int size;
        int capacity;

        public MyCircularQueue(int k) {
            arr = new int[k];
            front = -1;
            rear = -1;
            size = 0;
            capacity = k;
        }

        /** Insert an element into the circular queue. Return true if successful. */
        public boolean enQueue(int value) {
            if (isFull()) return false;
            if (isEmpty()) front = 0; // initialize front if queue was empty
            rear = (rear + 1) % capacity;
            arr[rear] = value;
            size++;
            return true;
        }

        /** Delete an element from the circular queue. Return true if successful. */
        public boolean deQueue() {
            if (isEmpty()) return false;
            front = (front + 1) % capacity;
            size--;
            if (size == 0) { // reset pointers when queue becomes empty
                front = -1;
                rear = -1;
            }
            return true;
        }

        /** Get the front item from the queue. */
        public int Front() {
            if (isEmpty()) return -1;
            return arr[front];
        }

        /** Get the last item from the queue. */
        public int Rear() {
            if (isEmpty()) return -1;
            return arr[rear];
        }

        /** Check whether the circular queue is empty. */
        public boolean isEmpty() {
            return size == 0;
        }

        /** Check whether the circular queue is full. */
        public boolean isFull() {
            return size == capacity;
        }
    }

    // Test cases
    public static void main(String[] args) {
        MyCircularQueue queue = new MyCircularQueue(3);

        System.out.println(queue.enQueue(1)); // true
        System.out.println(queue.enQueue(2)); // true
        System.out.println(queue.enQueue(3)); // true
        System.out.println(queue.enQueue(4)); // false, queue full
        System.out.println(queue.Rear());     // 3
        System.out.println(queue.isFull());   // true
        System.out.println(queue.deQueue());  // true
        System.out.println(queue.enQueue(4)); // true
        System.out.println(queue.Rear());     // 4
        System.out.println(queue.Front());    // 2
        System.out.println(queue.isEmpty());  // false
    }
}
