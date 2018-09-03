package LeetCode;

import LeetCode.util.TreeNode;
import apple.laf.JRSUIUtils;

/**
 *
 Invert a binary tree.

 Example:

 Input:

 4
 /   \
 2     7
 / \   / \
 1   3 6   9
 Output:

 4
 /   \
 7     2
 / \   / \
 9   6 3   1
 */

public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        if (root.left != null) {
            invertTree(root.left);
        }
        if (root.right != null) {
            invertTree(root.right);
        }
        return root;
    }

    private TreeNode invert(TreeNode root, TreeNode res) {
        if (root == null) {
            return null;
        }
        if (root.left != null) {
            res.right = invert(root.left, res);
        }
        res = new TreeNode(root.val);
        if (root.right != null) {
            res.left = invert(root.right, res);
        }
        return res;
    }

    public static void main(String[] args) {
        InvertBinaryTree i = new InvertBinaryTree();
        TreeNode t0 = new TreeNode(4);
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(7);
        TreeNode t3 = new TreeNode(1);
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(6);
        TreeNode t6 = new TreeNode(9);

        t0.left = t1;
        t0.right = t2;
        t1.left = t3;
        t1.right = t4;
        t2.left = t5;
        t2.right = t6;

        TreeNode r = i.invertTree(t0);
        System.out.println(TreeNode.bfs(r));
    }
}
