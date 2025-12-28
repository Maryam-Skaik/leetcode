package Trees.Easy;

/**
 * Problem: Symmetric Tree (Easy)
 * LeetCode: https://leetcode.com/problems/symmetric-tree/
 *
 * Pattern: Recursion / DFS
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

public class _101_SymmetricTree {

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

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    private static boolean isMirror(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;

        return a.val == b.val
                && isMirror(a.left, b.right)
                && isMirror(a.right, b.left);
    }

    // Test the solution
    public static void main(String[] args) {

        // Example 1: root = [1,2,2,3,4,4,3] → true
        TreeNode root1 = new TreeNode(1,
                new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                new TreeNode(2, new TreeNode(4), new TreeNode(3))
        );
        System.out.println(isSymmetric(root1)); // true

        // Example 2: root = [1,2,2,null,3,null,3] → false
        TreeNode root2 = new TreeNode(1,
                new TreeNode(2, null, new TreeNode(3)),
                new TreeNode(2, null, new TreeNode(3))
        );
        System.out.println(isSymmetric(root2)); // false
    }
}
