package LinkedList.Quest;

/**
 * Problem: Odd Even Linked List (Medium)
 * LeetCode: https://leetcode.com/problems/odd-even-linked-list/
 *
 * Source:
 * - data-structures-and-algorithms-quest
 * - Linked Lists I
 *
 * Pattern: Linked List / Two Pointers
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class LinkedListI_Q2_OddEvenList {

    // Definition for singly-linked list
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even; // to connect at the end of odd list

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead; // merge odd and even lists
        return head;
    }

    // Test the solution
    public static void main(String[] args) {
        // Example 1: [1,2,3,4,5] -> [1,3,5,2,4]
        ListNode head1 = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5)))));
        printList(oddEvenList(head1)); // [1, 3, 5, 2, 4]

        // Example 2: [2,1,3,5,6,4,7] -> [2,3,6,7,1,5,4]
        ListNode head2 = new ListNode(2,
                new ListNode(1,
                        new ListNode(3,
                                new ListNode(5,
                                        new ListNode(6,
                                                new ListNode(4,
                                                        new ListNode(7)))))));
        printList(oddEvenList(head2)); // [2, 3, 6, 7, 1, 5, 4]
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
