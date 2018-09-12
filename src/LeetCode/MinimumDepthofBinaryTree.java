package LeetCode;

import LeetCode.util.TreeNode;

/**
 * Given a binary tree, find its minimum depth.
 * <p>
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
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
 * return its minimum depth = 2.
 * <p>
 * 1. use DFS
 * 2. if root is null, return 0
 * 3. post-order
 * 4. if current node is null or level > minDepth, return previous level of recursion.
 */

public class MinimumDepthofBinaryTree {

    int res = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        helper(root, 1);
        return res;
    }

    private void helper(TreeNode root, int curDepth) {
        if (root.left == null && root.right == null) {
            res = Math.min(res, curDepth);
            return;
        }
        if (curDepth <= res) {
            if (root.left != null) {
                helper(root.left, curDepth + 1);
            }
            if (root.right != null) {
                helper(root.right, curDepth + 1);
            }
        }
    }

    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth2(root.left);
        int right = minDepth2(root.right);
        return (left == 0 || right == 0)? left + right + 1 : Math.min(left, right) + 1;
    }

    public static void main(String[] args) {
        MinimumDepthofBinaryTree m = new MinimumDepthofBinaryTree();
        Integer[] i = {3,9,20,null,null,15,7};
        TreeNode root = new TreeNode(i).getRoot();
        TreeNode t = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        t.left = t2;
        System.out.println(m.minDepth2(root));
    }
}
