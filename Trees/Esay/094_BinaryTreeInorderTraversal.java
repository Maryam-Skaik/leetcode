package Trees.Easy;

/**
 * Problem: Binary Tree Inorder Traversal (Easy)
 * LeetCode: https://leetcode.com/problems/binary-tree-inorder-traversal/
 *
 * Pattern: Recursion / DFS
 *
 * Inorder Order: Left → Root → Right
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.ArrayList;
import java.util.List;

public class _094_BinaryTreeInorderTraversal {

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

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderHelper(root, result);
        return result;
    }

    private static void inorderHelper(TreeNode root, List<Integer> result) {
        if (root == null) return;

        inorderHelper(root.left, result);
        result.add(root.val);
        inorderHelper(root.right, result);
    }

    // Test the solution
    public static void main(String[] args) {

        // Example 1: [1,null,2,3]
        TreeNode root1 = new TreeNode(1,
                null,
                new TreeNode(2, new TreeNode(3), null)
        );
        System.out.println(inorderTraversal(root1)); // [1,3,2]

        // Example 4: [1]
        TreeNode root2 = new TreeNode(1);
        System.out.println(inorderTraversal(root2)); // [1]

        // Example 3: []
        TreeNode root3 = null;
        System.out.println(inorderTraversal(root3)); // []
    }
}
