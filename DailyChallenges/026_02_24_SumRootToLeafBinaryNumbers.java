package DailyChallenges;

/**
 * Problem: Sum of Root To Leaf Binary Numbers
 * Date: 24-02-2026
 * Difficulty: Easy
 * Pattern: Binary Tree / DFS
 *
 *
 * Problem Link:
 * https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/
 *
 * Description:
 * You are given the root of a binary tree where each node has a value 0 or 1. 
 * Each root-to-leaf path represents a binary number starting with the most significant bit.
 * 
 * For all leaves in the tree, consider the numbers represented by the path from the root to that leaf. 
 * Return the sum of these numbers.
 *
 * Constraints:
 * - The number of nodes in the tree is in the range [1, 1000].
 * - Node.val is 0 or 1.
 *
 * Time Complexity: O(n) - visit each node once
 * Space Complexity: O(h) - recursion stack, h = height of tree
 */
public class _2026_02_24_SumRootToLeafBinaryNumbers {

    /**
     * DFS Solution:
     * 1. Keep a running binary value for the path from root to current node.
     * 2. When reaching a leaf, add the path value to the total sum.
     */
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int current) {
        if (node == null) return 0;

        // Shift current value to the left and add current node's value
        current = (current << 1) | node.val;

        // If leaf, return current path value
        if (node.left == null && node.right == null) {
            return current;
        }

        // Recursively sum left and right subtrees
        return dfs(node.left, current) + dfs(node.right, current);
    }

    /**
     * Example main to test the solution
     */
    public static void main(String[] args) {
        _2026_02_24_SumRootToLeafBinaryNumbers solution = new _2026_02_24_SumRootToLeafBinaryNumbers();

        // Example 1: root = [1,0,1,0,1,0,1] -> Output: 22
        TreeNode root1 = new TreeNode(1,
                new TreeNode(0, new TreeNode(0), new TreeNode(1)),
                new TreeNode(1, new TreeNode(0), new TreeNode(1))
        );
        System.out.println("Example 1 Output: " + solution.sumRootToLeaf(root1));

        // Example 2: root = [0] -> Output: 0
        TreeNode root2 = new TreeNode(0);
        System.out.println("Example 2 Output: " + solution.sumRootToLeaf(root2));
    }

    /**
     * Definition for a binary tree node.
     */
    static class TreeNode {
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
}
