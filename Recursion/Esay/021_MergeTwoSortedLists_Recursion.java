package Recursion.Easy;

/**
 * Problem: Merge Two Sorted Lists (Easy)
 * LeetCode: https://leetcode.com/problems/merge-two-sorted-lists/
 * Pattern: Recursion / Linked List
 * Time Complexity: O(m + n) where m and n are lengths of list1 and list2
 * Space Complexity: O(m + n) due to recursion stack
 */

public class _021_MergeTwoSortedLists_Recursion {

    // Definition for singly-linked list.
    public static class ListNode {
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
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode merged = mergeTwoLists(l1, l2); // Output: 1 -> 1 -> 2 -> 3 -> 4 -> 4
        System.out.print("Merged List: ");
        printList(merged);

        ListNode l3 = null;
        ListNode l4 = new ListNode(0);
        ListNode merged2 = mergeTwoLists(l3, l4); // Output: 0
        System.out.print("Merged List: ");
        printList(merged2);
    }
}
