package LeetCode;

import LeetCode.util.TreeNode;

/**
 * Given a binary tree, find its maximum depth.
 * <p>
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * <p>
 * Note: A leaf is a node with no children.
 * <p>
 * Example:
 * <p>
 * Given binary tree [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its depth = 3.
 */
public class MaximumDepthofBinaryTree {
    int maxDepth = -1;

    public int maxDepth(TreeNode root) {
        getDepth(root, 1);
        return maxDepth;
    }

    private void getDepth(TreeNode root, int level) {
        if (root == null) {
            return;
        }

        if (level > maxDepth) {
            maxDepth = level;
        }
        if (root.left != null) {
            getDepth(root.left, level + 1);
        }

        if (root.right != null) {
            getDepth(root.right, level + 1);
        }
    }

    public static void main(String[] args) {
        MaximumDepthofBinaryTree m = new MaximumDepthofBinaryTree();
        TreeNode t0 = new TreeNode(3);
        TreeNode t1 = new TreeNode(9);
        TreeNode t2 = new TreeNode(20);
        TreeNode t3 = new TreeNode(15);
        TreeNode t4 = new TreeNode(7);

        t0.left = t1;
        t0.right = t2;
        t1.left = t3;
        t1.right = t4;

        System.out.println(m.maxDepth(t0));
    }

}
