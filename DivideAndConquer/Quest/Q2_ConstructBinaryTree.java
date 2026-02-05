package DivideAndConquer.Quest;

/**
 * Problem: Construct Binary Tree from Inorder and Postorder Traversal (Medium)
 * LeetCode: https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 *
 * Source:
 * - data-structures-and-algorithms-quest
 * - Trees I
 *
 * Pattern: Divide and Conquer / Recursive Construction
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Explanation:
 * - Postorder traversal gives the root as the last element.
 * - Inorder traversal allows splitting the tree into left and right subtrees.
 * - Recursive construction:
 *   1. Pick root from postorder[index--]
 *   2. Find root position in inorder
 *   3. Recursively build right subtree first, then left subtree
 */

public class Q2_ConstructBinaryTree {

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

    private int index;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        index = postorder.length - 1;
        return build(postorder, inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] post, int[] in, int l, int r) {
        if (l > r) return null;

        // Root is the last element in postorder
        TreeNode root = new TreeNode(post[index--]);

        // Find root in inorder
        int mid = l;
        while (in[mid] != root.val) mid++;

        // Important: build right subtree first, then left
        root.right = build(post, in, mid + 1, r);
        root.left  = build(post, in, l, mid - 1);

        return root;
    }

    // Helper to print tree in inorder (for testing)
    private static void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    // Helper to print tree in postorder (for testing)
    private static void printPostorder(TreeNode root) {
        if (root == null) return;
        printPostorder(root.left);
        printPostorder(root.right);
        System.out.print(root.val + " ");
    }

    // Test the solution
    public static void main(String[] args) {
        DivideAndConquer_Q2_ConstructBinaryTree solution = new DivideAndConquer_Q2_ConstructBinaryTree();

        int[] inorder1   = {9, 3, 15, 20, 7};
        int[] postorder1 = {9, 15, 7, 20, 3};
        TreeNode root1 = solution.buildTree(inorder1, postorder1);
        System.out.print("Inorder: ");
        printInorder(root1);    // Should match inorder1
        System.out.println();
        System.out.print("Postorder: ");
        printPostorder(root1);  // Should match postorder1
        System.out.println("\n");

        int[] inorder2   = {-1};
        int[] postorder2 = {-1};
        TreeNode root2 = solution.buildTree(inorder2, postorder2);
        System.out.print("Inorder: ");
        printInorder(root2);
        System.out.println();
        System.out.print("Postorder: ");
        printPostorder(root2);
        System.out.println();
    }
}
