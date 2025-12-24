package LinkedLists.Easy;

/**
 * Problem: Remove Duplicates from Sorted List (Easy)
 * LeetCode: https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 * Topic: Linked List / Two Pointers
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

// Definition for singly-linked list
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class _083_RemoveDuplicatesFromSortedList {

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode current = head;

        while (current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next; // skip duplicate
            } else {
                current = current.next;
            }
        }
        return head;
    }

    // Helper method for testing
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    // Test cases
    public static void main(String[] args) {
        ListNode t1 = new ListNode(1, new ListNode(1, new ListNode(2)));
        printList(deleteDuplicates(t1)); // 1 -> 2 -> null

        ListNode t2 = new ListNode(1,
                new ListNode(1,
                new ListNode(2,
                new ListNode(3,
                new ListNode(3)))));
        printList(deleteDuplicates(t2)); // 1 -> 2 -> 3 -> null
    }
}
