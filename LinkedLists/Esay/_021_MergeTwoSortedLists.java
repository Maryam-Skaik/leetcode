package LinkedLists.Easy;

/**
 * Problem: Merge Two Sorted Lists (Easy)
 * LeetCode: https://leetcode.com/problems/merge-two-sorted-lists/
 * Topic: Linked List / Merge
 * Time Complexity: O(n + m) where n and m are the lengths of the two lists
 * Space Complexity: O(1) (iterative, in-place merge)
 */

// Definition for singly-linked list
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class _021_MergeTwoSortedLists {

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        ListNode result;
        if(list1.val < list2.val){
            result = list1;
            list1 = list1.next;
        } else {
            result = list2;
            list2 = list2.next;
        }

        ListNode newHead = result;

        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                result.next = list1;
                list1 = list1.next;
            } else {
                result.next = list2;
                list2 = list2.next;
            }
            result = result.next;
        }

        // Attach remaining nodes
        result.next = (list1 != null) ? list1 : list2;

        return newHead;
    }

    // Helper method to print linked list
    public static void printList(ListNode head) {
        ListNode curr = head;
        while(curr != null){
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    // Test the solution
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        ListNode merged = mergeTwoLists(l1, l2);
        printList(merged); // Output: 1 -> 1 -> 2 -> 3 -> 4 -> 4 -> null

        ListNode l3 = null;
        ListNode l4 = null;
        printList(mergeTwoLists(l3, l4)); // Output: null

        ListNode l5 = null;
        ListNode l6 = new ListNode(0);
        printList(mergeTwoLists(l5, l6)); // Output: 0 -> null
    }
}
