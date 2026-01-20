package LinkedList.Quest;

/**
 * Problem: Reverse Linked List (Easy)
 * LeetCode: https://leetcode.com/problems/reverse-linked-list/
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

public class LinkedListI_Q3_ReverseList {

    // Definition for singly-linked list
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        return prev;
    }

    // Test the solution
    public static void main(String[] args) {
        // Example 1: [1,2,3,4,5] -> [5,4,3,2,1]
        ListNode head1 = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5)))));
        printList(reverseList(head1)); // [5, 4, 3, 2, 1]

        // Example 2: [1,2] -> [2,1]
        ListNode head2 = new ListNode(1, new ListNode(2));
        printList(reverseList(head2)); // [2, 1]

        // Example 3: [] -> []
        ListNode head3 = null;
        printList(reverseList(head3)); // []
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
