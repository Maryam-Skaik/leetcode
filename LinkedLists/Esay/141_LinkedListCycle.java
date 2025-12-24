package LinkedLists.Easy;

/**
 * Problem: Linked List Cycle (Easy)
 * LeetCode: https://leetcode.com/problems/linked-list-cycle/
 * Topic: Linked List / Two Pointers (Floyd’s Cycle Detection)
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

// Definition for singly-linked list
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class _141_LinkedListCycle {

    public static boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;        // moves 1 step
            fast = fast.next.next;  // moves 2 steps

            if (slow == fast) {
                return true;        // cycle detected
            }
        }
        return false;               // reached null → no cycle
    }

    // Simple test
    public static void main(String[] args) {
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(0);
        ListNode n4 = new ListNode(-4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n2; // create cycle

        System.out.println(hasCycle(n1)); // true

        ListNode single = new ListNode(1);
        System.out.println(hasCycle(single)); // false
    }
}
