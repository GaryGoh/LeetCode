package LeetCode;

import LeetCode.util.TreeNode;

/**
 * Given a binary search tree and the lowest and highest boundaries as L and R, trim the tree so that all its elements lies in [L, R] (R >= L). You might need to change the root of the tree, so the result should return the new root of the trimmed binary search tree.
 * <p>
 * Example 1:
 * Input:
 * 1
 * / \
 * 0   2
 * <p>
 * L = 1
 * R = 2
 * <p>
 * Output:
 * 1
 * \
 * 2
 * Example 2:
 * Input:
 * 3
 * / \
 * 0   4
 * \
 * 2
 * /
 * 1
 * <p>
 * L = 1
 * R = 3
 * <p>
 * Output:
 * 3
 * /
 * 2
 * /
 * 1
 */


public class TrimaBinarySearchTree {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) {
            return null;
        }
        if (root.val < L) {
            return trimBST(root.right,  L, R);
        }
        if (root.val > R) {
            return trimBST(root.left,  L, R);
        }
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }

    public static void main(String[] args) {
        Integer[] i = {1, 0, 2};
        TreeNode root = new TreeNode(i).getRoot();
        TrimaBinarySearchTree t = new TrimaBinarySearchTree();
        TreeNode t0 = new TreeNode(1);
        TreeNode t1 = new TreeNode(0);
        TreeNode t2 = new TreeNode(2);
        t0.left = t1;
        t0.right = t2;
        System.out.println(TreeNode.bfs(root));
        TreeNode res = t.trimBST(root, 1,2);
//        System.out.println(TreeNode.bfs(res));
    }
}
