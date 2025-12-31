package LinkedLists.Easy;

/**
 * Problem: Intersection of Two Linked Lists (Easy)
 * LeetCode: https://leetcode.com/problems/intersection-of-two-linked-lists/
 * Topic: Linked List / Two Pointers
 * Time Complexity: O(m + n) where m and n are the lengths of the two lists
 * Space Complexity: O(1)
 * 
 * Idea:
 * - Use two pointers to traverse both lists.
 * - When a pointer reaches the end of its list, redirect it to the head of the other list.
 * - If the lists intersect, the pointers will meet at the intersection node.
 * - If the lists do not intersect, both pointers eventually reach null.
 */

// Definition for singly-linked list
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class _160_IntersectionOfTwoLinkedLists {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode ptrA = headA;
        ListNode ptrB = headB;

        // Traverse both lists
        while (ptrA != ptrB) {
            // Move pointer or redirect to the other list's head
            ptrA = (ptrA == null) ? headB : ptrA.next;
            ptrB = (ptrB == null) ? headA : ptrB.next;
        }

        // Either intersection node or null
        return ptrA;
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
        // Create intersection
        ListNode common = new ListNode(8, new ListNode(10));

        // List A: 4 -> 1 -> 8 -> 10
        ListNode headA = new ListNode(4, new ListNode(1, common));

        // List B: 5 -> 6 -> 1 -> 8 -> 10
        ListNode headB = new ListNode(5, new ListNode(6, new ListNode(1, common)));

        ListNode intersection = getIntersectionNode(headA, headB);

        if (intersection != null) {
            System.out.println("Intersected at node with value: " + intersection.val);
        } else {
            System.out.println("No intersection");
        }

        // Optional: print lists
        System.out.print("List A: ");
        printList(headA);
        System.out.print("List B: ");
        printList(headB);
    }
}
