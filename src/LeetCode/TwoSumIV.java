package LeetCode;

import LeetCode.util.TreeNode;

import java.util.HashSet;

/**
 * Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.

 Example 1:
 Input:
 5
 / \
 3   6
 / \   \
 2   4   7

 Target = 9

 Output: True
 Example 2:
 Input:
 5
 / \
 3   6
 / \   \
 2   4   7

 Target = 28

 Output: False

    3
   / \
  1  4
   \  \
    2
 */
public class TwoSumIV {
    /**
     * 1. val > k, root.left
     * 1. val < k
     */
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        return helper(root, k, new HashSet());
    }

    private boolean helper (TreeNode root, int k, HashSet<Integer> table) {
        if (root == null) {
            return false;
        }
        if (table.contains(k - root.val)) {
            return true;
        } else {
            table.add(root.val);
        }
        return helper(root.left, k, table) || helper(root.right, k, table);
    }

    public static void main(String[] args) {
        Integer[] l = {3,1,4,null, 2};
        int k = 9;
//        TreeNode tn = new TreeNode(l);
        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(6);
        TreeNode t4 = new TreeNode(2);
        TreeNode t5 = new TreeNode(4);
        TreeNode t6 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.right = t6;

//        TreeNode t1 = new TreeNode(3);
//        TreeNode t2 = new TreeNode(1);
//        TreeNode t3 = new TreeNode(4);
//        TreeNode t4 = new TreeNode(2);
//        t1.left = t2;
//        t1.right = t3;
//        t2.right = t4;

        TwoSumIV t = new TwoSumIV();
        System.out.println(t.findTarget(t1, k));
    }
}
