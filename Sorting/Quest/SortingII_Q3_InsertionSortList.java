package Sorting.Quest;

/**
 * Problem: Insertion Sort List
 * Difficulty: Medium
 *
 * LeetCode:
 * https://leetcode.com/problems/insertion-sort-list/
 *
 * Source:
 * - data-structures-and-algorithms-quest
 * - Sorting II
 *
 * Pattern:
 * - Insertion Sort
 * - Linked List Manipulation
 *
 * Idea:
 * 1. Use a dummy node to represent the head of the sorted list.
 * 2. Iterate through the original list one node at a time.
 * 3. For each node:
 *    - Find the correct position in the already sorted list.
 *    - Insert the node in-place.
 * 4. Continue until all nodes are processed.
 *
 * Notes:
 * - Unlike arrays, insertion sort on linked lists is efficient for insertion
 *   because no shifting is required.
 * - The algorithm maintains a growing sorted list.
 *
 * Time Complexity:
 * O(n²), since for each node we may traverse the sorted portion.
 *
 * Space Complexity:
 * O(1), sorting is done in-place using constant extra space.
 */
public class SortingII_Q3_InsertionSortList {

    /**
     * Definition for singly-linked list.
     */
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode insertionSortList(ListNode head) {
        // Dummy head for the sorted list
        ListNode dummy = new ListNode(0);

        ListNode curr = head;

        while (curr != null) {
            // Save next node to process
            ListNode next = curr.next;

            // Find the insertion position in the sorted list
            ListNode prev = dummy;
            while (prev.next != null && prev.next.val < curr.val) {
                prev = prev.next;
            }

            // Insert curr between prev and prev.next
            curr.next = prev.next;
            prev.next = curr;

            // Move to the next node
            curr = next;
        }

        return dummy.next;
    }

    // Test the solution
    public static void main(String[] args) {

        // Example 1: [4,2,1,3]
        ListNode ex1 =
                new ListNode(4,
                        new ListNode(2,
                                new ListNode(1,
                                        new ListNode(3))));

        ListNode sorted1 = insertionSortList(ex1);
        printList(sorted1); // Output: 1 2 3 4

        // Example 2: [-1,5,3,4,0]
        ListNode ex2 =
                new ListNode(-1,
                        new ListNode(5,
                                new ListNode(3,
                                        new ListNode(4,
                                                new ListNode(0)))));

        ListNode sorted2 = insertionSortList(ex2);
        printList(sorted2); // Output: -1 0 3 4 5
    }

    // Helper method to print linked list
    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
