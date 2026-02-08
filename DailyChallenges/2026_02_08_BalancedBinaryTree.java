package DailyChallenges;

/**
 * Problem: Balanced Binary Tree
 * Date: 08-02-2026
 * Difficulty: Easy
 * Pattern: DFS / Post-order Traversal
 *
 * Problem Link:
 * https://leetcode.com/problems/balanced-binary-tree/
 *
 * Description:
 * Given a binary tree, determine if it is height-balanced.
 *
 * A binary tree is height-balanced if for every node:
 * |height(left subtree) - height(right subtree)| ≤ 1
 *
 * Constraints:
 * - Number of nodes: [0, 5000]
 * - Node values: [-10^4, 10^4]
 *
 * Time Complexity: O(n) — each node is visited once
 * Space Complexity: O(h) — recursion stack (h = height of tree)
 */
public class _2026_02_08_BalancedBinaryTree {

    /**
     * Solution:
     * - Use a helper method to compute height using post-order traversal.
     * - If any subtree is unbalanced, return -1 immediately.
     * - The tree is balanced if the helper never returns -1.
     */
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    /**
     * Returns the height of the subtree rooted at node.
     * Returns -1 if the subtree is unbalanced.
     */
    private int height(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = height(node.left);
        if (leftHeight == -1) return -1;

        int rightHeight = height(node.right);
        if (rightHeight == -1) return -1;

        if (Math.abs(leftHeight - rightHeight) > 1) return -1;

        return Math.max(leftHeight, rightHeight) + 1;
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
