package DailyChallenges;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: Balance a Binary Search Tree
 * Date: 09-02-2026
 * Difficulty: Medium
 * Pattern: DFS / In-order Traversal + Divide & Conquer
 *
 * Problem Link:
 * https://leetcode.com/problems/balance-a-binary-search-tree/
 *
 * Description:
 * Given the root of a binary search tree, return a balanced binary search tree
 * with the same node values. If there is more than one answer, return any of them.
 *
 * A binary search tree is balanced if the depth of the two subtrees of every node
 * never differs by more than 1.
 *
 * Constraints:
 * - Number of nodes: [1, 10^4]
 * - Node values: [1, 10^5]
 *
 * Time Complexity: O(n) — each node visited once to collect values, then O(n) to build tree
 * Space Complexity: O(n) — list of values + recursion stack
 */
public class _2026_02_09_BalanceBST {

    /**
     * Solution:
     * 1. Perform in-order traversal to collect node values in sorted order.
     * 2. Build a balanced BST from the sorted values using divide & conquer.
     */
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> sortedValues = new ArrayList<>();
        inorder(root, sortedValues); // collect values in sorted order
        return buildBalancedBST(sortedValues, 0, sortedValues.size() - 1);
    }

    /**
     * In-order traversal: left -> node -> right
     * Collects BST node values in sorted order.
     */
    private void inorder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
    }

    /**
     * Builds a balanced BST from a sorted list using divide & conquer.
     */
    private TreeNode buildBalancedBST(List<Integer> arr, int left, int right) {
        if (left > right) return null;

        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(arr.get(mid));
        node.left = buildBalancedBST(arr, left, mid - 1);
        node.right = buildBalancedBST(arr, mid + 1, right);
        return node;
    }

    /**
     * Definition for a binary tree node.
     */
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
