package Trees.Medium;

/**
 * Problem: Construct Binary Tree from Preorder and Inorder Traversal
 * LeetCode: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 * Difficulty: Medium
 * Pattern: DFS / Divide & Conquer
 *
 * Description:
 * Given preorder and inorder traversal arrays of a binary tree,
 * reconstruct and return the original binary tree.
 *
 * Constraints:
 * 1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 * preorder and inorder consist of unique values
 *
 * Time Complexity:
 * O(n²) in the worst case (linear search in inorder for each node)
 *
 * Space Complexity:
 * O(n) — recursion stack
 */

public class _105_ConstructBinaryTreeFromPreorderInorder {

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

    // Global index for preorder traversal
    static int idx;

    /**
     * Builds the binary tree using preorder and inorder arrays.
     */
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        idx = 0;
        return helper(preorder, inorder, 0, inorder.length - 1);
    }

    private static TreeNode helper(int[] pre, int[] in, int left, int right) {
        if (left > right) return null;

        TreeNode root = new TreeNode(pre[idx++]);

        int mid = left;
        while (in[mid] != root.val) mid++;

        root.left = helper(pre, in, left, mid - 1);
        root.right = helper(pre, in, mid + 1, right);

        return root;
    }

    // Test examples
    public static void main(String[] args) {

        // Example 1
        int[] preorder1 = {3, 9, 20, 15, 7};
        int[] inorder1  = {9, 3, 15, 20, 7};

        TreeNode root1 = buildTree(preorder1, inorder1);
        System.out.println(root1.val); // 3

        // Example 2
        int[] preorder2 = {-1};
        int[] inorder2  = {-1};

        TreeNode root2 = buildTree(preorder2, inorder2);
        System.out.println(root2.val); // -1
    }
}
