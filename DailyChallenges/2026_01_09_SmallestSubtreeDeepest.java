package DailyChallenges;

/**
 * Problem: Smallest Subtree with all the Deepest Nodes
 * Date: 09-01-2026
 * Difficulty: Medium
 * Pattern: DFS / Tree / Recursion
 *
 * Problem Link:
 * https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/
 *
 * Time Complexity:
 * O(n) where n = number of nodes in the tree
 *
 * Space Complexity:
 * O(h) where h = height of the tree (recursion stack)
 */

public class _2026_01_09_SmallestSubtreeDeepest {

    /**
     * Solution:
     * - First, compute the maximum depth of the tree.
     * - Then, recursively find the subtree that contains all nodes at the maximum depth.
     * - If both left and right subtrees contain deepest nodes, return the current node.
     * - Otherwise, return the subtree that contains deepest nodes.
     */
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        int max = maxDepth(root);
        return helper(root, 1, max); // start at depth 1
    }

    private int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    private TreeNode helper(TreeNode root, int depth, int maxDepth){
        if (root == null) return null;
        if (depth == maxDepth) return root;

        TreeNode left = helper(root.left, depth + 1, maxDepth);
        TreeNode right = helper(root.right, depth + 1, maxDepth);

        if (left != null && right != null) return root;
        return left != null ? left : right;
    }

    // TreeNode definition
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // Test examples
    public static void main(String[] args) {
        _2026_01_09_SmallestSubtreeDeepest solution = new _2026_01_09_SmallestSubtreeDeepest();

        // Example 1: root = [3,5,1,6,2,0,8,null,null,7,4] → subtree root = 2
        TreeNode ex1 = new TreeNode(3,
                new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4))),
                new TreeNode(1, new TreeNode(0), new TreeNode(8))
        );
        System.out.println("Example 1 Output: " + solution.subtreeWithAllDeepest(ex1).val); // 2

        // Example 2: root = [1] → subtree root = 1
        TreeNode ex2 = new TreeNode(1);
        System.out.println("Example 2 Output: " + solution.subtreeWithAllDeepest(ex2).val); // 1

        // Example 3: root = [0,1,3,null,2] → subtree root = 2
        TreeNode ex3 = new TreeNode(0,
                new TreeNode(1, null, new TreeNode(2)),
                new TreeNode(3)
        );
        System.out.println("Example 3 Output: " + solution.subtreeWithAllDeepest(ex3).val); // 2
    }
}
