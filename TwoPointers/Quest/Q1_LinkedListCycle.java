package TwoPointers.Quest;

/**
 * Problem: Linked List Cycle (Easy)
 * LeetCode: https://leetcode.com/problems/linked-list-cycle/
 *
 * Source:
 * - data-structures-and-algorithms-quest
 * - Linked List
 *
 * Pattern: Two Pointers / Fast & Slow Pointer
 *
 * Time Complexity: O(n) — each node is visited at most twice
 * Space Complexity: O(1) — no extra space used
 *
 * Description:
 * Given the head of a linked list, determine if the linked list has a cycle.
 * A cycle exists if some node can be reached again by continuously following next pointers.
 * Return true if there is a cycle, otherwise false.
 */
public class Q1_LinkedListCycle {

    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * Solution:
     * - Use two pointers: slow (moves 1 step) and fast (moves 2 steps)
     * - If there is a cycle, fast and slow will eventually meet
     * - If fast reaches null, there is no cycle
     */
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;           // move slow by 1
            fast = fast.next.next;      // move fast by 2

            if (slow == fast) {         // cycle detected
                return true;
            }
        }

        return false; // no cycle
    }

    // Test the solution
    public static void main(String[] args) {
        Q1_LinkedListCycle solution = new Q1_LinkedListCycle();

        // Example 1: cycle exists
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2; // cycle
        System.out.println(solution.hasCycle(node1)); // true

        // Example 2: cycle exists
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next = n2;
        n2.next = n1; // cycle
        System.out.println(solution.hasCycle(n1)); // true

        // Example 3: no cycle
        ListNode single = new ListNode(1);
        System.out.println(solution.hasCycle(single)); // false
    }
}
