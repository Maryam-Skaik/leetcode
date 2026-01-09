package Trees.Medium;

/**
 * Problem: Smallest Subtree with all the Deepest Nodes (Medium)
 * LeetCode: https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/
 *
 * Pattern: DFS / Recursion
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h) where h = height of the tree (recursion stack)
 */

public class _865_SmallestSubtreeDeepest {

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

    public static TreeNode subtreeWithAllDeepest(TreeNode root) {
        int max = maxDepth(root);
        return helper(root, 1, max); // start at depth 1
    }

    private static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    private static TreeNode helper(TreeNode root, int depth, int maxDepth) {
        if (root == null) return null;
        if (depth == maxDepth) return root;

        TreeNode left = helper(root.left, depth + 1, maxDepth);
        TreeNode right = helper(root.right, depth + 1, maxDepth);

        if (left != null && right != null) return root;
        return left != null ? left : right;
    }

    // Test the solution
    public static void main(String[] args) {

        // Example 1: [3,5,1,6,2,0,8,null,null,7,4] → subtree root = 2
        TreeNode root1 = new TreeNode(3,
                new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4))),
                new TreeNode(1, new TreeNode(0), new TreeNode(8))
        );
        System.out.println(subtreeWithAllDeepest(root1).val); // 2

        // Example 2: [1] → subtree root = 1
        TreeNode root2 = new TreeNode(1);
        System.out.println(subtreeWithAllDeepest(root2).val); // 1

        // Example 3: [0,1,3,null,2] → subtree root = 2
        TreeNode root3 = new TreeNode(0,
                new TreeNode(1, null, new TreeNode(2)),
                new TreeNode(3)
        );
        System.out.println(subtreeWithAllDeepest(root3).val); // 2
    }
}
