package Trees.Medium;

/**
 * Problem: Binary Tree Level Order Traversal (Medium)
 * LeetCode: https://leetcode.com/problems/binary-tree-level-order-traversal/
 *
 * Pattern: BFS / Queue
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _102_BinaryTreeLevelOrderTraversal {

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

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                level.add(node.val);
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            res.add(level);
        }
        return res;
    }

    // Test the solution
    public static void main(String[] args) {

        // Example 1: [3,9,20,null,null,15,7]
        TreeNode root1 = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7))
        );
        System.out.println(levelOrder(root1)); // [[3],[9,20],[15,7]]

        // Example 2: [1]
        TreeNode root2 = new TreeNode(1);
        System.out.println(levelOrder(root2)); // [[1]]

        // Example 3: []
        TreeNode root3 = null;
        System.out.println(levelOrder(root3)); // []
    }
}
