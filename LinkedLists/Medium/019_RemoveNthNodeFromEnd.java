package LinkedLists.Medium;

/**
 * Problem: Remove N-th Node From End of List (Medium)
 * LeetCode: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * Topic: Linked List / Two Pointers
 * Time Complexity: O(n) where n is the number of nodes in the list
 * Space Complexity: O(1)
 *
 * Idea:
 * - Use two pointers: first and second.
 * - Move first pointer n steps ahead.
 * - Then move both pointers until first reaches the last node.
 * - second.next will be the node to remove.
 * - Handle edge case when the head itself needs to be removed.
 */

// Definition for singly-linked list
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class _019_RemoveNthNodeFromEnd {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (n <= 0) return null;

        ListNode first = head;
        ListNode second = head;

        // Move first pointer n steps ahead
        for (int i = 0; i < n; i++) {
            if (first == null) return null; // safety check
            first = first.next;
        }

        // If first is null, remove the head
        if (first == null) return head.next;

        // Move both pointers until first reaches the last node
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }

        // Remove the nth node from end
        second.next = second.next.next;

        return head;
    }

    // Helper method to print linked list
    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    // Test the solution
    public static void main(String[] args) {
        // Example 1: [1,2,3,4,5], n = 2 -> [1,2,3,5]
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode res1 = removeNthFromEnd(head1, 2);
        printList(res1); // Output: 1 -> 2 -> 3 -> 5 -> null

        // Example 2: [1], n = 1 -> []
        ListNode head2 = new ListNode(1);
        ListNode res2 = removeNthFromEnd(head2, 1);
        printList(res2); // Output: null

        // Example 3: [1,2], n = 1 -> [1]
        ListNode head3 = new ListNode(1, new ListNode(2));
        ListNode res3 = removeNthFromEnd(head3, 1);
        printList(res3); // Output: 1 -> null
    }
}
