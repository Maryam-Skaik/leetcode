package Recursion.Quest;

/**
 * Problem: Merge Two Sorted Lists (Easy)
 * LeetCode: https://leetcode.com/problems/merge-two-sorted-lists/
 *
 * Source:
 * - data-structures-and-algorithms-quest
 * - Recursion I
 *
 * Pattern: Linked List / Recursion
 *
 * Idea:
 * Recursively merge two sorted linked lists by always choosing
 * the smaller head node and recursing on the rest.
 *
 * Time Complexity: O(n + m) where n, m are lengths of the two lists
 * Space Complexity: O(n + m) due to recursion stack
 */

public class Recursion_Q1_MergeTwoSortedLists {

    // Definition for singly-linked list
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

    // Helper to print linked list
    public static void printList(ListNode head) {
        ListNode curr = head;
        System.out.print("[");
        while (curr != null) {
            System.out.print(curr.val);
            if (curr.next != null) System.out.print(", ");
            curr = curr.next;
        }
        System.out.println("]");
    }

    // Test the solution
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        ListNode merged = mergeTwoLists(l1, l2);
        printList(merged); // [1, 1, 2, 3, 4, 4]

        ListNode l3 = null;
        ListNode l4 = null;
        printList(mergeTwoLists(l3, l4)); // []

        ListNode l5 = null;
        ListNode l6 = new ListNode(0);
        printList(mergeTwoLists(l5, l6)); // [0]
    }
}
