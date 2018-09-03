package LeetCode;

import LeetCode.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 * <p>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its zigzag level order traversal as:
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 * <p>
 * 15 7
 * <p>
 * 3, 20 9,
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode t0 = new TreeNode(1);
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(4);
        TreeNode t4 = new TreeNode(5);

        t0.left = t1;
        t0.right = t2;

        t1.left = t3;
        t1.right = t4;

        BinaryTreeZigzagLevelOrderTraversal b = new BinaryTreeZigzagLevelOrderTraversal();
        List<List<Integer>> res = b.zigzagLevelOrder(t0);
        System.out.println(res);

    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        boolean isRight = true;
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> curRes = new LinkedList<>();
            if (isRight) {
                for (int i = 0; i < size; i++) {
                    TreeNode cur = queue.poll();
                    curRes.add(cur.val);
                    if (cur.left != null) {
                        queue.addLast(cur.left);
                    }
                    if (cur.right != null) {
                        queue.addLast(cur.right);
                    }
                }
            } else {
                for (int i = 0; i < size; i++) {
                    TreeNode cur = queue.pollLast();
                    curRes.add(cur.val);
                    if (cur.right != null) {
                        queue.addFirst(cur.right);
                    }
                    if (cur.left != null) {
                        queue.addFirst(cur.left);
                    }
                }
            }
            res.add(curRes);
            isRight = !isRight;
        }
        return res;
    }

//    private TreeNode zigzagTraverse(List<List<Integer>> res, TreeNode node, boolean right) {
//        List<Integer> curRes = new ArrayList<>();
//        if (node == null) {
//            return node;
//        }
//        curRes.add(node.val);
//        if (right) {
//            zigzagLevelOrder(res, node.right, right);
//        } else {
//
//        }
//    }
}
