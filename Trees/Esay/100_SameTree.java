package Trees.Easy;

/**
 * Problem: Same Tree (Easy)
 * LeetCode: https://leetcode.com/problems/same-tree/
 *
 * Pattern: Recursion / DFS
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

public class _100_SameTree {

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

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    // Test the solution
    public static void main(String[] args) {

        // Example 1: p = [1,2,3], q = [1,2,3] → true
        TreeNode p1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode q1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println(isSameTree(p1, q1)); // true

        // Example 2: p = [1,2], q = [1,null,2] → false
        TreeNode p2 = new TreeNode(1, new TreeNode(2), null);
        TreeNode q2 = new TreeNode(1, null, new TreeNode(2));
        System.out.println(isSameTree(p2, q2)); // false

        // Example 3: p = [1,2,1], q = [1,1,2] → false
        TreeNode p3 = new TreeNode(1, new TreeNode(2), new TreeNode(1));
        TreeNode q3 = new TreeNode(1, new TreeNode(1), new TreeNode(2));
        System.out.println(isSameTree(p3, q3)); // false
    }
}
