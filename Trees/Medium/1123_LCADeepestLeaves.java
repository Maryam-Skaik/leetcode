package Trees.Medium;

/**
 * Problem: Lowest Common Ancestor of Deepest Leaves (Medium)
 * LeetCode: https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/
 *
 * Note: This problem is essentially the same as "Smallest Subtree with all the Deepest Nodes" (LeetCode 865).
 *
 * Pattern: DFS / Recursion
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h) where h = height of the tree (recursion stack)
 */

public class _1123_LCADeepestLeaves {

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

    public static TreeNode lcaDeepestLeaves(TreeNode root) {
        int max = maxDepth(root);
        return helper(root, 1, max);
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

        // Example 1: root = [3,5,1,6,2,0,8,null,null,7,4] → LCA = 2
        TreeNode root1 = new TreeNode(3,
                new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4))),
                new TreeNode(1, new TreeNode(0), new TreeNode(8))
        );
        System.out.println(lcaDeepestLeaves(root1).val); // 2

        // Example 2: root = [1] → LCA = 1
        TreeNode root2 = new TreeNode(1);
        System.out.println(lcaDeepestLeaves(root2).val); // 1

        // Example 3: root = [0,1,3,null,2] → LCA = 2
        TreeNode root3 = new TreeNode(0,
                new TreeNode(1, null, new TreeNode(2)),
                new TreeNode(3)
        );
        System.out.println(lcaDeepestLeaves(root3).val); // 2
    }
}
