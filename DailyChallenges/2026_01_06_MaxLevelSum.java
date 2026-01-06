package DailyChallenges;

/**
 * Problem: Maximum Level Sum of a Binary Tree
 * Date: 06-01-2026
 * Difficulty: Medium
 * Pattern: BFS / Tree
 *
 * Problem Link:
 * https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/
 *
 * Time Complexity:
 * O(n) where n = number of nodes in the tree
 *
 * Space Complexity:
 * O(w) where w = maximum width of the tree
 */

import java.util.Queue;
import java.util.LinkedList;

public class _2026_01_06_MaxLevelSum {

    /**
     * Solution:
     * - Use BFS (level-order traversal) with a queue.
     * - For each level, compute the sum of node values.
     * - Track the maximum sum and the corresponding level.
     * - Return the smallest level with the maximal sum.
     */
    public int maxLevelSum(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int level = 1;
        int maxLevel = 1;
        int maxSum = Integer.MIN_VALUE;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int sum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            if (sum > maxSum) {
                maxSum = sum;
                maxLevel = level;
            }

            level++;
        }

        return maxLevel;
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
        _2026_01_06_MaxLevelSum solution = new _2026_01_06_MaxLevelSum();

        TreeNode ex1 = new TreeNode(1,
                        new TreeNode(7, new TreeNode(7), new TreeNode(-8)),
                        new TreeNode(0));

        TreeNode ex2 = new TreeNode(989,
                        null,
                        new TreeNode(10250,
                            new TreeNode(98693),
                            new TreeNode(-89388, null, new TreeNode(-32127))));

        System.out.println("Example 1 Output: " + solution.maxLevelSum(ex1)); // 2
        System.out.println("Example 2 Output: " + solution.maxLevelSum(ex2)); // 2
    }
}
