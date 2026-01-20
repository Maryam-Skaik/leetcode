package LinkedList.Quest;

/**
 * Problem: Remove Duplicates from Sorted List (Easy)
 * LeetCode: https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 *
 * Source:
 * - data-structures-and-algorithms-quest
 * - Linked Lists I
 *
 * Pattern: Linked List / Iteration
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class LinkedListI_Q1_RemoveDuplicates {

    // Definition for singly-linked list
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode current = head;
        while (current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    // Test the solution
    public static void main(String[] args) {
        // Example 1: [1, 1, 2] -> [1, 2]
        ListNode head1 = new ListNode(1, new ListNode(1, new ListNode(2)));
        printList(deleteDuplicates(head1)); // [1, 2]

        // Example 2: [1, 1, 2, 3, 3] -> [1, 2, 3]
        ListNode head2 = new ListNode(1,
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(3,
                                        new ListNode(3)))));
        printList(deleteDuplicates(head2)); // [1, 2, 3]
    }

    private static void printList(ListNode head) {
        System.out.print("[");
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) System.out.print(", ");
            current = current.next;
        }
        System.out.println("]");
    }
}
