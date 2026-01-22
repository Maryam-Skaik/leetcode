package Hash.Quest;

import java.util.HashMap;

/**
 * Problem: Copy List with Random Pointer (Medium)
 * LeetCode: https://leetcode.com/problems/copy-list-with-random-pointer/
 *
 * Pattern: Hashing (HashMap)
 *
 * Idea:
 * - Use a HashMap to map each original node to its copied node.
 * - First pass: create all new nodes without setting next/random.
 * - Second pass: set next and random pointers using the map.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Node {
    int val;
    Node next;
    Node random;

    Node(int val) {
        this.val = val;
    }
}

public class LinkedList_Q2_CopyRandomList_Hash {

    public static Node copyRandomList(Node head) {
        if (head == null) return null;

        // Step 1: Create all new nodes and store mapping
        HashMap<Node, Node> map = new HashMap<>();
        Node curr = head;
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        // Step 2: Set next and random pointers for copied nodes
        curr = head;
        while (curr != null) {
            Node copy = map.get(curr);
            copy.next = map.get(curr.next);       // may be null
            copy.random = map.get(curr.random);   // may be null
            curr = curr.next;
        }

        // Return the head of the copied list
        return map.get(head);
    }

    // ---------------- Test ----------------
    public static void main(String[] args) {
        // Example: [[7,null],[13,0],[11,4],[10,2],[1,0]]
        Node n0 = new Node(7);
        Node n1 = new Node(13);
        Node n2 = new Node(11);
        Node n3 = new Node(10);
        Node n4 = new Node(1);

        n0.next = n1; n1.next = n2; n2.next = n3; n3.next = n4;

        n0.random = null;
        n1.random = n0;
        n2.random = n4;
        n3.random = n2;
        n4.random = n0;

        Node copiedHead = copyRandomList(n0);

        // Print copied list
        Node temp = copiedHead;
        while (temp != null) {
            int randomVal = (temp.random != null) ? temp.random.val : -1;
            System.out.println("Node val: " + temp.val + ", Random points to: " + randomVal);
            temp = temp.next;
        }
    }
}
