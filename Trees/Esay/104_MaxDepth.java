package Trees.Easy;

/**
 * Problem: Maximum Depth of Binary Tree (Easy)
 * LeetCode: https://leetcode.com/problems/maximum-depth-of-binary-tree/
 *
 * Pattern: Recursion / DFS
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

public class _104_MaxDepth {

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

    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    // Test the solution
    public static void main(String[] args) {

        // Example 1: root = [3,9,20,null,null,15,7] → 3
        TreeNode root1 = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7))
        );
        System.out.println(maxDepth(root1)); // 3

        // Example 2: root = [1,null,2] → 2
        TreeNode root2 = new TreeNode(1,
                null,
                new TreeNode(2)
        );
        System.out.println(maxDepth(root2)); // 2

        // Example 3: empty tree → 0
        TreeNode root3 = null;
        System.out.println(maxDepth(root3)); // 0
    }
}
