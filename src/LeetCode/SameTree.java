package LeetCode;

import LeetCode.util.TreeNode;

/**
 * Given two binary trees, write a function to check if they are the same or not.

 Two binary trees are considered the same if they are structurally identical and the nodes have the same value.

 Example 1:

 Input:     1         1
 / \       / \
 2   3     2   3

 [1,2,3],   [1,2,3]

 Output: true
 Example 2:

 Input:     1         1
 /           \
 2             2

 [1,2],     [1,null,2]

 Output: false
 Example 3:

 Input:     1         1
 / \       / \
 2   1     1   2

 [1,2,1],   [1,1,2]

 Output: false
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p != null && q == null || p== null && q!= null) {
            return false;
        }  else {
            boolean res = (q.val == p.val);
            res &= isSameTree(p.left, q.left);
            res &= isSameTree(p.right, q.right);
            return res;
        }
    }

    public boolean isSameTree1(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return true;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree1(p.left, q.left) && isSameTree (p.right, q.right);
    }

    public static void main(String[] args) {
        SameTree t = new SameTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);

        TreeNode root2 = new TreeNode(1);
//        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);


        System.out.println(t.isSameTree1(root, root2));
    }
}
