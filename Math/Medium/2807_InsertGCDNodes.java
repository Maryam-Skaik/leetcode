package Math.Medium;

/**
 * Problem: Insert Greatest Common Divisors in Linked List (Medium)
 * LeetCode: https://leetcode.com/problems/insert-greatest-common-divisors-in-linked-list/
 * Pattern: Linked List / Math / GCD
 * Time Complexity: O(n * log(maxNodeValue)) for GCD calculations
 * Space Complexity: O(1) (in-place insertion)
 */

public class _2807_InsertGCDNodes {

    /**
     * Inserts a new node between every pair of adjacent nodes
     * with value equal to the greatest common divisor (GCD) of them.
     */
    public static ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode curr = head;

        while (curr.next != null) {
            // Create new node with GCD value
            ListNode node = new ListNode(gcd(curr.val, curr.next.val));
            node.next = curr.next;
            curr.next = node;
            curr = node.next; // move to the next original node
        }

        return head;
    }

    // Helper method to calculate GCD using Euclidean algorithm
    private static int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    // Helper method to print the linked list
    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val);
            if (curr.next != null) System.out.print(" -> ");
            curr = curr.next;
        }
        System.out.println();
    }

    // Definition for singly-linked list
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // Test the solution
    public static void main(String[] args) {
        // Example 1
        ListNode head1 = new ListNode(18, new ListNode(6, new ListNode(10, new ListNode(3))));
        System.out.println("Example 1 Input: 18 -> 6 -> 10 -> 3");
        ListNode res1 = insertGreatestCommonDivisors(head1);
        System.out.print("Output: ");
        printList(res1); // Expected: 18 -> 6 -> 6 -> 2 -> 10 -> 1 -> 3

        // Example 2
        ListNode head2 = new ListNode(7);
        System.out.println("\nExample 2 Input: 7");
        ListNode res2 = insertGreatestCommonDivisors(head2);
        System.out.print("Output: ");
        printList(res2); // Expected: 7
    }
}
