package Recursion.Medium;

/**
 * Problem: Add Two Numbers (Medium)
 * LeetCode: https://leetcode.com/problems/add-two-numbers/
 * Pattern: Recursion / Linked List
 * Time Complexity: O(max(m, n)) where m and n are lengths of l1 and l2
 * Space Complexity: O(max(m, n)) due to recursion stack
 */

public class _002_AddTwoNumbers_Recursion {

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return add(l1, l2, 0);
    }

    private static ListNode add(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) return null;

        int val1 = (l1 != null) ? l1.val : 0;
        int val2 = (l2 != null) ? l2.val : 0;

        int sum = val1 + val2 + carry;
        ListNode node = new ListNode(sum % 10);

        node.next = add(
            (l1 != null) ? l1.next : null,
            (l2 != null) ? l2.next : null,
            sum / 10
        );

        return node;
    }

    // Helper function to print linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    // Test the solution
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode sum = addTwoNumbers(l1, l2); // Output: 7 -> 0 -> 8
        System.out.print("Sum: ");
        printList(sum);

        ListNode l3 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        ListNode l4 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        ListNode sum2 = addTwoNumbers(l3, l4); // Output: 8 -> 9 -> 9 -> 9 -> 0 -> 0 -> 0 -> 1
        System.out.print("Sum: ");
        printList(sum2);
    }
}
