package LeetCode;

import LeetCode.util.TreeNode;

import java.util.ArrayDeque;

/**
 *
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

 For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 1
 / \
 2   2
 / \ / \
 3  4 4  3
 But the following [1,2,2,null,3,null,3] is not:
 1
 / \
 2   2
 \   \
 3    3
 Note:
 Bonus points if you could solve it both recursively and iteratively.


 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SymmetricTree {

    /**
     * Use LinkedList as LinkedList can store null, but ArrayDeque cannot.
     */
    public boolean isSymmetric(TreeNode root) {
        ArrayDeque<TreeNode> queue = new ArrayDeque();
        if (root == null) return true;
        if (root.left == null && root.right == null ) return true;
        if (root.left == null || root.right == null ) return false;
        queue.add(root.left);
        queue.addLast(root.right);

        while(!queue.isEmpty()) {
            TreeNode head = queue.pollFirst();
            TreeNode tail = queue.pollLast();
            if (head.val == tail.val) {
                if (head.left != null && head.right != null) {
                    queue.add(head.left);
                    queue.add(head.right);
                } else if (head.left != null || head.right != null) {
                    return false;
                }
                if (tail.left != null && tail.right != null) {
                    queue.addLast(tail.left);
                    queue.addLast(tail.right);
                } else if (tail.left != null || tail.right != null) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }


    public boolean isSymmetric1(TreeNode root) {
        return checkSymmetric(root, root);
    }

    private boolean checkSymmetric(TreeNode root1, TreeNode root2) {
        if ((root1 != null && root2 == null) || (root1 == null && root2 != null)) {return false;}
        if (root1 == null && root2 == null) {return true;}
        if (root1.val == root2.val) {
            return checkSymmetric(root1.left, root2.right) && checkSymmetric(root1.right, root2.left);
        } else {
            return false;
        }
    }


    public static void main(String[] args) {
        SymmetricTree s = new SymmetricTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(2);
//        root.left.right = new TreeNode(3);
//        root.right.right = new TreeNode(3);
        System.out.println(s.isSymmetric(root));
    }
}

